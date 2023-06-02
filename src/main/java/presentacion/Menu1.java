/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import logica.Exportar;
import static presentacion.M06UF1PracMJ.entrada;

/**
 * MENÚ 1: DA LA OPCIÓN DE EXPORTAR UN FICHERO EN FORMATO XML/CSV
 * @author ivan
 */
public class Menu1 {

    public static void mostrarMenu1() throws JAXBException, IOException {
        String sOpcion = "", ruta;
        boolean salir1 = false;

        System.out.println("\n1. Exportar fichero en formato XML/CSV ordenado por datos.");
        entrada.nextLine();
        
        do {
            System.out.println("1.1 Elige el formato de exportación XML(x) o CSV(c):");
            try {
                sOpcion = entrada.nextLine();

                switch (sOpcion) {
                    case "x":
                        System.out.println("Has elegido exportar en formato XML.");
                        Exportar.ExportarXMLSort();
                        salir1 = true;
                        break;

                    case "c":
                        System.out.println("Has elegido exportar en formato CSV.");
                        Exportar.ExportCSV();
                        salir1 = true;
                        break;

                    default:
                        System.out.println("Introduce una opción correcta (x) o (c).");
                        break;
                }
                
            } catch (Exception e) {
                System.out.println("Introduce una opción correcta (x) o (c).");
            }

        } while (!salir1);
        
        System.out.println("1.5 Se ha exportado el fichero. \n");
    }

}


/*



System.out.println("1.2 Indica el archivo que quieres exportar:");
        entrada.next();
        ruta = entrada.nextLine();
        
        while (!sOpcion.equals("x") && !sOpcion.equals("c")) {
            System.out.println("1.1 Elige el formato de exportación XML(x) o CSV(c):");
            sOpcion = entrada.nextLine().toLowerCase();
        }

        Exportar.ExportCSV();
        

        do {
            System.out.println("1.3 Elige el orden según el tipo de datos elegido: \n"
                    + "\t (a) Centro. \n"
                    + "\t (b) Nombre área estudios. \n"
                    + "\t (c) Idioma. \n"
                    + "\t (d) País. \n"
                    + "\t (e) Universidad. \n"
                    + "\t (f) Plazas ofertadas.");
            try {
                sOpcion = entrada.nextLine().toLowerCase();

                switch (sOpcion) {
                    case "a":
                        System.out.println("Has elegido ordenar por Centro.");
                        salir1 = true;
                        break;

                    case "b":
                        System.out.println("Has elegido ordenar por Nombre área estudios.");
                        salir1 = true;
                        break;

                    case "c":
                        System.out.println("Has elegido ordenar por Idioma.");
                        salir1 = true;
                        break;

                    case "d":
                        System.out.println("Has elegido ordenar por País.");
                        salir1 = true;
                        break;

                    case "e":
                        System.out.println("Has elegido ordenar por Universidad.");
                        salir1 = true;
                        break;

                    case "f":
                        System.out.println("Has elegido ordenar por Plazas ofertadas.");
                        salir1 = true;
                        break;

                    default:
                        System.out.println("Introduce una opción correcta (a-f).");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Introduce una opción correcta (a-f).");
            }

        } while (!salir1);

        System.out.println("1.4 Indica dónde se guardará el archivo exportado:");
        entrada.next();
        ruta = entrada.nextLine();
        System.out.println("1.5 Se ha exportado el fichero. \n");
*/