package com.thinkify.cabBooking.exception;

public class UserAlreadyPresentException extends RuntimeException{

    public UserAlreadyPresentException(String msg){
        super(msg);
    }

    public UserAlreadyPresentException(){

    }
}
