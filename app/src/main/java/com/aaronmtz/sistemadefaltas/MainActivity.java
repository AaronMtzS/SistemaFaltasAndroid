package com.aaronmtz.sistemadefaltas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.View;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irTomarLista(View view) {
        Intent i = new Intent(this, TomarLista.class );
        startActivity(i);
    }

    public void irListAlumno(View view) {
        Intent i = new Intent(this, ListAlumno.class);
        startActivity(i);
    }

    public void irListFaltas(View view) {
        Intent i = new Intent(this, ListFaltas.class);
        startActivity(i);
    }
}
