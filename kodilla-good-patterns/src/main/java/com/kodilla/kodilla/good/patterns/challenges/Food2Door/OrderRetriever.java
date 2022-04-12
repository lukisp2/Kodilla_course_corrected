package com.kodilla.kodilla.good.patterns.challenges.Food2Door;

import java.util.ArrayList;
import java.util.List;

public class OrderRetriever {
    List<Shop> shopList = new ArrayList<>();

    public List<Shop> retrieve() {
        shopList.add(new ExtraFoodShop("Truskawki", 11));
        shopList.add(new GlutenFreeShop("Maliny", 11));
        shopList.add(new HealthyShop("Chleb", 11));

        return shopList;
    }
}
