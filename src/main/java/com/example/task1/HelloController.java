package com.example.task1;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class HelloController {

    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker fillColorPicker;
    @FXML
    private ColorPicker strokeColorPicker;
    @FXML
    private TextField sizeField;
    @FXML
    private Slider strokeWidthSlider;
    @FXML
    private TextField countField;
    @FXML
    private Label infoLabel;

    @FXML
    public void drawRectangle() {
        drawShape("Прямоугольник");
    }

    @FXML
    public void drawEllipse() {
        drawShape("Эллипс");
    }

    @FXML
    public void drawRoundedRectangle() {
        drawShape("Скругленный прямоугольник");
    }

    @FXML
    public void drawSquare() {
        drawShape("Квадрат");
    }

    private void drawShape(String shapeType) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        Color fillColor = fillColorPicker.getValue();
        Color strokeColor = strokeColorPicker.getValue();
        double strokeWidth = strokeWidthSlider.getValue();
        double size = Double.parseDouble(sizeField.getText());
        int count = Integer.parseInt(countField.getText());

        gc.setFill(fillColor);
        gc.setStroke(strokeColor);
        gc.setLineWidth(strokeWidth);

        for (int i = 0; i < count; i++) {
            double x = 50 + i * (size + 10);
            double y = 100;

            switch (shapeType) {
                case "Прямоугольник":
                    gc.fillRect(x, y, size, size * 0.6);
                    gc.strokeRect(x, y, size, size * 0.6);
                    break;
                case "Эллипс":
                    gc.fillOval(x, y, size, size);
                    gc.strokeOval(x, y, size, size);
                    break;
                case "Скругленный прямоугольник":
                    gc.fillRoundRect(x, y, size, size * 0.6, 20, 20);
                    gc.strokeRoundRect(x, y, size, size * 0.6, 20, 20);
                    break;
                case "Квадрат":
                    gc.fillRect(x, y, size, size);
                    gc.strokeRect(x, y, size, size);
                    break;
            }
        }

        infoLabel.setText("Последняя фигура: " + shapeType + ", площадь: " + (size * size));
    }
}
