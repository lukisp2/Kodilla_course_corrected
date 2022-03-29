package com.kodilla.kodilla.good.patterns.challenges;

import java.util.*;
import java.util.stream.Collectors;

public class Separator {
    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();
        List<String> list = new ArrayList<>();
        movieStore
                .getMovies()
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .map(e->e+"!")
                .forEach(System.out::print);

    }
}
