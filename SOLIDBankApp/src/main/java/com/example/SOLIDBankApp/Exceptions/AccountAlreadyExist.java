package com.example.SOLIDBankApp.Exceptions;

import lombok.Getter;

@Getter
public class AccountAlreadyExist extends Exception{
    private final String message;
    public AccountAlreadyExist(String accountID){
        this.message = "Account " + accountID + " already exist";
    }
}
