package com.example.solidbankapp.Transactions.DAO;

import com.example.solidbankapp.Transactions.Transaction;

import java.util.List;

public interface TransactionDAO {
    int getID();
    List<Transaction> getTransactions();
    void addTransaction(Transaction transaction);
}
