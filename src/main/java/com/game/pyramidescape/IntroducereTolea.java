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

public class IntroducereTolea extends Application {

    private String textGrisa = "În Pyramid Escape Game, jucătorii trebuie să fie cu un pas înaintea capcanelor și să \n" +
            "dezlege enigme străvechi. Cu grafică impresionantă și o poveste captivantă, \n" +
            "jocul aduce la viață aventura exploratorului și îi provoacă pe jucători să își \n" +
            "pună la încercare inteligența și spiritul de echipă pentru a scăpa din această piramidă \n fascinantă.";
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
            CeleTreiUsi celeTreiUsi = new CeleTreiUsi();
            celeTreiUsi.start(primaryStage);
        });

        Image backgroundImage = new Image("backInterfata3.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        Image movingImage = new Image("tolea.png");
        ImageView movingImageView = new ImageView(movingImage);
        movingImageView.setTranslateY(700);
        movingImageView.setFitWidth(100*1.5);
        movingImageView.setFitHeight(250*1.5);

        TranslateTransition transition = new TranslateTransition(Duration.seconds(2), movingImageView);
        transition.setToY(120);
        transition.play();

        PauseTransition pause = new PauseTransition(Duration.seconds(2.5));
        pause.setOnFinished(event -> {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(50), e -> {
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
