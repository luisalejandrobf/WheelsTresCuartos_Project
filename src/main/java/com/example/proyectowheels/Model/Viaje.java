package com.example.proyectowheels.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/**
 * Clase que representa un viaje
 */
public class Viaje {
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private String conductor;
    private String placa;
    private double tarifa;
    private String destino;
    private String zona;
    private String mensaje;

    /**
     * Constructor de la clase Viaje sin mensaje
     * @param fechaSeleccionada
     * @param horaSal
     * @param nombres
     * @param placa
     * @param tarifa
     * @param destino
     * @param zona
     */
    public Viaje(LocalDate fechaSeleccionada, LocalTime horaSal, String nombres, String placa, double tarifa, String destino, String zona) {
        this.fechaSalida = fechaSeleccionada;
        this.horaSalida = horaSal;
        this.conductor = nombres;
        this.placa = placa;
        this.tarifa = tarifa;
        this.destino = destino;
        this.zona = zona;
    }


    /**
     * Pasa la información del viaje a un String
     * @return String con la información del viaje
     */
    @Override
    public String toString(){
        return this.mensaje;
    }

    /**
     * Genera la linea que se escribira en el archivo con el formato de la clase
     * @return String con la información del viaje
     *
     */
    public String formatearEscritura(){
        return fechaSalida + "," + horaSalida + "," + conductor + "," + placa + "," + tarifa + "," + destino + "," + zona;
    }

    /**
     * Metodo para la comparación de objetos tipo viaje
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Viaje viaje = (Viaje) o;
        return Double.compare(viaje.tarifa, tarifa) == 0 && Objects.equals(fechaSalida, viaje.fechaSalida) && Objects.equals(horaSalida, viaje.horaSalida) && Objects.equals(conductor, viaje.conductor) && Objects.equals(placa, viaje.placa) && Objects.equals(destino, viaje.destino) && Objects.equals(zona, viaje.zona) && Objects.equals(mensaje, viaje.mensaje);
    }


    @Override
    public int hashCode() {
        return Objects.hash(fechaSalida, horaSalida, conductor, placa, tarifa, destino, zona, mensaje);
    }
}