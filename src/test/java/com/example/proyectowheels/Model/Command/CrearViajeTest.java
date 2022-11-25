package com.example.proyectowheels.Model.Command;

import com.example.proyectowheels.Model.ListaViajes;
import com.example.proyectowheels.Model.Viaje;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class CrearViajeTest {

    @Test
    public void testCrearViaje() {
        Viaje viaje = new Viaje(LocalDate.parse("2020-10-10"), LocalTime.parse("10:00:00"), "Juan", "ABC123", 10000, "Calle 100", "Centro");
        ListaViajes listaViajes = new ListaViajes();
        CrearViaje crearViaje = new CrearViaje();
        crearViaje.execute(listaViajes, viaje);
        assertEquals(listaViajes.getViajes().size(), 1);
    }

}