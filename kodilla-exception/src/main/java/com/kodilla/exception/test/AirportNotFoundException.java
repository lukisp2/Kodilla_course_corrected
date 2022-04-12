package com.kodilla.exception.test;

public class AirportNotFoundException extends Exception{
    public AirportNotFoundException(String message) {
        super(message);
    }
}
