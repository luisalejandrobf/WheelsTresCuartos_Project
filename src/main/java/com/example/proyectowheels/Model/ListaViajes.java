package com.example.proyectowheels.Model;

import com.example.proyectowheels.Model.Interfaces.AlgoritmoBuscarMostrar;
import lombok.*;

import java.util.ArrayList;


@Getter
@Setter
@RequiredArgsConstructor

/**
 * Clase que representa la lista de viajes
 */
public class ListaViajes {


    @NonNull
    private ArrayList<Viaje> viajes ;

    private AlgoritmoBuscarMostrar algoritmo;

    /**
     * Constructor de la clase ListaViajes
     */
    public ListaViajes(){

        this.viajes = new ArrayList<>();
    }

    /**
     * Filtra los viajes de la lista de viajes según el parámetro ingresado por el usuario con un algoritmo y retorna la lista de viajes filtrada
     * @param parametro
     * @return ArrayList con los viajes filtrados
     */
    public ArrayList<Viaje> filtrarViajes(String parametro){
        ArrayList<Viaje> viajesFiltro = algoritmo.buscar(parametro, viajes);
        viajes.stream().forEach(v->v.setMensaje(algoritmo.mostrarMensaje(v)));
        return viajesFiltro;
    }


}
