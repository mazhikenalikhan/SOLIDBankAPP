package com.example.SOLIDBankApp.Transactions.Service;

import com.example.SOLIDBankApp.Transactions.DAO.TransactionDAO;
import com.example.SOLIDBankApp.Transactions.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionDataService {
    private final TransactionDAO transactionDAO;

    public TransactionDataService(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Transactional
    public String getID(){
        return String.valueOf(transactionDAO.count());
    }
    @Transactional
    public void addTransaction(Transaction transaction){
        transactionDAO.add(transaction.getID());
        transactionDAO.save(transaction);
    }
    @Transactional
    public List<Transaction> getAccountTransactions(String accountID){
        return transactionDAO.getAccountTransactions(accountID);
    }

    @Transactional
    public void delete(String account_id) {
        transactionDAO.deleteByAccountID(account_id);
    }
}
