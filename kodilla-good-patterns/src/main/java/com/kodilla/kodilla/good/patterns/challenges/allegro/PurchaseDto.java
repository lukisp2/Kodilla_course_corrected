package com.kodilla.kodilla.good.patterns.challenges.allegro;

public class PurchaseDto {
    private User user;
    private boolean isBought;

    public PurchaseDto(User user, boolean isBought) {
        this.user = user;
        this.isBought = isBought;
    }

}
