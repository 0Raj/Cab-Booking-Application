package com.thinkify.cabBooking.exception;

public class NoCabFoundException extends RuntimeException{

    public NoCabFoundException(String msg){
        super(msg);
    }

    public NoCabFoundException(){

    }
}
