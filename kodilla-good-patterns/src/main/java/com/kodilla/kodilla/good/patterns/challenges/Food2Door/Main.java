package com.kodilla.kodilla.good.patterns.challenges.Food2Door;

public class Main {
    public static void main(String[] args) {

        OrderRetriever orderRetriever = new OrderRetriever();
        AllOrders allOrders = new AllOrders(orderRetriever.retrieve());
        OrderMaker orderMaker = new OrderMaker();
        orderMaker.make(allOrders.getShopList());

    }
}