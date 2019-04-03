package com.aaronmtz.sistemadefaltas;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Win 8 on 28/03/2019.
 */

public class NuevoAlumno extends AppCompatActivity {
    private EditText edtMatricula, edtNombre, edtApellido;
    AdminSQLiteOpenHelper admin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_alumno);

        edtMatricula=(EditText) findViewById(R.id.edtMatricula);
        edtNombre=(EditText) findViewById(R.id.edtNombre);
        edtApellido=(EditText) findViewById(R.id.edtApellido);
    }

    public void altaAlumno(View v){
        admin = new AdminSQLiteOpenHelper(this);

        int mat = Integer.parseInt(edtMatricula.getText().toString());
        String nom = edtNombre.getText().toString();
        String ape = edtApellido.getText().toString();

        admin.insertAlumno(mat,nom,ape);
        admin.close();
        edtMatricula.setText("");
        edtNombre.setText("");
        edtApellido.setText("");
        Toast.makeText(this, "Se cargaron los datos del alumno",
                Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, ListAlumno.class);
        startActivity(i);
    }

    public void irListAlumno(View view) {
        Intent i = new Intent(this, ListAlumno.class);
        startActivity(i);
    }
}
