package com.example.solidbankapp.Config;

import com.example.solidbankapp.Account.AccountBasicCLI;
import com.example.solidbankapp.Account.Creation.AccountCreationService;
import com.example.solidbankapp.Account.Creation.AccountCreationServiceImpl;
import com.example.solidbankapp.Account.Creation.BankCore;
import com.example.solidbankapp.Account.DAO.AccountDAO;
import com.example.solidbankapp.Account.DAO.MemoryAccountDAO;
import com.example.solidbankapp.Account.Listing.AccountListingService;
import com.example.solidbankapp.Account.Listing.AccountListingServiceImpl;
import com.example.solidbankapp.MyCLI;
import com.example.solidbankapp.Transactions.DAO.MemoryTransactionDAO;
import com.example.solidbankapp.Transactions.DAO.TransactionDAO;
import com.example.solidbankapp.Transactions.Deposit.AccountDepositService;
import com.example.solidbankapp.Transactions.Deposit.AccountDepositServiceImpl;
import com.example.solidbankapp.Transactions.Deposit.TransactionDeposit;
import com.example.solidbankapp.Transactions.Deposit.TransactionDepositCLI;
import com.example.solidbankapp.Transactions.Withdraw.AccountWithdrawService;
import com.example.solidbankapp.Transactions.Withdraw.AccountWithdrawServiceImpl;
import com.example.solidbankapp.Transactions.Withdraw.TransactionWithdraw;
import com.example.solidbankapp.Transactions.Withdraw.TransactionWithdrawCLI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    MyCLI myCLIBean(){
        return new MyCLI();
    }

    @Bean
    AccountDAO accountDAOBean(){
        return new MemoryAccountDAO();
    }

    @Bean
    AccountListingService accountListingServiceBean(){
        return new AccountListingServiceImpl(accountDAOBean());
    }

    @Bean
    AccountCreationService accountCreationServiceBean(){
        return new AccountCreationServiceImpl(accountDAOBean());
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
        return new AccountWithdrawServiceImpl(accountDAOBean());
    }

    @Bean
    TransactionDAO transactionDAOBean(){
        return new MemoryTransactionDAO();
    }

    @Bean
    TransactionWithdraw transactionWithdrawBean(){
        return new TransactionWithdraw(accountWithdrawServiceBean(), transactionDAOBean());
    }

    @Bean
    TransactionWithdrawCLI transactionWithdrawCLIBean(){
        return new TransactionWithdrawCLI(transactionWithdrawBean(), myCLIBean(), accountListingServiceBean());
    }

    @Bean
    AccountDepositService accountDepositServiceBean(){
        return new AccountDepositServiceImpl(accountDAOBean());
    }

    @Bean
    TransactionDeposit transactionDepositBean(){
        return new TransactionDeposit(accountDepositServiceBean(), transactionDAOBean());
    }

    @Bean
    TransactionDepositCLI transactionDepositCLIBean(){
        return new TransactionDepositCLI(transactionDepositBean(), myCLIBean(), accountListingServiceBean());
    }
}
