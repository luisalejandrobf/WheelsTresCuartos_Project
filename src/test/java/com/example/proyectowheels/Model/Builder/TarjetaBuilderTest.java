package com.example.proyectowheels.Model.Builder;

import com.example.proyectowheels.Model.Tarjeta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TarjetaBuilderTest {

    @Test
    public void PruebaProducto()
    {
        Tarjeta tarjeta = new Tarjeta('C', "EstaPrueba", "0", "1", "2020", "123");
        TarjetaBuilder tarjetaBuilder = new TarjetaBuilder();
        tarjetaBuilder.reset();
        tarjetaBuilder.setTipo('C');
        tarjetaBuilder.setCardCardMM("1");
        tarjetaBuilder.setCardHolder("EstaPrueba");
        tarjetaBuilder.setCardCardCVC_CCV("123");
        tarjetaBuilder.setCardCardYY("2020");
        tarjetaBuilder.setCardCardNumber("0");

        assertEquals ( tarjeta.toString(), tarjetaBuilder.getProduct().toString() );
    }

}