package com.example.solidbankapp.Transactions.Deposit;

import com.example.solidbankapp.Account.Accounts.Account;
import com.example.solidbankapp.Account.DAO.AccountDAO;

public class AccountDepositServiceImpl implements AccountDepositService {
    private final AccountDAO accountDAO;

    public AccountDepositServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    @Override
    public void deposit(double amount, Account account) {
        account.setBalance(account.getBalance() + amount);
    }

}
