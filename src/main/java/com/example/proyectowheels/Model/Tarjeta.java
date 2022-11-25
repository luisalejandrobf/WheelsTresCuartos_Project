package com.example.proyectowheels.Model;

/* Se implementa el patron builder. En este caso, solo se utiliza para construir tarjetas,
Pero cumple el principio open/closed. Abierto para modificacion (Posibles nuevos metodos de pago) y cerrado para modificacion.*/

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
/**
 * La clase se encarga de almacenar la informacion de la tarjeta asociada a un cliente/conductor.
 * Hace parte de la implementacion del patron builder.
 */
public class Tarjeta {

    private char tipo;
    private String CardHolder;
    private String CardNumber;
    private String MM;
    private String YY;
    private String CVC_CCV;

    /**
     * Metodo para la construccion de tarjetas, pasando los parametros correspondientes.
     *
     * @param tipo
     * @param cardHolder
     * @param cardNumber
     * @param MM
     * @param YY
     * @param CVC_CCV
     */
    public Tarjeta(char tipo, String cardHolder, String cardNumber, String MM, String YY, String CVC_CCV) {
        this.tipo = tipo;
        CardHolder = cardHolder;
        CardNumber = cardNumber;
        this.MM = MM;
        this.YY = YY;
        this.CVC_CCV = CVC_CCV;
    }

    /**
     * Retorna la informacion del objeto tarjeta en un String.
     * @return String con la informacion de la tarjeta.
     */
    @Override
    public String toString() {
        return "Tarjeta{" +
                "tipo=" + tipo +
                ", CardHolder='" + CardHolder + '\'' +
                ", CardNumber='" + CardNumber + '\'' +
                ", MM='" + MM + '\'' +
                ", YY='" + YY + '\'' +
                ", CVC_CCV='" + CVC_CCV + '\'' +
                '}';
    }
}
