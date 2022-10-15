package com.thinkify.cabBooking.exception;

public class DriverAlreadyPresentException extends RuntimeException{

    public DriverAlreadyPresentException(String msg){
        super(msg);
    }

    public DriverAlreadyPresentException(){

    }
}
