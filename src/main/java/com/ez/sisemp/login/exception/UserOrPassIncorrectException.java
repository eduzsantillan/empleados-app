package com.ez.sisemp.login.exception;

public class UserOrPassIncorrectException extends RuntimeException{
    public UserOrPassIncorrectException(String message) {
        super(message);
    }
}
