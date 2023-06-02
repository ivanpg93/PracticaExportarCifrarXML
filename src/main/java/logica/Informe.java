/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dao.Curso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author ivan
 */
public class Informe {
    
    /**
     * OBTIENE LAS PLAZAS OFERTADAS EN CADA PAÍS DE DESTINO
     * @return String con los datos del informe
     */
    public static String informePais() {

        HashMap<String, Integer> informe = new HashMap<>();
        int contador;
        String res;

        for (Curso c : Datos.getListaSingleton()) {
            if (!informe.isEmpty()) {
                if (!informe.containsKey(c.getPais())) {
                    contador = 0 + c.getPlazasOfertadas();
                    informe.put(c.getPais(), contador);
                } else {
                    contador = informe.get(c.getPais());
                    contador += c.getPlazasOfertadas();
                    informe.replace(c.getPais(), contador);
                }
            } else {
                informe.put(c.getPais(), c.getPlazasOfertadas());
            }
        }

        res = "PLAZAS OFERTADAS SEGÚN EL PAÍS: \n" + informe.toString();
        
        System.out.println(res + "\n");

        return res;

    }

    /**
     * CALCULA LA MEDIA DE LAS PLAZAS OFERTADAS ENTRE TODOS LOS CURSOS
     * @return String con los datos del informe
     */
    public static String promedioPlazasOfertadas() {

        double totalPlazas = 0, contadorPlazas = 0;
        double mediaPlazas;
        String res;

        for (Curso c : Datos.getListaSingleton()) {
            totalPlazas += c.getPlazasOfertadas();
            contadorPlazas++;
        }

        mediaPlazas = totalPlazas / contadorPlazas;
        res = Double.toString(mediaPlazas);

        res = ("La media de plazas ofertadas es de " + res);
        
        System.out.println(res + "\n");

        return res;
    }

    /**
     * OBTIENE EL IDIOMA MÁS SOLICITADO ENTRE TODOS LOS CURSOS
     * @return String con los datos del informe
     */
    public static String topIdioma() {

        String topIdioma = null;
        int contador, maxContador = 0;
        ArrayList<String> idiomas = new ArrayList();

        for (Curso c : Datos.getListaSingleton()) {
            idiomas.add(c.getIdioma());
        }

        Collections.sort(idiomas);

        for (String i : idiomas) {
            contador = Collections.frequency(idiomas, i);
            if (maxContador < contador) {
                maxContador = contador;
                if (!i.equals("No Informado")) {
                    topIdioma = i;
                }
            }
        }

        topIdioma = ("El idioma más solicitado es: " + topIdioma + " " + maxContador + " veces.");
        
        System.out.println(topIdioma + "\n");

        return topIdioma;
    }

}
