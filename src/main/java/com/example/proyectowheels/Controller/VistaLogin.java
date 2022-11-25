package com.example.proyectowheels.Controller;

import com.example.proyectowheels.HelloApplication;
import com.example.proyectowheels.Model.Usuario;
import com.example.proyectowheels.Model.Wheels;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Clase controladora de la vista VistaGestionarInfoUsuario
 */
public class VistaLogin {

    @FXML
    private PasswordField txtCon;
    @FXML
    private TextField txtCor;
    @FXML
    private Button btnIni;
    @FXML
    private Button btnCre;

    //Atributos del controlador necesarios
    private Wheels wheels;


    private Usuario usuario;

    /**
     * Metodo que se ejecuta al iniciar la vista
     */
    public void initAttribute() {
        Wheels wheels = new Wheels();
        PersistenciaWheels per = new PersistenciaWheels();
        per.LeerArchivo(wheels);
        this.wheels = wheels;

    }

    /**
     * Metodo que se ejecuta al presionar el boton btnIni (Iniciar Sesion) de la vista VistaLogin
     * @param actionEvent
     */
    @FXML
    public void iniciarSesion(ActionEvent actionEvent) {
        usuario = new Usuario();
        //Se autentica el usuario con sus datos para entrar a la aplicación
        String correo, contraseña;
        correo = txtCor.getText();
        contraseña = txtCon.getText();

        if(wheels.validarInicioSesion(correo, contraseña)){

            for(int i = 0; i < wheels.getUsuarios().size(); i++){
                if(wheels.getUsuarios().get(i).getCorreo().equals(correo)){
                    this.usuario = wheels.getUsuarios().get(i);
                }
            }
            Stage stage1 = (Stage) this.btnIni.getScene().getWindow();

            stage1.close();
            //Se abre la pantalla de crear cuenta.
            //No se inicializan ningun atributo a la pantalla.
            //Va a retornar el usuario creado.
            FXMLLoader loader;
            Parent root;
            Scene scene;
            Stage stage;
            try {
                loader = new FXMLLoader(HelloApplication.class.getResource("VistaPrincipal.fxml"));
                root = loader.load();
                //Se prepara el controlador de la otra pantalla
                VistaPrincipal controlador = loader.getController();
                controlador.initAttribute(wheels, usuario);

                scene = new Scene(root);
                stage = new Stage();
                stage.setScene(scene);

                // Titulo e imagen
                stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                stage.setTitle("UniWheels");

                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El usuario o contraseña ingresados no existen");

            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stageAlert.setTitle("UniWheels");

            alert.showAndWait();
        }
    }

    /**
     * Metodo que se ejecuta al presionar el boton btnCre (Crear Cuenta) de la vista VistaLogin
     * @param actionEvent
     */
    @FXML
    public void crearCuenta(ActionEvent actionEvent) {
        Stage stage1 = (Stage) this.btnCre.getScene().getWindow();
        stage1.close();
        //Se abre la pantalla de crear cuenta.
        //No se inicializan ningun atributo a la pantalla.
        //Va a retornar el usuario creado.
        FXMLLoader loader;
        Parent root;
        Scene scene;
        Stage stage;
        try {
            loader = new FXMLLoader(HelloApplication.class.getResource("CrearCuenta.fxml"));
            root = loader.load();
            //Se prepara el controlador de la otra pantalla
            VistaCrearCuenta vistaCrearCuenta = (VistaCrearCuenta) loader.getController();
            vistaCrearCuenta.initAttribute(wheels);
            scene = new Scene(root);
            stage = new Stage();


            // Titulo e imagen
            stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stage.setTitle("UniWheels");


            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}