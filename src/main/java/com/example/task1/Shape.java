package com.example.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    protected Color color;
    protected Color borderColor;
    protected double x, y;

    public Shape(Color color, Color borderColor, double x, double y) {
        this.color = color;
        this.borderColor = borderColor;
        this.x = x;
        this.y = y;
    }

    public abstract double area();
    public abstract void draw(GraphicsContext gc);

    public void setColor(Color color) {
        this.color = color;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
}
