package com.ez.sisemp.empleado.exception;

public class EmailAlreadyInUseException extends RuntimeException{
    public EmailAlreadyInUseException(String message){
        super(message);
    }
}
