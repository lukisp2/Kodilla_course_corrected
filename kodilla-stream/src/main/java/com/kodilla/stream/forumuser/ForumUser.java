package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int userId;
    private final String username;
    private final  char sex;
    private final LocalDate birthDate;
    private final int postsPublished;

    public ForumUser(int userId, String username, char sex, int year, int month, int day, int postsPublished) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.birthDate = LocalDate.of(year,month,day);
        this.postsPublished = postsPublished;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getYear(){
        return birthDate.getYear();
    }

    public int getPostsPublished() {
        return postsPublished;
    }
}
