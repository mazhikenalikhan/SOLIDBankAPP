package com.example.SOLIDBankApp.Account.Services;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Account.Accounts.AccountType;
import com.example.SOLIDBankApp.Account.DAO.AccountRepository;
import com.example.SOLIDBankApp.Exceptions.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountDataService {
    private final AccountRepository accountRepository;

    public AccountDataService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void createNewAccount(Account account) throws AccountAlreadyExist, IncorrectAccount {
        if(account == null) throw new IncorrectAccount();
        if(accountRepository.existsById(account.getAccountID())) throw new AccountAlreadyExist(account.getAccountID());
        accountRepository.create(account.getAccountID());
        accountRepository.save(account);
    }

    @Transactional
    public Account getClientAccount(String clientID, String accountID) throws AccountNotFound{
        if(accountRepository.getClientAccount(clientID, accountID) == null) throw new AccountNotFound(clientID, accountID);
        return accountRepository.getClientAccount(clientID, accountID);
    }
    @Transactional
    public Account getClientWithdrawAccount(String clientID, String accountID) throws AccountNotWithdraw {
        if(accountRepository.getClientWithdrawAccount(clientID,accountID) == null) throw new AccountNotWithdraw(clientID, accountID);
        return accountRepository.getClientWithdrawAccount(clientID,accountID);
    }
    @Transactional
    public List<Account> getClientAccounts(String clientID){
        return accountRepository.getClientAccounts(clientID);
    }
    @Transactional
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType){
        return accountRepository.getClientAccountsByType(clientID, accountType);
    }
    @Transactional
    public void update(Account account) {
        accountRepository.save(account);
    }

    @Transactional
    public void delete(String clientID, String accountID) throws AccountNotFound, ClientNotFound {
        if(accountRepository.getClientAccounts(clientID).size() == 0) throw new ClientNotFound(clientID);
        if(accountRepository.getClientAccount(clientID, accountID) == null) throw new AccountNotFound(clientID, accountID);
        accountRepository.delete(getClientAccount(clientID, accountID));
    }
}
