package experimente;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Nivel2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Nivel 2");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Nivel 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
