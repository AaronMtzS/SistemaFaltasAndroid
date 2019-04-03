package com.aaronmtz.sistemadefaltas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Win 8 on 02/04/2019.
 */

public class ListAlumno extends AppCompatActivity {
    private ListView ltvAlumnos;
    AdminSQLiteOpenHelper admin;
    ArrayList<Alumno> alumnos;
    private ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_alumno);

        admin = new AdminSQLiteOpenHelper(this);


        ltvAlumnos = (ListView)findViewById(R.id.ltvAlumnos);

        init();
    }

    public void init(){
        alumnos=admin.listAlumno();

        spinnerAdapter=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, alumnos);
        ltvAlumnos.setAdapter(spinnerAdapter);
        System.out.println(alumnos);
    }

    public void irNuevoAlumno(View view) {
        Intent i = new Intent(this, NuevoAlumno.class );
        startActivity(i);
    }


}


