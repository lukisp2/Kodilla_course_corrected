package com.kodilla.kodilla.good.patterns.challenges.Food2Door_v2;

public class ExtraFoodShop {

    public String getName() {
        return "ExtraFoodShop";
    }

    public String getOrderType(OrderDto orderDto) {
        return orderDto.getOrderType();
    }

    public double getQuantity(OrderDto orderDto) {
        return orderDto.getOrderQuantity();
    }

    public OrderDto process(OrderDto orderDto) {
        System.out.println("Przetwarzam Extra Shop zamówiono -> "
                + orderDto.getOrderType() + " o wadze  " + orderDto.getOrderQuantity() + " kg");
        orderDto.setOrderSuccess(true);
        return orderDto;
    }
}
