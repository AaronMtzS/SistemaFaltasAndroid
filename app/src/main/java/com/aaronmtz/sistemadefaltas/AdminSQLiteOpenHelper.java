package com.aaronmtz.sistemadefaltas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Win 8 on 01/04/2019.
 */

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    public AdminSQLiteOpenHelper(Context context) {
        super(context, "faltas" , null, 1);
        db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table grupos(clave int primary key,materia text,docente text)");
        db.execSQL("create table alumnos(matricula int primary key,nombre text,apellido text)");
        db.execSQL("create table lista(id INTEGER PRIMARY KEY autoincrement,grupo int,alumno int,faltas int, estado text, foreign key (grupo) references grupos(clave), foreign key (alumno) references alumnos(matricula))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertGrupo(int clave, String materia, String docente){

        ContentValues registro = new ContentValues();
        registro.put("clave", clave);
        registro.put("materia", materia);
        registro.put("docente", docente);
        db.insert("grupos", null, registro);
    }

    public void insertAlumno(int mat, String nom, String ape){
        ContentValues registro = new ContentValues();
        registro.put("matricula", mat);
        registro.put("nombre", nom);
        registro.put("apellido", ape);
        db.insert("alumnos",null,registro);
    }

    public void insertFaltas(int cla, int mat,int fal, String est){
        ContentValues registro = new ContentValues();
        registro.put("grupo", cla);
        registro.put("alumno", mat);
        registro.put("faltas", fal);
        registro.put("estado", est);
        db.insert("lista",null,registro);
    }

    public ArrayList<Grupo> listGrupo(){
        ArrayList<Grupo> tomar_lista = new ArrayList<>();
        Grupo grupTemp;
        Cursor fila =db.rawQuery("select clave, materia, docente from grupos", null);
        if(fila!=null && fila.getCount()>0){
            fila.moveToFirst();
            do{
                int clave = Integer.parseInt(fila.getString(fila.getColumnIndex("clave")));
                String materia = fila.getString(fila.getColumnIndex("materia"));
                String docente = fila.getString(fila.getColumnIndex("docente"));

                grupTemp=new Grupo(clave,materia,docente);
                tomar_lista.add(grupTemp);
            }while(fila.moveToNext());
        }
        fila.close();
        return tomar_lista;
    }

    public ArrayList<Alumno> listAlumno(){
        ArrayList<Alumno> tomar_lista = new ArrayList<>();
        Alumno alumTemp;
        Cursor fila = db.rawQuery("select matricula, nombre, apellido from alumnos", null);
        if(fila!=null && fila.getCount()>0){
            fila.moveToFirst();
            do{
                int matricula = Integer.parseInt(fila.getString(fila.getColumnIndex("matricula")));
                String nombre = fila.getString(fila.getColumnIndex("nombre"));
                String apellido = fila.getString(fila.getColumnIndex("apellido"));

                alumTemp=new Alumno(matricula,nombre,apellido);
                tomar_lista.add(alumTemp);
            }while(fila.moveToNext());
        }
        fila.close();
        return tomar_lista;
    }

    public ArrayList<Falta> listFalta(){
        ArrayList<Falta> tomar_lista = new ArrayList<>();
        Falta falTemp;
        Cursor fila = db.rawQuery("select grupo, alumno, faltas, estado from lista", null);
        if(fila!=null && fila.getCount()>0){
            fila.moveToFirst();
            do{
                int grupo = Integer.parseInt(fila.getString(fila.getColumnIndex("grupo")));
                int alumno = Integer.parseInt(fila.getString(fila.getColumnIndex("alumno")));
                int faltas = Integer.parseInt(fila.getString(fila.getColumnIndex("faltas")));
                String estado = fila.getString(fila.getColumnIndex("estado"));

                falTemp=new Falta(grupo,alumno,faltas,estado);
                tomar_lista.add(falTemp);
            }while(fila.moveToNext());
        }
        fila.close();
        return tomar_lista;
    }

}