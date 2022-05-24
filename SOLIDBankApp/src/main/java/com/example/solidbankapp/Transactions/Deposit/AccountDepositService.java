package com.example.solidbankapp.Transactions.Deposit;

import com.example.solidbankapp.Account.Accounts.Account;

public interface AccountDepositService {
    void deposit(double amount, Account account);
}
