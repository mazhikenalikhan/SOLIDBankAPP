package com.example.SOLIDBankApp.Account.Controllers;

import com.example.SOLIDBankApp.Exceptions.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AccountControllerAdvice {
    @ResponseBody
    @ExceptionHandler(AccountNotFound.class)
    @ResponseStatus()
    String accountNotFoundHandler(AccountNotFound ex) {
        return ex.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(ClientNotFound.class)
    @ResponseStatus()
    String clientNotFoundHandler(ClientNotFound ex) {
        return ex.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(NotEnoughMoney.class)
    @ResponseStatus()
    String NotEnoughMoneyHandler(NotEnoughMoney ex) {
        return ex.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(AccountAlreadyExist.class)
    @ResponseStatus()
    String accountAlreadyExistHandler(AccountAlreadyExist ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(AccountTypeDoesNotExists.class)
    @ResponseStatus()
    String accountTypeDoesNotExistsHandler(AccountTypeDoesNotExists ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(NegativeAmount.class)
    @ResponseStatus()
    String NegativeAmountHandler(NegativeAmount ex) {
        return ex.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(IncorrectAccount.class)
    @ResponseStatus()
    String IncorrectAccountHandler(IncorrectAccount ex) {
        return ex.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(AccountNotWithdraw.class)
    @ResponseStatus()
    String AccountNotWithdrawHandler(AccountNotWithdraw ex) {
        return ex.getMessage();
    }

}
