package com.game.pyramidescape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Introducere extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        Image backgroundImage = new Image("background1.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);

        Circle cercAlbastru = new Circle(100, Color.BLUE);
        StackPane layout = new StackPane();
        layout.getChildren().addAll(backgroundImageView, cercAlbastru);

        Scene introducereScene = new Scene(layout, 1000, 700);
        stage.setScene(introducereScene);
        stage.show();
    }
}
