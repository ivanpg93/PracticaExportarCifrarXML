/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Enric
 */
public class ExportarStringBuilder {
    public static void exportar(StringBuilder mensaje, String ruta){
        try {
            File archivo = new File(ruta);
            FileWriter fw = new FileWriter(archivo);
            String mensajeDesglosado;
            for (int i = 0; i < mensaje.length(); i++) {
                mensajeDesglosado = mensaje.substring(i, i+1);
                fw.write(mensajeDesglosado);
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el archivo en la ruta " + ruta);
        }
    }
}