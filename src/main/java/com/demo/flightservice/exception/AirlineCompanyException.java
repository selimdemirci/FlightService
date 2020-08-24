package com.demo.flightservice.exception;

public class AirlineCompanyException extends RuntimeException {

    private static final long serialVersionUID = 645656670132345528L;

    public AirlineCompanyException(String message) {
        super(message);
    }
    
}