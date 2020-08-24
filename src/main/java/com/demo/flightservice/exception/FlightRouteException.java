package com.demo.flightservice.exception;

public class FlightRouteException extends RuntimeException{
    
    private static final long serialVersionUID = 5879914322885005033L;

    public FlightRouteException(String message){
        super(message);
    }

}