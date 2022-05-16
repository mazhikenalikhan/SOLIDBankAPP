package com.example.solidbankapp;

public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDAO transactionDAO;

    TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO){
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
