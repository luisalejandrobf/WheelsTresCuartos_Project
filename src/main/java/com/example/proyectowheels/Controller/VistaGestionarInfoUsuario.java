package com.example.proyectowheels.Controller;
import com.example.proyectowheels.HelloApplication;
import com.example.proyectowheels.Model.ListaViajes;
import com.example.proyectowheels.Model.Usuario;
import com.example.proyectowheels.Model.Wheels;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Metodo Controlador de la vista VistaGestionarInfoUsuario
 */
public class VistaGestionarInfoUsuario {

    @FXML
    private Button btnRegresar;

    @FXML
    private ImageView btnCerrarSesion;

    @FXML
    private TextField inputApellido;

    @FXML
    private TextField inputCelular;

    @FXML
    private CheckBox inputCheckConductor;

    @FXML
    private TextField inputContrasena;

    @FXML
    private TextField inputCorreo;

    @FXML
    private TextField inputNombre;

    private Usuario usuario;
    private PersistenciaWheels persistencia;
    private String correoOriginal;

    private Wheels wheels;

    private ListaViajes listaViajes;

    /**
     * Metodo que inicializa los atributos de la clase
     * @param usuario
     * @param wheels
     * @param listaViajes
     */
    public void initAttribute(Usuario usuario, Wheels wheels, ListaViajes listaViajes) {
        persistencia = new PersistenciaWheels();
        this.usuario = usuario;
        this.wheels = wheels;
        this.listaViajes = listaViajes;
        correoOriginal = this.usuario.getCorreo();
        inputNombre.setText(this.usuario.getNombres());
        inputApellido.setText(this.usuario.getApellidos());
        inputCelular.setText(String.valueOf(this.usuario.getCelular()));
        inputCorreo.setText(this.usuario.getCorreo());
        inputContrasena.setText(this.usuario.getContrasena());
        if(this.usuario.isConductor())
            inputCheckConductor.setSelected(true);
        else
            inputCheckConductor.setSelected(false);
    }

    /**
     * Metodo que se encarga de guardar los cambios realizados en la informacion del usuario
     * @param event
     * @throws IOException
     */
    @FXML
    void guardarActualizacionDatos(ActionEvent event) throws IOException {
        if(inputNombre.getText().equals("") || inputApellido.getText().equals("") ||
                inputCelular.getText().equals("") || inputCorreo.getText().equals("") || inputContrasena.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Hay campos vacíos");

            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stageAlert.setTitle("UniWheels");

            alert.showAndWait();
        } else {
            try {
                if (inputCheckConductor.isSelected())
                    wheels.editarConductor(correoOriginal, true);
                else
                    wheels.editarConductor(correoOriginal, false);

                wheels.editarNombres(correoOriginal, inputNombre.getText());
                wheels.editarApellidos(correoOriginal, inputApellido.getText());
                wheels.editarContrasena(correoOriginal, inputContrasena.getText());
                long celular = Long.parseLong(inputCelular.getText());
                wheels.editarCelular(correoOriginal, celular);
                wheels.editarCorreo(correoOriginal, inputCorreo.getText());

                persistencia.EscribirArchivo(wheels);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha actualizado la información correctamente");

                Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                stageAlert.setTitle("UniWheels");

                alert.showAndWait();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El dato ingresado no corresponde a un entero");

                Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                stageAlert.setTitle("UniWheels");


                alert.showAndWait();
            }
        }
    }

    /**
     * Metodo que se encarga de regresar a la vista anterior
     * @param event
     */
    @FXML
    void regresarPrincipal(ActionEvent event) {
        Stage stage1 = (Stage) this.btnRegresar.getScene().getWindow();
        stage1.close();

        FXMLLoader loader;
        Parent root;
        Scene scene;
        Stage stage;
        try {
            loader = new FXMLLoader(HelloApplication.class.getResource("VistaPrincipal.fxml"));
            root = loader.load();
            VistaPrincipal vistaPrincipal = (VistaPrincipal) loader.getController();
            vistaPrincipal.initAttribute(wheels, usuario);
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

    /**
     * Metodo que se encarga de cerrar la sesion del usuario
     * @param event
     */
    @FXML
    void cerrarSesion(MouseEvent event) {
        Stage stage1 = (Stage) this.btnCerrarSesion.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Cerrar sesión");
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}