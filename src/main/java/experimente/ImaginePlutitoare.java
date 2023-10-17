package experimente;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ImaginePlutitoare extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Imaginea de fundal
        Image backgroundImage = new Image("background.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);

        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        // Imaginea deplasabilă
        Image movingImageGrisa = new Image("grisa.png");
        ImageView movingImageViewGrisa = new ImageView(movingImageGrisa);
        movingImageViewGrisa.setTranslateX(-500); // Inițial, imaginea este în afara ecranului la stânga
        movingImageViewGrisa.setFitWidth(190);
        movingImageViewGrisa.setFitHeight(250);

        Image movingImageDima = new Image("dima.png");
        ImageView movingImageViewDima = new ImageView(movingImageDima);
        movingImageViewDima.setTranslateX(-600); // Inițial, imaginea este în afara ecranului la stânga
        movingImageViewDima.setFitWidth(340);
        movingImageViewDima.setFitHeight(260);

        Image movingImageTolea = new Image("tolea.png");
        ImageView movingImageViewTolea = new ImageView(movingImageTolea);
        movingImageViewTolea.setTranslateX(-700); // Inițial, imaginea este în afara ecranului la stânga
        movingImageViewTolea.setFitWidth(100);
        movingImageViewTolea.setFitHeight(250);

        // Grup pentru a le afișa pe ambele
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView, movingImageViewGrisa, movingImageViewDima, movingImageViewTolea);

        Scene scene = new Scene(root, 1000, 700);
        stage.setScene(scene);
        stage.setTitle("Animație de deplasare");
        stage.show();

        // Creați o tranzitie de deplasare
        TranslateTransition transitionForGrisa = new TranslateTransition(Duration.seconds(2), movingImageViewGrisa);
        transitionForGrisa.setToX(100); // De la -200 la 300 pentru a ajunge la mijloc
        transitionForGrisa.play();

        TranslateTransition transitionForDima = new TranslateTransition(Duration.seconds(2), movingImageViewDima);
        transitionForDima.setToX(200); // De la -200 la 300 pentru a ajunge la mijloc
        transitionForDima.play();

        TranslateTransition transitionForTolea = new TranslateTransition(Duration.seconds(2), movingImageViewTolea);
        transitionForTolea.setToX(300); // De la -200 la 300 pentru a ajunge la mijloc
        transitionForTolea.play();
    }
}
