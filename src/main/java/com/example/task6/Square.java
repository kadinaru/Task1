package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {

    @Override
    public void draw(GraphicsContext gc, double x, double y) {
        gc.setFill(color);
        gc.fillRect(x - 25, y - 25, 50, 50);
    }

    @Override
    public String toString() {
        return "Square";
    }
}
