package com.kodilla.kodilla.good.patterns.challenges.allegro;

public class ProductPurchaseRepository implements PurchaseRepository {

  public void createPurchase(User user, Product product){
        System.out.println("Creating a purchase in repository for " + user.getName() +
                " " + product.getName());
    }

}
