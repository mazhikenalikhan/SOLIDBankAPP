package com.example.solidbankapp.Transactions;

import com.example.solidbankapp.Account.Accounts.Account;

public class Transaction {
    private final String id;
    private final Account account;
    private final double amount;

    public Transaction(int id, Account account, double amount){
        this.id = String.valueOf(id);
        this.account = account;
        this.amount = amount;
    }
}
