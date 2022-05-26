package com.example.solidbankapp.Transactions.Deposit;

import com.example.solidbankapp.Account.Accounts.Account;
import com.example.solidbankapp.Transactions.DAO.TransactionDAO;
import com.example.solidbankapp.Transactions.Transaction;

public class TransactionDeposit {
    private final AccountDepositService accountDepositService;
    private final TransactionDAO transactionDAO;

    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO){
        this.accountDepositService = accountDepositService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(Account account, double amount){
        if(amount <= 0){
            System.out.println("FAILED: Incorrect data");
            return;
        }
        accountDepositService.deposit(amount, account);
        Transaction transaction = new Transaction(transactionDAO.getID(), account, amount);
        transactionDAO.addTransaction(transaction);
        System.out.println("SUCCESS");
    }
}
