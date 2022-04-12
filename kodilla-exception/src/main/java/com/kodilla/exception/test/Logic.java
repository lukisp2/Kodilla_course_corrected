package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class Logic {
    private Map<String, Boolean> flightMap = new HashMap<>();

    public Logic() {
        flightMap.put("Warszawa", true);
        flightMap.put("Gdańsk", true);
        flightMap.put("Kraków", true);
        flightMap.put("Hamburg", true);
        flightMap.put("Wilno", true);
        flightMap.put("Kijów", false);
    }

    public void findFlight(Flight flight) throws AirportNotFoundException {

        if (flightMap.get(flight.arrivalAirport) == null || flightMap.get(flight.departureAirport) == null) {
            throw new AirportNotFoundException("Exception - > One or more objects not in the database");
        }

        if (flightMap.get(flight.departureAirport) && flightMap.get(flight.arrivalAirport)) {
            System.out.println("Ok " + flight.departureAirport + " " + flight.arrivalAirport);
        }

        if (!flightMap.get(flight.arrivalAirport) || !flightMap.get(flight.departureAirport)) {
            throw new AirportNotFoundException("Exception -> Airport exists but not available");
        }



    }
}


