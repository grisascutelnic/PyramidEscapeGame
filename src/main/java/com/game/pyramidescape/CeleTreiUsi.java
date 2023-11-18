package com.game.pyramidescape;

import experimente.ExperimentTolea;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CeleTreiUsi extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private Stage stage;
    private double coeficient;
    private boolean deschidere = true;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        // Imaginea de fundal
        Image backgroundImage = new Image("background7.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        //Imagine sub care dispar usile care se ridica
        Image TransparentImage = new Image("FundalTransparent.png");
        ImageView TransparentImageView = new ImageView(TransparentImage);
        TransparentImageView.setFitWidth(1000);
        TransparentImageView.setFitHeight(700);

        // Textul de la mijloc
        Text text = new Text("Welcome to the Pyramid Escape Game!");
        text.setTranslateY(-300);
        text.getStyleClass().add("textGame");

        HBox buttonBox = new HBox(70);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER); // Alinează butoanele pe centru

        // Adaugă un padding în partea de jos a HBox pentru a ridica butoanele
        buttonBox.setPadding(new Insets(0, 0, 30, 0));

        // Creare butoane
        Button door1 = new Button();
        Button door2 = new Button();
        Button door3 = new Button();

        coeficient = 0.9;
        // Setare dimensiuni mai mari pentru butoane modificand coeficientul
        door1.setPrefSize(200 * coeficient, 450 * coeficient);
        door2.setPrefSize(200 * coeficient, 450 * coeficient);
        door3.setPrefSize(200 * coeficient, 450 * coeficient);

        Image image1 = new Image("UsaNoua.jpg");
        ImageView imageView1 = new ImageView(image1);
        door1.setGraphic(imageView1);
        imageView1.setFitWidth(200 * coeficient);
        imageView1.setFitHeight(450 * coeficient);
        door1.getStyleClass().add("door1");

        Image image2 = new Image("UsaNoua.jpg");
        ImageView imageView2 = new ImageView(image2);
        door2.setGraphic(imageView2);
        imageView2.setFitWidth(200 * coeficient);
        imageView2.setFitHeight(450 * coeficient);
        door2.getStyleClass().add("door2");

        Image image3 = new Image("UsaNoua.jpg");
        ImageView imageView3 = new ImageView(image3);
        door3.setGraphic(imageView3);
        imageView3.setFitWidth(200 * coeficient);
        imageView3.setFitHeight(450 * coeficient);
        door3.getStyleClass().add("door3");

        buttonBox.getChildren().addAll(door1, door2, door3);

        HBox usiBox = new HBox(-200);
        usiBox.setAlignment(Pos.BOTTOM_CENTER);
        usiBox.setPadding(new Insets(0, 0, -160, 0));

        Image usa1 = new Image("deschidereUsa.png");
        Image usa2 = new Image("deschidereUsa.png");
        Image usa3 = new Image("deschidereUsa.png");

        ImageView imageViewUsa1 = new ImageView(usa1);
        ImageView imageViewUsa2 = new ImageView(usa2);
        ImageView imageViewUsa3 = new ImageView(usa3);

        double coeficient = 4.5;
    // Setăm mărimea dorită pentru fiecare imagine modificand coeficientul
        imageViewUsa1.setFitWidth(100 * coeficient);
        imageViewUsa1.setFitHeight(200 * coeficient);

        imageViewUsa2.setFitWidth(100 * coeficient);
        imageViewUsa2.setFitHeight(200 * coeficient);

        imageViewUsa3.setFitWidth(100 * coeficient);
        imageViewUsa3.setFitHeight(200 * coeficient);

    // Adăugăm fiecare ImageView în usiBox
        usiBox.getChildren().addAll(imageViewUsa1, imageViewUsa2, imageViewUsa3);

    // Creăm și configurăm TranslateTransition pentru fiecare ImageView
        TranslateTransition transitionUsa1 = new TranslateTransition(Duration.seconds(2.5), imageViewUsa1);
        transitionUsa1.setByY(-400); // Tranzlație pe axa Y pentru usa1

        TranslateTransition transitionUsa2 = new TranslateTransition(Duration.seconds(2.5), imageViewUsa2);
        transitionUsa2.setByY(-400); // Tranzlație pe axa Y pentru usa2

        TranslateTransition transitionUsa3 = new TranslateTransition(Duration.seconds(2.5), imageViewUsa3);
        transitionUsa3.setByY(-400); // Tranzlație pe axa Y pentru usa3

        //Actiunile usilor
        imageViewUsa1.setOnMouseClicked(event -> {
            transitionUsa1.play();
            PauseTransition pause = new PauseTransition(Duration.seconds(2.6));
            pause.setOnFinished(e -> {
                SudokuInterface sudoku = new SudokuInterface();
                sudoku.start(primaryStage);
            });
            pause.play();
        });

        imageViewUsa2.setOnMouseClicked(event -> {
            transitionUsa2.play();
            PauseTransition pause = new PauseTransition(Duration.seconds(2.6));
            pause.setOnFinished(e -> {
                BoiSiVaci boiSiVaci = new BoiSiVaci();
                boiSiVaci.start(primaryStage);
            });
            pause.play();
        });

        imageViewUsa3.setOnMouseClicked(event -> {
            transitionUsa3.play();
            PauseTransition pause = new PauseTransition(Duration.seconds(2.6));
            pause.setOnFinished(e -> {
                ExperimentTolea ceasLogic = new ExperimentTolea();
                ceasLogic.start(primaryStage);
            });
            pause.play();
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView, buttonBox, usiBox, TransparentImageView, text);

        Scene scene = new Scene(root, 1000, 700);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setTitle("Pyramid Escape Game");
        stage.show();
    }
}
