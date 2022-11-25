package com.example.proyectowheels.Model.Decorador;

import com.example.proyectowheels.Model.CalificacionConductor;
import com.example.proyectowheels.Model.Factory.FabricaAlgoritmoBuscarMostrar;
import com.example.proyectowheels.Model.Interfaces.AlgoritmoBuscarMostrar;
import com.example.proyectowheels.Model.Viaje;

import java.util.ArrayList;


/**
 * Clase decorador que extiende el decorador base (la clase abstracta)
 * Se indica la implementación del constructor donde se va a proeveer la instancia la interfaz
 * Se agrega la funcionalidad adicional en este caso calificar
 * El patrón decorator permite añadir nuevas funcionalidades a un objeto existente sin alterar su estructura
 */
public class CalConductorDecorator extends CalConductorAbstract{

    /**
     * Constructor de la clase CalConductorDecorator que recibe la instancia de la interfaz AlgoritmoBuscarMostrar y la asigna a la variable algoritmo de la clase padre (CalConductorAbstract)
     * @param calConductor
     */
    public CalConductorDecorator(AlgoritmoBuscarMostrar calConductor){
        super(calConductor);
    }

    /**
     * Función que busca los viajes de un conductor y los retorna
     * @param parametro
     * @param viajes
     * @return
     */
    @Override
    public ArrayList<Viaje> buscar(String parametro, ArrayList<Viaje> viajes) {
        //System.out.println("PASA POR AQUI, saludos profe >:)");
        return super.buscar(parametro, viajes);
    }

    /**
     * Función que permite calificar al conductor de un viaje
     * @param viajes
     * @param casilla
     * @param indice
     * @param puntaje
     */
    public void  calificar (ArrayList<Viaje> viajes, String casilla, int indice, String puntaje){
        this.buscar(casilla, viajes);
        System.out.println("CALIFICACION "+viajes.get(indice).getPlaca()+ " puntaje "+puntaje);
        CalificacionConductor CalCon =  new CalificacionConductor();

        CalCon.setPlaca(viajes.get(indice).getPlaca());
        CalCon.setConductor(viajes.get(indice).getConductor());
        CalCon.setMensaje(viajes.get(indice).getMensaje());
        CalCon.setDestino(viajes.get(indice).getDestino());
        CalCon.setZona(viajes.get(indice).getZona());
        CalCon.setFechaSalida(viajes.get(indice).getFechaSalida());
        CalCon.setHoraSalida(viajes.get(indice).getHoraSalida());
        CalCon.setTarifa(viajes.get(indice).getTarifa());
        CalCon.setPuntuacion(puntaje);
        //calConductorD.buscar( parametro,  viajes);
    }



}
