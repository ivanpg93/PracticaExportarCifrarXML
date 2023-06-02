/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dao.Curso;
import java.util.ArrayList;

/**
 * CLASE SINGLETON PARA ACCEDER A LOS DATOS DEL XML IMPORTADO
 * @author ivan
 */
public class Datos {

    static ArrayList<Curso> listaSingleton = new ArrayList();

    private Datos(ArrayList<Curso> cursos) {
        this.listaSingleton = cursos;
    }

    public static ArrayList<Curso> getListaSingleton() {
        return listaSingleton;
    }

    public static void setListaSingleton(ArrayList<Curso> listaSingleton) {
        Datos.listaSingleton = listaSingleton;
    }
    
    //Sobreescribimos el método clone, para que no se pueda clonar un objeto de esta clase
    @Override
    public Datos clone() {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
            System.out.println("No se puede clonar un objeto de la clase Datos");
        }
        return null;
    }

}
