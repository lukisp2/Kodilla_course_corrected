package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    List<Continent> continents = new ArrayList<>();

    public List<Continent> getContinents() {
        return this.continents;
    }

    public void addContinent(Continent continent){
        continents.add(continent);
    }


    public BigDecimal getPeopleQuantity() {

        BigDecimal total = getContinents().stream().flatMap(continent ->
                        continent.getCountries().stream()).map(country -> country.getPeopleQuantity()).
                reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return total;
    }
}
