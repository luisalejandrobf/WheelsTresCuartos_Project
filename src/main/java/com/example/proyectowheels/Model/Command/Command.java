package com.example.proyectowheels.Model.Command;

import com.example.proyectowheels.Model.ListaViajes;
import com.example.proyectowheels.Model.Viaje;

/**
 * Interface Command para el patron de diseño Command.
 */
public interface Command {

    /**
     * Metodo execute para el patron de diseño Command.
     * @param listaViajes
     * @param viaje
     */
    void execute(ListaViajes listaViajes, Viaje viaje);

}
