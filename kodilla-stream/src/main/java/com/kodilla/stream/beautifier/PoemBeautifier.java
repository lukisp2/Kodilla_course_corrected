package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String str, PoemDecorator poemDecorator) {
        String result = poemDecorator.process(str);
        System.out.println(result);
        return result;

    }

}
