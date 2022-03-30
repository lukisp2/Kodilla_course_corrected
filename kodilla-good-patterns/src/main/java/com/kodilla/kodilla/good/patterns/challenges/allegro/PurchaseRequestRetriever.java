package com.kodilla.kodilla.good.patterns.challenges.allegro;

public class PurchaseRequestRetriever {

    public PurchaseRequest retrieve() {
        User user = new User("Lukasz", "Marchel");
        Product product = new Product("Pralka", 2000);
        return new PurchaseRequest(user, product);
    }
}
