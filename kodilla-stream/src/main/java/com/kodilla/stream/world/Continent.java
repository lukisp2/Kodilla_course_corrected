package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {

  private final List<Country> countries = new ArrayList<>();

    public List<Country> getCountries(){
        return this.countries;
    }

    public void addCountry(Country country){
        this.countries.add(country);
    }
}
