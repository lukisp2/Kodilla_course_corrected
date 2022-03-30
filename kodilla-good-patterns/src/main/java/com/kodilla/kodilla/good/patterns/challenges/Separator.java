package com.kodilla.kodilla.good.patterns.challenges;

import java.util.*;
import java.util.stream.Collectors;

public class Separator {
    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();
        String str = movieStore
                .getMovies()
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.joining("!"));
        System.out.println(str);

    }
}
