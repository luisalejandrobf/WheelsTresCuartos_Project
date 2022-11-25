package com.example.proyectowheels.Model.Command;

import com.example.proyectowheels.Model.ListaViajes;
import com.example.proyectowheels.Model.Viaje;

/**
 * Clase que implementa la interfaz Command, y que se encarga de crear un viaje.
 */
public class CrearViaje implements Command {

    /**
     * Función que crea un viaje
     * @param listaViajes
     * @param viaje
     */
    @Override
    public void execute(ListaViajes listaViajes, Viaje viaje) {
        listaViajes.getViajes().add(viaje);
    }

}
