package com.example.proyectowheels.Model.Decorador;

import com.example.proyectowheels.Model.Algoritmos.PorDestino;
import com.example.proyectowheels.Model.CalificacionConductor;
import com.example.proyectowheels.Model.Interfaces.AlgoritmoBuscarMostrar;
import com.example.proyectowheels.Model.Viaje;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalConductorDecoratorTest {

    @Test
    public void PruebaFiltrado()
    {
        AlgoritmoBuscarMostrar algoritmo = new PorDestino();
        CalConductorDecorator calConductorDecorator = new CalConductorDecorator(algoritmo);
        ArrayList<Viaje> viajes =  new ArrayList<Viaje>();

        assertEquals ( 0, calConductorDecorator.buscar("",viajes).size() );
    }

}