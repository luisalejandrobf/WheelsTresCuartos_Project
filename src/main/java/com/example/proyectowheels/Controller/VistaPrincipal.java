package com.example.proyectowheels.Controller;

import com.example.proyectowheels.HelloApplication;
import com.example.proyectowheels.Model.Command.*;
import com.example.proyectowheels.Model.ListaViajes;
import com.example.proyectowheels.Model.Usuario;
import com.example.proyectowheels.Model.Viaje;
import com.example.proyectowheels.Model.Wheels;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

/**
 * Clase que controla la vista principal del usuario
 */
public class VistaPrincipal {

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnGestionarInfo;

    private Usuario usuario;
    private Wheels wheels;
    @FXML
    private Button gestionarInfoPagobtn;
    @FXML
    private Button btnBus;

    //Inicialización de prueba para lista viajes, la declaración fue un poco díficil de lograr
    ListaViajes listaViajes;
    GestorMetodos gestorMetodos = new GestorMetodos();
    @FXML
    private Button btnCalificar;
    @FXML
    private Button btnPublicar;

    /**
     * Método que inicializa los atributos de la clase
     * @param wheels
     * @param usuario
     */
    public void initAttribute(Wheels wheels, Usuario usuario) {
        this.wheels = wheels;
        this.usuario = usuario;
        listaViajes = new ListaViajes();


        gestorMetodos.execute(new CargarViajes(), listaViajes, null);



    }

    /**
     * Método que inicializa los atributos de la clase
     * @param wheels
     * @param usuario
     * @param listaViajes
     */
    public void initAttribute(Wheels wheels, Usuario usuario, ListaViajes listaViajes) {
        this.wheels = wheels;
        this.usuario = usuario;
        this.listaViajes = listaViajes;
    }


