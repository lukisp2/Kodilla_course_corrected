package com.kodilla.patterns.builder.pizza.bigmac;

import com.kodilla.patterns.builder.bigmac.BigMac;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BigMacTestSuite {

    @Test
    public void testMacBuilder() {
        //Given
        BigMac bigMac = new BigMac
                .BigMacBuilder()
                .bun("Plain")
                .burgers(2)
                .sauce("Onion")
                .ingredient(BigMac.BigMacBuilder.BEACON)
                .ingredient(BigMac.BigMacBuilder.ONION)
                .ingredient(BigMac.BigMacBuilder.SALAD)
                .buildBigMac();

        //When
        String bunType = bigMac.getBun();
        int numberOfIngredients = bigMac.getIngredients().size();
        String sauceType = bigMac.getSauce();
        int burgersNumber = bigMac.getBurgers();

        //Then
        Assertions.assertTrue(bigMac.getIngredients().contains("BEACON"));
        Assertions.assertTrue(bigMac.getIngredients().contains("ONION"));
        Assertions.assertTrue(bigMac.getIngredients().contains("SALAD"));
        Assertions.assertEquals(2, burgersNumber);
        Assertions.assertEquals("Plain", bunType);
        Assertions.assertEquals(3, numberOfIngredients);
        Assertions.assertEquals("Onion", sauceType);
    }
}

