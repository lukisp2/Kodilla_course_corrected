package com.kodilla.kodilla.good.patterns.challenges.Food2Door;

import java.util.List;

public class AllOrders {
    private List<Shop> shopList;

    public AllOrders(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public List<Shop> getShopList() {
        return shopList;
    }
}
