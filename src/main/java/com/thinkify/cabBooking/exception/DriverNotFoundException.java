package com.thinkify.cabBooking.exception;

public class DriverNotFoundException extends RuntimeException{

    public DriverNotFoundException(String msg){
        super(msg);
    }

    public DriverNotFoundException(){

    }
}
