package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {

    private final BigDecimal people;

    public Country(BigDecimal people) {
        this.people = people;
    }

    public BigDecimal getPeopleQuantity(){

        return this.people;
    }

}
