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
        if (flightMap.containsKey(flight.getArrivalAirport()) && flightMap.containsKey(flight.departureAirport)) {
            System.out.println("Flight can be completed");
        } else {
            throw new AirportNotFoundException("Exception - > One or more airports not included \n " +
                    "in database or not available.");
        }
    }
}
