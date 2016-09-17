package com.example.a1107513806.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    EditText nombre;
    EditText contrasena;
    Button iniciarSesion;
    Button registro;
    String ipServidor;
    String getNombre;
    String getContrasena;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        nombre= (EditText) findViewById(R.id.name);
        contrasena = (EditText) findViewById(R.id.contra);
        iniciarSesion= (Button) findViewById(R.id.BotonIniciarSesion);
        registro= (Button) findViewById(R.id.BotonRegistro);
        Intent intent = getIntent();
        ipServidor = intent.getStringExtra("ipeson");

        if(nombre.getText().toString().equalsIgnoreCase("nombre")) {
            nombre.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    nombre.setText("");

                }
            });

        }

        nombre.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    System.out.println("hecho");
                    getNombre=nombre.getText().toString();
                    System.out.println(getNombre);
                    return false;
                }


                return true;
            }
        });

        contrasena.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    System.out.println("hecho");
                    getContrasena=contrasena.getText().toString();
                    System.out.println(getContrasena);

                    return false;
                }


                return true;
            }
        });
//aqui lo que pasa cuando se da iniciar sesion (crear un objeto Usuario)(serializar y enviar mediante comununicacion)
        iniciarSesion.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                getNombre=nombre.getText().toString();
                getContrasena=contrasena.getText().toString();
                System.out.println(getNombre);
                System.out.println(getContrasena);
            }
        });





    }
}
