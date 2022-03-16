package com.kodilla_2.testing.shape;


public class Square implements Shape {

    private int length;

    public Square(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return length == square.length;
    }

    @Override
    public int hashCode() {
        return length;
    }

    public String getShapeName() {
        return "This is a square.";
    }

    public double getField() {

        return length * length;
    }
}



