package com.challenge1.module.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends AppRuntimeException {
    public InternalServerException(Throwable cause) {
        this("Something went wrong", cause);
    }

    public InternalServerException(String message, Throwable cause) {
        this("INTERNAL_SERVER_ERROR", message, cause);
    }

    public InternalServerException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}