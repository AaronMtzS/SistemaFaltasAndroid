package com.aaronmtz.sistemadefaltas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

/**
 * Created by Win 8 on 28/03/2019.
 */

public class NuevoGrupo extends AppCompatActivity {
    private EditText edtClave, edtMateria, edtDocente;
    AdminSQLiteOpenHelper admin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_grupo);

        edtClave=(EditText)findViewById(R.id.edtClave);
        edtMateria=(EditText)findViewById(R.id.edtMateria);
        edtDocente=(EditText)findViewById(R.id.edtDocente);
    }

    public void altaGrupo(View v){
        admin = new AdminSQLiteOpenHelper(this);
        int cla = Integer.parseInt(edtClave.getText().toString());
        String mat = edtMateria.getText().toString();
        String doc = edtDocente.getText().toString();

        admin.insertGrupo(cla,mat,doc);

        admin.close();
        edtClave.setText("");
        edtMateria.setText("");
        edtDocente.setText("");
        Toast.makeText(this, "Se cargaron los datos del grupo",
                Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, TomarLista.class);
        startActivity(i);
    }

    public void irTomarLista(View view) {
        Intent i = new Intent(this, TomarLista.class );
        startActivity(i);
    }

}
