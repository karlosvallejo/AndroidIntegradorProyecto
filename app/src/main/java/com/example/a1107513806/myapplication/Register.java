package com.example.a1107513806.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nombre = (EditText) findViewById(R.id.username);
        contrase = (EditText) findViewById(R.id.contra);
        email = (EditText) findViewById(R.id.email);
        regis = (Button) findViewById(R.id.Registrar);

        regis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String name = nombre.getText().toString();
                String correo = email.getText().toString();
                String contrasena = contrase.getText().toString();
                Usuario usuario = new Usuario(name,contrasena);

                }
        }
    }




            @Override
    public void update(Observable observable, Object data) {

    }
}
