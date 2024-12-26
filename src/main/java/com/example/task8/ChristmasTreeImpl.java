package com.example.task8;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class ChristmasTreeImpl implements ChristmasTree {
    @Override
    public void Operation(Pane pane) {
        pane.getChildren().clear();

        Rectangle trunk = new Rectangle(185, 280, 30, 50);
        trunk.setFill(Color.SADDLEBROWN);
        pane.getChildren().add(trunk);

        Polygon layer1 = new Polygon(
                200.0, 50.0,
                240.0, 110.0,
                160.0, 110.0
        );
        layer1.setFill(Color.SEAGREEN);
        pane.getChildren().add(layer1);

        Polygon layer2 = new Polygon(
                200.0, 80.0,
                260.0, 160.0,
                140.0, 160.0
        );
        layer2.setFill(Color.FORESTGREEN);
        pane.getChildren().add(layer2);

        Polygon layer3 = new Polygon(
                200.0, 130.0,
                280.0, 220.0,
                120.0, 220.0
        );
        layer3.setFill(Color.GREEN);
        pane.getChildren().add(layer3);

        Polygon layer4 = new Polygon(
                200.0, 190.0,
                290, 285.0,
                100.0, 285.0
        );
        layer4.setFill(Color.DARKGREEN);
        pane.getChildren().add(layer4);
    }

    @Override
    public String decorate() {
        return "Новогодняя елка";
    }

    @Override
    public float cost() {
        return 2000.0f;
    }
}
