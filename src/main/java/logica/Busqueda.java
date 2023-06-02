/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dao.Curso;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import static presentacion.M06UF1PracMJ.entrada;

/**
 *
 * @author ivan
 */
public class Busqueda {

    /**
     * BUSCAR COINCIDENCIAS SEGÚN EL ÁREA DE ESTUDIOS
     *
     * @throws javax.xml.bind.JAXBException
     */
    public static void buscarAreaEstudios() throws JAXBException {

        ArrayList<Curso> listaBusqueda = new ArrayList<>();
        System.out.println("4.1 Introduce el Área de estudios que deseas buscar (Ejemplo: Diseño industrial, de moda y de interiores):");
        String area = entrada.nextLine();

        for (Curso c : Datos.getListaSingleton()) {
            if (c.getAreaEstudios().contains(area) && !area.isBlank()) {
                listaBusqueda.add(c);
            }
        }

        if (!listaBusqueda.isEmpty()) {
            System.out.println("4.2 Estas son las coincidencias encontradas:");
            for (Curso c : listaBusqueda) {
                System.out.println(c);
            }
            System.out.println();
        } else {
            System.out.println("No se han encontrado coincidencias con: " + area + "\n");
        }
    }

    /**
     * BUSCAR COINCIDENCIAS SEGÚN EL CENTRO
     *
     * @throws JAXBException
     */
    public static void buscarCentro() throws JAXBException {

        ArrayList<Curso> listaBusqueda = new ArrayList<>();
        System.out.println("4.1 Introduce el Centro que deseas buscar (Ejemplo: Escuela de Ingeniería y Arquitectura):");
        String centro = entrada.nextLine();

        // Formateamos el centro para que coincida con el formato del XML
        if(centro.length() > 0) {
           centro = primeraLetraMayuscula(centro); 
        }

        for (Curso c : Datos.getListaSingleton()) {
            if (c.getCentro().contains(centro) && !centro.isBlank()) {
                listaBusqueda.add(c);
            }
        }

        if (!listaBusqueda.isEmpty()) {
            System.out.println("4.2 Estas son las coincidencias encontradas:");
            for (Curso c : listaBusqueda) {
                System.out.println(c);
            }
            System.out.println();
        } else {
            System.out.println("No se han encontrado coincidencias con: " + centro + "\n");
        }
    }

    /**
     * BUSCAR COINCIDENCIAS SEGÚN EL IDIOMA
     *
     * @throws JAXBException
     */
    public static void buscarIdioma() throws JAXBException {

        ArrayList<Curso> listaBusqueda = new ArrayList<>();
        System.out.println("4.1 Introduce el Idioma que deseas buscar (Ejemplo: ESPAÑOL):");

        // Formateamos el pais para que coincida con el formato del XML
        String idioma = entrada.nextLine().toUpperCase();

        for (Curso c : Datos.getListaSingleton()) {
            if (c.getIdioma().contains(idioma) && !idioma.isBlank()) {
                listaBusqueda.add(c);
            }
        }

        if (!listaBusqueda.isEmpty()) {
            System.out.println("4.2 Estas son las coincidencias encontradas:");
            for (Curso c : listaBusqueda) {
                System.out.println(c);
            }
            System.out.println();
        } else {
            System.out.println("No se han encontrado coincidencias con: " + idioma + "\n");
        }
    }

    /**
     * BUSCAR COINCIDENCIAS SEGÚN EL PAÍS
     *
     * @throws JAXBException
     */
    public static void buscarPais() throws JAXBException {

        ArrayList<Curso> listaBusqueda = new ArrayList<>();
        System.out.println("4.1 Introduce el País que deseas buscar (Ejemplo: Polonia):");
        String pais = entrada.nextLine();

        // Formateamos el pais para que coincida con el formato del XML
        if(pais.length() > 0) {
           pais = pais.toUpperCase().charAt(0) + pais.substring(1, pais.length()).toLowerCase(); 
        }

        for (Curso c : Datos.getListaSingleton()) {
            if (c.getPais().contains(pais) && !pais.isBlank()) {
                listaBusqueda.add(c);
            }
        }

        if (!listaBusqueda.isEmpty()) {
            System.out.println("4.2 Estas son las coincidencias encontradas:");
            for (Curso c : listaBusqueda) {
                System.out.println(c);
            }
            System.out.println();
        } else {
            System.out.println("No se han encontrado coincidencias con: " + pais + "\n");
        }
    }

