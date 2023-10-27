package experimente;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Nivel2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Nivel 2");

        StackPane layout = new StackPane();

        Scene scene = new Scene(layout, 400, 200);
        //scene.setStyle("-fx-background-color: lightblue");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
