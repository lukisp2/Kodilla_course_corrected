package com.kodilla.kodilla.good.patterns.challenges.allegro;

public class Main {

    public static void main(String[] args) {

        PurchaseRequestRetriever purchaseRequestRetriever = new PurchaseRequestRetriever();
        PurchaseRequest purchaseRequest = purchaseRequestRetriever.retrieve();
        ProductOrderService productOrderService = new ProductOrderService(
                new MailService() , new ProductPurchaseService(), new ProductPurchaseRepository());
        productOrderService.process(purchaseRequest);

    }
}
