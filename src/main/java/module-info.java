module proyecto.socketCliente {
    requires javafx.controls;
    requires javafx.fxml;

    opens socket to javafx.fxml;
    exports socket;
}
