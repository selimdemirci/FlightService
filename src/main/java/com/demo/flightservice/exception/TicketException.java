package com.demo.flightservice.exception;

public class TicketException extends RuntimeException{

    private static final long serialVersionUID = 6879912342884005033L;

    public TicketException(String message){
        super(message);
    }
    
}