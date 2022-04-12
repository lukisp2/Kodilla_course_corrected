package com.kodilla.exception.test;

public class Main {
    public static void main(String[] args) {
        Flight flight1 = new Flight("Warszawa", "NY");
        Flight flight2 = new Flight("Warszawa", "Wilno");
        Flight flight3 = new Flight("Warszawa", "Kijów");

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

        try {
            logic.findFlight(flight3);
        } catch (AirportNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}