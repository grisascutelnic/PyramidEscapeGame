package com.game.pyramidescape;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Introducere {

    private Scene introducereScene;

    Introducere(Stage stage) {
        Circle cercAlbastru = new Circle(100, Color.BLUE);
        StackPane layout1 = new StackPane();
        layout1.getChildren().addAll(cercAlbastru);
        introducereScene = new Scene(layout1, 1000, 700);
    }


    public Scene getIntroducereScene() {return introducereScene; }
}
