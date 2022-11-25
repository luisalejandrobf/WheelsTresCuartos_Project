package com.example.proyectowheels.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    @Test
    public void PruebaConstructor()
    {
        Usuario usuario = new Usuario(false, "Nombre1 Nombre2", "Apellido1 Apellido2", "Prueba@gmail.com", "123", 123, null, null);

        assertEquals ( "false,Nombre1 Nombre2,Apellido1 Apellido2,Prueba@gmail.com,123,123", usuario.toString());
    }

}