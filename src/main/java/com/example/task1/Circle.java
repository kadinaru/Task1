package com.example.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    private double radius;

    public Circle(Color color, Color borderColor, double x, double y, double radius) {
        super(color, borderColor, x, y);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(x, y, radius * 2, radius * 2);
        gc.setStroke(borderColor);
        gc.strokeOval(x, y, radius * 2, radius * 2);
    }
}
