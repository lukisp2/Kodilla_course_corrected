package com.kodilla.kodilla.good.patterns.challenges.Food2Door;

import java.util.List;

public class OrderMaker {

    public boolean make(List<Shop> shopList) {
        int success = 0;
        for (Shop element : shopList) {
            if(element.process()){success++;}
        }

        System.out.println(success + " out of " + shopList.size() + " ordered!");

        if(shopList.size()==success){return true;}
        return false;
    }

}
