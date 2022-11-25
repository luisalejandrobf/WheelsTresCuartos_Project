module com.example.proyectowheels {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.proyectowheels to javafx.fxml;
    exports com.example.proyectowheels;
    exports com.example.proyectowheels.Controller;
    opens com.example.proyectowheels.Controller to javafx.fxml;
}