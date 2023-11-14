package experimente;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ExperimentDima extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();

        Image backgroundImage = new Image("backInterfata1.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        // Adaugă trei imagini
        ImageView imgView1 = createImageView("Egipt1.png");
        ImageView imgView2 = createImageView("Egipt2.png");
        ImageView imgView3 = createImageView("Egipt3.png");

        // Poziționează imaginile
        imgView1.setLayoutX(125); // Deplasează a doua imagine spre dreapta
        imgView1.setLayoutY(50);
        imgView2.setLayoutX(120); // Deplasează a doua imagine spre dreapta
        imgView2.setLayoutY(45);
        imgView3.setLayoutX(125); // Deplasează a treia imagine și mai spre dreapta
        imgView3.setLayoutY(51);

        pane.getChildren().addAll(backgroundImageView, imgView1, imgView2, imgView3);

        Scene scene = new Scene(pane, 1000, 700);
        stage.setTitle("Pyramide Escape Game");
        stage.setScene(scene);
        stage.show();
    }

    private ImageView createImageView(String imagePath) {
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(650);
        imageView.setFitWidth(650);
        imageView.setPreserveRatio(true);
        return imageView;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
