package com.example.a1107513806.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by sebas on 18/9/16.
 */
public class Register extends AppCompatActivity implements Observer {

   private EditText nombre;
    private EditText contrase;
    private EditText email;
    private Button regis;
    private String ipServidor;
    private String getNombre;
    private String getContrasena;
    private String getEmail;
    private Usuario user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Intent intente = getIntent();
        SerializameEsta.getInstance(ipServidor).addObserver(this);
        ipServidor = intente.getStringExtra("ipeson");
        nombre = (EditText) findViewById(R.id.username);
        contrase = (EditText) findViewById(R.id.contra);
        email = (EditText) findViewById(R.id.email);
        regis = (Button) findViewById(R.id.Registrar);

        if(nombre.getText().toString().equalsIgnoreCase("nombre")) {
            nombre.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    nombre.setText("");

                }
            });

        }


        nombre.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent evente) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    System.out.println("hecho");
                    getNombre=nombre.getText().toString();
                    System.out.println(getNombre);
                    return false;
                }


                return true;
            }
        });

        regis.setOnClickListener(new View.OnClickListener(){
                                     @Override
                                     public void onClick(View view) {
                                         getNombre=nombre.getText().toString();
                                         getContrasena=contrase.getText().toString();
                                         getEmail=email.getText().toString();

                                         user= new Usuario(getNombre,getContrasena,getEmail,true);
                                         SerializameEsta.getInstance(ipServidor).enviar(user);

                                     }


                                 });

        contrase.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    System.out.println("hecho");
                    getContrasena=contrase.getText().toString();
                    System.out.println(getContrasena);

                    return false;
                }


                return true;
            }
        });

        email.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){

                    getEmail=email.getText().toString();


                    return false;
                }


                return true;
            }
        });

    }




    @Override
    public void update(Observable observable, Object data) {

    }
}





