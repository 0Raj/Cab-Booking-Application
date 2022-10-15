package com.thinkify.cabBooking.exception;

public class NoStrongPasswordException extends RuntimeException{

    public NoStrongPasswordException(String msg){
        super(msg);
    }

    public NoStrongPasswordException(){

    }
}
