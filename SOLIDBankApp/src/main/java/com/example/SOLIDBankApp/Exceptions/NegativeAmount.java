package com.example.SOLIDBankApp.Exceptions;

import lombok.Getter;

@Getter
public class NegativeAmount extends Exception{
    private final String message;
    public NegativeAmount(){
        this.message = "Impossible to input negative amount money\n";
    }
}
