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

public class IntroducereDima extends Application {

    private String textGrisa = "Sudoku Mistic: Pe măsură ce exploratorul avansează, el găsește puzzle-uri \n" +
            "de sudoku misterioase care dezvăluie indicii cruciale pentru a debloca uși secrete \n" +
            "Jocul Boi și Vaci pe Hieroglife Egiptene: Jucătorii trebuie să rezolve un joc de tip\n" +
            "boi și vaci folosind hieroglife egiptene în loc de cifre sau litere \n" +
            "Ceasul binar: O altă provocare unică constă în a transforma un ceas simplu intr-un\n" +
            "ceas binar, oferind jucătorilor un indiciu crucial despre următorul pas în evadare ";
    private Text textt = new Text();
    private int index;
    @Override
    public void start(Stage primaryStage) {
        textt.setTranslateY(-170);
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
            IntroducereTolea introducereTolea = new IntroducereTolea();
            introducereTolea.start(primaryStage);
        });

        Image backgroundImage = new Image("backInterfata3.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        Image movingImage = new Image("dima.png");
        ImageView movingImageView = new ImageView(movingImage);
        movingImageView.setTranslateY(700);
        movingImageView.setFitWidth(300*1.5);
        movingImageView.setFitHeight(280*1.5);

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
