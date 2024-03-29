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

    private String textGrisa = "             Un explorator curajos se trezește în interiorul Piramidei \n" +
            "Luminii, o structură antică din Egiptul antic, plină de mistere și comori. Jucătorii \n" +
            "         preiau rolul acestui explorator și au o singură misiune: să dezlege secretele \n" +
            "                          piramidei și să evadeze înainte ca timpul să se scurgă.";
    private Text textt = new Text();
    private int index;
    @Override
    public void start(Stage primaryStage) {
        textt.setTranslateY(-150);
        textt.getStyleClass().add("textt");

        Image imageButtonPlay = new Image("playBut1.png");
        ImageView imageViewButton = new ImageView(imageButtonPlay);
        imageViewButton.setFitWidth(150);
        imageViewButton.setFitHeight(40);

        Button playButton = new Button();
        playButton.getStyleClass().add("playButton");
        playButton.setGraphic(imageViewButton);

        playButton.setTranslateY(-300);

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
                    new KeyFrame(Duration.millis(20), e -> {
                        if (index <= textGrisa.length()) {
                            textt.setText(textGrisa.substring(0, index));
                            index++;
                        } else if (index == textGrisa.length()+10) textt.setText(textGrisa.substring(0,0));
                    })
            );
            timeline.setCycleCount(textGrisa.length() + 14);
            timeline.play();
        });
        pause.play();



        StackPane layout = new StackPane();
        layout.getChildren().addAll(backgroundImageView, movingImageView, textt, playButton);

        layout.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        Scene introducereScene = new Scene(layout, 1000, 700);
        primaryStage.setScene(introducereScene);
        primaryStage.show();
    }
}
