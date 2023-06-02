/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package presentacion;

import java.io.File;
import java.io.IOException;
import static logica.Importar.importarXml;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import static presentacion.Menu1.mostrarMenu1;
import static presentacion.Menu2.mostrarMenu2;
import static presentacion.Menu3.mostrarMenu3;
import static presentacion.Menu4.mostrarMenu4;
import static presentacion.Menu5.mostrarMenu5;

/**
 * CLASE MAIN QUE EJECUTA LA APLICACIÓN
 * @author ivan
 */
public class M06UF1PracMJ {

    public static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) throws JAXBException, IOException {
        boolean salir = false;
        int opcion;

        /**
         * IMPORTACIÓN DEL ARCHIVO XML
         */
        System.out.println("Introduce la ruta del archivo a importar:");
        String ruta = entrada.nextLine();
        File archivoXml = new File(ruta);

        try {
            importarXml(archivoXml);

            /**
             * MENÚ PRINCIPAL
             */
            do {
                System.out.println("Pulsa la opción deseada: \n"
                        + "\t 1. Exportar fichero en formato XML/CSV ordenado por datos. \n"
                        + "\t 2. Cifrar/Descifrar el fichero. \n"
                        + "\t 3. Mostrar el informe según el tipo de datos elegido. \n"
                        + "\t 4. Búsqueda por categoría. \n"
                        + "\t 5. Más información (HELP). \n"
                        + "\t 0. Salir.");

                try {
                    opcion = entrada.nextInt();

                    switch (opcion) {
                        case 1:
                            /**
                             * MENÚ OPCIÓN 1
                             */
                            mostrarMenu1();
                            break;

                        case 2:
                            /**
                             * MENÚ OPCIÓN 2
                             */
                            mostrarMenu2();
                            break;

                        case 3:
                            /**
                             * MENÚ OPCIÓN 3
                             */
                            mostrarMenu3();
                            break;

                        case 4:
                            /**
                             * MENÚ OPCIÓN 4
                             */
                            mostrarMenu4();
                            break;

                        case 5:
                            /**
                             * MENÚ OPCIÓN 5
                             */
                            mostrarMenu5();
                            break;

                        case 0:
                            /**
                             * MENÚ OPCIÓN 0 - SALIR DE LA APLICACIÓN
                             */
                            System.out.println("\nHas salido de la aplicación.");
                            salir = true;
                            break;

                        default:
                            System.out.println("\nSólo números entre 0 y 5. \n");
                            break;
                    }

                } catch (InputMismatchException ex) {
                    System.out.println("Debes elegir una opción del menú. \n");
                    entrada.next();
                }

            } while (!salir);
        } catch (IllegalArgumentException ex) {
            System.out.println("No se ha podido encontrar el fichero XML.");
        } catch (UnmarshalException ex) {
            System.out.println("El XML está vacío o no tiene la estructura requerida.\n");
        }
    }
}
