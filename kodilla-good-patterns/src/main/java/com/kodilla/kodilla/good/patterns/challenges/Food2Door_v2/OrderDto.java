package com.kodilla.kodilla.good.patterns.challenges.Food2Door_v2;

public class OrderDto {
    private String shopName;
    private boolean orderSuccess;
    private String orderType;
    private double orderQuantity;

    public OrderDto(String shopName, boolean orderSuccess, String orderType, double orderQuantity) {
        this.shopName = shopName;
        this.orderSuccess = orderSuccess;
        this.orderType = orderType;
        this.orderQuantity = orderQuantity;
    }

    public String getShopName() {
        return shopName;
    }

    public boolean isOrderSuccess() {
        return orderSuccess;
    }

    public String getOrderType() {
        return orderType;
    }

    public double getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderSuccess(Boolean success) {
        this.orderSuccess = success;
    }
}
