package com.example.SOLIDBankApp.Account.Services;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Account.Accounts.AccountType;
import com.example.SOLIDBankApp.Account.DAO.AccountRepository;
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
    public void createNewAccount(Account account){
        System.out.println("Success");
        accountRepository.create(account.getAccountID());
        accountRepository.save(account);
    }

    @Transactional
    public Account getClientAccount(String clientID, String accountID){
        return accountRepository.getClientAccount(clientID, accountID);
    }
    @Transactional
    public Account getClientWithdrawAccount(String clientID, String accountID) {
        return accountRepository.getClientWithdrawAccount(clientID,accountID);
    }
    @Transactional
    public List<Account> getClientAccounts(String clientID) {
        return accountRepository.getClientAccounts(clientID);
    }
    @Transactional
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountRepository.getClientAccountsByType(clientID, accountType);
    }
    @Transactional
    public void update(Account account) {
        accountRepository.save(account);
    }
}
