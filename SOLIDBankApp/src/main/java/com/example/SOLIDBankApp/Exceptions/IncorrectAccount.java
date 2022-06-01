package com.example.SOLIDBankApp.Exceptions;

import lombok.Getter;

@Getter
public class IncorrectAccount extends Exception{
    private final String message;
    public IncorrectAccount(){
        this.message = "Incorrect data for account\n";
    }
}
