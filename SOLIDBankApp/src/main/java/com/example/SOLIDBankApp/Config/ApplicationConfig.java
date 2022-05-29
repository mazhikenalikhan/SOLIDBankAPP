package com.example.SOLIDBankApp.Config;

import com.example.SOLIDBankApp.Account.AccountBasicCLI;
import com.example.SOLIDBankApp.Account.Creation.AccountCreationService;
import com.example.SOLIDBankApp.Account.Creation.AccountCreationServiceImpl;
import com.example.SOLIDBankApp.Account.Creation.BankCore;
import com.example.SOLIDBankApp.Account.Listing.AccountListingService;
import com.example.SOLIDBankApp.Account.Listing.AccountListingServiceImpl;
import com.example.SOLIDBankApp.MyCLI;
import com.example.SOLIDBankApp.Transactions.Deposit.AccountDepositService;
import com.example.SOLIDBankApp.Transactions.Deposit.AccountDepositServiceImpl;
import com.example.SOLIDBankApp.Transactions.Deposit.TransactionDeposit;
import com.example.SOLIDBankApp.Transactions.Deposit.TransactionDepositCLI;
import com.example.SOLIDBankApp.Transactions.Withdraw.AccountWithdrawService;
import com.example.SOLIDBankApp.Transactions.Withdraw.AccountWithdrawServiceImpl;
import com.example.SOLIDBankApp.Transactions.Withdraw.TransactionWithdraw;
import com.example.SOLIDBankApp.Transactions.Withdraw.TransactionWithdrawCLI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    MyCLI myCLIBean(){
        return new MyCLI();
    }

    @Bean
    AccountListingService accountListingServiceBean(){
        return new AccountListingServiceImpl();
    }

    @Bean
    AccountCreationService accountCreationServiceBean(){
        return new AccountCreationServiceImpl();
    }

    @Bean
    BankCore bankCoreBean(){
        return new BankCore(accountCreationServiceBean());
    }

    @Bean
    AccountBasicCLI accountBasicCLIBean(){
        return new AccountBasicCLI(myCLIBean(), bankCoreBean(), accountListingServiceBean());
    }

    @Bean
    AccountWithdrawService accountWithdrawServiceBean(){
        return new AccountWithdrawServiceImpl();
    }

    @Bean
    TransactionWithdraw transactionWithdrawBean(){
        return new TransactionWithdraw(accountWithdrawServiceBean());
    }

    @Bean
    TransactionWithdrawCLI transactionWithdrawCLIBean(){
        return new TransactionWithdrawCLI(transactionWithdrawBean(), myCLIBean(), accountListingServiceBean());
    }

    @Bean
    AccountDepositService accountDepositServiceBean(){
        return new AccountDepositServiceImpl();
    }

    @Bean
    TransactionDeposit transactionDepositBean(){
        return new TransactionDeposit(accountDepositServiceBean());
    }

    @Bean
    TransactionDepositCLI transactionDepositCLIBean(){
        return new TransactionDepositCLI(transactionDepositBean(), myCLIBean(), accountListingServiceBean());
    }
}
