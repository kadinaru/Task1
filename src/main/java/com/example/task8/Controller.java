package com.example.task8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Controller {
    @FXML private Pane paintpane;
    @FXML private CheckBox garlandCheckBox;
    @FXML private CheckBox toysCheckBox;
    @FXML private CheckBox starCheckBox;
    @FXML private Label statusLabel;

    private ChristmasTree tree;
    private ChristmasTree decoratedTree;

    public void initialize() {
        tree = new ChristmasTreeImpl();
        decoratedTree = tree;
        drawTree();
    }

    private void drawTree() {
        paintpane.getChildren().clear();
        decoratedTree.Operation(paintpane);
        statusLabel.setText(decoratedTree.decorate() + " - Стоимость: ₽" + decoratedTree.cost());
    }

    public void addGarland() {
        resetDecorations();
        if (garlandCheckBox.isSelected()) {
            decoratedTree = new Garland(decoratedTree);
        }
        drawTree();
    }

    public void addToys() {
        resetDecorations();
        if (toysCheckBox.isSelected()) {
            decoratedTree = new Toys(decoratedTree);
        }
        drawTree();
    }

    public void addStar() {
        resetDecorations();
        if (starCheckBox.isSelected()) {
            decoratedTree = new Star(decoratedTree);
        }
        drawTree();
    }

    private void resetDecorations() {
        decoratedTree = tree;
        if (garlandCheckBox.isSelected()) {
            decoratedTree = new Garland(decoratedTree);
        }
        if (toysCheckBox.isSelected()) {
            decoratedTree = new Toys(decoratedTree);
        }
        if (starCheckBox.isSelected()) {
            decoratedTree = new Star(decoratedTree);
        }
    }

    // Метод для добавления всех элементов
    @FXML
    public void addAll() {
        garlandCheckBox.setSelected(true);
        toysCheckBox.setSelected(true);
        starCheckBox.setSelected(true);

        addGarland();
        addToys();
        addStar();
    }

    // Метод для удаления всех украшений
    @FXML
    public void removeAll() {
        if (garlandCheckBox.isSelected()) {
            garlandCheckBox.setSelected(false);
            decoratedTree = tree;
        }
        if (toysCheckBox.isSelected()) {
            toysCheckBox.setSelected(false);
            decoratedTree = tree;
        }
        if (starCheckBox.isSelected()) {
            starCheckBox.setSelected(false);
            decoratedTree = tree;
        }

        drawTree();
    }
}
