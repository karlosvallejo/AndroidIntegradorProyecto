package com.example.a1107513806.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActividadPedir extends AppCompatActivity {

    float precioTotal;
    TextView total;
    String nombreUsuario;
    Button pedir;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_pedir);
        Intent intent = getIntent();
       precioTotal= intent.getFloatExtra("precioTotal",0);
        nombreUsuario= intent.getStringExtra("nombreUsuario");
        total= (TextView) findViewById(R.id.totalPrecio);
        total.setText(String.valueOf(precioTotal));
        pedir= (Button) findViewById(R.id.botonPedir);
        pedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Pedido Realizado",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
