package com.kbc.EmailService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code= HttpStatus.UNPROCESSABLE_ENTITY)
public class ValidationException extends RuntimeException {
    String errorCode;
    public ValidationException(String errorCode,String message)  {
        super(message);
        this.errorCode=errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
