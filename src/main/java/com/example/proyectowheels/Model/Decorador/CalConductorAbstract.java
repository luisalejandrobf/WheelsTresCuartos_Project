package com.example.proyectowheels.Model.Decorador;

import com.example.proyectowheels.Model.Interfaces.AlgoritmoBuscarMostrar;
import com.example.proyectowheels.Model.Viaje;

import java.util.ArrayList;

/**
 * Es una clase abstracta, la cual se encarga de implementar la interfaz de búsqueda.
 * Tiene un costructor que recibe cualquier implementación de dicha interfaz.
 */
public abstract class CalConductorAbstract implements AlgoritmoBuscarMostrar {
    protected AlgoritmoBuscarMostrar calConductorD;

    /**
     * Constructor de la clase CalConductorAbstract
     * @param calConductorD
     */
    public CalConductorAbstract(AlgoritmoBuscarMostrar calConductorD){
        this.calConductorD = calConductorD;
    }

    /**
     * Función que busca un viaje en la lista de viajes
     * @param parametro
     * @param viajes
     * @return ArrayList con los viajes filtrados
     */
    @Override
    public ArrayList<Viaje> buscar(String parametro, ArrayList<Viaje> viajes){
        return this.calConductorD.buscar(parametro, viajes);
    }

    /**
     * Función que muestra el mensaje de un viaje
     * @param viaje
     * @return String con el mensaje del viaje
     */
    @Override
    public String mostrarMensaje(Viaje viaje) {
        return this.calConductorD.mostrarMensaje(viaje);
    }

}
