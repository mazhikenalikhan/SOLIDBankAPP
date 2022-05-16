package com.example.solidbankapp;

public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionDAO transactionDAO;

    TransactionWithdraw(AccountWithdrawService accountWithdrawService, TransactionDAO transactionDAO){
        this.accountWithdrawService = accountWithdrawService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(AccountWithdraw accountWithdraw, double amount){
        if(accountWithdraw.getBalance() < amount) {
            System.out.println("FAILED: Not enough money");
            return;
        }
        if(amount <= 0){
            System.out.println("FAILED: Incorrect data");
            return;
        }
        accountWithdrawService.withdraw(amount, accountWithdraw);
        Transaction transaction = new Transaction(transactionDAO.getID(), accountWithdraw, amount);
        transactionDAO.addTransaction(transaction);
        System.out.println("SUCCESS");
    }
}
