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

public class ListFaltas extends AppCompatActivity {
    private ListView ltvFaltas;
    AdminSQLiteOpenHelper admin;
    ArrayList<Falta> faltas;
    private ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_faltas);

        admin = new AdminSQLiteOpenHelper(this);


        ltvFaltas = (ListView)findViewById(R.id.ltvFaltas);

        init();
    }

    public void init(){
        faltas=admin.listFalta();

        spinnerAdapter=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, faltas);
        ltvFaltas.setAdapter(spinnerAdapter);
        System.out.println(faltas);
    }

    public void irRegFaltas(View view) {
        Intent i = new Intent(this, RegFaltas.class);
        startActivity(i);
    }
}
