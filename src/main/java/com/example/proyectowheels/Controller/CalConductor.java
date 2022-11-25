package com.example.proyectowheels.Controller;

import com.example.proyectowheels.HelloApplication;
import com.example.proyectowheels.Model.Decorador.CalConductorDecorator;
import com.example.proyectowheels.Model.Factory.FabricaAlgoritmoBuscarMostrar;
import com.example.proyectowheels.Model.ListaViajes;
import com.example.proyectowheels.Model.Interfaces.AlgoritmoBuscarMostrar;
import com.example.proyectowheels.Model.Usuario;
import com.example.proyectowheels.Model.Viaje;
import com.example.proyectowheels.Model.Wheels;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Clase que controla la ventana de calificar conductor
 */
public class CalConductor implements Initializable  {
    @javafx.fxml.FXML
    private TextField txtSea;
    @javafx.fxml.FXML
    private ChoiceBox<String> myChoiceBox;
    @javafx.fxml.FXML
    private ListView<Viaje> myListView;
    @javafx.fxml.FXML
    private Button btnReg;
    @javafx.fxml.FXML
    private Button btnIr;

    private String[] tipoBusqueda ={"Por Destino", "Por Nombre", "Por Zona"};

    private ListaViajes listaViajes;

    private Usuario usuario;

    private Wheels wheels;

    @javafx.fxml.FXML
    private ToggleGroup puntaje;

    /**
     * Método que inicializa la ventana
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myChoiceBox.getItems().addAll(tipoBusqueda);
    }

    /**
     * Metodo para inicializar la lista de viajes, el usuario y la instancia de Wheels
     * @param listaViajes
     * @param usuario
     * @param wheels
     */
    public void initAttributes(ListaViajes listaViajes, Usuario usuario, Wheels wheels){
        this.usuario = usuario;
        this.listaViajes = listaViajes;
        this.wheels = wheels;
    }

    /**
     * Método que se ejecuta cuando se presiona el botón de enter en el campo de búsqueda
     * @param actionEvent
     */
    @javafx.fxml.FXML
    public void enter(KeyEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(event.getCode() == KeyCode.ENTER){
            //Se recupera la casilla seleccionada
            if(myChoiceBox.getValue() != null){
                //Se crea el algoritmo de busqueda
                String casilla = myChoiceBox.getValue();
                casilla = casilla.replaceAll(" ", "");
                AlgoritmoBuscarMostrar algoritmo =FabricaAlgoritmoBuscarMostrar.crearAlgoritmoBuscarMostrar(casilla);
                CalConductorDecorator cal = new CalConductorDecorator(algoritmo);
                //Se obtiene el texto de la busqueda
                if(txtSea.getText() != ""){
                    String parametro = txtSea.getText();
                    listaViajes.setAlgoritmo(algoritmo);
                    ArrayList<Viaje> lista  = cal.buscar( parametro,listaViajes.getViajes());
                    lista = listaViajes.filtrarViajes(parametro);
                    //Se hace observable la lista filtrada
                    myListView.setItems(FXCollections.observableList(lista));
                }
                else{
                    alert.setHeaderText(null);
                    alert.setTitle("Error de busqueda");
                    alert.setContentText("Ingrese un dato para obtener resultados");
                    alert.showAndWait();
                }
            }
            else{
                alert.setHeaderText(null);
                alert.setTitle("Error de busqueda");
                alert.setContentText("Por favor, seleccione un valor de la casilla");
                alert.showAndWait();
            }
        }
    }

    /**
     * Método que se ejecuta cuando se presiona el botón de regresar
     * @param actionEvent
     */
    @javafx.fxml.FXML
    public void regresar(ActionEvent actionEvent) {
        Stage stage1 = (Stage)btnReg.getScene().getWindow();
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
     * Método que se ejecuta cuando se presiona el botón de ir
     * @param actionEvent
     */
    //Botón: No es funcional (Posible fucnionalidad: Ir a detalles de la información de Viaje y asegurar un puesto)
    @javafx.fxml.FXML
    public void irRide(ActionEvent actionEvent) {
        int indice =  myListView.getSelectionModel().getSelectedIndex();
        String valPuntaje = ((RadioButton)this.puntaje.getSelectedToggle()).getText();
        String casilla = myChoiceBox.getValue();
        casilla = casilla.replaceAll(" ", "");
        AlgoritmoBuscarMostrar algoritmo =FabricaAlgoritmoBuscarMostrar.crearAlgoritmoBuscarMostrar(casilla);
        CalConductorDecorator cal = new CalConductorDecorator(algoritmo);
        cal.calificar(listaViajes.getViajes(),casilla, indice, valPuntaje );
    }
}
