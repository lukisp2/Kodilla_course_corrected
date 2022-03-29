package com.kodilla.exception.test;

public class Main {
    public static void main(String[] args) {
        Flight flight1 = new Flight("Warszawa", "Kraków");
        Flight flight2 = new Flight("Warszawa", "Doha");

        Logic logic = new Logic();

        try {
            logic.findFlight(flight1);
        } catch (AirportNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            logic.findFlight(flight2);
        } catch (AirportNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}