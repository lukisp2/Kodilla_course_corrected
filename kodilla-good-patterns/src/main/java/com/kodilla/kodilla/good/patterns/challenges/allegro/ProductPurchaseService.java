package com.kodilla.kodilla.good.patterns.challenges.allegro;

public class ProductPurchaseService implements PurchaseService {

    public boolean buy(User user, Product product) {

        System.out.println("User + " + user.getName() +
                " bought a product " + product.getName() +
                " for " + product.getPrice());
        return true;

    }

}
