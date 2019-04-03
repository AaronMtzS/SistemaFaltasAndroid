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
 * Created by Win 8 on 28/03/2019.
 */

public class TomarLista extends AppCompatActivity {
    private ListView ltvGrupos;
    AdminSQLiteOpenHelper admin;
    ArrayList<Grupo> grupos;
    private ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tomar_lista);

        admin = new AdminSQLiteOpenHelper(this);


        ltvGrupos = (ListView)findViewById(R.id.ltvGrupos);

        init();
    }

    public void init(){
        grupos=admin.listGrupo();

        spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,grupos);
        ltvGrupos.setAdapter(spinnerAdapter);
        System.out.println(grupos);
    }

    public void irNuevoGrupo(View view) {
        Intent i = new Intent(this, NuevoGrupo.class );
        startActivity(i);
    }
}
