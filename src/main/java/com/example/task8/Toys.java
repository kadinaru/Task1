package com.example.task8;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Toys extends TreeDecorator {
    private static final int TOY_COUNT = 15;
    private static final double TREE_TOP_X = 200.0;
    private static final double TREE_TOP_Y = 50.0;
    private static final double TREE_BOTTOM_Y = 285.0;
    private static final double MIN_RADIUS = 5.0;
    private static final double MAX_RADIUS = 8.0;

    private static List<Circle> toys = new ArrayList<>();
    private static final Color[] TOY_COLORS = {Color.CYAN, Color.DODGERBLUE, Color.WHITE};

    public Toys(ChristmasTree tree) {
        super(tree);
    }

    @Override
    public void Operation(Pane pane) {
        super.Operation(pane);

        if (toys.isEmpty()) {
            drawWithToys();
        }

        for (Circle toy : toys) {
            if (!pane.getChildren().contains(toy)) {
                pane.getChildren().add(toy);
            }
        }
    }

    private void drawWithToys() {
        Random random = new Random();

        for (int i = 0; i < TOY_COUNT; i++) {
            boolean placed = false;

            while (!placed) {
                double x = 120 + random.nextDouble() * 160;
                double y = TREE_TOP_Y + random.nextDouble() * (TREE_BOTTOM_Y - TREE_TOP_Y);
                double radius = MIN_RADIUS + random.nextDouble() * (MAX_RADIUS - MIN_RADIUS);

                if (isInsideTree(x, y) && !overlapsExisting(toys, x, y, radius)) {
                    Circle toy = new Circle(x, y, radius, getRandomToyColor(random));
                    toys.add(toy);
                    placed = true;
                }
            }
        }
    }

    private boolean isInsideTree(double x, double y) {
        return isInsideTriangle(x, y, 200, 50, 240, 110, 160, 110) ||
                isInsideTriangle(x, y, 200, 80, 260, 160, 140, 160) ||
                isInsideTriangle(x, y, 200, 130, 280, 220, 120, 220) ||
                isInsideTriangle(x, y, 200, 190, 290, 285, 100, 285);
    }

    private boolean isInsideTriangle(double px, double py, double x1, double y1, double x2, double y2, double x3, double y3) {
        double denominator = (y2 - y3) * (x1 - x3) + (x3 - x2) * (y1 - y3);
        double a = ((y2 - y3) * (px - x3) + (x3 - x2) * (py - y3)) / denominator;
        double b = ((y3 - y1) * (px - x3) + (x1 - x3) * (py - y3)) / denominator;
        double c = 1 - a - b;

        return a >= 0 && b >= 0 && c >= 0;
    }

    private boolean overlapsExisting(List<Circle> toys, double x, double y, double radius) {
        for (Circle toy : toys) {
            double dx = toy.getCenterX() - x;
            double dy = toy.getCenterY() - y;
            if (Math.sqrt(dx * dx + dy * dy) < toy.getRadius() + radius) {
                return true;
            }
        }
        return false;
    }

    private Color getRandomToyColor(Random random) {
        return TOY_COLORS[random.nextInt(TOY_COLORS.length)];
    }

    @Override
    public String decorate() {
        String baseDecoration = super.decorate();
        if (!baseDecoration.contains("Игрушки")) {
            return baseDecoration + ", Игрушки";
        }
        return baseDecoration;
    }

    @Override
    public float cost() {
        return super.cost() + 250.0f;
    }
}
