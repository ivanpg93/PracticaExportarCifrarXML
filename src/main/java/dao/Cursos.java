/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * CLASE QUE ALMACENA TODOS LOS CURSOS
 * @author ivan
 */

@XmlRootElement (name = "Rows")
public class Cursos {
    
    private ArrayList<Curso> cursos;

    public Cursos() {
    }
    
    @XmlElement(name = "Row")
    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return cursos.toString();
    }
    
}
