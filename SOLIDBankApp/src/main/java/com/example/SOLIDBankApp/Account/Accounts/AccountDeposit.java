package com.example.SOLIDBankApp.Account.Accounts;

public class AccountDeposit extends Account {
    public AccountDeposit(AccountType accountType, String id, String clientID, double balance) {
        super(id, clientID, accountType, balance, false);
    }
}
