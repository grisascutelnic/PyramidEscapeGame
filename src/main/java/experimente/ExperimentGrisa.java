package experimente;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ExperimentGrisa extends Application {
    private Text text;
    private String textToType = "Salut! Eu ma numesc Grisa! Acesta este un joc de tip Escape Cube Game";
    private int currentIndex = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Afișare text în timp real");

        text = new Text();
        StackPane root = new StackPane(text);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);

        primaryStage.show();

        // Creăm un Timeline pentru afișarea textului în timp real
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(50), event -> {
                    if (currentIndex <= textToType.length()) {
                        text.setText(textToType.substring(0, currentIndex));
                        currentIndex++;
                    }
                })
        );
        timeline.setCycleCount(textToType.length() + 1);
        timeline.play();
    }
}
