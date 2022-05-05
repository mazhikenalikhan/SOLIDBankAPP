package com.example.solidbankapp;

public class Account {
    private AccountType accountType;
    private String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;

    public double getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "Account{, id=" + this.id + ", clientID=" + this.clientID + ", balance="+this.balance + "}";
    }

    public String getClientID() {
        return this.clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public Account(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed){
        this.clientID = clientID;
        this.accountType = accountType;
        this.balance = balance;
        this.id = id;
        this.withdrawAllowed = withdrawAllowed;
    }

    public boolean isWithdrawAllowed(){
        return this.withdrawAllowed;
    }

    public void setWithdrawAllowed(boolean withdrawAllowed){
        this.withdrawAllowed = withdrawAllowed;
    }

    public AccountType getAccountType(){
        return this.accountType;
    }

    public void setAccountType(AccountType accountType){
        this.accountType = accountType;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
