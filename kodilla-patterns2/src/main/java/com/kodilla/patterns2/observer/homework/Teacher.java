package com.kodilla.patterns2.observer.homework;

public class Teacher implements Observer {
private String teacherName;
private int updateCount;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    public void update(Homework homework) {
        updateCount++;
        System.out.println("Homework notification no " + updateCount + " for " + this.getTeacherName() );
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
