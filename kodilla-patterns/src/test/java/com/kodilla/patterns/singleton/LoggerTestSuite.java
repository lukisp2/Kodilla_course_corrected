package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void  addSomeTextToLog(){
        logger = Logger.INSTANCE;
        logger.log("TEXT_TEXT");
    }

    @Test
    public void getLastLogTest(){
        //Given
        //When
        String str = logger.getLastLog();
        //Then
        Assertions.assertEquals("TEXT_TEXT",str);

    }
}
