package com.example.solidbankapp.Transactions.Withdraw;

import com.example.solidbankapp.Account.Accounts.AccountWithdraw;
import com.example.solidbankapp.Account.Listing.AccountListingService;
import com.example.solidbankapp.Transactions.WithdrawDepositOperationCLIUI;

public class TransactionWithdrawCLI {
    private final TransactionWithdraw transactionWithdraw;
    private final WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private final AccountListingService accountListingService;

    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService){
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }

    public void withdrawMoney(String clientID){
        String accountID = withdrawDepositOperationCLIUI.requestClientAmountNumber();
        AccountWithdraw account = accountListingService.getClientWithdrawAccount(clientID, accountID);
        if(account == null){
            System.out.println("FAILED: Impossible to find withdraw-allowed account");
            return;
        }
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        transactionWithdraw.execute(account, amount);
    }
}
