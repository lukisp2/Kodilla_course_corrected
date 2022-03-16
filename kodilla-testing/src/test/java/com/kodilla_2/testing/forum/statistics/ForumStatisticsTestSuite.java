package com.kodilla_2.testing.forum.statistics;

import com.kodilla_2.testing.statistics.CalculateStatistics;
import com.kodilla_2.testing.statistics.Statistics;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    @Test
    void testCalculateStatisticWith0Posts() {
        //Given
        List<String> users = generateUsers(100);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        //When
        calculateStatistics.calculateAdvStatistics();
        int numberOfUsers = calculateStatistics.getUserNumber();
        int numberOfComments = calculateStatistics.getCommentsNum();
        int numberOfPosts = calculateStatistics.getPostsNum();
        double postsForUser = calculateStatistics.getPostsForUser();
        double commentsForUser = calculateStatistics.getCommentsForUser();
        double commentsForPost = calculateStatistics.getCommentsForPost();
        //Then
        Assertions.assertEquals(100, numberOfUsers);
        Assertions.assertEquals(0, numberOfComments);
        Assertions.assertEquals(0, numberOfPosts);
        Assertions.assertEquals(0, postsForUser);
        Assertions.assertEquals(0, commentsForUser);
        Assertions.assertEquals(0, commentsForPost);
    }

    @Test
    void testCalculateStatisticWith100Posts() {
        //Given
        List<String> users = generateUsers(100);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        //When
        calculateStatistics.calculateAdvStatistics();
        int numberOfUsers = calculateStatistics.getUserNumber();
        int numberOfComments = calculateStatistics.getCommentsNum();
        int numberOfPosts = calculateStatistics.getPostsNum();
        double postsForUser = calculateStatistics.getPostsForUser();
        double commentsForUser = calculateStatistics.getCommentsForUser();
        double commentsForPost = calculateStatistics.getCommentsForPost();
        //Then
        Assertions.assertEquals(100, numberOfUsers);
        Assertions.assertEquals(0, numberOfComments);
        Assertions.assertEquals(100, numberOfPosts);
        Assertions.assertEquals(1, postsForUser);
        Assertions.assertEquals(0, commentsForUser);
        Assertions.assertEquals(0, commentsForPost);

    }

    @Test
    void testCalculateStatisticWith0Comments() {
        //Given
        List<String> users = generateUsers(100);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        //When
        calculateStatistics.calculateAdvStatistics();
        int numberOfUsers = calculateStatistics.getUserNumber();
        int numberOfComments = calculateStatistics.getCommentsNum();
        int numberOfPosts = calculateStatistics.getPostsNum();
        double postsForUser = calculateStatistics.getPostsForUser();
        double commentsForUser = calculateStatistics.getCommentsForUser();
        double commentsForPost = calculateStatistics.getCommentsForPost();
        //Then
        Assertions.assertEquals(100, numberOfUsers);
        Assertions.assertEquals(0, numberOfComments);
        Assertions.assertEquals(100, numberOfPosts);
        Assertions.assertEquals(1, postsForUser);
        Assertions.assertEquals(0, commentsForUser);
        Assertions.assertEquals(0, commentsForPost);

    }

    @Test
    void testCalculateStatisticWithMorePostsThenComments() {
        //Given
        List<String> users = generateUsers(100);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        //When
        calculateStatistics.calculateAdvStatistics();
        int numberOfUsers = calculateStatistics.getUserNumber();
        int numberOfComments = calculateStatistics.getCommentsNum();
        int numberOfPosts = calculateStatistics.getPostsNum();
        double postsForUser = calculateStatistics.getPostsForUser();
        double commentsForUser = calculateStatistics.getCommentsForUser();
        double commentsForPost = calculateStatistics.getCommentsForPost();
        //Then
        Assertions.assertEquals(100, numberOfUsers);
        Assertions.assertEquals(50, numberOfComments);
        Assertions.assertEquals(100, numberOfPosts);
        Assertions.assertEquals(1, postsForUser);
        Assertions.assertEquals(0.5, commentsForUser);
        Assertions.assertEquals(0.5, commentsForPost);

    }


    @Test
    void testCalculateStatisticWithMoreCommentsThenPosts() {
        //Given
        List<String> users = generateUsers(100);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(200);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        //When
        calculateStatistics.calculateAdvStatistics();
        int numberOfUsers = calculateStatistics.getUserNumber();
        int numberOfComments = calculateStatistics.getCommentsNum();
        int numberOfPosts = calculateStatistics.getPostsNum();
        double postsForUser = calculateStatistics.getPostsForUser();
        double commentsForUser = calculateStatistics.getCommentsForUser();
        double commentsForPost = calculateStatistics.getCommentsForPost();
        //Then
        Assertions.assertEquals(100, numberOfUsers);
        Assertions.assertEquals(200, numberOfComments);
        Assertions.assertEquals(100, numberOfPosts);
        Assertions.assertEquals(1, postsForUser);
        Assertions.assertEquals(2, commentsForUser);
        Assertions.assertEquals(2, commentsForPost);
    }


    @Test
    void testCalculateStatisticWith0Users() {
        //Given
        List<String> users = generateUsers(0);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        //When
        calculateStatistics.calculateAdvStatistics();
        int numberOfUsers = calculateStatistics.getUserNumber();
        int numberOfComments = calculateStatistics.getCommentsNum();
        int numberOfPosts = calculateStatistics.getPostsNum();
        double postsForUser = calculateStatistics.getPostsForUser();
        double commentsForUser = calculateStatistics.getCommentsForUser();
        double commentsForPost = calculateStatistics.getCommentsForPost();
        //Then
        Assertions.assertEquals(0, numberOfUsers);
        Assertions.assertEquals(50, numberOfComments);
        Assertions.assertEquals(100, numberOfPosts);
        Assertions.assertEquals(0, postsForUser);
        Assertions.assertEquals(0, commentsForUser);
        Assertions.assertEquals(0.5, commentsForPost);
    }


    @Test
    void testCalculateStatisticWithM100Users() {
        //Given
        List<String> users = generateUsers(100);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        //When
        calculateStatistics.calculateAdvStatistics();
        int numberOfUsers = calculateStatistics.getUserNumber();
        int numberOfComments = calculateStatistics.getCommentsNum();
        int numberOfPosts = calculateStatistics.getPostsNum();
        double postsForUser = calculateStatistics.getPostsForUser();
        double commentsForUser = calculateStatistics.getCommentsForUser();
        double commentsForPost = calculateStatistics.getCommentsForPost();
        //Then
        Assertions.assertEquals(100, numberOfUsers);
        Assertions.assertEquals(50, numberOfComments);
        Assertions.assertEquals(100, numberOfPosts);
        Assertions.assertEquals(1, postsForUser);
        Assertions.assertEquals(0.5, commentsForUser);
        Assertions.assertEquals(0.5, commentsForPost);

    }

    private List<String> generateUsers(int n) {
        List<String> userList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            userList.add("User " + i);
        }
        return userList;
    }

}
