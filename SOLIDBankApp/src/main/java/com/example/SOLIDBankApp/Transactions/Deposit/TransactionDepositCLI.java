package com.example.SOLIDBankApp.Transactions.Deposit;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Account.Listing.AccountListingService;
import com.example.SOLIDBankApp.Transactions.WithdrawDepositOperationCLIUI;

public class TransactionDepositCLI {
    private final TransactionDeposit transactionDeposit;
    private final WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private final AccountListingService accountListingService;

    public TransactionDepositCLI(TransactionDeposit transactionDeposit, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService){
        this.transactionDeposit = transactionDeposit;
        this.accountListingService = accountListingService;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
    }

    public void depositMoney(String clientID){
        String accountID = withdrawDepositOperationCLIUI.requestClientAmountNumber();
        Account account = accountListingService.getClientAccount(clientID, accountID);
        if(account == null){
            System.out.println("FAILED: Impossible to find account");
            return;
        }
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        transactionDeposit.execute(account, amount);
    }
}
