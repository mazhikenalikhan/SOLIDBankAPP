package com.example.solidbankapp;

public class AccountCreationServiceImpl implements AccountCreationService{
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }


    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        Account newAccount = null;
        String accountNumber = String.format("%03d%06d", bankID, accountID);
        if(accountType.getType().equals("FIXED")){
            newAccount = new FixedAccount(accountType, accountNumber, clientID, 0.0, false);
        }
        if(accountType.getType().equals("SAVING")){
            newAccount = new SavingAccount(accountType, accountNumber, clientID, 0.0, true);
        }
        if(accountType.getType().equals("CHECKING")){
            newAccount = new CheckingAccount(accountType, accountNumber, clientID, 0.0, true);
        }
        accountDAO.createNewAccount(newAccount);
    }
}
