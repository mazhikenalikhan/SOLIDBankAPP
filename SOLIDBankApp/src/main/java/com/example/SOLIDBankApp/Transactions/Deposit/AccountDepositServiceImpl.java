package com.example.SOLIDBankApp.Transactions.Deposit;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Account.Services.AccountDataService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountDepositServiceImpl implements AccountDepositService {
    @Autowired
    private AccountDataService accountDataService;
    @Override
    public void deposit(double amount, Account account) {
        account.setBalance(account.getBalance() + amount);
        accountDataService.update(account);
    }
}
