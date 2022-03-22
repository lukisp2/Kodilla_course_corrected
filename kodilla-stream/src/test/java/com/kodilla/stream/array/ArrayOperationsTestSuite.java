package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        int[] numbers = new int[3];
        numbers[0]=10;
        numbers[1]=5;
        numbers[2]=0;

       double test = ArrayOperations.getAverage(numbers);

        Assertions.assertEquals(5,test);

    }
}
