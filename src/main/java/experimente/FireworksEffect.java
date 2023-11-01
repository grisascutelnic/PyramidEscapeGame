package experimente;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FireworksEffect extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Efect de artificii");
        primaryStage.setScene(scene);

        // Crează un cerc pentru fiecare scânteie
        int numSparks = 100;
        for (int i = 0; i < numSparks; i++) {
            Circle spark1 = new Circle(3, Color.YELLOW);
            Circle spark2 = new Circle(3, Color.BLUE);
            Circle spark3 = new Circle(3, Color.RED);
            root.getChildren().add(spark1);
            root.getChildren().add(spark2);
            root.getChildren().add(spark3);


            // Generează o animație de mișcare aleatoare pentru fiecare scânteie
            Timeline timeline1 = createSparkAnimation(spark1);
            Timeline timeline2 = createSparkAnimation(spark2);
            Timeline timeline3 = createSparkAnimation(spark3);
            timeline1.setDelay(Duration.seconds(Math.random() * 3));
            timeline1.play();
            timeline2.setDelay(Duration.seconds(Math.random() * 3));
            timeline2.play();
            timeline1.setDelay(Duration.seconds(Math.random() * 3));
            timeline3.play();
        }

        primaryStage.show();
    }

    // Creați o animație pentru o scânteie
    private Timeline createSparkAnimation(Circle spark) {
        Timeline timeline = new Timeline();

        // Setează o valoare inițială pentru Y
        KeyValue startY = new KeyValue(spark.centerYProperty(), 200);

        // Setează o valoare finală pentru Y (poziție deasupra)
        KeyValue endY = new KeyValue(spark.centerXProperty(), Math.random() * 800);

        // Setează o valoare finală pentru X (mișcare laterală aleatoare)
        KeyValue endX = new KeyValue(spark.centerYProperty(), Math.random() * 600);

        // Definim o durată pentru animație
        Duration duration = Duration.seconds(2);

        // Adaugăm keyframes la animație
        KeyFrame startFrame = new KeyFrame(Duration.ZERO, startY);
        KeyFrame endFrame = new KeyFrame(duration, endY, endX);

        timeline.getKeyFrames().addAll(startFrame, endFrame);

        return timeline;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
