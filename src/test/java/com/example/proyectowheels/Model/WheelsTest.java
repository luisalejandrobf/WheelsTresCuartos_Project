package com.example.proyectowheels.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WheelsTest {

    @Test
    public void PruebaArraylist()
    {
        Wheels wheels = new Wheels();
        Usuario usuario = new Usuario(false, "Nombre1 Nombre2", "Apellido1 Apellido2", "Prueba@gmail.com", "123", 123, null, null);
        wheels.agregarUsuario(usuario);

        assertEquals ( usuario.toString(), wheels.getUsuarios().get(0).toString() );
    }

}