package com.example.proyectowheels.Model.Command;

import com.example.proyectowheels.Model.ListaViajes;
import com.example.proyectowheels.Model.Viaje;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class CargarViajesTest {

    @Test
    public void testCargarViajes() throws FileNotFoundException {
        int lineas = 0;
        Viaje viaje = new Viaje();
        ListaViajes listaViajes = new ListaViajes();
        CargarViajes cargarViajes = new CargarViajes();
        FileReader fr = new FileReader("Wheels_Viajes.txt");
        BufferedReader bf = new BufferedReader(fr);
        lineas = bf.lines().toArray().length;
        cargarViajes.execute(listaViajes, viaje);
        assertEquals(listaViajes.getViajes().size(), lineas);
    }

}