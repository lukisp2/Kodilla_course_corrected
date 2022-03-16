package com.kodilla_2.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;

public class TemperaturesStub implements Temperature {

    public Map<String, Double> getTemperatures() {

        Map<String, Double> stubResult = new HashMap<>();
        stubResult.put("Rzeszów", 25.5);
        stubResult.put("Warszawa", 21.5);
        stubResult.put("Gdansk", 22.5);
        stubResult.put("Wroclaw", 24.5);
        stubResult.put("Gdynia", 20.5);

        return stubResult;


    }


}
