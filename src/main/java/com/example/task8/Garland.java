package com.example.task8;

import javafx.animation.FadeTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

public class Garland extends TreeDecorator {
    public Garland(ChristmasTree tree) {
        super(tree);
    }

    @Override
    public void Operation(Pane pane) {
        super.Operation(pane);
        drawGarlands(pane);
    }

    private void drawGarlands(Pane pane) {
        drawInvertedArc(pane, 160, 110, 240, 110, 5);
        drawInvertedArc(pane, 140, 160, 260, 160, 6);
        drawInvertedArc(pane, 120, 220, 280, 220, 7);
        drawInvertedArc(pane, 100, 285, 290, 285, 8);
    }

    private void drawInvertedArc(Pane pane, double startX, double startY, double endX, double endY, int numLights) {
        Polyline arc = new Polyline();
        for (int i = 0; i <= 100; i++) {
            double t = i / 100.0;
            double x = startX + (endX - startX) * t;
            double y = startY + Math.sin(t * Math.PI) * 20;
            arc.getPoints().addAll(x, y);
        }

        for (int i = 0; i < numLights; i++) {
            double t = (double) i / (numLights - 1);
            double x = startX + (endX - startX) * t;
            double y = startY + Math.sin(t * Math.PI) * 20;
            Circle light = new Circle(x, y, 5, Color.GOLD);

            FadeTransition ft = new FadeTransition(Duration.seconds(1), light);
            ft.setFromValue(1.0);
            ft.setToValue(0.3);
            ft.setCycleCount(FadeTransition.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();

            pane.getChildren().add(light);
        }
    }

    @Override
    public String decorate() {
        String baseDecoration = super.decorate();
        if (!baseDecoration.contains("Гирлянда")) {
            return baseDecoration + ", Гирлянда";
        }
        return baseDecoration;
    }

    @Override
    public float cost() {
        return super.cost() + 200.0f;
    }
}
