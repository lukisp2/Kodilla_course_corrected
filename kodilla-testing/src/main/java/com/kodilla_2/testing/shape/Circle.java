package com.kodilla_2.testing.shape;

public class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return radius;
    }

    public String getShapeName() {
        return "This is a circle";
    }

    @Override
    public double getField() {
        return 3.14 * radius * radius;
    }
}


