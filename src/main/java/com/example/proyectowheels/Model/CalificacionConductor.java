package com.example.proyectowheels.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

/**
 * Clase que representa la calificación de un conductor por parte de un pasajero en un viaje y que extiende de la clase Viaje
 */
public class CalificacionConductor extends Viaje {
  private String puntuacion ;
  private String observacion;

}
