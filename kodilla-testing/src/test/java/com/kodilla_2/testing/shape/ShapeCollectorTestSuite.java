package com.kodilla_2.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ShapeCollectorTestSuite {
    @Nested
    @DisplayName("Tests of ShapeCollector")
    class TestCollector {

        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            shapeCollector.addFigure(new Circle(10));
            //Then
            Assertions.assertEquals(1, shapeCollector.getShapes().size());
        }

        @Test
        void testRemoveFigure() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            Circle circle = new Circle(10);
            shapeCollector.addFigure(circle);
            shapeCollector.removeFigure(circle);
            //Then
            Assertions.assertEquals(0, shapeCollector.getShapes().size());

        }


        @Test
        void testGetFigure() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            Circle circle = new Circle(10);
            shapeCollector.addFigure(circle);
            //Then
            Assertions.assertEquals(circle, shapeCollector.getFigure(0));
        }


        @Test
        void testShowFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            Circle circle = new Circle(10);
            shapeCollector.addFigure(circle);
            //Then
            Assertions.assertEquals("This is a circle", shapeCollector.getFigure(0).getShapeName());
        }


    }
}
