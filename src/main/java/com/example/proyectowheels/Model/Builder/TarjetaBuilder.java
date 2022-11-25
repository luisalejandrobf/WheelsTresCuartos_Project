package com.example.proyectowheels.Model.Builder;

import com.example.proyectowheels.Model.Interfaces.DatosPago_Builder;
import com.example.proyectowheels.Model.Tarjeta;

/**
 * La clase se encarga de segmentar los distintos pasos para la construccion de una tarjeta, de modo que el Director pueda hacer uso de los mismos.
 * Esto permite que mas adelante se puedan implementar diferentes metodos de pago, cada uno con su builder dedicado, a disposicion del director.
 */

public class TarjetaBuilder implements DatosPago_Builder {

    Tarjeta tarjeta = null;

    // Se implementan los metodos definidos en la interfaz.

    /**
     * Metodo para la resetear la tarjeta. Se encarga de borrar datos si habian anteriormente, reemplazando la instancia de tarjeta con una totalmente vacia.
     */

    public void reset(){
        this.tarjeta = new Tarjeta();
    }

    /**
     * Setter de tipo.
     * @param Tipo
     */
    public void setTipo(char Tipo){
        this.tarjeta.setTipo(Tipo);
    }

    /**
     * Setter de CardHolder.
     * @param CardHolder
     */

    public void setCardHolder(String CardHolder){
        this.tarjeta.setCardHolder(CardHolder);
    }

    /**
     * Setter de CardNumber.
     *  @param CardNumber
     */

    public void setCardCardNumber(String CardNumber){
        this.tarjeta.setCardNumber(CardNumber);
    }

    /**
     * Setter de mes de expedicion.
     * @param MM
     */

    public void setCardCardMM(String MM){
        this.tarjeta.setMM(MM);
    }

    /**
     * Setter de ano de expedicion.
     * @param YY
     */

    public void setCardCardYY(String YY){
        this.tarjeta.setYY(YY);
    }

    /**
     * Setter de CCV/CVC.
     * @param CVC_CCV
     */
    public void setCardCardCVC_CCV(String CVC_CCV){
        this.tarjeta.setCVC_CCV(CVC_CCV);
    }

    /**
     * Metodo para obtener el producto. Se encarga de retornar la tarjeta creada mediante los pasos anteriormente vistos.
     * @return  Tarjeta
     */
    public Tarjeta getProduct(){
        return this.tarjeta;
    }

}
