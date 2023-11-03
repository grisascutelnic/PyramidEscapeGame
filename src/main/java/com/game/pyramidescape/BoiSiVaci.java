package com.game.pyramidescape;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BoiSiVaci extends Application {
    private int countPositions = 0;
    @Override
    public void start(Stage primaryStage) {
        StackPane layout = new StackPane();

        Image backgroundImage = new Image("background5.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        Image tabel = new Image("tabel2.png");
        ImageView backTabel = new ImageView(tabel);
        backTabel.getStyleClass().add("backTabel");
        backTabel.setFitWidth(120*2.5);
        backTabel.setFitHeight(30*2.5);
        backTabel.setTranslateY(-250);

        Image tabel9 = new Image("tabel9_2.jpg");
        ImageView tabel9View = new ImageView(tabel9);
        tabel9View.setFitHeight(300);
        tabel9View.setFitWidth(300);

        // CELE NOUA BUTOANE CU HIEROGLIFE
        Image her1 = new Image("hero1.png");
        ImageView herView1 = new ImageView(her1);
        herView1.setFitWidth(70);
        herView1.setFitHeight(70);
        Button button1 = new Button();
        button1.setTranslateX(-95);
        button1.setTranslateY(-94);
        button1.getStyleClass().add("playButton");
        button1.setGraphic(herView1);
        button1.setOnAction(event -> {
            ImageView heroView1 = new ImageView(her1);
            heroView1.setFitWidth(60);
            heroView1.setFitHeight(60);
            switch (countPositions) {
                case 0:
                    heroView1.setTranslateY(-251);
                    heroView1.setTranslateX(-114);
                break;
                case 1:
                    heroView1.setTranslateY(-251);
                    heroView1.setTranslateX(-38);
                break;
                case 2:
                    heroView1.setTranslateY(-251);
                    heroView1.setTranslateX(38);
                break;
                case 3:
                    heroView1.setTranslateY(-251);
                    heroView1.setTranslateX(114);
                break;
            }
            countPositions++;
            System.out.println(countPositions);
            if (countPositions >= 5) {
                for (Node child : layout.getChildren()) {
                    if (child instanceof ImageView) {
                        ImageView imageView = (ImageView) child;
                        if (imageView == heroView1) {
                            layout.getChildren().remove(imageView);
                        }
                    }
                }
            } else
            layout.getChildren().add(heroView1);
        });

        Image her2 = new Image("hero2.png");
        ImageView herView2 = new ImageView(her2);
        herView2.setFitWidth(70);
        herView2.setFitHeight(70);
        Button button2 = new Button();
        button2.setTranslateX(0);
        button2.setTranslateY(-94);
        button2.getStyleClass().add("playButton");
        button2.setGraphic(herView2);

        Image her3 = new Image("hero3.png");
        ImageView herView3 = new ImageView(her3);
        herView3.setFitWidth(70);
        herView3.setFitHeight(70);
        Button button3 = new Button();
        button3.setTranslateX(94);
        button3.setTranslateY(-94);
        button3.getStyleClass().add("playButton");
        button3.setGraphic(herView3);

        Image her4 = new Image("hero4.png");
        ImageView herView4 = new ImageView(her4);
        herView4.setFitWidth(70);
        herView4.setFitHeight(70);
        Button button4 = new Button();
        button4.setTranslateX(-95);
        button4.setTranslateY(1);
        button4.getStyleClass().add("playButton");
        button4.setGraphic(herView4);

        Image her5 = new Image("hero5.png");
        ImageView herView5 = new ImageView(her5);
        herView5.setFitWidth(70);
        herView5.setFitHeight(70);
        Button button5 = new Button();
        button5.setTranslateX(0);
        button5.setTranslateY(1);
        button5.getStyleClass().add("playButton");
        button5.setGraphic(herView5);

        Image her6 = new Image("hero6.png");
        ImageView herView6 = new ImageView(her6);
        herView6.setFitWidth(70);
        herView6.setFitHeight(70);
        Button button6 = new Button();
        button6.setTranslateX(94);
        button6.setTranslateY(1);
        button6.getStyleClass().add("playButton");
        button6.setGraphic(herView6);

        Image her7 = new Image("hero7.png");
        ImageView herView7 = new ImageView(her7);
        herView7.setFitWidth(70);
        herView7.setFitHeight(70);
        Button button7 = new Button();
        button7.setTranslateX(-95);
        button7.setTranslateY(96);
        button7.getStyleClass().add("playButton");
        button7.setGraphic(herView7);

        Image her8 = new Image("hero8.png");
        ImageView herView8 = new ImageView(her8);
        herView8.setFitWidth(70);
        herView8.setFitHeight(70);
        Button button8 = new Button();
        button8.setTranslateX(0);
        button8.setTranslateY(95);
        button8.getStyleClass().add("playButton");
        button8.setGraphic(herView8);

        Image her9 = new Image("hero9.png");
        ImageView herView9 = new ImageView(her9);
        herView9.setFitWidth(70);
        herView9.setFitHeight(70);
        Button button9 = new Button();
        button9.setTranslateX(94);
        button9.setTranslateY(94);
        button9.getStyleClass().add("playButton");
        button9.setGraphic(herView9);

        layout.getChildren().addAll(backgroundImageView, backTabel, tabel9View, button1, button2, button3, button4,
                button5, button6, button7, button8, button9);

        Scene introducereScene = new Scene(layout, 1000, 700);
        layout.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        primaryStage.setScene(introducereScene);
        primaryStage.show();
    }

    private boolean isObjectInScene(Scene scene, ImageView objectToFind) {
        if (scene != null) {
            ObservableList<Node> nodesInScene = scene.getRoot().getChildrenUnmodifiable();
            return nodesInScene.contains(objectToFind);
        }
        return false;
    }
}