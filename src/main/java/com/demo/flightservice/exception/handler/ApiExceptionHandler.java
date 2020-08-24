package com.demo.flightservice.exception.handler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import com.demo.flightservice.exception.AirlineCompanyException;
import com.demo.flightservice.exception.AirportException;
import com.demo.flightservice.exception.DataNotFoundException;
import com.demo.flightservice.exception.FlightRouteException;
import com.demo.flightservice.exception.TicketException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({DataNotFoundException.class})
    public ResponseEntity<Object> notFoundEx(DataNotFoundException e){
        
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({TicketException.class})
    public ResponseEntity<Object> ticketEx(TicketException e){
        
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({FlightRouteException.class})
    public ResponseEntity<Object> flightRouteEx(FlightRouteException e){
        
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AirlineCompanyException.class})
    public ResponseEntity<Object> airlineCompanyEx(AirlineCompanyException e){
        
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AirportException.class})
    public ResponseEntity<Object> airportEx(AirportException e){
        
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    
}