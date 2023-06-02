/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ivan
 */
public class Exportar {
    
    /**
     * EXPORTA UN INFORME 
     * @param informe String con los datos del informe generado en la Clase Informe
     * @param ruta String con la ruta solicitada al usuario que define donde se guardará el informe
     * @return boolean para saber si se ha podido guardar el informe
     * @throws IOException 
     */
    public static boolean exportarInforme(String informe, String ruta) throws IOException {
        boolean bol;
        try {
            File archivo = new File(ruta);
            FileWriter fw = new FileWriter(archivo);
            fw.write(informe);
            fw.close();
            bol = true;
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el archivo en la ruta: " + ruta + "\n");
            bol = false;
        }
        return bol;
    }

}
