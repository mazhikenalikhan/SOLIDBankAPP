package com.example.solidbankapp;

public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    private AccountCreationService accountCreation;

    BankCore(AccountCreationService accountCreation) {
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
