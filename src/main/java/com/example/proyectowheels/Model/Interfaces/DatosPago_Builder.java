package com.example.proyectowheels.Model.Interfaces;

/* Se implementa el patron builder. En este caso, solo se utiliza para construir tarjetas,
Pero cumple el principio open/closed. Abierto para modificacion (Posibles nuevos metodos de pago) y cerrado para modificacion.*/

import com.example.proyectowheels.Model.Tarjeta;

/**
 * Interface que contiene los metodos para la construccion de tarjetas. Hace parte de la implementacion del patron builder.
 */
public interface DatosPago_Builder {

    Tarjeta tarjeta = null;

    // Los metodos de las interfaces son vacios...

    public default void reset(){
    }

    public default void setTipo(char Tipo){
    }

    public default void setCardHolder(String CardHolder){
    }

    public default void setCardCardNumber(String CardNumber){
    }

    public default void setCardCardMM(String MM){
    }

    public default void setCardCardYY(String YY){
    }

    public default void setCardCardCVC_CCV(String CVC_CCV){
    }

    public default Tarjeta getProduct(){
        return null;
    }

}
