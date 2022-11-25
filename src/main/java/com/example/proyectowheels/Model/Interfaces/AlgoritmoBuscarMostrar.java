package com.example.proyectowheels.Model.Interfaces;

import com.example.proyectowheels.Model.Viaje;

import java.util.ArrayList;

/**
 * Interface que define el comportamiento de los algoritmos de busqueda y mostrar para los viajes
 */
public interface AlgoritmoBuscarMostrar {
    public ArrayList<Viaje> buscar(String parametro, ArrayList<Viaje> viajes);
    public String mostrarMensaje (Viaje viaje);
}
