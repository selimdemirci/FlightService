package com.demo.flightservice.exception;

public class FlightException extends RuntimeException{

    private static final long serialVersionUID = 6612351077793511757L;

    public FlightException(String message) {
        super(message);
    }
    
}