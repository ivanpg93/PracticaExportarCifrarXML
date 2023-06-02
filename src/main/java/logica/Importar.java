/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dao.Cursos;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author ivan
 */
public class Importar {

    /**
     * IMPORTACIÓN DEL ARCHIVO XML
     * @param file archivo XML que deseas importar
     * @throws javax.xml.bind.JAXBException
     */
    public static void importarXml(File file) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Cursos.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        Cursos cursos = (Cursos) unmarshaller.unmarshal(file);
        Datos.listaSingleton = cursos.getCursos();

        System.out.println("\nSe ha importado el fichero XML. \n");
    }

}