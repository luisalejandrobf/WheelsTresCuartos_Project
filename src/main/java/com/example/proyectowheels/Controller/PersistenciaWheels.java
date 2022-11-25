package com.example.proyectowheels.Controller;

import com.example.proyectowheels.Model.*;
import com.example.proyectowheels.Model.Command.CargarViajes;
import com.example.proyectowheels.Model.Command.CrearViaje;
import com.example.proyectowheels.Model.Command.GestorMetodos;
import lombok.NoArgsConstructor;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
@NoArgsConstructor
/**
 * Clase que se encarga de la persistencia de los datos.
 */
public class PersistenciaWheels {

    /**
     * Función que se encarga de guardar los datos de los usuarios en un archivo de texto
     * @param wheels
     * @throws IOException
     */
    public void EscribirArchivo (Wheels wheels) throws IOException {
        // Escribir al archivo txt.

        //SOBREESCRITURA?
        // Se pone el nombre del archivo y ,true, para deshabilitar la SOBREESCRITURA. En este caso se sobreescribe, ya que el archivo se escribe cuando ya se ha leido previamente,
        // permitiendo que no se dupliquen los datos. tras cada ejecucion.

        try (FileWriter fw = new FileWriter("Wheels_Usuarios.txt");
             BufferedWriter salida = new BufferedWriter(fw);) {

            for (int i = 0; i < wheels.getUsuarios().size(); i++)
            {
                salida.write(wheels.getUsuarios().get(i).toString());
                salida.newLine();
            }

            System.out.println("\n\\ Archivo de Usuarios Escrito Exitosamente");
            CarroArchivoEscribir(wheels);

        } catch (IOException ex){
            System.err.println("Hubo un error al escribir el archivo de Usuarios >> " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    /**
     * Función que se encarga de guardar los datos de los carros en un archivo de texto
     * @param wheels
     * @throws IOException
     */
    public void CarroArchivoEscribir (Wheels wheels) throws IOException {
        // Escribir al archivo txt.

        //SOBREESCRITURA?
        // Se pone el nombre del archivo y ,true, para deshabilitar la SOBREESCRITURA. En este caso se sobreescribe, ya que el archivo se escribe cuando ya se ha leido previamente,
        // permitiendo que no se dupliquen los datos. tras cada ejecucion.

        try (FileWriter fw = new FileWriter("Wheels_Carros.txt");
             BufferedWriter salida = new BufferedWriter(fw);) {
            for (int i = 0; i < wheels.getUsuarios().size(); i++)
            {
                if(wheels.getUsuarios().get(i).getCarros() != null){
                    for (int j = 0; j < wheels.getUsuarios().get(i).getCarros().size(); j++)
                    {
                        salida.write(wheels.getUsuarios().get(i).getCorreo() + "," + wheels.getUsuarios().get(i).getCarros().get(j).toString());
                        salida.newLine();
                    }
                }
            }

            System.out.println("\n\\ Archivo de Carros Escrito Exitosamente\n");

        } catch (IOException ex){
            System.err.println("Hubo un error al escribir el archivo de carros >> " + ex.getMessage());
            ex.printStackTrace();
        }

    }


    /**
     * Función que se encarga de leer los datos de los usuarios de un archivo de texto
     * @param wheels
     */
    public void LeerArchivo (Wheels wheels){
        // Leer el archivo txt

        try (FileReader fr = new FileReader("Wheels_Usuarios.txt");
             BufferedReader entrada = new BufferedReader(fr)){

            // Se crean campos/variables auxiliares para guardar valores.

            // Para Usuario
            String inLine = "";
            long cel = 0;
            long numCarros = 0;
            boolean Conductor = false;
            String[] campo = {""};
            ArrayList<String> ListaCampos = new ArrayList<String>();

            // Para carro
            long ano = 0;

            System.out.println("Archivo usuarios:");

            while ((inLine = entrada.readLine()) != null){

                ListaCampos.clear();
                System.out.println(inLine);

                // Se parte la linea en cadenas.
                //campo = inLine.split(",");
                campo = inLine.split("[,]", 0);


                for (int i =0; i<campo.length; i++) {
                    ListaCampos.add(campo[i]);
                }



                //System.out.println(" #Tam" + ":" + ListaCampos.get(4));

                // Se hace el casting de datos, y la la respectiva instanciacion haciendo uso de los constructores.
                Conductor = Boolean.parseBoolean(ListaCampos.get(0));
                cel = Long.parseLong(ListaCampos.get(5));

                Usuario usuarioAux = new Usuario(Conductor, ListaCampos.get(1), ListaCampos.get(2), ListaCampos.get(3), ListaCampos.get(4), cel , null, null);
                wheels.agregarUsuario(usuarioAux); // Se añade al wheels, el usuario.
            }

            CarroArchivoLeer(wheels);
            System.out.println("\n\n\\ Archivos de Wheels Leidos. Informacion escrita.\n");

        }   catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Función que se encarga de leer los datos de los carros de un archivo de texto
     * @param wheels
     */
    public void CarroArchivoLeer (Wheels wheels){
        // Leer el archivo txt

        try (FileReader fr = new FileReader("Wheels_Carros.txt");
             BufferedReader entrada = new BufferedReader(fr)){

            // Se crean campos/variables auxiliares para guardar valores.

            String inLine = "";
            String[] campo = {""};

            // Para carro
            long ano = 0;
            String correoDueno = "";

            System.out.println("\nArchivo carros:");

            while ((inLine = entrada.readLine()) != null){
                campo = inLine.split("[,]", 0);

                System.out.println(inLine);
                correoDueno = campo[0];
                ano = Long.parseLong(campo[5]);
                Carro carroAux = new Carro(campo[1], campo[2], campo[3], campo[4], ano);

                for (int i = 0; i<wheels.getUsuarios().size(); i++)
                {
                    if (wheels.getUsuarios().get(i).getCorreo().compareTo(correoDueno) == 0)
                    {
                        //System.out.println("Se encontro un carro de " + wheels.getUsuarios().get(i).getCorreo() + "\n");
                        wheels.getUsuarios().get(i).agregarCarro(carroAux);
                    }
                }

            }

        }   catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}

