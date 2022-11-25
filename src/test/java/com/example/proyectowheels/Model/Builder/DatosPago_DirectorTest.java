package com.example.proyectowheels.Model.Builder;

import com.example.proyectowheels.Model.Tarjeta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatosPago_DirectorTest {

    @Test
    public void PruebaDirector()
    {
        Tarjeta tarjeta = new Tarjeta('C', "EstaPrueba", "0", "1", "2020", "123");
        DatosPago_Director datosPago_Director = new DatosPago_Director('C', "EstaPrueba", "0", "1", "2020", "123");
        TarjetaBuilder tarjetaBuilder = new TarjetaBuilder();
        datosPago_Director.construirTarjeta(tarjetaBuilder);

        assertEquals ( tarjeta.toString(), tarjetaBuilder.getProduct().toString() );
    }

}