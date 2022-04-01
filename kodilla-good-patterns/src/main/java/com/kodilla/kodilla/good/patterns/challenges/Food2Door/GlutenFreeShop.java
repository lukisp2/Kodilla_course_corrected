package com.kodilla.kodilla.good.patterns.challenges.Food2Door;

public class GlutenFreeShop implements Shop {

    private String orderType;
    private double quantity;

    public GlutenFreeShop(String orderType, double quantity) {
        this.orderType = orderType;
        this.quantity = quantity;
    }

    public String getName(){
        return "GlutenFreeShop";
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
        System.out.println("Przetwarzam GlutenFreeShop -> zamówiono "
                + this.orderType + " w liczbie " + this.quantity*2 + " kobialek");
        return true;

    }
}
