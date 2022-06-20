package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Homework implements Observable {

    private Deque<String> homeworks = new ArrayDeque<>();
    private List<Observer> teachers = new ArrayList<>();
    private String studentName;

    public Homework(String studentName) {
        this.studentName = studentName;
    }

    public void addHomework(String taskName) {
        homeworks.offer(taskName);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        teachers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer teacher : teachers) {
            teacher.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        teachers.remove(observer);
    }
}
