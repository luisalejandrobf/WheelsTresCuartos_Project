package com.example.proyectowheels.Controller;

import com.example.proyectowheels.HelloApplication;
import com.example.proyectowheels.Model.Carro;
import com.example.proyectowheels.Model.Usuario;
import com.example.proyectowheels.Model.Wheels;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Clase que controla la vista de gestionar la creacion de un usuario
 */
public class VistaCrearCuenta {
    @javafx.fxml.FXML
    private TextField txtCon;
    @javafx.fxml.FXML
    private Button btnSal;
    @javafx.fxml.FXML
    private TextField txtApe;
    @javafx.fxml.FXML
    private TextField txtCor;
    @javafx.fxml.FXML
    private RadioButton btnNo;
    @javafx.fxml.FXML
    private TextField txtPla;
    @javafx.fxml.FXML
    private TextField txtCel;
    @javafx.fxml.FXML
    private RadioButton btnSi;
    @javafx.fxml.FXML
    private Button btnCre;
    @javafx.fxml.FXML
    private TextField txtNom;

    @javafx.fxml.FXML
    private ToggleGroup tgUser;


    //Atributos de la clase
    private Wheels wheels;
    private PersistenciaWheels per;

    /**
     * Metodo que inicializa los atributos de la clase
     * @param url
     * @param resourceBundle
     */
    public void initialize(URL url, ResourceBundle resourceBundle){
        this.btnSi.setToggleGroup(tgUser);
        this.btnNo.setToggleGroup(tgUser);
    }

    /**
     * Metodo que inicializa los atributos de la clase
     * @param wheels
     * @param per
     */
    public void initAttribute(Wheels wheels){
        this.per = new PersistenciaWheels();
        this.wheels = wheels;
    }

    /**
     * Metodo que se retorna a la vista de inicio de sesion
     * @param actionEvent
     * @throws IOException
     */
    @javafx.fxml.FXML
    public void salir(ActionEvent actionEvent) {
        Stage stage1 = (Stage) this.btnSal.getScene().getWindow();
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
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo que crea un usuario y lo agrega a la lista de usuarios al presionar el boton crear cuenta
     * @param actionEvent
     */
    @javafx.fxml.FXML
    public void crearCuenta(ActionEvent actionEvent) throws IOException {
        Usuario usuario;
        String nombre, apellido, correo, contraseña, placa;
        boolean registro = false;
        long celular;
        if(btnSi.isSelected()){
            //Se obtienen los datos para del conductor
            nombre = txtNom.getText();
            apellido = txtApe.getText();
            correo = txtCor.getText();
            contraseña = txtCon.getText();
            placa = txtPla.getText();
            //Primero revisa que todos los datos hayan sido llenados
            if(nombre != "" && apellido != "" && correo != "" && txtCel.getText() != "" && contraseña != "" && placa != ""){
                //Validar creación de usuario
                //Se revisa que se haya colocado un numero
                try{
                    celular = Long.parseLong(txtCel.getText());
                    //Revisa que el número no sea negativo
                    if(celular > 0){
                        //Se valida el correo ingresado del usuario
                        if(wheels.validarUsuario(correo)){
                            Carro carro;
                            carro = new Carro(placa, "", "", "", 0);
                            //Se agrega un carro con la placa ingresada
                            usuario = new Usuario(true,nombre, apellido, correo, contraseña, celular,new ArrayList<Carro>(){{
                                add(carro);
                            }}, null);
                            wheels.agregarUsuario(usuario);
                            //Se agrego carro exitosamente
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setTitle("Información");
                            alert.setContentText("El usuario ha sido creado exitosamente");

                            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                            stageAlert.setTitle("UniWheels");


                            alert.showAndWait();
                            registro = true;
                        }
                        else{
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("Error");
                            alert.setContentText("El correo ya está usado");

                            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                            stageAlert.setTitle("UniWheels");

                            alert.showAndWait();
                        }
                    }
                    else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("El campo celular no puede ser un numero negativo");

                        Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                        stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                        stageAlert.setTitle("UniWheels");

                        alert.showAndWait();
                    }
                }
                catch(NumberFormatException e){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("El campo celular solo recibe numeros");

                    Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                    stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                    stageAlert.setTitle("UniWheels");

                    alert.showAndWait();
                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Lleno los campos vacios. No deje en blanco su placa si es conductor");

                Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                stageAlert.setTitle("UniWheels");

                alert.showAndWait();
            }


        }
        else if(btnNo.isSelected()){
            //Se obtienen los datos para del usuario que no es conductor
            nombre = txtNom.getText();
            apellido = txtApe.getText();
            correo = txtCor.getText();
            contraseña = txtCon.getText();
            //Se verifica que los campos necesarios han sido llenados
            if(nombre != "" && apellido != "" && correo != "" && txtCel.getText() != "" && contraseña != ""){
                celular = Long.parseLong(txtCel.getText());
                try{
                    if(celular > 0){
                        if(wheels.validarUsuario(correo)){
                            //Se agrega el nuevo usuario
                            usuario = new Usuario(false,nombre, apellido, correo, contraseña, celular, null, null);
                            wheels.agregarUsuario(usuario);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setTitle("Información");
                            alert.setContentText("Se ha completado el registro de perfil");

                            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                            stageAlert.setTitle("UniWheels");

                            alert.showAndWait();
                            registro = true;
                        }
                        else{
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("Error");
                            alert.setContentText("El correo ya fue usado");

                            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                            stageAlert.setTitle("UniWheels");

                            alert.showAndWait();
                        }
                    }
                    else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("El campo celular no puede tener numeros negativos");

                        Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                        stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                        stageAlert.setTitle("UniWheels");

                        alert.showAndWait();
                    }
                }
                catch (NumberFormatException e){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("El campo celular solo recibe numeros");

                    Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                    stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                    stageAlert.setTitle("UniWheels");

                    alert.showAndWait();
                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Llene los campos vacios. Deje en blanco placa si no es conductor");

                Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                stageAlert.setTitle("UniWheels");

                alert.showAndWait();
            }
        }
        else{
            //Se lanza una alerta al programa.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Ningún boton de tipo de usuario fue seleccionado. Seleccione uno antes de registrarse");

            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stageAlert.setTitle("UniWheels");

            alert.showAndWait();
        }
        if(registro){
            per.EscribirArchivo(wheels);
            Stage stage1 = (Stage) this.btnCre.getScene().getWindow();

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
                stage.showAndWait();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
