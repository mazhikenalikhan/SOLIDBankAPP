package com.example.SOLIDBankApp.Transactions.Withdraw;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Account.Services.AccountDataService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    @Autowired
    private AccountDataService accountDataService;
    @Override
    public void withdraw(double amount, Account account){
        account.setBalance(account.getBalance() - amount);
        accountDataService.update(account);
    }
}
