package com.example.a1107513806.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ListaArticulos extends AppCompatActivity {
    String nombreUsuario;
    Categoria cat;
    Item articuloUno;
    Item articuloDos;
    Item articuloTres;
    Item articuloCuatro;
    Button artOne;
    Button artTwo;
    Button artThree;
    Button artFor;
    TextView nombresito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_articulos);
        Intent intent = getIntent();
        cat=(Categoria) intent.getSerializableExtra("categoriaEscogida");
        nombresito= (TextView) findViewById(R.id.nombrin);
        nombreUsuario= intent.getStringExtra("nombreUsuario");
        nombresito.setText(nombreUsuario);
        articuloUno=cat.itemsLista.get(0);
        articuloDos=cat.itemsLista.get(1);
        articuloTres=cat.itemsLista.get(2);
        articuloCuatro=cat.itemsLista.get(3);
        artOne= (Button) findViewById(R.id.artUno);
        artOne.setText(articuloUno.nombre);
        artTwo= (Button) findViewById(R.id.artDos);
        artTwo.setText(articuloDos.nombre);
        artThree= (Button) findViewById(R.id.artTres);
        artThree.setText(articuloTres.nombre);
        artFor= (Button) findViewById(R.id.artCuatro);
        artFor.setText(articuloCuatro.nombre);
    }
}
