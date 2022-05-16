package com.example.solidbankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@SpringBootApplication
@Component
public class SolidBankAppApplication{
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        boolean running = true;
        String clientID = "1";
        MyCLI myCLI = context.getBean(MyCLI.class);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
        TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
        TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);
        String helpMessage = "1 - show accounts\n2 - create account\n3 - deposit\n4 - withdraw\n5 - transfer\n6 - this message\n7 - exit \n";
        System.out.print("Welcome to CLI bank service \n");
        System.out.print("Enter operation number: \n");
        System.out.print(helpMessage);
        Scanner scanner = myCLI.getScanner();
        while(running){
            String req = scanner.nextLine();
            System.out.println(req);
            switch (req) {
                case "1" -> accountBasicCLI.getAccounts(clientID);
                case "2" -> accountBasicCLI.createAccountRequest(clientID);
                case "3" -> transactionDepositCLI.depositMoney(clientID);
                case "4" -> transactionWithdrawCLI.withdrawMoney(clientID);
                case "6" -> System.out.printf(helpMessage);
                case "7" -> {
                    System.out.print("Application Closed\n");
                    running = false;
                }
                default -> System.out.print("Command not recognized!\n");
            }
        }
        scanner.close();
    }
}