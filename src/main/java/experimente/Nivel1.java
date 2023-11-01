package experimente;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Nivel1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Nivel 1");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setTitle("Nivel 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
