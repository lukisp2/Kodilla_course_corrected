package com.kodilla.decorator.pizza;

import com.kodilla.patterns2.decorator.pizza.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PizzaTestSuite {

    @Test
    public void testPizzaWithoutAdditionalIngredients() {
        //Given
        Pizza pizza = new BasicPizza();
        //When
        BigDecimal cost = pizza.getPrice();
        String description = pizza.getIngredients();
        //Then
        Assertions.assertEquals(BigDecimal.valueOf(15),cost);
        Assertions.assertEquals("Pizza base + tomato sauce + cheese",description);
    }

    @Test
    public void testPizzaWithOneAdditionalIngredient() {
        //Given
        Pizza pizza = new BasicPizza();
        pizza = new PizzaAdditionalCheese(pizza);
        //When
        BigDecimal cost = pizza.getPrice();
        String description = pizza.getIngredients();
        //Then
        Assertions.assertEquals(BigDecimal.valueOf(20),cost);
        Assertions.assertEquals("Pizza base + tomato sauce + cheese + additional cheese",description);
    }

    @Test void testPizzaWithManyAdditionalIngredients() {

        //Given
        Pizza pizza = new BasicPizza();
        pizza = new PizzaAdditionalCheese(pizza);
        pizza = new PizzaAdditionalTomatos(pizza);
        pizza = new PizzaAdditionalMeat(pizza);
        //When
        BigDecimal cost = pizza.getPrice();
        String description = pizza.getIngredients();
        //Then
        Assertions.assertEquals(BigDecimal.valueOf(30),cost);
        Assertions.assertEquals("Pizza base + tomato sauce + cheese + additional cheese + additional tomatos + additional meat",description);

    }

}
