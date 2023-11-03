package com.game.pyramidescape;

import experimente.SudokuInterface;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class Game extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private Stage stage;
    @Override
    public void start(Stage primaryStage) {

        //INTERFATA

        stage = primaryStage;

        // Imaginea de fundal
        Image backgroundImage = new Image("background6.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);

        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        // Imaginile celor 3 faraoni
        Image movingImageGrisa = new Image("grisa.png");
        ImageView movingImageViewGrisa = new ImageView(movingImageGrisa);
        movingImageViewGrisa.setTranslateX(-600);
        movingImageViewGrisa.setFitWidth(210);
        movingImageViewGrisa.setFitHeight(260);

        Image movingImageDima = new Image("dima.png");
        ImageView movingImageViewDima = new ImageView(movingImageDima);
        movingImageViewDima.setTranslateY(700);
        movingImageViewDima.setFitWidth(300);
        movingImageViewDima.setFitHeight(280);

        Image movingImageTolea = new Image("tolea.png");
        ImageView movingImageViewTolea = new ImageView(movingImageTolea);
        movingImageViewTolea.setTranslateX(600);
        movingImageViewTolea.setFitWidth(100);
        movingImageViewTolea.setFitHeight(250);

        // Tranzitia de deplasare a faraonilor
        TranslateTransition transitionForGrisa = new TranslateTransition(Duration.seconds(2), movingImageViewGrisa);
        transitionForGrisa.setToX(-150);
        transitionForGrisa.setToY(120);
        transitionForGrisa.play();

        TranslateTransition transitionForDima = new TranslateTransition(Duration.seconds(2), movingImageViewDima);
        transitionForDima.setToY(120);
        transitionForDima.play();

        TranslateTransition transitionForTolea = new TranslateTransition(Duration.seconds(2), movingImageViewTolea);
        transitionForTolea.setToX(150);
        transitionForTolea.setToY(120);
        transitionForTolea.play();


        //PLAY BUTTON
        Text text = new Text("Welcome to the Pyramid Escape Game!");
        text.setTranslateY(-300);
        text.getStyleClass().add("text");

        Image imageButtonPlay = new Image("playBut1.png");
        ImageView imageViewButton = new ImageView(imageButtonPlay);
        imageViewButton.setFitWidth(150);
        imageViewButton.setFitHeight(40);

        Button playButton = new Button();
        playButton.getStyleClass().add("playButton");
        playButton.setGraphic(imageViewButton);
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView, movingImageViewGrisa, movingImageViewDima, movingImageViewTolea, text, playButton);

        playButton.setTranslateY(-200);

        playButton.setOnAction(event -> {
//          Introducere introducere = new Introducere();
//          introducere.start(new Stage());
//          primaryStage.close();
            IntroducereGrisa introducere = new IntroducereGrisa();
            introducere.start(primaryStage);
        });

        Scene scene = new Scene(root, 1000, 700);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setTitle("Pyramid Escape Game");
        stage.show();

    }
}
