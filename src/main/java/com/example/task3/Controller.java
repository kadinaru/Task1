package com.example.task3;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Controller {
    private Memento temp = null;
    private Caretaker caretaker = new Caretaker();
    private double offsetX; // Смещение по оси X
    private double offsetY; // Смещение по оси Y

    @FXML
    private Pane drawingPane;

    @FXML
    public void initialize() {
        // Создаем стартовые фигуры
        Circle circle = createCircle(100, 100, 50);
        Rectangle rectangle = createRectangle(200, 200, 100, 60);

        // Добавляем фигуры на панель
        drawingPane.getChildren().addAll(circle, rectangle);
    }

    private Circle createCircle(double x, double y, double radius) {
        Circle circle = new Circle(x, y, radius, Color.TURQUOISE);
        circle.setStroke(Color.DARKBLUE);
        circle.setStrokeWidth(1);
        addMouseHandlers(circle);
        return circle;
    }

    private Rectangle createRectangle(double x, double y, double width, double height) {
        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(Color.CORAL);
        rectangle.setStroke(Color.DARKRED);
        rectangle.setStrokeWidth(1);
        addMouseHandlers(rectangle);
        return rectangle;
    }

    private void addMouseHandlers(Shape shape) {
        shape.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> onBegin(shape, event));
        shape.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> onDrag(shape, event));
        shape.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> onEnd(shape, event));
    }

    private void onBegin(Shape shape, MouseEvent event) {
        temp = new Memento(shape);
        caretaker.push(temp);
        temp.highlight().toFront();

        // Вычисляем смещение между положением мыши и верхним левым углом фигуры
        offsetX = event.getSceneX() - shape.getLayoutX();
        offsetY = event.getSceneY() - shape.getLayoutY();
    }

    private void onDrag(Shape shape, MouseEvent event) {
        if (temp == null) return;

        // Устанавливаем новую позицию фигуры, учитывая смещение
        shape.setLayoutX(event.getSceneX() - offsetX);
        shape.setLayoutY(event.getSceneY() - offsetY);
    }

    private void onEnd(Shape shape, MouseEvent event) {
        if (temp == null) return;

        // Восстанавливаем фигуру из состояния Memento
        temp.restore();
        temp = null;
    }

    @FXML
    public void addCircle() {
        Circle circle = new Circle(50, Color.TURQUOISE);
        circle.setStroke(Color.DARKBLUE);
        circle.setStrokeWidth(1);
        circle.setCenterX(100); // начальная позиция
        circle.setCenterY(100);

        // Добавить обработчики событий для перемещения
        addMouseHandlers(circle);

        // Добавить круг на панель
        drawingPane.getChildren().add(circle);
    }

    @FXML
    public void addRectangle() {
        Rectangle rectangle = new Rectangle(100, 60, Color.CORAL);
        rectangle.setStroke(Color.DARKRED);
        rectangle.setStrokeWidth(1);
        rectangle.setX(200); // начальная позиция
        rectangle.setY(200);

        // Добавить обработчики событий для перемещения
        addMouseHandlers(rectangle);

        // Добавить прямоугольник на панель
        drawingPane.getChildren().add(rectangle);
    }
}
