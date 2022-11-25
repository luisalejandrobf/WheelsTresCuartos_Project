package com.example.proyectowheels.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
/**
 * Clase que representa un usuario
 */
@Getter
@Setter
public class Usuario {

    private boolean conductor;
    private String nombres;
    private  String apellidos;
    private  String correo;
    private  String contrasena;
    private long celular;
    private ArrayList<Carro> carros;
    private Tarjeta datosPago;

    // Constructor. Si no hay un carro, ponerlo en NULL.

    /**
     * Constructor de la clase Usuario
     * @param conductor
     * @param nombres
     * @param apellidos
     * @param correo
     * @param contrasena
     * @param celular
     * @param carros
     * @param datosPago
     */
    public Usuario(boolean conductor, String nombres, String apellidos, String correo, String contrasena, long celular, ArrayList<Carro> carros, Tarjeta datosPago) {
        this.conductor = conductor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.celular = celular;
        this.carros = carros;
        this.datosPago = datosPago;

        if (carros == null) {
            this.carros = new ArrayList<Carro>();
        }

        else {
            this.carros = carros;
        }
    }


    // Constructor con todo en vacio-nulo.
    public Usuario() {
        this.conductor = false;
        this.nombres = null;
        this.apellidos = null;
        this.correo = null;
        this.contrasena = null;
        this.celular = 0;
        this.carros = new ArrayList<Carro>();
        this.datosPago = null;
    }


    /**
     * Pasa la información del usuario a un String
     * @return String con la información del usuario
     */
    // Metodo toString para escribir archivo.
    @Override
    public String toString() {
        return  conductor +
                "," + nombres +
                "," + apellidos +
                "," + correo +
                "," + contrasena +
                "," + celular;
    }

    /**
     * Agrega un carro al usuario
     * @param carro
     * @return void
     */
    public void agregarCarro(Carro carro) {
        carros.add(carro);

    }

}

