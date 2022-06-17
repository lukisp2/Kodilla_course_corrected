package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizza implements Pizza {

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(15);
    }

    @Override
    public String getIngredients() {
        return "Pizza base + tomato sauce + cheese";
    }

}
