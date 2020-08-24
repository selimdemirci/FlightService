package com.demo.flightservice.exception;

public class AirportException extends RuntimeException {
    
    private static final long serialVersionUID = 64567503124224528L;

    public AirportException(String message) {
        super(message);
    }

}