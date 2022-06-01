package com.example.SOLIDBankApp.Exceptions;

import lombok.Getter;

@Getter
public class AccountTypeDoesNotExists extends Exception{
    private final String message;
    AccountTypeDoesNotExists(String accountType){
        this.message = "This " + accountType + "does not exists\n";
    }
}
