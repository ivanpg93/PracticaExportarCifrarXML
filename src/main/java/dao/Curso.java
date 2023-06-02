/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * CLASE QUE ALMACENA LOS DATOS DE CADA CURSO
 * @author ivan
 */

@XmlRootElement(name = "Row")
public class Curso {
    
    private String programa;
    private String areaEstudios;
    private String centro;
    private String idioma;
    private String pais;
    private String universidad;
    private int plazasOfertadas;

    public Curso() {
    }

    public Curso(String programa, String areaEstudios, String centro, String idioma, String pais, String universidad, int plazasOfertadas) {
        this.programa = programa;
        this.areaEstudios = areaEstudios;
        this.centro = centro;
        this.idioma = idioma;
        this.pais = pais;
        this.universidad = universidad;
        this.plazasOfertadas = plazasOfertadas;
    }
    
    @XmlElement(name = "NOMBRE_PROGRAMA_MOVILIDAD")
    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
    
    @XmlElement(name = "NOMBRE_AREA_ESTUDIOS_MOV")
    public String getAreaEstudios() {
        return areaEstudios;
    }

    public void setAreaEstudios(String areaEstudios) {
        this.areaEstudios = areaEstudios;
    }
    
    @XmlElement(name = "CENTRO")
    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }
    
    @XmlElement(name = "NOMBRE_IDIOMA_NIVEL_MOVILIDAD")
    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    @XmlElement(name = "PAIS_UNIVERSIDAD_ACUERDO")
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    @XmlElement(name = "UNIVERSIDAD_ACUERDO")
    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    
    @XmlElement(name = "PLAZAS_OFERTADAS_ALUMNOS")
    public int getPlazasOfertadas() {
        return plazasOfertadas;
    }

    public void setPlazasOfertadas(int plazasOfertadas) {
        this.plazasOfertadas = plazasOfertadas;
    }

    @Override
    public String toString() {
        return "CURSO - " + "Programa: " + programa + ", AreaEstudios: " + areaEstudios + ", Centro: " + centro + ", Idioma: " + idioma + ", Pais: " + pais + ", Universidad: " + universidad + ", PlazasOfertadas: " + plazasOfertadas;
    }    
    
}
