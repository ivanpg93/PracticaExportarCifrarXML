/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import static datos.Exportar.exportarInforme;
import java.io.IOException;
import logica.LeerXML;
import datos.ExportarStringBuilder;

/**
 *
 * @author Enric
 */
public class CifrarDescifrar {
    
    /**
    * Cifra un mensaje desde un archivo XML
    * @param clau La clave utilizada para cifrar el mensaje
    * @param ruta La ruta al archivo XML que contiene el mensaje
    * @throws IOException
    */
    public static void cifrar(String clau, String ruta, String rutaNueva) throws IOException
    {
        StringBuilder missatge = LeerXML.leerXml(ruta);
        //He de importar el missatge    
        //Dividim entre 94 perque son els caràcters possibles.
        StringBuilder primeraPart = new StringBuilder("");
        StringBuilder segonaPart = new StringBuilder("");
        int multiplicador = (int) clau.charAt(0);
        int restador = (int) clau.charAt(1);
        String restaClau = "";
        for (int i = 2; i < clau.length(); i++) {
            restaClau += clau.charAt(i);
        }
        
        
        for (int i = 0; i < missatge.length(); i++) {
            primeraPart.append((char)(((missatge.charAt(i)*multiplicador)-restador)/94));
            segonaPart.append((char)((((missatge.charAt(i)*multiplicador)-restador)%94)+33));
        }
        StringBuilder juntarParts = new StringBuilder();
        juntarParts = primeraPart.append(segonaPart);
        juntarParts.append(restaClau);
        ExportarStringBuilder.exportar(juntarParts, rutaNueva);
    }

    /**
    * Comprueba si una clave es válida
    * @param clau La clave a ser comprobada
    * @return Un booleano que indica si la clave es válida o no
    */
    public static boolean comprovarClau(String clau){
        if(clau.length()<2)
            return false;
        for (int i = 0; i < clau.length(); i++) {
            if(clau.charAt(i)<(char)33 || clau.charAt(i)>(char)126)
            {
                return false;
            }
        }
        return true;
    }
    /**
     * Descifra un mensaje desde un archivo XML
     * @param clau La clave utilizada para descifrar el mensaje
     * @param ruta La ruta al archivo XML que contiene el mensaje cifrado
     * @param rutaNueva
     */
    public static void descifrar(String clau, String ruta, String rutaNueva)
    {
        StringBuilder missatge = LeerXML.leerXml(ruta);
        
        StringBuilder primeraPart = new StringBuilder("");
        StringBuilder segonaPart = new StringBuilder();
        int multiplicador = (int) clau.charAt(0);
        int restador = (int) clau.charAt(1);
        String restaClau = "";
        for (int i = 2; i < clau.length(); i++) {
            restaClau += clau.charAt(i);
        }
        int longitud = missatge.length() / 2;

        primeraPart.append(missatge.substring(0, longitud));
        segonaPart.append(missatge.substring(longitud));

        StringBuilder resultado = new StringBuilder("");
        if(restaClau.equals(missatge.substring(missatge.length()-restaClau.length(), missatge.length()))){
        for (int i = 0; i < longitud; i++) {
            int numero = (primeraPart.charAt(i) * 94 + segonaPart.charAt(i) - 33 + restador) / multiplicador;
            resultado.append((char)numero);
        }
        }
        ExportarStringBuilder.exportar(resultado, rutaNueva);
    }
}
