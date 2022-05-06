package com.example.solidbankapp;

import java.util.Scanner;

public class MyCLI implements CLIUI{
    private Scanner scanner;

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public double requestClientAmount(){
        return scanner.nextDouble();
    }

    public String requestClientAmountNumber(){
        return scanner.nextLine();
    }

    @Override
    public AccountType requestAccountType() {
        AccountType accountType = AccountType.INCORRECT;
        String request = this.scanner.nextLine();
        switch (request) {
            case "CHECKING" -> accountType = AccountType.CHECKING;
            case "SAVING" -> accountType = AccountType.SAVING;
            case "FIXED" -> accountType = AccountType.FIXED;
        }
        return accountType;
    }
}
