package com.example.solidbankapp;

import java.util.List;

public interface TransactionDAO {
    public int getID();
    public List<Transaction> getTransactions();
    public void addTransaction(Transaction transaction);
}
