package com.game.pyramidescape;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
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

        Image movingImageGrisa = new Image("grisa.png");
        ImageView movingImageViewGrisa = new ImageView(movingImageGrisa);
        movingImageViewGrisa.setTranslateY(700);
        movingImageViewGrisa.setFitWidth(210*1.5);
        movingImageViewGrisa.setFitHeight(260*1.5);

        TranslateTransition transitionForGrisa = new TranslateTransition(Duration.seconds(2), movingImageViewGrisa);
        transitionForGrisa.setToY(120);
        transitionForGrisa.play();

        PauseTransition pause = new PauseTransition(Duration.seconds(2.5));
        pause.setOnFinished(event -> {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(50), e -> {
                        if (index <= textGrisa.length()) {
                            text.setText(textGrisa.substring(0, index));
                            index++;
                        } else if (index == textGrisa.length()+10) text.setText(textGrisa.substring(0,0));
                    })
            );
            timeline.setCycleCount(textGrisa.length() + 14);
            timeline.play();
        });
        pause.play();



        StackPane layout = new StackPane();
        layout.getChildren().addAll(backgroundImageView, movingImageViewGrisa, text);

        Scene introducereScene = new Scene(layout, 1000, 700);
        stage.setScene(introducereScene);
        stage.show();
    }
}
