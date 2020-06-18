package com.kbc.EmailService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GeneralException extends RuntimeException{

    private final String errorCode;

    public GeneralException(String errorCode,String message) {
        super(message);
        this.errorCode=errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

