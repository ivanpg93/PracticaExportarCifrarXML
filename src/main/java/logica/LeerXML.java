/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Enric
 */
public class LeerXML {
    
    public static StringBuilder leerXml(String ruta) {
        
        StringBuilder contenido = new StringBuilder();
        try {
            File archivo = new File(ruta);
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }
}
