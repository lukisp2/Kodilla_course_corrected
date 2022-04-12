package com.kodilla.kodilla.good.patterns.challenges.airports;

public class Main {
    public static void main(String[] args) {

        FlightList flightList = new FlightList();
        Processor processor = new Processor();
        processor.allFlights(flightList.makeList());
        processor.flightsFrom("Gdansk", flightList.makeList(),true);
        processor.flightTo("Gdansk", flightList.makeList(),true);
        processor.flightPlan("Gdansk","Poznan",flightList.makeList());

    }
}
