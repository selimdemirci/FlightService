package com.demo.flightservice.exception.handler;

import com.demo.flightservice.exception.AirlineException;
import com.demo.flightservice.exception.AirportException;
import com.demo.flightservice.exception.FlightException;
import com.demo.flightservice.exception.FlightRouteException;
import com.demo.flightservice.exception.PassengerException;
import com.demo.flightservice.exception.TicketException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({AirlineException.class})
    public String airline(){
        return "An error was encountered! (Airline Company)";
    }

    @ExceptionHandler({AirportException.class})
    public String airport(){
        return "An error was encountered! (Airport)";
    }

    @ExceptionHandler({FlightException.class})
    public String flight(){
        return "An error was encountered! (Flight)";
    }

    @ExceptionHandler({FlightRouteException.class})
    public String flightRoute(){
        return "An error was encountered! (Flight Route)";
    }

    @ExceptionHandler({PassengerException.class})
    public String passenger(){
        return "An error was encountered! (Passenger)";
    }

    @ExceptionHandler({TicketException.class})
    public String ticket(){
        return "An error was encountered! (Ticket)";
    }
    
}