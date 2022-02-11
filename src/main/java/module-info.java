module proyecto.socketCliente {
    requires javafx.controls;
    requires javafx.fxml;

    opens proyecto.socketCliente to javafx.fxml;
    exports proyecto.socketCliente;
}
