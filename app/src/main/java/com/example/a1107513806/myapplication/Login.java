package com.example.a1107513806.myapplication;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;
import java.util.UUID;

public class Login extends AppCompatActivity implements Observer {

    EditText nombre;
    EditText contrasena;
    Button iniciarSesion;
    Button registro;
    String ipServidor;
    String getNombre;
    String getContrasena;
    Usuario user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        nombre= (EditText) findViewById(R.id.name);
        contrasena = (EditText) findViewById(R.id.contra);
        iniciarSesion= (Button) findViewById(R.id.BotonIniciarSesion);
        registro= (Button) findViewById(R.id.BotonRegistro);
        Intent intent = getIntent();
        ipServidor = intent.getStringExtra("ipeson");
        SerializameEsta.getInstance(ipServidor).addObserver(this);

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

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Login.this, Register.class);
                myIntent.putExtra("ipeson", ipServidor);
                Login.this.startActivity(myIntent);
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
//envia el objeto usuario cuando se da click en login
        iniciarSesion.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                getNombre=nombre.getText().toString();
                getContrasena=contrasena.getText().toString();
                System.out.println(getNombre);
                System.out.println(getContrasena);
                user= new Usuario(getNombre,getContrasena,false);
                System.out.println("enviado login a: "+ipServidor);
                SerializameEsta.getInstance(ipServidor).enviar(user);

            }
        });





    }

    @Override
    public void update(Observable observable, Object data) {

    }
}
