package com.example.SOLIDBankApp.Transactions.Service;

import com.example.SOLIDBankApp.Transactions.DAO.TransactionDAO;
import com.example.SOLIDBankApp.Transactions.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionDataService {
    @Autowired
    private TransactionDAO transactionDAO;
    @Transactional
    public String getID(){
        return String.valueOf(transactionDAO.count());
    }
    @Transactional
    public void addTransaction(Transaction transaction){
        transactionDAO.add(transaction.getID());
        transactionDAO.save(transaction);
    }
}
