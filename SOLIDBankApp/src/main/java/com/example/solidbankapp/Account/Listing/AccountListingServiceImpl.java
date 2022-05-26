package com.example.solidbankapp.Account.Listing;

import com.example.solidbankapp.Account.Accounts.Account;
import com.example.solidbankapp.Account.Accounts.AccountType;
import com.example.solidbankapp.Account.Accounts.AccountWithdraw;
import com.example.solidbankapp.Account.DAO.AccountDAO;

import java.util.List;

public class AccountListingServiceImpl implements AccountListingService {
    private final AccountDAO accountDAO;

    public AccountListingServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountDAO.getClientAccount(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return accountDAO.getClientWithdrawAccount(clientID, accountID);
    }

    @Override
    public List<Account> getClientAccounts(String clientID){
        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountDAO.getClientAccountsByType(clientID, accountType);
    }
}
