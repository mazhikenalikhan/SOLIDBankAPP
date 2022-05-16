package com.example.solidbankapp;

public class AccountDepositServiceImpl implements AccountDepositService{
    private AccountDAO accountDAO;

    AccountDepositServiceImpl (AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    @Override
    public void deposit(double amount, Account account) {
        account.setBalance(account.getBalance() + amount);
    }

}
