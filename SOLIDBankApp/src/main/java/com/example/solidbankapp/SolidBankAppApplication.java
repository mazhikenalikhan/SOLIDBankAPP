package com.example.solidbankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SpringBootApplication
public class SolidBankAppApplication {
    private static int nextInt(Scanner scanner){
        while(!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Please enter integer:");
        }
        int res = scanner.nextInt();
        if(res < 1 || res > 7) {
            System.out.println("Please enter integer between 1 and 7");
            return nextInt(scanner);
        }
        return res;
    }
    private static void helpMessage() throws FileNotFoundException {
        File file = new File("/home/mazhiken.alikhan/IdeaProjects/SOLIDBankApp/src/main/java/com/example/solidbankapp/welcome.txt");
        Scanner fileScan = new Scanner(file);
        while(fileScan.hasNextLine()) {
            System.out.println(fileScan.nextLine());
        }
        fileScan.close();
    }
    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(SolidBankAppApplication.class, args);
        ApplicationContext context = new ClassPathXmlApplicationContext("props.xml");
        Scanner scanner = new Scanner(System.in);
        AccountBasicCLI accountBasicCLI= (AccountBasicCLI) context.getBean("accountbasiccli");
        helpMessage();
        int request = nextInt(scanner);
        while(request != 7) {
            switch (request){
                case 1 :
                    accountBasicCLI.getAccounts("1");
                    break;
                case 2 :
                    System.out.println("[CHECKING, SAVING, FIXED]");
                    accountBasicCLI.createAccountRequest("1");
                    break;
                case 6 :
                    helpMessage();
                    break;
            }
            request = nextInt(scanner);
        }

    }

}
