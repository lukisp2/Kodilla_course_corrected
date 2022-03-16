package com.kodilla_2.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperature temperature;

    public WeatherForecast(Temperature temperature) {

        this.temperature = temperature;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        for (Map.Entry<String, Double> temperature : temperature.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateMean() {
        double sum = 0;
        for (Map.Entry<String, Double> element : temperature.getTemperatures().entrySet()) {
            sum += element.getValue();
        }
        return sum / temperature.getTemperatures().size();
    }

    public double calculateMedian() {
        List<Double> list = new ArrayList<>();
        for (Map.Entry<String, Double> element : temperature.getTemperatures().entrySet()) {
            list.add(element.getValue());
        }

        Collections.sort(list);

        if (list.size() % 2 == 0) {
            int lower = list.size() / 2;
            int upper = lower + 1;
            return (list.get(lower + 1) + list.get(upper + 1)) / 2;
        }
        else {
            double halfSize = list.size() / 2 + 0.5;
            return list.get((int) halfSize);
        }
    }
}

