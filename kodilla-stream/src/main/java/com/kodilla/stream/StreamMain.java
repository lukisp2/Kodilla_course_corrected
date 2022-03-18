package com.kodilla.stream;


import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {

    public static void main(String[] args) {

        Forum forum = new Forum();
        System.out.println("All users:");
        forum.getUserList().stream().map(forumUser -> forumUser.getUsername()).forEach(System.out::println);
        System.out.println("++++++++++++");
        System.out.println("All male users:");
        List<ForumUser> maleList =
                forum.getUserList().stream().filter(forumUser -> forumUser.getSex() == 'M').collect(Collectors.toList());
        maleList.stream().map(forumUser -> forumUser.getUsername()).forEach(System.out::println);
        System.out.println("++++++++++++");
        System.out.println("All users older then 20:");
        List<ForumUser> twentyOrMore =
                forum.getUserList().stream().filter(forumUser ->
                        (LocalDate.now().getYear() - forumUser.getYear()) > 20).collect(Collectors.toList());
        twentyOrMore.stream().map(forumUser -> forumUser.getUsername()).forEach(System.out::println);
        System.out.println("++++++++++++");
        System.out.println("All users with more then one post:");
        List<ForumUser> unlessOnePost = forum.getUserList().stream().filter(forumUser -> forumUser.getPostsPublished() >= 1).collect(Collectors.toList());
        unlessOnePost.stream().map(forumUser -> forumUser.getUsername()).forEach(System.out::println);
        System.out.println("++++++++++++");
        System.out.println("User map:");
        Map<Integer, ForumUser> userMap = forum.getUserList().stream().collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));
        userMap.entrySet().stream().map(entry -> entry.getKey() + " : " + entry.getValue().getUsername()).forEach(System.out::println);
    }
}