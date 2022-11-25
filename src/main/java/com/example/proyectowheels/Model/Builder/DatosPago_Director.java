package com.example.proyectowheels.Model.Builder;

import com.example.proyectowheels.Model.Interfaces.DatosPago_Builder;

/**
 * La clase Director se encarga de hacer uso de la clase Builder. Esto permite segmentar la construccion por pasos.
 * Por la misma razon, esto permite en un futuro agregar diferentes metodos de pago y que el mismo director se encarga de llamar la construccion de los mismos. *
 */

public class DatosPago_Director {

    private char Campotipo;
    private String CampoCardHolder;
    private String CampoCardNumber;
    private String CampoMM;
    private String CampoYY;
    private String CampoCVC_CCV;

    /**
     * Metodo para la construccion del Director, con el uso de parametros.
     *
     * @param campotipo
     * @param campoCardHolder
     * @param campoCardNumber
     * @param campoMM
     * @param campoYY
     * @param campoCVC_CCV
     */

    public DatosPago_Director(char campotipo, String campoCardHolder, String campoCardNumber, String campoMM, String campoYY, String campoCVC_CCV) {
        Campotipo = campotipo;
        CampoCardHolder = campoCardHolder;
        CampoCardNumber = campoCardNumber;
        CampoMM = campoMM;
        CampoYY = campoYY;
        CampoCVC_CCV = campoCVC_CCV;
    }

    /**
     * Metodo para la construccion de tarjetas, haciendo uso de la clase builder que corresponde a tarjetas.
     * @param datosPago_Builder
     */
    public DatosPago_Director() {
    }

    /**
     * Metodo para la construccion de tarjetas, haciendo uso de la clase builder que corresponde a tarjetas.
     * @param datosPago_Builder
     */

    public void construirTarjeta(DatosPago_Builder datosPago_Builder) {
        datosPago_Builder.reset();
        datosPago_Builder.setTipo(Campotipo);
        datosPago_Builder.setCardHolder(CampoCardHolder);
        datosPago_Builder.setCardCardNumber(CampoCardNumber);
        datosPago_Builder.setCardCardMM(CampoMM);
        datosPago_Builder.setCardCardYY(CampoYY);
        datosPago_Builder.setCardCardCVC_CCV(CampoCVC_CCV);
    }

}
