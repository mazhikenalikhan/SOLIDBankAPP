package com.example.solidbankapp.Transactions.DAO;

import com.example.solidbankapp.Transactions.Transaction;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MemoryTransactionDAO implements TransactionDAO {
    private final List<Transaction> transactions;

    public MemoryTransactionDAO(){
        this.transactions = new ArrayList<>();
    }

    public int getID(){
        return transactions.size();
    }

    @Override
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
}
