/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.opencsv.CSVWriter;
import dao.Curso;
import dao.Cursos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author Taufik
 */
public class Exportar {
    
    public static void ExportCSV() throws JAXBException, IOException{
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la ruta del archivo XML: ");
        String rutaEntrada = sc.nextLine();
        System.out.print("Introduce la ruta de salida del archivo CSV: ");
        String rutaSalida = sc.nextLine();
        System.out.println("1.3 Elige el orden según el tipo de datos elegido: \n"
                    + "\t (a) Programa. \n"
                    + "\t (b) Área de estudio. \n"
                    + "\t (f) Centro. \n"
                    + "\t (c) Idioma. \n"
                    + "\t (d) País. \n"
                    + "\t (e) Universidad. \n"
                    + "\t (g) Plazas ofertadas.");
        String tipoDato = sc.nextLine();

        try {
            
            //Objeto File par la ruta de entrada
            File file = new File(rutaEntrada);
            //deserialización del archivo xml
            JAXBContext jaxbContext = JAXBContext.newInstance(Cursos.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Cursos cursos = (Cursos) jaxbUnmarshaller.unmarshal(file);
            //lista de cursos
            List<Curso> listaCursos = cursos.getCursos();

            switch (tipoDato) {
                case "a":
                    listaCursos.sort(Comparator.comparing(Curso::getPrograma)); //ordenamos lista de Cursos por tipo de atributo, ene este caso Programa 
                    break;
                case "b":
                    listaCursos.sort(Comparator.comparing(Curso::getAreaEstudios));
                    break;
                case "c":
                    listaCursos.sort(Comparator.comparing(Curso::getCentro));
                    break;
                case "d":
                    listaCursos.sort(Comparator.comparing(Curso::getIdioma));
                    break;
                case "e":
                    listaCursos.sort(Comparator.comparing(Curso::getPais));
                    break;
                case "f":
                    listaCursos.sort(Comparator.comparing(Curso::getUniversidad));
                    break;
                case "g":
                    listaCursos.sort(Comparator.comparing(Curso::getPlazasOfertadas));
                    break;
                default:
                    System.out.println("Opción no válida");
                    return;
            }

            //å - ö - ä - à

            FileWriter csvWriter = new FileWriter(rutaSalida);
            csvWriter.append("PROGRAMA,AREA DE ESTUDIOS,CENTRO,IDIOMA,PAIS,UNIVERSIDAD,PLAZAS OFERTADAS\n");
            for (Curso curso : listaCursos) {
                //escribimos y realizamos una limpieza 
                csvWriter.append(curso.getPrograma().replaceAll(",", "").replaceAll("ñ", "n").replaceAll("Ñ", "N").replaceAll("ó", "o").replaceAll("é", "e").replaceAll("á", "a").replaceAll("ú", "u").replaceAll("à", "a").replaceAll("è", "e").replaceAll("å", "a").replaceAll("ö", "o").replaceAll("ä","a").replaceAll("í","i").replaceAll("É","E").replaceAll("Á","A"));
                csvWriter.append(",");
                csvWriter.append(curso.getAreaEstudios().replaceAll(",", "").replaceAll("ñ", "n").replaceAll("Ñ", "N").replaceAll("ó", "o").replaceAll("é", "e").replaceAll("á", "a").replaceAll("ú", "u").replaceAll("à", "a").replaceAll("è", "e").replaceAll("å", "a").replaceAll("ö", "o").replaceAll("ä","a").replaceAll("í","i").replaceAll("É","E").replaceAll("Á","A"));
                csvWriter.append(",");
                csvWriter.append(curso.getCentro().replaceAll(",", "").replaceAll("ñ", "n").replaceAll("Ñ", "N").replaceAll("ó", "o").replaceAll("é", "e").replaceAll("á", "a").replaceAll("ú", "u").replaceAll("à", "a").replaceAll("è", "e").replaceAll("å", "a").replaceAll("ö", "o").replaceAll("ä","a").replaceAll("í","i").replaceAll("É","E").replaceAll("Á","A"));
                csvWriter.append(",");
                csvWriter.append(curso.getIdioma().replaceAll(",", "").replaceAll("ñ", "n").replaceAll("Ñ", "N").replaceAll("ó", "o").replaceAll("é", "e").replaceAll("á", "a").replaceAll("ú", "u").replaceAll("à", "a").replaceAll("è", "e").replaceAll("å", "a").replaceAll("ö", "o").replaceAll("ä","a").replaceAll("í","i").replaceAll("É","E").replaceAll("Á","A"));
                csvWriter.append(",");
                csvWriter.append(curso.getPais().replaceAll(",", "").replaceAll("ñ", "n").replaceAll("Ñ", "N").replaceAll("ó", "o").replaceAll("é", "e").replaceAll("á", "a").replaceAll("ú", "u").replaceAll("à", "a").replaceAll("è", "e").replaceAll("å", "a").replaceAll("ö", "o").replaceAll("ä","a").replaceAll("í","i").replaceAll("É","E").replaceAll("Á","A"));
                csvWriter.append(",");
                csvWriter.append(curso.getUniversidad().replaceAll(",", "").replaceAll("ñ", "n").replaceAll("Ñ", "N").replaceAll("ó", "o").replaceAll("é", "e").replaceAll("á", "a").replaceAll("ú", "u").replaceAll("à", "a").replaceAll("è", "e").replaceAll("å", "a").replaceAll("ö", "o").replaceAll("ä","a").replaceAll("í","i").replaceAll("É","E").replaceAll("Á","A"));
                csvWriter.append(",");
                csvWriter.append(String.valueOf(curso.getPlazasOfertadas()));
                //csvWriter.append(Integer.toString(curso.getPlazasOfertadas()));
                csvWriter.append("\n");
            }
            
            csvWriter.flush();
            csvWriter.close();
            
            
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Archivo XML exportado exitosamente en: " + rutaSalida);
    }
    
    
    public static void ExportarXMLSort() throws JAXBException, IOException {
        
        boolean salir1 = false;
        
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce la ruta del archivo XML de entrada:");
            String rutaEntrada = sc.nextLine();
            System.out.println("Introduzca la ruta del archivo XML de salida:");
            String rutaSalida = sc.nextLine();

            //deserialización
            JAXBContext jaxbContext = JAXBContext.newInstance(Cursos.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Cursos cursos = (Cursos) jaxbUnmarshaller.unmarshal(new File(rutaEntrada));

            // Reemplazar '&' por 'y' y guardar en un StringBuilder
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(rutaEntrada));
            String line;
            while((line = br.readLine()) != null) {
                line = line.replaceAll("&", "y");
                sb.append(line).append("\n");
            }
            br.close();

            // Escribir los datos en el archivo XML de salida
            PrintWriter pw = new PrintWriter(new File(rutaSalida));
            pw.write(sb.toString());
            pw.close();

            do {
                System.out.println("1.3 Elige el orden según el tipo de datos elegido: \n"
                        + "\t (a) Programa. \n"
                        + "\t (b) Área de estudio. \n"
                        + "\t (c) Centro. \n"
                        + "\t (d) Idioma. \n"
                        + "\t (e) País. \n"
                        + "\t (f) Universidad. \n"
                        + "\t (g) Plazas ofertadas.");
                try {
                    String tipoDato = sc.nextLine();
                    switch (tipoDato) {
                        case "a":
                            System.out.println("Has elegido ordenar por Programa.");
                            cursos.getCursos().sort(Comparator.comparing(Curso::getPrograma));
                            break;
                        case "b":
                            System.out.println("Has elegido ordenar por Nombre área estudios.");
                            cursos.getCursos().sort(Comparator.comparing(Curso::getAreaEstudios));
                            break;
                        case "c":
                            System.out.println("Has elegido ordenar por Centro.");
                            cursos.getCursos().sort(Comparator.comparing(Curso::getCentro));
                            break;
                        case "d":
                            System.out.println("Has elegido ordenar por Idioma.");
                            cursos.getCursos().sort(Comparator.comparing(Curso::getIdioma));
                            break;
                        case "e":
                            System.out.println("Has elegido ordenar por Pais.");
                            cursos.getCursos().sort(Comparator.comparing(Curso::getPais));
                            break;
                        case "f":
                            System.out.println("Has elegido ordenar por Universidad.");
                            cursos.getCursos().sort(Comparator.comparing(Curso::getUniversidad));
                            break;
                        case "g":
                            System.out.println("Has elegido ordenar por Plazas Ofertadas.");
                            cursos.getCursos().sort(Comparator.comparingInt(Curso::getPlazasOfertadas));
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Introduce una opción correcta (a-f).");
            }
        } while (!salir1);
            
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(cursos, new File(rutaSalida));
            
            System.out.println("Archivo XML exportado exitosamente en: " + rutaSalida);
            
        } catch (JAXBException e) {
        System.out.println("Error en la exportación del archivo XML: " + e.getMessage());
        } catch (IOException e) {
        System.out.println("Error en la lectura/escritura del archivo: " + e.getMessage());
        }
        
        
    }
    
    
    
    

    /*public static void exportarXML() throws JAXBException, IOException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduzca la ruta del archivo XML de origen:");
            String rutaOrigen = sc.nextLine();
            System.out.println("Ingresa el nombre del archivo de salida (XML): ");
            String nombreSalida = sc.nextLine();

            // Lectura del archivo XML de origen
            File file = new File(rutaOrigen);
            
           
            String xml = new Scanner(file).useDelimiter("\\Z").next();
            xml = xml.replace("&", "y");
            // Busca y reemplaza cualquier referencia de entidad inválida
            Pattern pattern = Pattern.compile("&(?!(amp;|lt;|gt;|apos;|quot;))");
            Matcher matcher = pattern.matcher(xml);
            xml = matcher.replaceAll("&amp;");

            // Punt d'entrada al context JAXB, amb la classe "contenidora" o classe principal
            JAXBContext jaxbContext = JAXBContext.newInstance(Cursos.class);
            Cursos cursos = (Cursos) jaxbContext.createUnmarshaller().unmarshal(new StringReader(xml));
           

            // Escritura de los datos en el archivo XML de destino
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            //jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            jaxbMarshaller.marshal(cursos, new FileWriter(nombreSalida));
            jaxbMarshaller.marshal(cursos, System.out);
            
        /*} catch (JAXBException e) {
            System.out.println("El archivo xml no es válido: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo xml: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo xml de destino: " + e.getMessage());
        }
    }*/
    
    /*StringBuilder builder = new StringBuilder();
            
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                builder.append(input.nextLine());
                
            }
            String xml = builder.toString();
            xml = xml.replace("&", "y");*/
    
    
    /*public static void ExportarXMLStringPrimero() throws JAXBException, IOException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce la ruta del archivo XML de entrada:");
            String rutaEntrada = sc.nextLine();
            System.out.println("Introduzca la ruta del archivo XML de salida:");
            String rutaSalida = sc.nextLine();
            
            // Reemplazar '&' por 'y' y guardar en un StringBuilder
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(rutaEntrada));
            String line;
            while((line = br.readLine()) != null) {
                line = line.replaceAll("&", "y");
                sb.append(line).append("\n");
            }
            br.close();

            // Escribir los datos en el archivo XML de salida
            PrintWriter pw = new PrintWriter(new File(rutaSalida));
            pw.write(sb.toString());
            pw.close();
            
            JAXBContext jaxbContext = JAXBContext.newInstance(Cursos.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Cursos cursos = (Cursos) jaxbUnmarshaller.unmarshal(new File(rutaSalida));

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(cursos, System.out);
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo xml: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo xml de destino: " + e.getMessage());
        }
        
        System.out.println("El fichero se ha exportado con éxito!!!");
    }*/
}
