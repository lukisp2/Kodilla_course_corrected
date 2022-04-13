package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies(){
        //Given
        Millenials millenials = new Millenials("John");
        YGeneration yGeneration = new YGeneration("Melinda");
        ZGeneration zGeneration = new ZGeneration("Tom");
        //When
        String millenialsShare = millenials.sharePost();
        String yGenerationShare = yGeneration.sharePost();
        String zGenerationShare = zGeneration.sharePost();
        //Then
        Assertions.assertEquals("Facebook",millenialsShare);
        Assertions.assertEquals("Snapchat",yGenerationShare);
        Assertions.assertEquals("Twitter",zGenerationShare);

    }

    @Test
    public void testIndividualSharingStrategy(){
        //Given
        Millenials millenials = new Millenials("John");
        YGeneration yGeneration = new YGeneration("Melinda");
        ZGeneration zGeneration = new ZGeneration("Tom");

        //When
        millenials.socialChange(new TwitterPublisher());
        yGeneration.socialChange(new TwitterPublisher());
        zGeneration.socialChange(new TwitterPublisher());

        //Then
        Assertions.assertEquals("Twitter",millenials.sharePost());
        Assertions.assertEquals("Twitter",yGeneration.sharePost());
        Assertions.assertEquals("Twitter",zGeneration.sharePost());


    }
}
