/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.util.Scanner;
import javax.xml.bind.JAXBException;
import static logica.Busqueda.buscarAreaEstudios;
import static logica.Busqueda.buscarCentro;
import static logica.Busqueda.buscarIdioma;
import static logica.Busqueda.buscarPais;
import static logica.Busqueda.buscarPlazasOfertadas;
import static logica.Busqueda.buscarUniversidad;
import static presentacion.M06UF1PracMJ.entrada;

/**
 * MENÚ 4: DA LA OPCIÓN DE BUSCAR LOS CURSOS SEGÚN UNA SERIE DE CATEGORÍAS A ESCOGER POR EL USUARIO
 * @author ivan
 */
public class Menu4 {

    public static void mostrarMenu4() throws JAXBException {
        String sOpcion;
        boolean salir4 = false;

        do {
            System.out.println("\n4. Búsqueda por categoría. \n"
                    + "Elige la categoría: \n"
                    + "\t (a) Área de estudios. \n"
                    + "\t (b) Centro. \n"
                    + "\t (c) Idioma. \n"
                    + "\t (d) País. \n"
                    + "\t (e) Universidad. \n"
                    + "\t (f) Plazas ofertadas.");

            try {
                // Limpiamos el buffer de Scanner
                entrada = new Scanner(System.in);
                sOpcion = entrada.nextLine().toLowerCase();
                switch (sOpcion) {
                    case "a":
                        buscarAreaEstudios();
                        salir4 = true;
                        break;

                    case "b":
                        buscarCentro();
                        salir4 = true;
                        break;

                    case "c":
                        buscarIdioma();
                        salir4 = true;
                        break;

                    case "d":
                        buscarPais();
                        salir4 = true;
                        break;

                    case "e":
                        buscarUniversidad();
                        salir4 = true;
                        break;

                    case "f":
                        buscarPlazasOfertadas();
                        salir4 = true;
                        break;

                    default:
                        System.out.println("Introduce una opción correcta (a-f).");
                        break;
                }

            } catch (JAXBException ex) {
                System.out.println("Elige una opción correcta (a-f).");
            }
        } while (!salir4);

    }

}
