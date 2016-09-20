package com.example.a1107513806.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ActividadCategoria extends AppCompatActivity {

    TextView nombreUsuario;
    Button catOne;
    Button catTwo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_categoria);
        nombreUsuario=(TextView) findViewById(R.id.NombreUsuario);
        catOne=(Button) findViewById(R.id.BotonCatRopa);
        catTwo=(Button) findViewById(R.id.BotonCatComida);
        Intent intent = getIntent();
        nombreUsuario.setText(intent.getStringExtra("nombreUsuario"));
        catOne.setText(intent.getStringExtra("nombreCat1"));
        catTwo.setText(intent.getStringExtra("nombreCat2"));

    }
}
