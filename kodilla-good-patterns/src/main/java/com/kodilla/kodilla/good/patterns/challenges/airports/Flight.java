package com.kodilla.kodilla.good.patterns.challenges.airports;

import java.util.Objects;

public final class Flight {
    private final String outAirport;
    private final String inAirport;

    public Flight(String outAirport, String inAirport) {
        this.outAirport = outAirport;
        this.inAirport = inAirport;
    }

    public String getInAirport() {
        return inAirport;
    }

    public String getOutAirport() {
        return outAirport;
    }

    @Override
    public String toString() {
        return this.outAirport + " - > " + this.inAirport;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(outAirport, flight.outAirport) && Objects.equals(inAirport, flight.inAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(outAirport, inAirport);
    }
}
