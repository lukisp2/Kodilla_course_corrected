package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

   public Forum() {
        userList.add(new ForumUser(1, "John", 'M', 2019, 12, 14, 1));
        userList.add(new ForumUser(2, "Bob", 'M', 2020, 1, 4, 12));
        userList.add(new ForumUser(3, "Terry", 'M', 2021, 12, 31, 0));
        userList.add(new ForumUser(4, "Mark", 'M', 2021, 5, 12, 111));
        userList.add(new ForumUser(5, "Tom", 'M', 2021, 7, 4, 4));
        userList.add(new ForumUser(6, "Monica", 'F', 1910, 11, 3, 1));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
