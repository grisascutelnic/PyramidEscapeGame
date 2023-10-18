package experimente;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Nivele extends Application {
    private Stage stage;
    private Scene pagina1, pagina2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        // Pagina 1
//        Circle cercAlbastru = new Circle(100, Color.BLUE); // Creează un cerc albastru
//        Button button1 = new Button("Navighează la Pagina 2");
//        button1.setOnAction(e -> afiseazaPagina2());
//        StackPane layout1 = new StackPane();
//        layout1.getChildren().addAll(cercAlbastru, button1);
//        pagina1 = new Scene(layout1, 600, 600);

        // Pagina 2
        Rectangle patratGalben = new Rectangle(200, 200, Color.RED); // Creează un patrat galben
        Button button2 = new Button("Navighează la Pagina 1");
        button2.setOnAction(e -> afiseazaPagina1());
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(patratGalben, button2);
        pagina2 = new Scene(layout2, 600, 600);

        // Afișează pagina inițială
        stage.setScene(pagina1);
        stage.setTitle("Navigare între pagini");
        stage.show();
    }

    private void afiseazaPagina1() {
        stage.setScene(pagina1);
    }

    private void afiseazaPagina2() {
        stage.setScene(pagina2);
    }
}
