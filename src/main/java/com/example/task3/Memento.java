package com.example.task3;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Memento {
    private final Shape shape;
    private final double strokeWidth;
    private final Color strokeColor;

    public Memento(Shape shape) {
        this.shape = shape;
        this.strokeWidth = shape.getStrokeWidth();
        this.strokeColor = (Color) shape.getStroke();
    }

    public Shape highlight() {
        shape.setStrokeWidth(2);
        shape.setStroke(Color.RED);
        return shape;
    }

    public Shape restore() {
        shape.setStrokeWidth(strokeWidth);
        shape.setStroke(strokeColor);
        return shape;
    }
}
