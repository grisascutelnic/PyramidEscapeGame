package experimente;

import javafx.application.Application;
import javafx.stage.Stage;

public class Nivele extends Application {
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

<<<<<<< HEAD
        // Pagina 1
        Circle cercAlbastru = new Circle(300, Color.BLUE); // Creează un cerc albastru
        Button button1 = new Button("Navighează la Pagina 2");
        button1.setOnAction(e -> afiseazaPagina2());
        StackPane layout1 = new StackPane();
        layout1.getChildren().addAll(cercAlbastru, button1);
        pagina1 = new Scene(layout1, 600, 600);

        // Pagina 2
        Rectangle patratGalben = new Rectangle(400, 400, Color.RED); // Creează un patrat galben
        Button button2 = new Button("Navighează la Pagina 1");
        button2.setOnAction(e -> afiseazaPagina1());
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(patratGalben, button2);
        pagina2 = new Scene(layout2, 600, 600);

        // Afișează pagina inițială
        stage.setScene(pagina1);
=======
        Nivel1 pagina1 = new Nivel1(stage);
        Nivel2 pagina2 = new Nivel2(stage);

        stage.setScene(pagina1.getScene());
>>>>>>> 10226b0d22abf323c4be308ae77aa17f26de09bd
        stage.setTitle("Navigare între pagini");
        stage.show();
    }
}
