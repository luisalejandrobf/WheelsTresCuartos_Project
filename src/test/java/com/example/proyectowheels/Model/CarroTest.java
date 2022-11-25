package com.example.proyectowheels.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarroTest {
    @Test
    public void PruebaConstructor()
    {
        Carro carro = new Carro("ABC123", "Audi", "A5", "Azul", 2020);

        assertEquals ( "ABC123,Audi,A5,Azul,2020", carro.toString());
    }

}