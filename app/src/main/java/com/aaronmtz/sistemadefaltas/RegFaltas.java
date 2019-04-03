package com.aaronmtz.sistemadefaltas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Win 8 on 02/04/2019.
 */

public class RegFaltas extends AppCompatActivity {
    private EditText edtClaveReg, edtMatriculaReg, edtFaltas;
    AdminSQLiteOpenHelper admin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_faltas);

        edtClaveReg=(EditText) findViewById(R.id.edtClaveReg);
        edtMatriculaReg=(EditText) findViewById(R.id.edtMatriculaReg);
        edtFaltas=(EditText) findViewById(R.id.edtFaltas);
    }

    public void altaFaltas(View v){
        admin = new AdminSQLiteOpenHelper(this);

        int cla = Integer.parseInt(edtClaveReg.getText().toString());
        int mat = Integer.parseInt(edtMatriculaReg.getText().toString());
        int fal = Integer.parseInt(edtFaltas.getText().toString());
        String est;
        if(fal>=10){
            est = "Reprobado";
        }else{
            est = "Aprobado";
        }


        admin.insertFaltas(cla,mat,fal,est);
        admin.close();
        edtMatriculaReg.setText("");
        edtClaveReg.setText("");
        edtFaltas.setText("");
        Toast.makeText(this, "El alumno está "+est+".",
                Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, ListFaltas.class);
        startActivity(i);
    }

    public void irListFaltas(View view) {
        Intent i = new Intent(this, ListFaltas.class);
        startActivity(i);
    }
}
