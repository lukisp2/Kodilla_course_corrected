package com.kodilla.kodilla.good.patterns.challenges.Food2Door_v2;

import com.kodilla.kodilla.good.patterns.challenges.Food2Door_v2.OrderRetriever;

public class Main {
    public static void main(String[] args) {
        OrderRetriever orderRetriever = new OrderRetriever();
        Processor processor = new Processor(new ExtraFoodShop(), new GlutenFreeShop(), new HealthyShop());
        processor.processDto(orderRetriever.getOrder());
    }
}
