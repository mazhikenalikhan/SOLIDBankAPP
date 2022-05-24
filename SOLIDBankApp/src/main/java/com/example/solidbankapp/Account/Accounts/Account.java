package com.example.solidbankapp.Account.Accounts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private AccountType accountType;
    private String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;

    @Override
    public String toString() {
        return "Account{, id=" + id + ", clientID=" + clientID + ", balance=" + balance + "}";
    }

    public Account(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed){
        this.clientID = clientID;
        this.accountType = accountType;
        this.balance = balance;
        this.id = id;
        this.withdrawAllowed = withdrawAllowed;
    }

}
