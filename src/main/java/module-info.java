module com.game.pyramidescape {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.game.pyramidescape to javafx.fxml;
    exports com.game.pyramidescape;
    exports experimente;
}