    /**
     * Método que cierra la sesión del usuario
     * @param event
     */
    @FXML
    void cerrarSesion(ActionEvent event) {
        Stage stage1 = (Stage) this.btnCerrarSesion.getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        alert.setTitle("Wheels - Cerrar sesión");
        alert.setContentText("Ha cerrado sesión correctamente");

        Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
        stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
        stageAlert.setTitle("UniWheels");

        alert.showAndWait();
        stage1.close();

        FXMLLoader loader;
        Parent root;
        Scene scene;
        Stage stage;
        try {
            loader = new FXMLLoader(HelloApplication.class.getResource("VistaLogin.fxml"));
            root = loader.load();
            VistaLogin vistaLogin = (VistaLogin) loader.getController();
            vistaLogin.initAttribute();
            scene = new Scene(root);
            stage = new Stage();

            // Titulo e imagen
            stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stage.setTitle("UniWheels");

            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            gestorMetodos.execute(new EscribirViajes(), listaViajes, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que abre la ventana de gestión de información del usuario
     * @param event
     */
    @FXML
    void irGestionarInfoUsuario(ActionEvent event) {
        Stage stage1 = (Stage) this.btnGestionarInfo.getScene().getWindow();

        stage1.close();
        FXMLLoader loader;
        Parent root;
        Scene scene;
        Stage stage;
        try {
            loader = new FXMLLoader(HelloApplication.class.getResource("gestionarInfoUsuario.fxml"));
            root = loader.load();
            //Se prepara el controlador de la otra pantalla
            VistaGestionarInfoUsuario vistaGestionarInfoUsuario = (VistaGestionarInfoUsuario) loader.getController();
            vistaGestionarInfoUsuario.initAttribute(usuario, wheels, listaViajes);
            scene = new Scene(root);
            stage = new Stage();

            // Titulo e imagen
            stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stage.setTitle("UniWheels");

            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que abre la ventana de gestión de información de pago del usuario
     * @param event
     */
    @FXML
    void irGestionarInfoPago(ActionEvent event) {

        if (usuario.getDatosPago() != null)
        {
            Stage stage2 = (Stage) this.gestionarInfoPagobtn.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ADVERTENCIA - Actualizacion de datos");
            alert.setContentText("Se han encontrado datos de pago en su perfil. Los que actualice pasaran a ser los nuevos.");

            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stageAlert.setTitle("UniWheels");

            alert.showAndWait();
        }

        Stage stage1 = (Stage) this.gestionarInfoPagobtn.getScene().getWindow();

        stage1.close();
        FXMLLoader loader;
        Parent root;
        Scene scene;
        Stage stage;
        try {

            loader = new FXMLLoader(HelloApplication.class.getResource("gestionarInfoPago.fxml"));
            root = loader.load();
            //Se prepara el controlador de la otra pantalla
            VistaGestionarInfoPago vistaGestionarInfoPago = (VistaGestionarInfoPago) loader.getController();
            vistaGestionarInfoPago.initAttribute(usuario, wheels);
            scene = new Scene(root);
            stage = new Stage();

            // Titulo e imagen
            stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stage.setTitle("UniWheels");

            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo que abre la ventana de busqueda de viajes
     * @param actionEvent
     */
    @FXML
    public void irBusqueda(ActionEvent actionEvent) {
        //Se va a crear la pantalla de busqueda
        Stage stage1 = (Stage) this.gestionarInfoPagobtn.getScene().getWindow();

        stage1.close();
        FXMLLoader loader;
        Parent root;
        Scene scene;
        Stage stage;
        try {

            loader = new FXMLLoader(HelloApplication.class.getResource("VistaBusqueda.fxml"));
            root = loader.load();
            //Se prepara el controlador de la otra pantalla
            VistaBusqueda vistaBusqueda = (VistaBusqueda) loader.getController();
            vistaBusqueda.initAttributes(listaViajes, usuario, wheels);

            scene = new Scene(root);
            stage = new Stage();

            // Titulo e imagen
            stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stage.setTitle("UniWheels");

            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo que abre la ventana de publicacion de viajes
     * @param event
     */
    @FXML
    void publicarViaje(ActionEvent event) {
        if(usuario.isConductor()){
            //Se va a crear la pantalla de busqueda
            Stage stage1 = (Stage) this.gestionarInfoPagobtn.getScene().getWindow();

            stage1.close();
            FXMLLoader loader;
            Parent root;
            Scene scene;
            Stage stage;
            try {

                loader = new FXMLLoader(HelloApplication.class.getResource("PublicarViaje.fxml"));
                root = loader.load();
                //Se prepara el controlador de la otra pantalla
                VistaPublicarViaje vistaPublicarViaje = (VistaPublicarViaje) loader.getController();
                vistaPublicarViaje.initAttributes(listaViajes, usuario, wheels);

                scene = new Scene(root);
                stage = new Stage();

                // Titulo e imagen
                stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                stage.setTitle("UniWheels");

                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ADVERTENCIA - Publicar viaje");
            alert.setContentText("No puede publicar viajes si no es conductor.");

            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stageAlert.setTitle("UniWheels");

            alert.showAndWait();
        }
    }

    /**
     * Metodo que abre la ventana de calificacion de viajes
     * @param actionEvent
     */
    @FXML
    public void irCalConductor(ActionEvent actionEvent) {
        //Se va a crear la pantalla de calificacion del conductor
        Stage stage1 = (Stage) this.gestionarInfoPagobtn.getScene().getWindow();

        stage1.close();
        FXMLLoader loader;
        Parent root;
        Scene scene;
        Stage stage;
        try {

            loader = new FXMLLoader(HelloApplication.class.getResource("CalConductor.fxml"));
            root = loader.load();
            //Se prepara el controlador de la otra pantalla
            CalConductor calConductor = (CalConductor) loader.getController();
            calConductor.initAttributes(listaViajes, usuario, wheels);

            scene = new Scene(root);
            stage = new Stage();

            // Titulo e imagen
            stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stage.setTitle("UniWheels");

            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
