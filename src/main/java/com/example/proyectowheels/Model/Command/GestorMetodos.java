package com.example.proyectowheels.Model.Command;

import com.example.proyectowheels.Model.ListaViajes;
import com.example.proyectowheels.Model.Viaje;

/**
 * Clase que se encarga de gestionar la ejecucion
 * de los comandos referentes a los viajes
 */
public class GestorMetodos {

    /**
     * Función que se encarga de ejecutar el comando solicitado
     *
     * @param command
     * @param listaViajes
     * @param viaje
     */
    public void execute(Command command, ListaViajes listaViajes, Viaje viaje){
        command.execute(listaViajes, viaje);
    }
}
