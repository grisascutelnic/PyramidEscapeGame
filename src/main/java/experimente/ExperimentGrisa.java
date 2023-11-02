package experimente;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExperimentGrisa extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pyramid Escape Game");

        Text text = new Text("        Game Over!\nCONGRATULATIONS!");
        text.setTranslateY(-300);
        text.getStyleClass().add("textG");
        text.setTranslateY(-100);
        text.setTranslateX(30);

        // Încărcați imaginea GIF pentru fundal
        Image backgroundImage = new Image("firework.gif");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitHeight(700);
        backgroundImageView.setFitWidth(1000);



        // Creați un panou de stivă pentru a plasa elementele pe fundalul GIF
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView, text);

        // Creați scena și adăugați panoul de stivă ca conținut
        Scene scene = new Scene(root, 1000, 700);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
