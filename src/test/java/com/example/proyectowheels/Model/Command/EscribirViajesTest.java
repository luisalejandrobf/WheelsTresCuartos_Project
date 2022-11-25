package com.example.proyectowheels.Model.Command;

import com.example.proyectowheels.Model.ListaViajes;
import com.example.proyectowheels.Model.Viaje;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class EscribirViajesTest {

    @Test
    public void testEscribirViajes() throws FileNotFoundException {
        int lineas = 0;
        int lineas2 = 0;
        Viaje viaje = new Viaje(LocalDate.parse("2020-10-10"), LocalTime.parse("10:00:00"), "Juan", "ABC123", 10000, "Calle 100", "Centro");
        ListaViajes listaViajes = new ListaViajes();
        EscribirViajes escribirViajes = new EscribirViajes();
        CrearViaje crearViaje = new CrearViaje();
        crearViaje.execute(listaViajes, viaje);
        FileReader fr = new FileReader("Wheels_Viajes.txt");
        BufferedReader bf = new BufferedReader(fr);
        lineas = bf.lines().toArray().length;
        escribirViajes.execute(listaViajes, viaje);
        lineas2 += 1;
        assertEquals(listaViajes.getViajes().size(), lineas2);
    }

}