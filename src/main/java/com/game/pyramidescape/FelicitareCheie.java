package com.game.pyramidescape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class FelicitareCheie extends Application {

    double coeficient;

    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        StackPane centerPane = new StackPane();
        stage = primaryStage;

        Image backgroundImage = new Image("backInterfata1.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        Text text = new Text("Felicitari ai primit o cheiță!");
        text.setTranslateY(-280);
        text.setTranslateX(0);
        text.getStyleClass().add("textFelicitare");

        coeficient = 0.8;
        Image cheieImage = new Image("cheiat.png");
        ImageView cheieImageView = new ImageView(cheieImage);
        cheieImageView.setFitWidth(420 * coeficient);
        cheieImageView.setFitHeight(700 * coeficient);
        cheieImageView.setTranslateX(0);
        cheieImageView.setTranslateY(50);

        Button back = new Button();
        back.setPrefSize(120, 50);
        Image imageBack = new Image("BackButton.png");
        ImageView imageView1 = new ImageView(imageBack);
        back.setGraphic(imageView1);
        imageView1.setFitWidth(120);
        imageView1.setFitHeight(50);
        back.getStyleClass().add("back");

        back.setTranslateY(-300);
        back.setTranslateX(400);

        back.setOnAction(e -> {
            CeleTreiUsi treiUsi = new CeleTreiUsi();
            treiUsi.start(primaryStage);
        });

        centerPane.getChildren().addAll(backgroundImageView, text, cheieImageView, back);

        Scene scene = new Scene(centerPane, 1000, 700);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setTitle("Pyramid Escape Game");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
