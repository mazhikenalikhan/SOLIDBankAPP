package com.example.solidbankapp;

public class Transaction {
    private String id;
    private Account account;
    private double amount;

    Transaction(int id, Account account, double amount){
        this.id = String.valueOf(id);
        this.account = account;
        this.amount = amount;
    }
}
