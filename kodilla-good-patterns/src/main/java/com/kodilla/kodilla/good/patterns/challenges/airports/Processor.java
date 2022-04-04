package com.kodilla.kodilla.good.patterns.challenges.airports;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Processor {

    public void allFlights(Set<Flight> flightSet) {
        flightSet.stream().forEach(System.out::println);
    }

    public void flightsFrom(String airport, Set<Flight> flightSet) {
        System.out.println("Flights form " + airport + "\n");
        flightSet.stream().filter(flight -> flight.getOutAirport().equals(airport))
                .forEach(System.out::println);
    }

    public void flightTo(String airport, Set<Flight> flightSet) {
        System.out.println("Flights to " + airport + "\n");
        flightSet
                .stream()
                .filter(flight -> flight.getInAirport().equals(airport))
                .forEach(System.out::println);
    }

    private List<Flight> checkDirectFlights(String airportOut, String airportIn, Set<Flight> flightSet){
        List<Flight> directList = flightSet.stream()
                .filter(flight -> flight.getInAirport() == airportIn && flight.getOutAirport() == airportOut)
                .collect(Collectors.toList());
        return directList;
    }

    public void flightPlan(String airportOut, String airportIn, Set<Flight> flightSet) {
        //Check direct flights
        List<Flight> directList = checkDirectFlights(airportOut,airportIn,flightSet);

        if (directList.size() > 0) {
            System.out.println("Direct Flight Possible!");
            directList.stream().forEach(System.out::println);
        } else {
            System.out.println("Direct Flight not possible!! Arranging indirect flights!!");
            //Check indirect flights
            List<String> outList = flightSet.stream()
                    .filter(flight -> flight.getOutAirport().equals(airportOut))
                    .map(flight -> flight.getInAirport())
                    .collect(Collectors.toList());

            List<String> inList = flightSet.stream()
                    .filter(flight -> flight.getInAirport().equals(airportIn))
                    .map(flight -> flight.getOutAirport())
                    .collect(Collectors.toList());

            List<Flight> indirectFlights = new ArrayList<>();
            for (String element1 : outList) {
                for (String element2 : inList) {
                    if (element1 == element2) {
                        indirectFlights.add(new Flight(airportOut, element1));
                        indirectFlights.add(new Flight(element2, airportIn));
                    }
                }
            }
            if(indirectFlights.size()>0) System.out.println("List of indirectFlights: \n" + indirectFlights);
        }
    }
}
