package com.kodilla.kodilla.good.patterns.challenges.Food2Door;

public class HealthyShop implements Shop {

    private String orderType;
    private double quantity;

    public HealthyShop(String orderType, double quantity) {
        this.orderType = orderType;
        this.quantity = quantity;
    }

    public String getName(){
        return "HealthyShop";
    }

    @Override
    public String getOrderType() {
        return orderType;
    }

    @Override
    public double getQuantity() {
        return quantity;
    }

    public boolean process(){
        System.out.println("Przetwarzam HealthyShop -> zamowiono "
                + this.orderType + " w ilosci " + this.quantity + " bochenkow");
        return true;
    }
}
