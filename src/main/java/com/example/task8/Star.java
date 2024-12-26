package com.example.task8;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Star extends TreeDecorator {
    public Star(ChristmasTree tree) {
        super(tree);
    }

    @Override
    public void Operation(Pane pane) {
        super.Operation(pane);
        drawStar(pane);
    }

    private void drawStar(Pane pane) {
        Polygon outerStar = createStar(200, 30, 30, 15, Color.DODGERBLUE);
        pane.getChildren().add(outerStar);

        Polygon middleStar = createStar(200, 30, 20, 10, Color.CYAN);
        pane.getChildren().add(middleStar);

        Polygon innerStar = createStar(200, 30, 10, 5, Color.WHITE);
        pane.getChildren().add(innerStar);
    }


    private Polygon createStar(double centerX, double centerY, double outerRadius, double innerRadius, Color color) {
        Polygon star = new Polygon();
        int numPoints = 10;
        for (int i = 0; i < numPoints; i++) {
            double angle = Math.toRadians((360.0 / numPoints) * i - 90);
            double radius = (i % 2 == 0) ? outerRadius : innerRadius;
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            star.getPoints().addAll(x, y);
        }
        star.setFill(color);
        return star;
    }

    @Override
    public String decorate() {
        String baseDecoration = super.decorate();
        if (!baseDecoration.contains("Звезда")) {
            return baseDecoration + ", Звезда";
        }
        return baseDecoration;
    }


    @Override
    public float cost() {
        return super.cost() + 150.0f;
    }
}
