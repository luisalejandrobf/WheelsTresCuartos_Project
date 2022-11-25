package com.example.proyectowheels.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TarjetaTest {

    @Test
    public void PruebaGets()
    {
        Tarjeta tarjeta = new Tarjeta('C', "EstaPrueba", "0", "1", "2020", "123");

        assertEquals ( "EstaPrueba", tarjeta.getCardHolder() );
    }

}