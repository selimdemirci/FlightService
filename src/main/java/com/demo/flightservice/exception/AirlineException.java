package com.demo.flightservice.exception;

public class AirlineException extends RuntimeException{

    
    private static final long serialVersionUID = 6612312345793511757L;

    public AirlineException(String message) {
        super(message);
    }
    
}