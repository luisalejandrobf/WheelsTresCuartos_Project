package com.example.proyectowheels.Model.Factory;

import com.example.proyectowheels.Model.Interfaces.AlgoritmoBuscarMostrar;

/**
 * Clase que se encarga de crear un algoritmo de búsqueda y mostrar.
 */
public class FabricaAlgoritmoBuscarMostrar {

    /**
     * Metodo que crea un algoritmo de búsqueda y mostrar
     * @param tipo
     * @return  Objeto de tipo AlgoritmoBuscarMostrar
     */
    public static AlgoritmoBuscarMostrar crearAlgoritmoBuscarMostrar(String tipo)  {
        try {
            String path = "com.example.proyectowheels.Model.Algoritmos." + tipo;
            Class cls = Class.forName(path);
            return (AlgoritmoBuscarMostrar) cls.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
