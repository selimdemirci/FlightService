package com.demo.flightservice.exception;

public class PassengerException extends RuntimeException{

    private static final long serialVersionUID = 5832114322885004033L;

    public PassengerException(String message) {
        super(message);
    }
    
}