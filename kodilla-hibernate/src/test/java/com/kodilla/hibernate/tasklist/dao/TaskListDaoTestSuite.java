package com.kodilla.hibernate.tasklist.dao;


import com.kodilla.hibernate.task.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("ListOne", "This is first list");
        taskListDao.save(taskList);
        //When
        List<TaskList> foundList = taskListDao.findByListName(taskList.getListName());
        //Then
        Assertions.assertEquals(1, foundList.size());
        //Cleanup
        taskListDao.deleteAll();
    }
}
