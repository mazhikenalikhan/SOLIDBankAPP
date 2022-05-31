package com.example.SOLIDBankApp;

import com.example.SOLIDBankApp.Account.AccountBasicCLI;
import com.example.SOLIDBankApp.Transactions.Deposit.TransactionDepositCLI;
import com.example.SOLIDBankApp.Transactions.Withdraw.TransactionWithdrawCLI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SolidBankAppApplication implements CommandLineRunner {
	private final ApplicationContext context;

	public SolidBankAppApplication(ApplicationContext context) {
		this.context = context;
	}

	public static void main(String[] args)throws Exception {
		SpringApplication.run(SolidBankAppApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		boolean running = true;
		String clientID = "1";

		MyCLI myCLI = context.getBean(MyCLI.class);
		AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
		TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
		TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);

		String helpMessage = "1 - show accounts\n2 - create account\n3 - deposit\n4 - withdraw\n5 - transfer\n6 - this message\n7 - exit\n";
		System.out.print("Welcome to CLI bank service\n");
		System.out.print("Enter operation number: \n");
		System.out.print(helpMessage);
		while(running){
			switch (myCLI.getScanner().nextLine()) {
				case "1" -> accountBasicCLI.getAccounts(clientID);
				case "2" -> accountBasicCLI.createAccountRequest(clientID);
				case "3" -> transactionDepositCLI.depositMoney(clientID);
				case "4" -> transactionWithdrawCLI.withdrawMoney(clientID);
				case "6" -> System.out.print(helpMessage);
				case "7" -> {
					System.out.print("Application Closed\n");
					running = false;
				}
				default -> System.out.print("Command not recognized!\n");
			}
		}
		myCLI.getScanner().close();
	}
}
