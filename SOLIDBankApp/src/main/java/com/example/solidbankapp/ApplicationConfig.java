package com.example.solidbankapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ApplicationConfig {
    private AccountDAO accountDAO = null;
    private MyCLI myCLI = null;
    private AccountListingService accountListingService = null;
    private TransactionDAO transactionDAO = null;

    @Bean
    public MyCLI myCLI(){
        if(myCLI == null) return myCLI = new MyCLI();
        return myCLI;
    }

    @Bean
    public MyCLI myCLI(String scanner){
        return myCLI = new MyCLI(scanner);
    }

    @Bean
    public AccountDAO accountDAO(){
        if(accountDAO == null) return accountDAO = new MemoryAccountDAO();
        return accountDAO;
    }

    @Bean
    public AccountListingService accountListingService(){
        if(accountListingService == null) return accountListingService = new AccountListingServiceImpl(accountDAO());
        return accountListingService;
    }

    @Bean
    public AccountCreationService accountCreationService(){
        return new AccountCreationServiceImpl(accountDAO());
    }

    @Bean
    public BankCore bankCore(){
        return new BankCore(accountCreationService());
    }

    @Bean
    public AccountBasicCLI accountBasicCLI(){
        return new AccountBasicCLI(myCLI(), bankCore(), accountListingService());
    }

    @Bean
    public AccountWithdrawService accountWithdrawService(){
        return new AccountWithdrawServiceImpl(accountDAO());
    }

    @Bean
    public TransactionDAO transactionDAO(){
        if(transactionDAO == null) return transactionDAO = new MemoryTransactionDAO();
        return transactionDAO;
    }

    @Bean
    public TransactionWithdraw transactionWithdraw(){
        return new TransactionWithdraw(accountWithdrawService(), transactionDAO());
    }

    @Bean
    public TransactionWithdrawCLI transactionWithdrawCLI(){
        return new TransactionWithdrawCLI(transactionWithdraw(), myCLI(), accountListingService());
    }

    @Bean
    public AccountDepositService accountDepositService(){
        return new AccountDepositServiceImpl(accountDAO());
    }

    @Bean
    public TransactionDeposit transactionDeposit(){
        return new TransactionDeposit(accountDepositService(), transactionDAO());
    }

    @Bean
    public TransactionDepositCLI transactionDepositCLI(){
        return new TransactionDepositCLI(transactionDeposit(), myCLI(), accountListingService());
    }
}
