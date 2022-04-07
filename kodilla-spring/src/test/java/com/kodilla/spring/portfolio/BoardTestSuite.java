package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
public class BoardTestSuite {


    @Test
    void testBeansExistence() {
        //Given & When
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        //Then
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.doneList.task.add("DONE");
        board.inProgressList.task.add("PROGRESS");
        board.toDoList.task.add("TODO");
        //Then
        int sizeOfDoneList = board.doneList.task.size();
        int sizeOfInProgressList = board.inProgressList.task.size();
        int sizeOfToDoList = board.toDoList.task.size();

        String doneListString = board.doneList.task.get(0).toString();
        String inProgressListString = board.inProgressList.task.get(0).toString();
        String toDoListString = board.toDoList.task.get(0).toString();

        Assertions.assertEquals(1, sizeOfDoneList);
        Assertions.assertEquals(1, sizeOfInProgressList);
        Assertions.assertEquals(1, sizeOfToDoList);

        Assertions.assertEquals("DONE", doneListString);
        Assertions.assertEquals("PROGRESS", inProgressListString);
        Assertions.assertEquals("TODO", toDoListString);


    }

}
