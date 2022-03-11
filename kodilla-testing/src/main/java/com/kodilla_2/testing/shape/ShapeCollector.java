package com.kodilla_2.testing.shape;


import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();

    public List<Shape> getShapes() {
        return shapes;
    }

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (shapes.contains(shape)) {
            shapes.remove(shape);
            return true;
        }
        return result;
    }

    public Shape getFigure(int n) {

        if (shapes.size() >= n) {
            return shapes.get(n);
        } else {
            return null;
        }
    }

    public void showFigure() {
        for (Shape element : shapes) {
            element.getShapeName();
        }
    }

}




