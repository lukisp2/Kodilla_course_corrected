package com.kodilla.kodilla.good.patterns.challenges.Food2Door_v2;


public class GlutenFreeShop {

    public String getName() {
        return "GlutenFreeShop";
    }

    public String getOrderType(OrderDto orderDto) {
        return orderDto.getOrderType();
    }

    public double getQuantity(OrderDto orderDto) {
        return orderDto.getOrderQuantity();
    }

    public OrderDto process(OrderDto orderDto) {
        System.out.println("Przetwarzam GlutenFreeShop -> zamówiono "
                + orderDto.getOrderType() + " w liczbie " + orderDto.getOrderQuantity() * 2 + " kobialek");
        orderDto.setOrderSuccess(true);
        return orderDto;
    }
}
