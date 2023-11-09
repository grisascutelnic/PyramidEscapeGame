package com.game.pyramidescape;

import experimente.ExperimentTolea;
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

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        // Imaginea de fundal
        Image backgroundImage = new Image("background1.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);

        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        // Textul de la mijloc
        Text text = new Text("Welcome to the Pyramid Escape Game!");
        text.setTranslateY(-300);
        text.getStyleClass().add("text");

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

        HBox usiBox = new HBox(11);
        usiBox.setAlignment(Pos.BOTTOM_CENTER);
        usiBox.setPadding(new Insets(0, 0, -18, 0));

        Image usa1 = new Image("deschidereUsa.png");
        Image usa2 = new Image("deschidereUsa.png");
        Image usa3 = new Image("deschidereUsa.png");

        ImageView imageViewUsa1 = new ImageView(usa1);
        ImageView imageViewUsa2 = new ImageView(usa2);
        ImageView imageViewUsa3 = new ImageView(usa3);

        coeficient = 2.4;
        // Setăm mărimea dorită pentru fiecare imagine modificand coeficintul
        imageViewUsa1.setFitWidth(100 * coeficient);
        imageViewUsa1.setFitHeight(200 * coeficient);

        imageViewUsa2.setFitWidth(100 * coeficient);
        imageViewUsa2.setFitHeight(200 * coeficient);

        imageViewUsa3.setFitWidth(100 * coeficient);
        imageViewUsa3.setFitHeight(200 * coeficient);

        usiBox.getChildren().addAll(imageViewUsa1, imageViewUsa2, imageViewUsa3);
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2.5), usiBox);
        translateTransition.setByY(-330); // Tranzlație pe axa X cu 100 de unități

//        ColorAdjust colorAdjust = new ColorAdjust();
//        colorAdjust.setBrightness(-1); // Setează luminozitatea la -1 pentru a face elementele transparente
//        // Aplică efectul la HBox
//        usiBox.setEffect(colorAdjust);
//        // Configurează un eveniment care va fi declanșat după încheierea tranzlației
//        translateTransition.setOnFinished(event -> usiBox.setEffect(null));

        // Pornește animația
        translateTransition.play();

        // Adăugare acțiuni la butoane
        door1.setOnAction(e -> {
            SudokuInterface sudoku = new SudokuInterface();
            sudoku.start(primaryStage);
        });
        door2.setOnAction(e -> {
            BoiSiVaci boiSiVaci = new BoiSiVaci();
            boiSiVaci.start(primaryStage);
        });
        door3.setOnAction(e -> {
            ExperimentTolea ceasLogic = new ExperimentTolea();
            ceasLogic.start(primaryStage);
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView, text, buttonBox, usiBox);

        Scene scene = new Scene(root, 1000, 700);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setTitle("Pyramid Escape Game");
        stage.show();
    }
}
