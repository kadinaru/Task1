package com.example.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private double width, height;

    public Rectangle(Color color, Color borderColor, double x, double y, double width, double height) {
        super(color, borderColor, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
        gc.setStroke(borderColor);
        gc.strokeRect(x, y, width, height);
    }
}
