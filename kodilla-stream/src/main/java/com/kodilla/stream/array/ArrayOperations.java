package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {

        double value = IntStream.range(0, numbers.length).map(n ->numbers[n]).average().getAsDouble();
        System.out.println("Wyswietlam tablice o dlugosci " + numbers.length + " elementow.");
        IntStream.range(0, numbers.length).forEach(System.out::println);
        return value;

    }

}

