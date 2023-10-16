module com.game.pyramidescapegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens experimente to javafx.fxml;
    exports experimente;
}