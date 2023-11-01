package com.game.pyramidescape;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Introducere extends Application {

    private String textGrisa = "Salut! Eu ma numesc Grigore Scutelnic si\n" +
            "azi va voi prezenta micul nostru joculet de tip\n" +
            "Pyramid Escape Game. Bonne chance!";
    private Text text = new Text();
    private int index;
    @Override
    public void start(Stage stage) {
        Image backgroundImage = new Image("backInterfata3.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(50), event -> {
                    if (index <= textGrisa.length()) {
                        text.setText(textGrisa.substring(0, index));
                        index++;
                    } else text.setText(textGrisa.substring(0,0));
                })
        );
        timeline.setCycleCount(textGrisa.length() + 2);
        timeline.play();

        StackPane layout = new StackPane();
        layout.getChildren().addAll(backgroundImageView, text);

        Scene introducereScene = new Scene(layout, 1000, 700);
        stage.setScene(introducereScene);
        stage.show();
    }
}
