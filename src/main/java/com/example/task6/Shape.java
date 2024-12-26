package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements Cloneable {
    protected double x, y;
    protected Color color;

    public abstract void draw(GraphicsContext gc, double x, double y);

    public abstract String toString();

    public void setColor(Color color) {
        this.color = color;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Object clone() {
        Shape clone = null;
        try {
            clone = (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
