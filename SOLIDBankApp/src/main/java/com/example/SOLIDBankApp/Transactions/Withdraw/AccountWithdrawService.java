package com.example.SOLIDBankApp.Transactions.Withdraw;

import com.example.SOLIDBankApp.Account.Accounts.Account;

public interface AccountWithdrawService {
    void withdraw(double amount, Account account);
}
