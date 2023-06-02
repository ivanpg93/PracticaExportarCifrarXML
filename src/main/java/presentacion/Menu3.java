/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import static datos.Exportar.exportarInforme;
import java.io.IOException;
import static logica.Informe.informePais;
import static logica.Informe.promedioPlazasOfertadas;
import static logica.Informe.topIdioma;
import static presentacion.M06UF1PracMJ.entrada;

/**
 * MENÚ 3: DA LA OPCIÓN DE MOSTRAR UN INFORME SEGÚN UN TIPO DE DATOS Y ALMACENAR
 * EL RESULTADO EN UN ARCHIVO A ELECCIÓN DEL USUARIO
 *
 * @author ivan
 */
public class Menu3 {

    public static void mostrarMenu3() throws IOException {
        String sOpcion, ruta;
        boolean salir3 = false;

        System.out.println("\n3. Mostrar el informe según el tipo de datos elegido.");
        entrada.nextLine();

        do {
            System.out.println("3.1 Elige el tipo de datos que quieres generar el informe: \n"
                    + "\t (a) País. \n"
                    + "\t (b) Plazas ofertadas. \n"
                    + "\t (c) Idioma más solicitado.");

            try {
                sOpcion = entrada.nextLine().toLowerCase();
                switch (sOpcion) {
                    case "a":
                        System.out.println("Has elegido generar el informe por País.");
                        informePais();
                        System.out.println("3.2 Indica dónde se guardará el informe:");
                        ruta = entrada.nextLine();
                        if (exportarInforme(informePais(), ruta)) {
                            System.out.println("3.3 Se ha generado el informe correctamente. \n");
                        }
                        salir3 = true;
                        break;

                    case "b":
                        System.out.println("Has elegido generar el informe por Plazas ofertadas.");
                        promedioPlazasOfertadas();
                        System.out.println("3.2 Indica dónde se guardará el informe:");
                        ruta = entrada.nextLine();
                        if (exportarInforme(promedioPlazasOfertadas(), ruta)) {
                            System.out.println("3.3 Se ha generado el informe correctamente. \n");
                        }
                        salir3 = true;
                        break;

                    case "c":
                        System.out.println("Has elegido generar el informe por Idioma más solicitado.");
                        topIdioma();
                        System.out.println("3.2 Indica dónde se guardará el informe:");
                        ruta = entrada.nextLine();
                        if (exportarInforme(topIdioma(), ruta)) {
                            System.out.println("3.3 Se ha generado el informe correctamente. \n");
                        }
                        salir3 = true;
                        break;

                    default:
                        System.out.println("Elige una opción correcta (a-c).");
                }

            } catch (IOException ex) {
                System.out.println("Elige una opción correcta (a-c).");
            }

        } while (!salir3);

    }

}
