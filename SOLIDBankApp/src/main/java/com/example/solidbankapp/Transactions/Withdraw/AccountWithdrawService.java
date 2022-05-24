package com.example.solidbankapp.Transactions.Withdraw;

import com.example.solidbankapp.Account.Accounts.AccountWithdraw;

public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw account);
}
