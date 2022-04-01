package com.kodilla.kodilla.good.patterns.challenges.Food2Door_v2;

public class OrderRetriever {

    public OrderDto getOrder() {
        OrderDto orderDto = new OrderDto("GlutenFreeShop"
                , false, "Truskawki", 11);
        return orderDto;
    }

}
