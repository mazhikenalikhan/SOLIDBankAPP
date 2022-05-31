package com.example.SOLIDBankApp.Account.Accounts;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


public class AccountWithdraw extends Account {
    public AccountWithdraw(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(id, clientID, accountType, balance, withdrawAllowed);
    }
}
