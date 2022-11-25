package com.example.proyectowheels.Model.Algoritmos;

import com.example.proyectowheels.Model.Viaje;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PorNombreTest {

    @Test
    public void filtrarPorNombreExistente(){
        PorNombre porNombre = new PorNombre();
        ArrayList<Viaje> viajeArrayList = new ArrayList<Viaje>(){
            {
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(10, 32)
                        ,"Gabriel", "TUY466", 23400, "Universidad Javeriana", "Calle 80", ""));
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(11, 32)
                        ,"Daniel", "TOI293", 20000, "Javeriana", "Polo", ""));
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(11, 42)
                        ,"Daniel", "TOI293", 20000, "Javeriana", "Calle 100", ""));
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(12, 32)
                        ,"Sebastian", "YOT198", 40000, "Museo Nacional", "Calle 76", ""));
            }
        };
        ArrayList<Viaje> esperado = new ArrayList<Viaje>(){
            {
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(11, 32)
                        ,"Daniel", "TOI293", 20000, "Javeriana", "Polo", ""));
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(11, 42)
                        ,"Daniel", "TOI293", 20000, "Javeriana", "Calle 100", ""));
            }
        };
        assertTrue(esperado.equals(porNombre.buscar("Dani", viajeArrayList)));
    }
    @Test
    public void filtrarPorNombreNoEncontrado(){
        PorNombre porNombre = new PorNombre();
        ArrayList<Viaje> viajeArrayList = new ArrayList<Viaje>(){
            {
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(10, 32)
                        ,"Gabriel", "TUY466", 23400, "Universidad Javeriana", "Calle 80", ""));
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(11, 32)
                        ,"Daniel", "TOI293", 20000, "Javeriana", "Polo", ""));
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(11, 32)
                        ,"Daniel", "TOI293", 20000, "Javeriana", "Calle 100", ""));
                add(new Viaje(LocalDate.of(2022, Month.NOVEMBER, 10), LocalTime.of(12, 32)
                        ,"Sebastian", "YOT198", 40000, "Museo Nacional", "Calle 76", ""));
            }
        };
        assertEquals(new ArrayList<>(), porNombre.buscar("Camilo", viajeArrayList));
    }
}