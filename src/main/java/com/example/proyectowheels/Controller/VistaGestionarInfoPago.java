package com.example.proyectowheels.Controller;
import com.example.proyectowheels.HelloApplication;
import com.example.proyectowheels.Model.*;
import com.example.proyectowheels.Model.Builder.DatosPago_Director;
import com.example.proyectowheels.Model.Builder.TarjetaBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase se encarga de gestionar las llamadas y visualizacion de pestanas en el caso de la interfaz de gestion de pago.
 * Funciona como clase controladora
 */
public class VistaGestionarInfoPago {


    @FXML
    private TextField CardHolderInput;
    @FXML
    private ImageView btnCerrarSesion;
    @FXML
    private TextField MMInput;
    @FXML
    private TextField YYInput;
    @FXML
    private TextField CCVInput;
    @FXML
    private Button confirmarDatosBtn;
    @FXML
    private TextField CardNumberInput;
    @FXML
    private Button btnRegresar;

    private Usuario usuario;
    private PersistenciaWheels persistencia;
    private String correoOriginal;
    private Wheels wheels;
    @FXML
    private RadioButton radiobtnDebito;
    @FXML
    private RadioButton radiobtnCredito;
    @FXML
    private Text lbltipotarjeta;

    /**
     * Metodo para la construccion de tarjetas, de manera nula.
     */
    public void initAttribute(Usuario usuario, Wheels wheels) {
        persistencia = new PersistenciaWheels();
        this.usuario = usuario;
        this.wheels = wheels;
        correoOriginal = this.usuario.getCorreo();

        if (this.usuario.getDatosPago() != null){
            CardHolderInput.setText(this.usuario.getDatosPago().getCardHolder());
            CardNumberInput.setText(this.usuario.getDatosPago().getCardNumber());
            MMInput.setText(this.usuario.getDatosPago().getMM());
            YYInput.setText(this.usuario.getDatosPago().getYY());
            CCVInput.setText(this.usuario.getDatosPago().getCVC_CCV());

            if (this.usuario.getDatosPago().getTipo() == 'C')
                radiobtnCredito.setSelected(true);

            else
                radiobtnDebito.setSelected(true);

        }

    }

    public void actualizarDatosPago() {
        char Campotipo = ' ';
        String CampoCardHolder = CardHolderInput.getText();
        String CampoCardNumber = CardNumberInput.getText();
        String CampoMM = MMInput.getText();
        String CampoYY = YYInput.getText();
        String CampoCVC_CCV = CCVInput.getText();

        if (radiobtnCredito.isSelected())
            Campotipo = 'C';

        else
            Campotipo = 'D';

        /* Se implementa el patron builder. En este caso, solo se utiliza para construir tarjetas,
        Pero cumple el principio open/closed. Abierto para extension (Posibles nuevos metodos de pago) y cerrado para modificacion.*/


        DatosPago_Director datosPago_Director = new DatosPago_Director(Campotipo, CampoCardHolder, CampoCardNumber, CampoMM, CampoYY, CampoCVC_CCV);
        TarjetaBuilder tarjetaBuilder = new TarjetaBuilder();
        datosPago_Director.construirTarjeta(tarjetaBuilder);
        Tarjeta tarjeta = tarjetaBuilder.getProduct();

        //System.out.println(tarjeta.toString());

        // Se actualiza la informacion del usuario
        this.usuario.setDatosPago(tarjeta);

    }

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


    @FXML
    public void ConfirmarDatos(ActionEvent actionEvent) {

        boolean ValidarNumeros = false;

        if ((CardNumberInput.getText().matches("^[0-9]*$") && CardNumberInput.getText().length() > 1) && (CCVInput.getText().matches("^[0-9]*$") && CCVInput.getText().length() > 1) && (MMInput.getText().matches("^[0-9]*$") && MMInput.getText().length() > 1)){
            //Informacion Correcta, sigue al siguiente if.
            ValidarNumeros = true;
        }

        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Recuerde que solo puede ingresar numeros en algunos de los campos. Vuelva a intentarlo.");

            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stageAlert.setTitle("UniWheels");

            alert.showAndWait();
        }

        if (ValidarNumeros == true) {

            // Si alguno de los campos, incluyendo la seleccion multiple esta vacio.
            if (CardHolderInput.getText().equals("") || CardNumberInput.getText().equals("") ||
                    CCVInput.getText().equals("") || MMInput.getText().equals("") || YYInput.getText().equals("") || (radiobtnCredito.isSelected() == false && radiobtnDebito.isSelected() == false)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Hay campos vacíos. Por favor, rellene la información de pago, y seleccione si su tarjeta es de débito o crédito.");

                Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                stageAlert.setTitle("UniWheels");

                alert.showAndWait();

            } else {

                actualizarDatosPago();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha ingresado la información de pago correctamente");

                Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                stageAlert.setTitle("UniWheels");

                alert.showAndWait();

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

        }

    }

    @FXML
    public void actDebito(ActionEvent actionEvent) {
        if (radiobtnCredito.isSelected()){
            radiobtnCredito.setSelected(false);
        }
    }

    @FXML
    public void actCredito(ActionEvent actionEvent) {
        if (radiobtnDebito.isSelected()){
            radiobtnDebito.setSelected(false);
        }
    }



}