package com.kodilla.kodilla.good.patterns.challenges.Food2Door;

public class ExtraFoodShop implements Shop {

    private String orderType;
    private double quantity;

    public ExtraFoodShop(String orderType, double quantity) {
        this.orderType = orderType;
        this.quantity = quantity;
    }

    public String getName() {
        return "ExtraFoodShop";
    }

    @Override
    public String getOrderType() {
        return orderType;
    }

    @Override
    public double getQuantity() {
        return quantity;
    }

    public boolean process() {
        System.out.println("Przetwarzam Extra Shop zamówiono -> "
                + this.orderType + " o wadze  " + this.quantity + " kg");
        return true;
    }
}
