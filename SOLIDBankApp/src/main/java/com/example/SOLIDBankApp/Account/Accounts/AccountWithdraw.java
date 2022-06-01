package com.example.SOLIDBankApp.Account.Accounts;

public class AccountWithdraw extends Account {
    public AccountWithdraw(AccountType accountType, String id, String clientID, double balance) {
        super(id, clientID, accountType, balance, true);
    }
}
