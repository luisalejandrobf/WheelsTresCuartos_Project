package com.example.proyectowheels.Model;

import lombok.*;

@Getter
@Setter
/**
 * Clase que representa un carro
 */
public class Carro {

    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private long ano;

    /**
     * Constructor de la clase Carro
     * @param placa
     * @param marca
     * @param modelo
     * @param color
     * @param ano
     */
    public Carro(String placa, String marca, String modelo, String color, long ano) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.ano = ano;
    }

    /**
     * Pasa la información del carro a un String
     * @return String con la información del carro
     */
    @Override
    public String toString() {
        return  placa +
                "," + marca +
                "," + modelo +
                "," + color +
                "," + ano;
    }
}
