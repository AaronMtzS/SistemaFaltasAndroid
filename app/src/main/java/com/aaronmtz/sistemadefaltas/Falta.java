package com.aaronmtz.sistemadefaltas;

/**
 * Created by Win 8 on 02/04/2019.
 */

public class Falta {
    private int grupo;
    private int alumno;
    private int faltas;
    private String estado;

    @Override
    public String toString() {
        return "--"+ grupo + "--" + alumno +"--"+ faltas+"--"+estado ;
    }

    public Falta(int grupo, int alumno, int faltas, String estado){
        this.grupo = grupo;
        this.alumno = alumno;
        this.faltas = faltas;
        this.estado= estado;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
