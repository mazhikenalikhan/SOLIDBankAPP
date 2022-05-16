package com.example.solidbankapp;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MemoryTransactionDAO implements TransactionDAO{
    private List<Transaction> transactions;

    MemoryTransactionDAO(){
        this.transactions = new ArrayList<Transaction>();
    }

    public int getID(){
        return transactions.size();
    }

    @Override
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
}
