package com.example.proyectowheels.Model.Algoritmos;

import com.example.proyectowheels.Model.Interfaces.AlgoritmoBuscarMostrar;
import com.example.proyectowheels.Model.Viaje;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Clase que implementa el algoritmo de filtrado por destino
 */
public class PorDestino implements AlgoritmoBuscarMostrar {
    /**
     * Filtra los viajes de la lista de viajes según el destino Y retorna la lista de viajes filtrada
     * @param parametro
     * @param viajes
     * @return ArrayList con los viajes filtrados
     */
    @Override
    public ArrayList<Viaje> buscar(String parametro, ArrayList<Viaje> viajes) {
        return (ArrayList<Viaje>) viajes.stream().filter(v->v.getDestino().toLowerCase().replaceAll(" ", "").
                contains(parametro.toLowerCase().replaceAll(" ", ""))).collect(Collectors.toList());
    }
    /**
     * Retorna el mensaje que se mostrará al usuario cuando se filtra por destino
     * @param viaje
     * @return String con el mensaje
     */
    @Override
    public String mostrarMensaje(Viaje viaje) {
        return "Conductor: " + viaje.getConductor() + " hacia destino: " + viaje.getDestino() + " Cobra: "
                + Double.toString(viaje.getTarifa());
    }
}
