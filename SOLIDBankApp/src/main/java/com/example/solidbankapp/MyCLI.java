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
        return new AccountType(scanner.nextLine());
    }
}
