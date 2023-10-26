package experimente;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Nivele extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Nivele");
        Button buttonNivel1 = new Button("Nivel 1");
        Button buttonNivel2 = new Button("Nivel 2");

        buttonNivel1.setOnAction(e -> {
            Nivel1 nivel1 = new Nivel1();
            nivel1.start(new Stage());
        });

        buttonNivel2.setOnAction(e -> {
            Nivel2 nivel2 = new Nivel2();
            nivel2.start(new Stage());
        });

        StackPane layout = new StackPane();
        layout.getChildren().addAll(buttonNivel1, buttonNivel2);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
