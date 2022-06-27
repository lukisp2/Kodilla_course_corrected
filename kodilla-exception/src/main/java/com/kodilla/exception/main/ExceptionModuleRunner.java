package com.kodilla.exception.main;


import com.kodilla.exception.test.SecondChallenge;

public class ExceptionModuleRunner {
    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            String str = secondChallenge.probablyIWillThrowException(2, 2);
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("propablyIWillThrowException method executed");
        }

    }
}
