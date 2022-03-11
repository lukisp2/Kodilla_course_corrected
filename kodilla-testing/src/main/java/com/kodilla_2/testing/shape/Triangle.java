package com.kodilla_2.testing.shape;

public class Triangle implements Shape {
    private int baseOfTriangle;
    private int height;

    public Triangle(int baseOfTriangle, int height) {
        this.baseOfTriangle = baseOfTriangle;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (baseOfTriangle != triangle.baseOfTriangle) return false;
        return height == triangle.height;
    }

    @Override
    public int hashCode() {
        int result = baseOfTriangle;
        result = 31 * result + height;
        return result;
    }

    @Override
    public String getShapeName() {
        return "This is a triangle;";
    }

    public double getField() {
        return this.baseOfTriangle * this.height * 0.5;
    }
}