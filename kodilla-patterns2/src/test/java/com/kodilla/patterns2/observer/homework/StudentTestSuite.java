package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTestSuite {

    @Test
    public void homeworkTest() {
        //Given
        Teacher teacher1 = new Teacher("John_teacher");
        Teacher teacher2 = new Teacher("Simona_teacher");
        Student student1 = new Student("Bob_student");
        Student student2 = new Student("Ben_student");
        Student student3 = new Student("Ana_student");
        student1.registerObserver(teacher1);
        student2.registerObserver(teacher2);
        student3.registerObserver(teacher2);
        //When
        student1.addHomework("Task 1");
        student1.addHomework("Task 2");
        student2.addHomework("Task 1");
        student3.addHomework("Task 1");
        student3.addHomework("Task 2");
        student3.addHomework("Task 3");
        student3.addHomework("Task 4");
        //Then
        Assertions.assertEquals(2, teacher1.getUpdateCount());
        Assertions.assertEquals(5, teacher2.getUpdateCount());
    }
}
