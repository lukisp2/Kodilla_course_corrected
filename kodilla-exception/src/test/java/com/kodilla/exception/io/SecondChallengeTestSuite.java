package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondChallengeTestSuite {

    @Test
    void testThrowsExceptionWhenLoadingExceptionData() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When
        //Then
        Assertions.assertAll(
                () -> Assertions.assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 1.5)),
                () -> Assertions.assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.1, 1.5)),
                () -> Assertions.assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.5, 30))
        );
    }

    @Test
    void testThrowsExceptionWhenLoadingNotExceptionData() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When
        //Then
        Assertions.assertAll(
                () -> Assertions.assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.1, 1.1)),
                () -> Assertions.assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.1, .5))
        );
    }
}
