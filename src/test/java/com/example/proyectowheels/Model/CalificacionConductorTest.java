package com.example.proyectowheels.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalificacionConductorTest {

    @Test
    public void PruebaGets()
    {
        CalificacionConductor calificacionConductor = new CalificacionConductor("1000000", "2");

        assertEquals ( "1000000", calificacionConductor.getPuntuacion() );
    }

}