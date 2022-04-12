package com.kodilla.kodilla.good.patterns.challenges.allegro;

public class MailService implements InformationService {
    public void inform(User user) {

        System.out.println("Mail to " + user.getName());

    }
}
