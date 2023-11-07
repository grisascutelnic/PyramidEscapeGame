package com.game.pyramidescape;

import experimente.ExperimentTolea;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CeleTreiUsi extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        // Imaginea de fundal
        Image backgroundImage = new Image("background6.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);

        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        // Textul de la mijloc
        Text text = new Text("Welcome to the Pyramid Escape Game!");
        text.setTranslateY(-300);
        text.getStyleClass().add("textGame");

        // Creare HBox pentru a așeza butoanele într-un rând
        HBox buttonBox = new HBox(70);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER); // Alinează butoanele pe centru

        // Creare butoane
        Button door1 = new Button();
        Button door2 = new Button();
        Button door3 = new Button();

        // Setare dimensiuni mai mari pentru butoane
        door1.setPrefSize(200, 450);
        door2.setPrefSize(200, 450);
        door3.setPrefSize(200, 450);

        Image image1 = new Image("usaPiramida.jpg");
        ImageView imageView1 = new ImageView(image1);
        door1.setGraphic(imageView1);
        imageView1.setFitWidth(200);
        imageView1.setFitHeight(450);
        door1.getStyleClass().add("door1");

        Image image2 = new Image("usaPiramida.jpg");
        ImageView imageView2 = new ImageView(image2);
        door2.setGraphic(imageView2);
        imageView2.setFitWidth(200);
        imageView2.setFitHeight(450);
        door2.getStyleClass().add("door2");

        Image image3 = new Image("usaPiramida.jpg");
        ImageView imageView3 = new ImageView(image3);
        door3.setGraphic(imageView3);
        imageView3.setFitWidth(200);
        imageView3.setFitHeight(450);
        door3.getStyleClass().add("door3");

        buttonBox.getChildren().addAll(door1, door2, door3);

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
        root.getChildren().addAll(backgroundImageView, text, buttonBox);

        Scene scene = new Scene(root, 1000, 700);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setTitle("Pyramid Escape Game");
        stage.show();
    }
}
