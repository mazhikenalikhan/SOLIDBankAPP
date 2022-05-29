package com.example.SOLIDBankApp.Account.Accounts;

import org.springframework.data.relational.core.mapping.Table;


public class AccountDeposit extends Account {
    public AccountDeposit(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(id, clientID, accountType, balance, withdrawAllowed);
    }
}
