package com.kodilla.kodilla.good.patterns.challenges.airports;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlightList {

    public final Set<Flight> makeList(){
         Set<Flight> flightSet = new HashSet<>();

        flightSet.add(new Flight("Gdansk","Warszawa"));
        flightSet.add(new Flight("Gdansk","Wroclaw"));
        flightSet.add(new Flight("Gdansk","Krakow"));
        flightSet.add(new Flight("Krakow","Poznan"));
        flightSet.add(new Flight("Poznan","Gdansk"));
        flightSet.add(new Flight("Warszawa","Szczecin"));
        return new HashSet<Flight>(flightSet);

    }



}
