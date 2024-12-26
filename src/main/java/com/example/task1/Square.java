package com.example.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {
    private double side;

    public Square(Color color, Color borderColor, double x, double y, double side) {
        super(color, borderColor, x, y);
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, side, side);
        gc.setStroke(borderColor);
        gc.strokeRect(x, y, side, side);
    }
}
