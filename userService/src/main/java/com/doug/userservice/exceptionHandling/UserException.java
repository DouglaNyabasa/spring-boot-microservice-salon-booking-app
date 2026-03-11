package com.doug.userservice.exceptionHandling;

public class UserException extends RuntimeException {


    public UserException(String message) {
        super(message);
    }
}