    /**
     * BUSCAR COINCIDENCIAS SEGÚN LA UNIVERSIDAD
     *
     * @throws JAXBException
     */
    public static void buscarUniversidad() throws JAXBException {

        ArrayList<Curso> listaBusqueda = new ArrayList<>();
        System.out.println("4.1 Introduce la Universidad que deseas buscar (Ejemplo: Hochschule Coburg):");
        String universidad = entrada.nextLine();
        universidad = primeraLetraMayusculaCadaPalabra(universidad);

        for (Curso c : Datos.getListaSingleton()) {
            if (c.getUniversidad().contains(universidad) && !universidad.isBlank()) {
                listaBusqueda.add(c);
            }
        }

        if (!listaBusqueda.isEmpty()) {
            System.out.println("4.2 Estas son las coincidencias encontradas:");
            for (Curso c : listaBusqueda) {
                System.out.println(c);
            }
            System.out.println();
        } else {
            System.out.println("No se han encontrado coincidencias con: " + universidad + "\n");
        }
    }

    /**
     * BUSCAR COINCIDENCIAS SEGÚN LAS PLAZAS OFERTADAS
     *
     * @throws JAXBException
     */
    public static void buscarPlazasOfertadas() throws JAXBException {

        ArrayList<Curso> listaBusqueda = new ArrayList<>();
        System.out.println("4.1 Introduce las Plazas Ofertadas que deseas buscar (Ejemplo: 2):");
        String pOfertadas = entrada.nextLine();

        while (!isNumeric(pOfertadas) || Integer.parseInt(pOfertadas) < 0) {
            System.out.println("Introduce un número >= 0.");
            pOfertadas = entrada.nextLine();
        }

        for (Curso c : Datos.getListaSingleton()) {
            if (String.valueOf(c.getPlazasOfertadas()).equals(pOfertadas)) {
                listaBusqueda.add(c);
            }
        }

        if (!listaBusqueda.isEmpty()) {
            System.out.println("4.2 Estas son las coincidencias encontradas:");
            for (Curso c : listaBusqueda) {
                System.out.println(c);
            }
            System.out.println();
        } else {
            System.out.println("No se han encontrado coincidencias con: " + pOfertadas + "\n");
        }
    }

    /**
     * COMPRUEBA SI UN STRING ES UN ENTERO
     *
     * @param cadena String que se compara
     * @return true o false
     */
    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    /**
     * FORMATEA UN STRING PARA PONER LA PRIMERA LETRA DE LA CADENA EN MAYÚSCULA
     * 
     * @param cadena String que necesitas formatear
     * @return String de cadena formateado
     */
    public static String primeraLetraMayuscula(String cadena) {
        
        cadena = cadena.toUpperCase().charAt(0) + cadena.substring(1, cadena.length());

        return cadena;
    }

    /**
     * FORMATEA UN STRING PARA PONER LA PRIMERA LETRA DE CADA PALABRA EN
     * MAYÚSCULA
     *
     * @param cadena String que necesitas formatear
     * @return String de cadena formateado
     */
    public static String primeraLetraMayusculaCadaPalabra(String cadena) {

        try {
            char palabras[] = cadena.toCharArray();
            palabras[0] = Character.toUpperCase(palabras[0]);

            // el -2 es para evitar una excepción al caernos del arreglo
            for (int i = 0; i < cadena.length() - 2; i++) // Es 'palabra'
            {
                if (palabras[i] == ' ' || palabras[i] == '.' || palabras[i] == ',') // Reemplazamos
                {
                    palabras[i + 1] = Character.toUpperCase(palabras[i + 1]);
                }
            }
            cadena = new String(palabras);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("El campo no puede estar vacío.");
        }

        return cadena;
    }
}
