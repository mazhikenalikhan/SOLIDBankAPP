package com.example.SOLIDBankApp;

import com.example.SOLIDBankApp.Account.Accounts.AccountType;
import com.example.SOLIDBankApp.Account.CLIUI;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class MyCLI implements CLIUI {
    private final Scanner scanner;

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
        AccountType accountType = null;
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
