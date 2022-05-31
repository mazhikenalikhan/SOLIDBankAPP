package com.example.SOLIDBankApp.Transactions.Deposit;

import com.example.SOLIDBankApp.Account.Accounts.Account;

public interface AccountDepositService {
    void deposit(double amount, Account account);
}
