package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    Calculator calculator;

    @Test
    public void addDoubles() {
        //Given
        //When
        double res = calculator.add(2.2, 2.2);
        //Then
        Assertions.assertEquals(4.4, res);
    }

    @Test
    public void subtractDoubles() {
        //Given
        //When
        double res = calculator.sub(2.2, 2.2);
        //Then
        Assertions.assertEquals(0, res);
    }

    @Test
    public void multiplyDoubles() {
        //Given
        //When
        double res = calculator.mul(2, 2);
        //Then
        Assertions.assertEquals(4, res);
    }

    @Test
    public void divideDoubles() {
        //Given
        //When
        double res = calculator.div(2.2, 2.2);
        //Then
        Assertions.assertEquals(1, res);
    }


}
