package com.demo.flightservice.exception;

public class AirportException extends RuntimeException {

    private static final long serialVersionUID = 5879914322885005033L;

    public AirportException(String message){
        super(message);
    }
    
}