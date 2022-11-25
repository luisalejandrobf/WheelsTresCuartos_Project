package com.example.proyectowheels.Controller;

import com.example.proyectowheels.HelloApplication;
import com.example.proyectowheels.Model.*;
import com.example.proyectowheels.Model.Command.CrearViaje;
import com.example.proyectowheels.Model.Command.EscribirViajes;
import com.example.proyectowheels.Model.Command.GestorMetodos;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Clase que controla la vista de publicar viaje
 */
public class VistaPublicarViaje {

    @FXML
    private Button btnCrearViaje;

    @FXML
    private Button btnRegresar;

    @FXML
    private DatePicker fecha;

    @FXML
    private ComboBox<Carro> listaPlacasCarros;

    @FXML
    private TextField txtDestino;

    @FXML
    private TextField txtHora;

    @FXML
    private TextField txtMinutos;

    @FXML
    private TextField txtTarifa;

    @FXML
    private TextField txtZona;
    private ListaViajes listaViajes;
    private Usuario usuario;
    private Wheels wheels;
    private int hora;
    private int minutos;

    private double tarifa;


    LocalDate fechaSeleccionada;

    GestorMetodos gestorMetodos = new GestorMetodos();

    /**
     * Método que inicializa los atributos de la clase
     * @param listaViajes
     * @param usuario
     * @param wheels
     */
    public void initAttributes(ListaViajes listaViajes, Usuario usuario, Wheels wheels){
        listaPlacasCarros.getItems().addAll(usuario.getCarros());
        listaPlacasCarros.setConverter(new StringConverter<Carro>() {
            @Override
            public String toString(Carro object) {
                return object.getPlaca();
            }

            @Override
            public Carro fromString(String string) {
                return null;
            }
        });
        this.usuario = usuario;
        this.listaViajes = listaViajes;
        this.wheels = wheels;

    }


    @FXML
    void comboBoxEvents(ActionEvent event) {

    }

    /**
     * Método que se encarga de gestionar la entrada de datos en el campo de texto de la hora
     * @param event
     */
    boolean txtHoraEvent() {
        try{
            hora = Integer.parseInt(txtHora.getText());
            if(hora < 0 ){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El número de horas no puede ser negativo");

                Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                stageAlert.setTitle("UniWheels");

                alert.showAndWait();
                return false;
            } else if (hora > 23){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El número de horas no puede ser mayor a 23");

                Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                stageAlert.setTitle("UniWheels");

                alert.showAndWait();
                return false;
            } else {
                return true;
            }
            //Revisa que el número no sea negativo
        }
        catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La hora debe ser numérica");

            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stageAlert.setTitle("UniWheels");

            alert.showAndWait();
        }
        return false;
    }

    /**
     * Método que se encarga de gestionar la entrada de datos en el campo de texto de los minutos
     * @return
     */
    boolean txtMinutosEvents() {
        try{
            minutos = Integer.parseInt(txtMinutos.getText());
            //Revisa que el número no sea negativo
            if(minutos < 0 ){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El número de minutos no puede ser negativo");

                Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                stageAlert.setTitle("UniWheels");

                alert.showAndWait();
                return false;
            } else if (minutos > 60){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El número de minutos no puede ser mayor a 60");

                Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                stageAlert.setTitle("UniWheels");

                alert.showAndWait();
                return false;
            } else {
                return true;

            }
        }
        catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Los minutos deben ser numéricos");

            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stageAlert.setTitle("UniWheels");

            alert.showAndWait();
        }
        return false;
    }

    /**
     * Método que se encarga de gestionar la entrada de datos en el campo de texto de la tarifa
     * @return
     */
    boolean txtTarifaEvents() {
        try{
            tarifa = Double.parseDouble(txtTarifa.getText());
            //Revisa que el número no sea negativo
            if(tarifa < 0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("La tarifa no puede ser negativa");

                Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
                stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
                stageAlert.setTitle("UniWheels");

                alert.showAndWait();
                return false;
            }   else {
                return true;
            }
        }
        catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La tarifa debe ser numérica");

            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stageAlert.setTitle("UniWheels");

            alert.showAndWait();
        }
        return false;
    }

    /**
     * Metodo que se encarga de crear un nuevo viaje
     * @param event
     */
    @FXML
    void crearViaje(ActionEvent event) {
        if(txtDestino.getText().equals("") || txtZona.getText().equals("") || txtHora.getText().equals("") || txtMinutos.getText().equals("") || txtTarifa.getText().equals("") || fecha.getValue() == null || listaPlacasCarros.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No puede haber campos vacíos");

            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stageAlert.setTitle("UniWheels");

            alert.showAndWait();
        } else if (txtHoraEvent() == false || txtMinutosEvents() == false || txtTarifaEvents() == false){
            //No hace nada

        }
        else{
            LocalTime horaSal = LocalTime.parse(txtHora.getText() + ":" + txtMinutos.getText());
            Viaje viaje = new Viaje(fechaSeleccionada, horaSal, usuario.getNombres(), listaPlacasCarros.getValue().getPlaca(), tarifa, txtDestino.getText(), txtZona.getText());
            gestorMetodos.execute(new CrearViaje(), listaViajes, viaje);
            gestorMetodos.execute(new EscribirViajes(), listaViajes, viaje);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Éxito");
            alert.setContentText("Viaje creado exitosamente");

            Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
            stageAlert.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("UniWheels.png")));
            stageAlert.setTitle("UniWheels");

            alert.showAndWait();
            regresar();
        }
    }

    /**
     * Metodo que se encarga de controlar y manejar la entrada de datos de la fecha
     * @param event
     */
    @FXML
    void manejoFecha(ActionEvent event) {
        LocalDate hoy = LocalDate.now();
        fechaSeleccionada = fecha.getValue();
        if(fechaSeleccionada.isBefore(hoy)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fecha no válida");
            alert.setContentText("La fecha seleccionada no puede ser anterior a la fecha actual");
            alert.showAndWait();
        }
    }

    /**
     * Metodo que se encarga de regresar a la ventana anterior
     */
    @FXML
    void regresar() {
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
            vistaPrincipal.initAttribute(wheels, usuario, listaViajes);
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

