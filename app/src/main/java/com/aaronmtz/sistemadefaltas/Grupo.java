package com.aaronmtz.sistemadefaltas;

/**
 * Created by Win 8 on 01/04/2019.
 */

public class Grupo {
    private int clave;
    private String materia;
    private String docente;

    @Override
    public String toString() {
        return "--"+ clave + "--" + materia +"--"+ docente ;
    }

    public Grupo(int clave, String materia, String docente){
        this.clave = clave;
        this.materia = materia;
        this.docente = docente;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }
}
