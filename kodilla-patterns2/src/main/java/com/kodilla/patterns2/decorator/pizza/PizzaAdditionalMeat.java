package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaAdditionalMeat extends AbstractPizzaDecorator {
    public PizzaAdditionalMeat(Pizza pizza) {
        super(pizza);
    }


    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(BigDecimal.valueOf(5));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " + additional meat";
    }

}
