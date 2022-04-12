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
        board.getDoneList().getTask().add("DONE");
        board.getInProgressList().getTask().add("PROGRESS");
        board.getToDoList().getTask().add("TODO");

        //Then
        String doneListString = board.getDoneList().getTask().get(0);
        String inProgressListString = board.getInProgressList().getTask().get(0);
        String toDoListString = board.getToDoList().getTask().get(0);

        Assertions.assertEquals("DONE", doneListString);
        Assertions.assertEquals("PROGRESS", inProgressListString);
        Assertions.assertEquals("TODO", toDoListString);


    }

}
