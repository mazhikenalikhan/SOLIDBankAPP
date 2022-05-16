package com.example.solidbankapp;

import java.util.Scanner;


public class MyCLI implements CLIUI{
    private final Scanner scanner;

    public Scanner getScanner() {
        return scanner;
    }

    MyCLI(String scanner){
        this.scanner = new Scanner(scanner);
    }
    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public double requestClientAmount(){
        System.out.println("Enter amount of money");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        }
        catch (Exception e){
            return 0;
        }
        return amount;
    }

    public String requestClientAmountNumber(){
        System.out.println("Enter Account's id");
        return scanner.nextLine();
    }

    @Override
    public AccountType requestAccountType() {
        System.out.println("[CHECKING, FIXED, SAVING]");
        AccountType accountType = AccountType.INCORRECT;
        String request;
        request = scanner.nextLine();
        switch (request) {
            case "CHECKING" -> accountType = AccountType.CHECKING;
            case "SAVING" -> accountType = AccountType.SAVING;
            case "FIXED" -> accountType = AccountType.FIXED;
        }
        return accountType;
    }
}
