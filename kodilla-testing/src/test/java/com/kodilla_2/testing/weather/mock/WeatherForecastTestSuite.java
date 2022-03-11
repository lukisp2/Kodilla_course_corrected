package com.kodilla_2.testing.weather.mock;

import com.kodilla_2.testing.weather.stub.Temperature;
import com.kodilla_2.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {
@Mock
private Temperature temperatureMock;

@BeforeEach
public void before(){
    HashMap<String, Double> tempMap = new HashMap<>();
    tempMap.put("Wroclaw", 10.0);
    tempMap.put("Gdansk", 11.0);
    tempMap.put("Warszawa", 12.0);
    tempMap.put("Krakow", 13.0);
    tempMap.put("NY", 14.0);
    when(temperatureMock.getTemperatures()).thenReturn(tempMap);
}

    @Test
    void testCalculateMedian() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperatureMock);
        //When
        double median = weatherForecast.calculateMedian();
        //Then
        Assertions.assertEquals(12, median);
    }

    @Test
    void testCalculateMeanTemperature() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperatureMock);
        //When
        double mean = weatherForecast.calculateMean();
        //Then
        Assertions.assertEquals(12.0, mean);
    }

    @Test
    void testCalculateForecastWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperatureMock);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }
}
