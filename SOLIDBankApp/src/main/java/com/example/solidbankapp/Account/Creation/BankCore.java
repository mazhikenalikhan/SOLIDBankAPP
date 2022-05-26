package com.example.solidbankapp.Account.Creation;

import com.example.solidbankapp.Account.Accounts.AccountType;

public class BankCore {
    private static final long id = 1;
    private long lastAccountNumber = 1;
    private final AccountCreationService accountCreation;

    public BankCore(AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }

   public void createNewAccount(AccountType accountType, String clientID) {
        if(accountType == AccountType.INCORRECT){
            System.out.println("Incorrect account type.");
            return;
        }
        accountCreation.create(accountType, id, clientID,  lastAccountNumber);
        incrementLastAccountNumber();
   }

   private void incrementLastAccountNumber(){
        lastAccountNumber++;
   }
}
