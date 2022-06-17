package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AbstractPizzaDecorator implements Pizza {

    private final Pizza pizza;


    public AbstractPizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public BigDecimal getPrice() {
        return pizza.getPrice();
    }

    @Override
    public String getIngredients() {
        return pizza.getIngredients();
    }
}
