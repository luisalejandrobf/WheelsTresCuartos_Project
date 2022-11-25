package com.example.proyectowheels;

import com.example.proyectowheels.Controller.PersistenciaWheels;
import com.example.proyectowheels.Controller.VistaLogin;
import com.example.proyectowheels.Model.Carro;
import com.example.proyectowheels.Model.Command.GestorMetodos;
import com.example.proyectowheels.Model.Usuario;
import com.example.proyectowheels.Model.Wheels;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase principal de la aplicacion Wheels que se encarga de cargar la ventana de login y de inicializar el objeto Wheels que se usara en toda la aplicacion
 */
public class HelloApplication extends Application {


    /**
     * Metodo que se encarga de inicializar el objeto Wheels y cargar la ventana de login
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VistaLogin.fxml"));
        Parent root = fxmlLoader.load();
        VistaLogin controlador = fxmlLoader.getController();
        controlador.initAttribute();

        // Titulo e imagen
        stage.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResourceAsStream("UniWheels.png"))));
        stage.setTitle("UniWheels");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        /*
        * */
    }

    /**
     * Metodo que se encarga de lanzar la ventana inicial.
     */
    public static void main(String[] args) throws IOException {
        launch();
    }
}