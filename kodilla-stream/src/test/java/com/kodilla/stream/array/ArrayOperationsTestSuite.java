package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        int[] numbers = new int[3];
        numbers[0]=0;
        numbers[1]=1;
        numbers[2]=2;

       double test = ArrayOperations.getAverage(numbers);

        Assertions.assertEquals(1,test);

    }
}
