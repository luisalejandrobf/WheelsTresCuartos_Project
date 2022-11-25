package com.example.proyectowheels.Model.Command;

import com.example.proyectowheels.Model.ListaViajes;
import com.example.proyectowheels.Model.Viaje;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
/**
 * Clase que implementa la interfaz Command, y que se encarga de cargar los viajes de un archivo de texto
 */
public class CargarViajes implements Command {

    /**
     * Función que realiza la carga de la información de los viajes del archivo Wheels_Viajes.txt
     * @param listaViajes
     * @param viaje
     */
    public void execute(ListaViajes listaViajes, Viaje viaje) {
        try (FileReader fr = new FileReader("Wheels_Viajes.txt");
             BufferedReader entrada = new BufferedReader(fr)){

            // Se crean campos/variables auxiliares para guardar valores.
            String inLine = "";
            String[] campo = {""};

            // Para Usuario
            LocalDate fechaSalida = null;
            LocalTime horaSalida = null;
            String conductor = "";
            String placas = "";
            Double tarifa = 0.0;
            String destino = "";
            String zona = "";
            String mensaje = "";
            ArrayList<String> ListaCampos = new ArrayList<String>();
            System.out.println("Archivo Viajes:");

            while ((inLine = entrada.readLine()) != null){

                ListaCampos.clear();
                System.out.println(inLine);

                // Se parte la linea en cadenas.
                //campo = inLine.split(",");
                campo = inLine.split("[,]", 0);


                for (int i =0; i<campo.length; i++) {
                    ListaCampos.add(campo[i]);
                }



                //System.out.println(" #Tam" + ":" + ListaCampos.get(4));

                // Se hace el casting de datos, y la la respectiva instanciacion haciendo uso de los constructores.
                fechaSalida = LocalDate.parse(ListaCampos.get(0));
                horaSalida = LocalTime.parse(ListaCampos.get(1));
                conductor = ListaCampos.get(2);
                placas = ListaCampos.get(3);
                tarifa = Double.parseDouble(ListaCampos.get(4));
                destino = ListaCampos.get(5);
                zona = ListaCampos.get(6);

                Viaje viajeAux = new Viaje(fechaSalida, horaSalida, conductor, placas, tarifa, destino, zona, mensaje);
                GestorMetodos gestorMetodos = new GestorMetodos();
                gestorMetodos.execute(new CrearViaje(), listaViajes, viajeAux);
            }
            System.out.println("\n\n\\ Archivo de viajes leido.\n");

        }   catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
