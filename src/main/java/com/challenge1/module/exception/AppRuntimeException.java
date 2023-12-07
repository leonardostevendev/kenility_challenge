package com.challenge1.module.exception;

public class AppRuntimeException extends RuntimeException {
    private final String errorCode;

    protected AppRuntimeException(String errorCode, String message) {
        this(errorCode, message, (Throwable)null);
    }

    protected AppRuntimeException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}