package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class BigMac {

    private String bun;
    private int burgers;
    private String sauce;
    private List<String> ingredients;

    public static class BigMacBuilder {
        public static final String SALAD = "SALAD";
        public static final String ONION = "ONION";
        public static final String BEACON = "BEACON";
        public static final String CHILLI = "CHILLI";
        public static final String CHEESE = "CHEESE";
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigMacBuilder bun(String bun) {
            this.bun = bun;
            return this;
        }

        public BigMacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigMacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigMacBuilder ingredient(String ingredient) {
            if(ingredient.equals(SALAD)
                    || ingredient.equals(ONION)
                    || ingredient.equals(BEACON)
                    || ingredient.equals(CHILLI)
                    || ingredient.equals(CHEESE)) {
                this.ingredients.add(ingredient);
                return this;
            } else {
                return this;
            }
        }

        public BigMac buildBigMac() {
            return new BigMac(bun, burgers, sauce, ingredients);
        }

    }

    private BigMac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
