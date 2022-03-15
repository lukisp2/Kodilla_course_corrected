package com.kodilla.stream;


import com.kodilla.stream.beautifier.PoemBeautifier;


public class StreamMain {

    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("STR", (str) -> str + "ABC");
        poemBeautifier.beautify("STR", (str) -> "ABC" + str + "ABC");
        poemBeautifier.beautify("str", String::toUpperCase);
        poemBeautifier.beautify("STR", String::toLowerCase);
        poemBeautifier.beautify("STR", (str) -> str.repeat(2));
        poemBeautifier.beautify("STR", (str) -> str.replaceAll(str, "ABC"));

    }
}