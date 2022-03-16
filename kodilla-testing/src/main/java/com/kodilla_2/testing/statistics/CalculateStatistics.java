package com.kodilla_2.testing.statistics;

public class CalculateStatistics {
    private Statistics statistics;

    private int postsNum;
    private int commentsNum;
    private int userNumber;

    private double postsForUser;
    private double commentsForUser;
    private double commentsForPost;

    public CalculateStatistics(Statistics statistics) {
        this.statistics = statistics;
        this.userNumber = statistics.usersNames().size();
        this.commentsNum = statistics.commentsCount();
        this.postsNum = statistics.postsCount();
    }

    public int getPostsNum() {
        return postsNum;
    }

    public int getCommentsNum() {
        return commentsNum;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public double getPostsForUser() {
        return postsForUser;
    }

    public double getCommentsForUser() {
        return commentsForUser;
    }

    public double getCommentsForPost() {
        return commentsForPost;
    }



    public void calculateAdvStatistics() {
        if (this.userNumber > 0) {
            this.postsForUser = (double) this.postsNum / this.userNumber;
            this.commentsForUser = (double) this.commentsNum / this.userNumber;
        } else {
            this.postsForUser = 0;
            this.commentsForUser=0;
        }

        if (this.postsNum > 0) {
            this.commentsForPost = (double) this.commentsNum / this.postsNum;
        } else {
            this.commentsForPost = 0;
        }
    }

}
