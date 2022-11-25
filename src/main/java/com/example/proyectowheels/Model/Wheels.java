package com.example.proyectowheels.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
/**
 * Clase que representa a la aplicacion de viajes de la empresa Wheels y que contiene la lista de viajes
 */
public class Wheels {

    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    /**
     * Constructor de la clase Wheels
     */
    public Wheels() {usuarios = new ArrayList<Usuario>();}

    /**
     * Agrega un usuario a la lista de usuarios
     * @param usuario Usuario a agregar
     */
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Valida si un usuario ya existe en la lista de usuarios a partir de su correo
     * @param correo
     * @return true si el usuario existe, false si no existe
     */
    public boolean validarUsuario(String correo){
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getCorreo().equals(correo)){
                return false;
            }
        }
        return true;
    }

    /**
     * Valida si la placa de un carro ya existe en la lista de carros de un usuario a partir de su placa
     * @param placa
     * @return Carro si el carro existe, null si no existe
     */
    public Carro validarPlaca(String placa){
        for(int i = 0; i < usuarios.size(); i++){
            for(int j = 0; j < usuarios.get(i).getCarros().size(); j++){
                if(usuarios.get(i).getCarros().get(j).getPlaca().equals(placa)){
                    return usuarios.get(i).getCarros().get(j) ;
                }
            }
        }
        return null;
    }

    /**
     * Muestra la información de todos los usuarios
     */
    public void mostrarInfoUsuarios () {

        if (usuarios.size()==0)
            System.out.println("No hay usuarios para mostrar\n");


        for (int i = 0; i<usuarios.size(); i++){
            System.out.println("\n" + usuarios.get(i).toString());

            if (usuarios.get(i).getCarros().size() != 0){
                for (int j = 0; j<usuarios.get(i).getCarros().size(); j++) {
                    System.out.println("Carro " + j + " de: " + usuarios.get(i).getNombres() + "... " + usuarios.get(i).getCarros().get(j).toString());
                }
            }

            else {
                System.out.println(usuarios.get(i).getNombres() + " No tiene carros");
            }
        }
    }

    /**
     * Valida el inicio de sesión de un usuario
     * @param correo
     * @param contrasena
     * @return true si el usuario existe, false si no existe
     */
    public boolean validarInicioSesion (String correo, String contrasena){
        boolean sesionIniciada = false;

        for (int i = 0; i < usuarios.size(); i++){
            // Primera verificacion. Existe el correo
            if (usuarios.get(i).getCorreo().equals(correo))
            {
                if (usuarios.get(i).getContrasena().equals(contrasena))
                {
                    sesionIniciada = true;
                }
            }
        }
        return sesionIniciada;
    }

    /**
     * Edita la información de un conductor
     * @param correo
     * @param conductor
     */
    public void editarConductor(String correo, boolean conductor) {
        boolean found = false;

        for (int i = 0; i < usuarios.size(); i++){
            // Primera verificacion. Existe el correo
            if (usuarios.get(i).getCorreo().equals(correo))
            {
                found = true;
                System.out.println("\n/Se realizo exitosamente el cambio.");
                usuarios.get(i).setConductor(conductor);
                if(!conductor)
                    usuarios.get(i).setCarros(null);
            }
        }

        if (found == false)
            System.out.println("\n/No se pudo realizar el cambio. No se encontro un usuario registrado con el correo proporcionado");
    }

    /**
     * Edita el nombre de un usuario
     * @param correo
     * @param nombres
     */
    public void editarNombres(String correo, String nombres) {
        boolean found = false;

        for (int i = 0; i < usuarios.size(); i++){
            // Primera verificacion. Existe el correo
            if (usuarios.get(i).getCorreo().equals(correo))
            {
                found = true;
                System.out.println("\n/Se realizo exitosamente el cambio.");
                usuarios.get(i).setNombres(nombres);
            }
        }

        if (found == false)
            System.out.println("\n/No se pudo realizar el cambio. No se encontro un usuario registrado con el correo proporcionado");
    }

    /**
     * Edita el apellido de un usuario
     * @param correo
     * @param apellidos
     */
    public void editarApellidos(String correo, String apellidos) {
        boolean found = false;

        for (int i = 0; i < usuarios.size(); i++){
            // Primera verificacion. Existe el correo
            if (usuarios.get(i).getCorreo().equals(correo))
            {
                found = true;
                System.out.println("\n/Se realizo exitosamente el cambio.");
                usuarios.get(i).setApellidos(apellidos);
            }
        }

        if (found == false)
            System.out.println("\n/No se pudo realizar el cambio. No se encontro un usuario registrado con el correo proporcionado");
    }

    /**
     * Edita el correo de un usuario
     * @param correo
     * @param contrasena
     */
    public void editarCorreo(String correo, String correoEditar) {
        boolean found = false;

        for (int i = 0; i < usuarios.size(); i++){
            // Primera verificacion. Existe el correo
            if (usuarios.get(i).getCorreo().equals(correo))
            {
                found = true;
                System.out.println("\n/Se realizo exitosamente el cambio.");
                usuarios.get(i).setCorreo(correoEditar);
            }
        }

        if (found == false)
            System.out.println("\n/No se pudo realizar el cambio. No se encontro un usuario registrado con el correo proporcionado");
    }

    /**
     * Edita la contraseña de un usuario
     * @param correo
     * @param contrasena
     */
    public void editarContrasena(String correo, String contrasena) {
        boolean found = false;

        for (int i = 0; i < usuarios.size(); i++){
            // Primera verificacion. Existe el correo
            if (usuarios.get(i).getCorreo().equals(correo))
            {
                found = true;
                System.out.println("\n/Se realizo exitosamente el cambio.");
                usuarios.get(i).setContrasena(contrasena);
            }
        }

        if (found == false)
            System.out.println("\n/No se pudo realizar el cambio. No se encontro un usuario registrado con el correo proporcionado");
    }

    /**
     * Edita el numero de telefono de un usuario
     * @param correo
     * @param celular
     */
    public void editarCelular(String correo, long celular) {
        boolean found = false;

        for (int i = 0; i < usuarios.size(); i++){
            // Primera verificacion. Existe el correo
            if (usuarios.get(i).getCorreo().equals(correo))
            {
                found = true;
                System.out.println("\n/Se realizo exitosamente el cambio.");
                usuarios.get(i).setCelular(celular);
            }
        }

        if (found == false)
            System.out.println("\n/No se pudo realizar el cambio. No se encontro un usuario registrado con el correo proporcionado");
    }

    /**
     * Edita la informacion de un carro
     * @param correo
     * @param carros
     */
    public void editarCarros(String correo, ArrayList<Carro> carros) {
        boolean found = false;

        for (int i = 0; i < usuarios.size(); i++){
            // Primera verificacion. Existe el correo
            if (usuarios.get(i).getCorreo().equals(correo))
            {
                found = true;
                System.out.println("\n/Se realizo exitosamente el cambio.");
                usuarios.get(i).setCarros(carros);
            }
        }

        if (found == false)
            System.out.println("\n/No se pudo realizar el cambio. No se encontro un usuario registrado con el correo proporcionado");
    }

    // Getters y setters
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


}
