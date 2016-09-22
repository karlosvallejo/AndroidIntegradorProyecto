package com.example.a1107513806.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    Button continu;
    TextView nombresito;
    float precioTotal;
    float precioCadaArticulo[];
    EditText valores[];
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
        continu= (Button) findViewById(R.id.botonContinuar);
        valores= new EditText[4];
      precioCadaArticulo= new float[4];
            valores[0]=(EditText) findViewById(R.id.cantidadPedidos1);
        valores[1]=(EditText) findViewById(R.id.cantidadPedidos2);
        valores[2]=(EditText) findViewById(R.id.cantidadPedidos3);
        valores[3]=(EditText) findViewById(R.id.cantidadPedidos4);
        continu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ListaArticulos.this, ActividadPedir.class);
                for (int i=0; i<4;i++){
                  precioCadaArticulo[i]= cat.itemsLista.get(i).precio * Integer.parseInt(valores[i].getText().toString());


                }
                precioTotal= precioCadaArticulo[0] + precioCadaArticulo[1] + precioCadaArticulo[2] + precioCadaArticulo[3];
                myIntent.putExtra("nombreUsuario", nombreUsuario);
                myIntent.putExtra("precioTotal", precioTotal);
                ListaArticulos.this.startActivity(myIntent);
            }
        });
    }
}
