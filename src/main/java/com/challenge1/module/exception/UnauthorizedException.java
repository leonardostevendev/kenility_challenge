package com.challenge1.module.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.challenge1.module.exception.AppRuntimeException;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends AppRuntimeException {
    public UnauthorizedException(String errorCode, String message) {
        super(errorCode, message);
    }

    public UnauthorizedException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}

