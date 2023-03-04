package com.zootopia.demo.Exception;

public class UserServiceException extends RuntimeException {
    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}