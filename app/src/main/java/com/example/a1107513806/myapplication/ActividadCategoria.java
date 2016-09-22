package com.example.a1107513806.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActividadCategoria extends AppCompatActivity {

    TextView nombreUsi;
    Button catOne;
    Button catTwo;
    Categoria catUno;
    Categoria catDos;
    String nombreUsuario;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_categoria);
        nombreUsi=(TextView) findViewById(R.id.NombreUsuario);
        catOne=(Button) findViewById(R.id.BotonCatRopa);
        catTwo=(Button) findViewById(R.id.lacomida);
        Intent intent = getIntent();
        nombreUsuario= intent.getStringExtra("nombreUsuario");
        nombreUsi.setText(nombreUsuario);
        catUno =(Categoria) intent.getSerializableExtra("catUno");
        catDos =(Categoria) intent.getSerializableExtra("catDos");
        catOne.setText(catUno.nombreCategoria);
        System.out.println(catDos.nombreCategoria);
        catTwo.setText(catDos.nombreCategoria);

        catOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(ActividadCategoria.this, ListaArticulos.class);
                myIntent.putExtra("nombreUsuario", nombreUsuario);
                myIntent.putExtra("categoriaEscogida", catUno);

                ActividadCategoria.this.startActivity(myIntent);
            }
        });

        catTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(ActividadCategoria.this, ListaArticulos.class);
                myIntent.putExtra("nombreUsuario", nombreUsuario);
                myIntent.putExtra("categoriaEscogida", catDos);

                ActividadCategoria.this.startActivity(myIntent);
            }
        });

    }
}
