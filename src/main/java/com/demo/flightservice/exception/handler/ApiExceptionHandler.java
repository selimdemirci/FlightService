package com.demo.flightservice.exception.handler;

import com.demo.flightservice.exception.TicketException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({TicketException.class})
    public String ticket(){
        return "Reservation couldn't complete.";
    }
    
}