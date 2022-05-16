package com.example.solidbankapp;

public class AccountWithdrawServiceImpl implements AccountWithdrawService{
    private final AccountDAO accountDAO;

    AccountWithdrawServiceImpl (AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void withdraw(double amount, AccountWithdraw account){
        account.setBalance(account.getBalance() - amount);
    }
}
