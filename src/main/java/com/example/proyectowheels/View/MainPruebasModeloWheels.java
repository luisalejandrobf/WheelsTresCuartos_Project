package com.example.proyectowheels.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.proyectowheels.Controller.PersistenciaWheels;
import com.example.proyectowheels.Model.*;

/**
 * Metodo de pruebas basicas de las clases de logica de la aplicacion
 */

public class MainPruebasModeloWheels {


    public static void main(String[] args) throws IOException {

        // CREACION DE OBJETOS

        // Se crea un wheels nuevo. (GENERAL, contiene lo demas)
        Wheels wheels = new Wheels ();

        // Se crea un usuario auxiliar
        Usuario usuarioAux;
        usuarioAux = new Usuario(true, "Pepito", "Perez", "PepitoPerez123@gmail.com", "123", 123456789 , null, null);

        // Se crea un carro que pertenece al usuarioAux.
        Carro carro = new Carro("ABC123", "Chevrolet", "Sail", "Azul", 2000);
        usuarioAux.agregarCarro(carro);

        // Se anade el usuario al wheels
        wheels.agregarUsuario(usuarioAux);


        // Se crean mas usuariosy carros, para validar que funciona de la manera correcta.
        Usuario usuarioAux2;
        usuarioAux2 = new Usuario(true, "Pepita", "Pancho", "PepitaPancho123@gmail.com", "123", 1231231231 , null, null);
        Usuario usuarioAux3;
        usuarioAux3 = new Usuario(true, "Sancho", "Panza", "SanchoPanza123@gmail.com", "123", 1412412 , null, null);
        Carro carro2 = new Carro("ABC523", "Chevrolet", "Sail", "Blanco", 2000);
        Carro carro3 = new Carro("ABC852", "Chevrolet", "Sail", "Rojo", 2000);
        usuarioAux2.agregarCarro(carro2);
        usuarioAux2.agregarCarro(carro3);
        // Se anaden al sistema.
        wheels.agregarUsuario(usuarioAux2);
        wheels.agregarUsuario(usuarioAux3);

        // Pruebas...
        System.out.println("Pruebas del modelo -> Wheels");
        // Mostrar informacion de los usuarios
        wheels.mostrarInfoUsuarios();

        // PARA INICIO DE SESION
        // Pruebas de inicio de sesion. Retorna un boolean, usarlo para el JavaFX.
        wheels.validarInicioSesion("SanchoPanza123@gmail.com", "123");
        wheels.validarInicioSesion("NODEBERIAFUNCIONAR@gmail.com", "123");

        // PARA EDITAR INFORMACION
        // Editar informacion de un usuario.
        wheels.editarNombres("PepitoPerez123@gmail.com", "Pepote");
        wheels.editarApellidos("PepitoPerez123@gmail.com", "CambioDeNombre");
        wheels.editarConductor("PepitoPerez123@gmail.com", false);
        wheels.editarContrasena("PepitoPerez123@gmail.com", "CambioExitoso!");
        wheels.editarCelular("PepitoPerez123@gmail.com", 12341412);
        wheels.editarCorreo("PepitoPerez123@gmail.com", "CambioElCorreoDePepitoPerez@gmail.com");

        // Verificar que se edito correctamente.
        for (int i = 0; i < wheels.getUsuarios().size(); i++){
            // Primera verificacion. Existe el correo
            if (wheels.getUsuarios().get(i).getCorreo() == "CambioElCorreoDePepitoPerez@gmail.com")
            {
                System.out.println("\nInformacion Editada >> "+ wheels.getUsuarios().get(i).toString());
            }
        }

        PersistenciaWheels persistenciaWheels = new PersistenciaWheels();
        persistenciaWheels.EscribirArchivo(wheels);


        wheels = new Wheels();
        System.out.println("\nSe pone en nulo el Wheels para revisar...");
        wheels.mostrarInfoUsuarios();

        System.out.println("Se realiza el cargue de archivos");
        persistenciaWheels.LeerArchivo(wheels);

        System.out.println("\nInfo despues de cargar el archivo...");
        wheels.mostrarInfoUsuarios();


    }

}
