package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country poland = new Country(new BigDecimal(2));
        Country germany = new Country(new BigDecimal(10));
        Country chile = new Country(new BigDecimal(11));
        Country peru = new Country(new BigDecimal(0));
        Country australia = new Country(new BigDecimal(8));
        Country india = new Country(new BigDecimal(2));
        Country china = new Country(new BigDecimal(1));

        Continent asia = new Continent();
        Continent europe = new Continent();
        Continent southAmerica = new Continent();
        Continent australiaContinent = new Continent();

        asia.addCountry(china);
        asia.addCountry(india);
        australiaContinent.addCountry(australia);
        europe.addCountry(poland);
        europe.addCountry(germany);
        southAmerica.addCountry(chile);
        southAmerica.addCountry(peru);

        World world = new World();
        world.addContinent(asia);
        world.addContinent(europe);
        world.addContinent(southAmerica);
        world.addContinent(australiaContinent);
        //When
        BigDecimal total = world.getPeopleQuantity();
        BigDecimal expected = BigDecimal.valueOf(34);
        //Then
        Assertions.assertEquals(expected,total);
    }
}
