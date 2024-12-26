package com.example.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ellipse extends Shape {
    private double radiusX, radiusY;

    public Ellipse(Color color, Color borderColor, double x, double y, double radiusX, double radiusY) {
        super(color, borderColor, x, y);
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    @Override
    public double area() {
        return Math.PI * radiusX * radiusY;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(x, y, radiusX * 2, radiusY * 2);
        gc.setStroke(borderColor);
        gc.strokeOval(x, y, radiusX * 2, radiusY * 2);
    }
}
