package com.example.proyectowheels.Model.Command;

import com.example.proyectowheels.Model.ListaViajes;
import com.example.proyectowheels.Model.Viaje;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase que implementa la interfaz Command, y que se encarga de escribir en el archivo de texto
 */
public class EscribirViajes implements Command {

    /**
     * Función que realiza la escritura de la información de los viajes en el archivo Wheels_Viajes.txt
     *
     * @param listaViajes
     * @param viaje
     * @return void
     */
    @Override
    public void execute(ListaViajes listaViajes, Viaje viaje) {
        try (FileWriter fw = new FileWriter("Wheels_Viajes.txt");
             BufferedWriter salida = new BufferedWriter(fw);) {
            listaViajes.getViajes().stream().iterator().forEachRemaining(viajeAux -> {
                try {
                    salida.write(viajeAux.formatearEscritura());
                    System.out.println(viajeAux.formatearEscritura());
                    System.out.println("Viaje guardado: " + viajeAux.formatearEscritura());
                    salida.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("\n\\ Archivo de Viajes Escrito Exitosamente\n");

        } catch (IOException ex){
            System.err.println("Hubo un error al escribir el archivo de viajes >> " + ex.getMessage());
            ex.printStackTrace();
        }
    }


}

