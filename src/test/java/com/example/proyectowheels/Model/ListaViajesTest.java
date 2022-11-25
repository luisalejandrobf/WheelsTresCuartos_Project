package com.example.proyectowheels.Model;

import com.example.proyectowheels.Model.Algoritmos.PorDestino;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListaViajesTest {

    /*
    @Test
    public void filtrarListaViajesDestino(){
        ListaViajes listaViajes = new ListaViajes(new ArrayList<Viaje>(){
            {
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(10, 32)
                        ,"Gabriel", "TUY466", 23400, "Universidad Javeriana", "Calle 80", ""));
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(11, 32)
                        ,"Daniel", "TOI293", 20000, "Javeriana", "Polo", ""));
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(11, 42)
                        ,"Daniel", "TOI293", 20000, "Bulevar Niza", "Calle 100", ""));
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(12, 32)
                        ,"Sebastian", "YOT198", 40000, "Bulevar Niza", "Calle 76", ""));
            }
        });
        ArrayList<Viaje> esperado = new ArrayList<Viaje>(){
            {
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(11, 42)
                        ,"Daniel", "TOI293", 20000, "Bulevar Niza", "Calle 100", ""));
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(12, 32)
                        ,"Sebastian", "YOT198", 40000, "Bulevar Niza", "Calle 76", ""));
            }
        };
        PorDestino porDestino = new PorDestino();
        listaViajes.setAlgoritmo(porDestino);
        assertEquals(esperado, listaViajes);
    }
    @Test
    public void filtrarListaViajesDestinoInexistente(){
        ListaViajes listaViajes = new ListaViajes(new ArrayList<Viaje>(){
            {
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(10, 32)
                        ,"Gabriel", "TUY466", 23400, "Universidad Javeriana", "Calle 80", ""));
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(11, 32)
                        ,"Daniel", "TOI293", 20000, "Javeriana", "Polo", ""));
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(11, 42)
                        ,"Daniel", "TOI293", 20000, "Bulevar Niza", "Calle 100", ""));
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(12, 32)
                        ,"Sebastian", "YOT198", 40000, "Bulevar Niza", "Calle 76", ""));
            }
        });
        PorDestino porDestino = new PorDestino();
        listaViajes.setAlgoritmo(porDestino);
        assertEquals(new ArrayList<>(), listaViajes.filtrarViajes("Suba"));
    }
     */

}