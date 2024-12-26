package com.example.task6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Canvas canvas;

    @FXML
    private ListView<Shape> listView;

    @FXML
    private ColorPicker colorPicker;

    private ObservableList<Shape> content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        content = FXCollections.observableArrayList(
                new Circle(),
                new Square(),
                new Rectangle(),
                new Triangle()
        );

        listView.setItems(content);
        listView.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.SINGLE);
    }

    @FXML
    public void drawShape(MouseEvent mouseEvent) {
        int index = listView.getSelectionModel().getSelectedIndex();
        Shape shape = (Shape) content.get(index).clone();
        shape.setColor(colorPicker.getValue());

        GraphicsContext gc = canvas.getGraphicsContext2D();
        shape.draw(gc, mouseEvent.getX(), mouseEvent.getY());
    }

    @FXML
    public void clearCanvas(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
