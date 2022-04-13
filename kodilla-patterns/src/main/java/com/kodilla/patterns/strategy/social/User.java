package com.kodilla.patterns.strategy.social;

public class User {
    String name;
    SocialPublisher publisher;

    public User(String name) {
        this.name = name;
    }

    public String sharePost(){
       return publisher.share();
    }

    public void socialChange(SocialPublisher newSocial){
        this.publisher = newSocial;
    }


}
