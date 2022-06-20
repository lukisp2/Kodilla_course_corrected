package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeworkTestSuite {

    @Test
    public void homeworkTest() {
        //Given
        Teacher teacher1 = new Teacher("John_teacher");
        Teacher teacher2 = new Teacher("Simona_teacher");
        Homework homework1 = new Homework("Bob_student");
        Homework homework2 = new Homework("Ben_student");
        Homework homework3 = new Homework("Ana_student");
        homework1.registerObserver(teacher1);
        homework2.registerObserver(teacher2);
        homework3.registerObserver(teacher2);

        //When
        homework1.addHomework("Task 1");
        homework1.addHomework("Task 2");
        homework2.addHomework("Task 1");
        homework3.addHomework("Task 1");
        homework3.addHomework("Task 2");
        homework3.addHomework("Task 3");
        homework3.addHomework("Task 4");

        //Then
        Assertions.assertEquals(2, teacher1.getUpdateCount());
        Assertions.assertEquals(5, teacher2.getUpdateCount());


    }
}
