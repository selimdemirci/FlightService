package com.demo.flightservice.exception;

public class DataNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1978156670133786528L;

    public DataNotFoundException(String message) {
        super(message);
    }
    
}