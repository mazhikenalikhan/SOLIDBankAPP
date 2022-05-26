package com.example.solidbankapp.Transactions.Withdraw;

import com.example.solidbankapp.Account.Accounts.AccountWithdraw;
import com.example.solidbankapp.Account.DAO.AccountDAO;

public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private final AccountDAO accountDAO;

    public AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void withdraw(double amount, AccountWithdraw account){
        account.setBalance(account.getBalance() - amount);
    }
}
