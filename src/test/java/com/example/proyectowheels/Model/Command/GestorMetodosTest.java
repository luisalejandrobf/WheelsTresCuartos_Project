package com.example.proyectowheels.Model.Command;

import com.example.proyectowheels.Model.ListaViajes;
import com.example.proyectowheels.Model.Viaje;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class GestorMetodosTest {

    @Test
    void testGestorMetodosCrearViaje() {
        GestorMetodos gestorMetodos = new GestorMetodos();
        Viaje viaje = new Viaje(LocalDate.parse("2020-10-10"), LocalTime.parse("10:00:00"), "Juan", "ABC123", 10000, "Calle 100", "Centro");
        ListaViajes listaViajes = new ListaViajes();
        gestorMetodos.execute(new CrearViaje(), listaViajes, viaje);
        assertEquals(listaViajes.getViajes().size(), 1);
    }
}