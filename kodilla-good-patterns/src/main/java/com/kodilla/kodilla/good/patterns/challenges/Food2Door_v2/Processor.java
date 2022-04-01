package com.kodilla.kodilla.good.patterns.challenges.Food2Door_v2;

public class Processor {
    ExtraFoodShop extraFoodShop;
    GlutenFreeShop glutenFreeShop;
    HealthyShop healthyShop;

    public Processor(ExtraFoodShop extraFoodShop, GlutenFreeShop glutenFreeShop, HealthyShop healthyShop) {
        this.extraFoodShop = extraFoodShop;
        this.glutenFreeShop = glutenFreeShop;
        this.healthyShop = healthyShop;
    }

    public OrderDto processDto(OrderDto orderDto) {
        String shop = orderDto.getShopName();
        switch (shop) {

            case "ExtraFoodShop": {
                orderDto = extraFoodShop.process(orderDto);
                break;
            }
            case "GlutenFreeShop": {
                orderDto = glutenFreeShop.process(orderDto);
                break;
            }
            case "HealthyShop": {
                orderDto = healthyShop.process(orderDto);
                break;
            }
        }
        if(orderDto.isOrderSuccess()){System.out.println("Zamówienie zrealizowane!");}
        return orderDto;
    }
}
