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

public class IntroducereGrisa extends Application {

    private String textGrisa = "Salut! Eu ma numesc Grigore Scutelnic si\n" +
            "azi va voi prezenta micul nostru joculet de tip\n" +
            "Pyramid Escape Game. Bonne chance!";
    private Text text = new Text();
    private int index;
    @Override
    public void start(Stage primaryStage) {
        text.setTranslateY(-150);
        //text.setTranslateX(-0);

        Image imageButtonPlay = new Image("playBut1.png");
        ImageView imageViewButton = new ImageView(imageButtonPlay);
        imageViewButton.setFitWidth(150);
        imageViewButton.setFitHeight(40);

        Button playButton = new Button();
        playButton.getStyleClass().add("playButton");
        playButton.setGraphic(imageViewButton);

        playButton.setTranslateY(-200);

        playButton.setOnAction(event -> {
            IntroducereDima introducereDima = new IntroducereDima();
             introducereDima.start(primaryStage);
        });

        Image backgroundImage = new Image("backInterfata3.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        Image movingImage = new Image("grisa.png");
        ImageView movingImageView = new ImageView(movingImage);
        movingImageView.setTranslateY(700);
        movingImageView.setFitWidth(210*1.5);
        movingImageView.setFitHeight(260*1.5);

        TranslateTransition transition = new TranslateTransition(Duration.seconds(2), movingImageView);
        transition.setToY(120);
        transition.play();

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
        layout.getChildren().addAll(backgroundImageView, movingImageView, text, playButton);

        Scene introducereScene = new Scene(layout, 1000, 700);
        primaryStage.setScene(introducereScene);
        primaryStage.show();
    }
}
