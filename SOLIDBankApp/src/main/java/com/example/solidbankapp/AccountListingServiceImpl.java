package com.example.solidbankapp;

import java.util.List;

public class AccountListingServiceImpl implements AccountListingService{
    private AccountDAO accountDAO;

    AccountListingServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return this.accountDAO.getClientAccount(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return this.accountDAO.getClientWithdrawAccount(clientID, accountID);
    }

    @Override
    public List<Account> getClientAccounts(String clientID){
        return this.accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return this.accountDAO.getClientAccountsByType(clientID, accountType);
    }
}
