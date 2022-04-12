package com.kodilla.kodilla.good.patterns.challenges.Food2Door_v2;


public class HealthyShop {

    public String getName(){
        return "HealthyShop";
    }

    public String getOrderType(OrderDto orderDto) {
        return orderDto.getOrderType();
    }

    public double getQuantity(OrderDto orderDto) {
        return orderDto.getOrderQuantity();
    }

    public OrderDto process(OrderDto orderDto){
        System.out.println("Przetwarzam HealthyShop -> zamowiono "
                + orderDto.getOrderType() + " w ilosci " + orderDto.getOrderQuantity() + " bochenkow");
        orderDto.setOrderSuccess(true);
        return orderDto;
    }
}
