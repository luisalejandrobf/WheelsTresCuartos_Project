package com.example.proyectowheels.Model.Algoritmos;

import com.example.proyectowheels.Model.Interfaces.AlgoritmoBuscarMostrar;
import com.example.proyectowheels.Model.Viaje;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Clase que implementa el algoritmo de filtrado por nombre de conductor
 */
public class PorNombre implements AlgoritmoBuscarMostrar {
    /**
     * Retorna la lista de viajes filtrados por nombre de conductor
     * @param viajes
     * @return String con el mensaje
     */
    @Override
    public ArrayList<Viaje> buscar(String parametro, ArrayList<Viaje> viajes) {
        return (ArrayList<Viaje>) viajes.stream().filter(v->v.getConductor().toLowerCase().replaceAll(" ", "")
                .contains(parametro.toLowerCase().replaceAll(" ", ""))).collect(Collectors.toList());
    }
    /**
     * Retorna el mensaje que se mostrará al usuario cuando se filtra por nombre
     * @param viaje
     * @return String con el mensaje
     */
    @Override
    public String mostrarMensaje(Viaje viaje) {
        return "Conductor: " + viaje.getConductor() + " con placa "
                + viaje.getPlaca() + " cobra: " + viaje.getTarifa();
    }
}
