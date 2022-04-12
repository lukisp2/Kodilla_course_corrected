package com.kodilla.kodilla.good.patterns.challenges.airports;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Processor {

    public void allFlights(Set<Flight> flightSet) {
        System.out.println("All flights: ");
        flightSet.stream().forEach(System.out::println);
    }

    public List<Flight> flightsFrom(String airport, Set<Flight> flightSet, boolean print) {
        List<Flight> flightList = flightSet.stream().filter(flight -> flight.getOutAirport().equals(airport))
                .collect(Collectors.toList());
        if (print) {
            System.out.println("Flights form " + airport);
            flightList.stream().forEach(System.out::println);
        }
        return flightList;

    }

    public List<Flight> flightTo(String airport, Set<Flight> flightSet, boolean print) {
        List<Flight> flightList = flightSet
                .stream()
                .filter(flight -> flight.getInAirport().equals(airport))
                .collect(Collectors.toList());
        if (print) {
            System.out.println("Flights to " + airport);
            flightList.stream().forEach(System.out::println);
        }
        return flightList;
    }

    private List<Flight> checkDirectFlights(String airportOut, String airportIn, Set<Flight> flightSet) {
        List<Flight> directList = flightSet.stream()
                .filter(flight -> flight.getInAirport().equals(airportIn))
                .filter(flight -> flight.getOutAirport().equals(airportOut))
                .collect(Collectors.toList());
        return directList;
    }

    public void flightPlan(String airportOut, String airportIn, Set<Flight> flightSet) {
        //Check direct flights
        List<Flight> directList = checkDirectFlights(airportOut, airportIn, flightSet);
        if (directList.size() > 0) {
            System.out.println("Direct Flight Possible!");
            directList.stream().forEach(System.out::println);
        } else {
            System.out.println("Direct Flight not possible!! Arranging indirect flights!!");

            //Check indirect flights
            List<String> outList = flightsFrom(airportOut, flightSet, false)
                    .stream()
                    .map(flight -> flight.getInAirport())
                    .collect(Collectors.toList());

            List<String> inList = flightTo(airportIn, flightSet, false)
                    .stream()
                    .map(flight -> flight.getOutAirport())
                    .collect(Collectors.toList());

            List<Flight> indirectFlights = new ArrayList<>();
            for (String element1 : outList) {
                for (String element2 : inList) {
                    if (element1.equals(element2)) {
                        indirectFlights.add(new Flight(airportOut, element1));
                        indirectFlights.add(new Flight(element2, airportIn));
                    }
                }
            }
            if (indirectFlights.size() > 0) System.out.println("List of indirectFlights: \n" + indirectFlights);
        }
    }
}
