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
import android.widget.Toast;

import java.util.ArrayList;
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
    Categoria catUno;
    Categoria catDos;

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


    public void update(Observable observed, Object data) {
	//interpreto el objeto que llego


if(data instanceof Categoria){
    //asigno el objeto que llego a uno tipo Categoria
    Categoria c= (Categoria) data;
    //Si el objeto Categoria es del numero 1, lo asigno a su respectiva referencia
    if (c.numeroCategoria==1) {
      //  catUno = (Categoria) data;
    }
    //Si el objeto Categoria es del numero 2, lo asigno a su respectiva referencia
    if (c.numeroCategoria==1) {
      //  catDos = (Categoria) data;
    }

}

            if(data instanceof String){

                if(((String) data).equalsIgnoreCase("AprobadoLogin")){

//SIMULO QUE el servidor me mando las categorias, aun pendiente
                     String itemsUno[]=new String[4];
                    float[] itemsUnoPrecio= new float[4];
                      itemsUnoPrecio[0]=10000;
                    itemsUnoPrecio[1]=5000;
                    itemsUnoPrecio[2]=2000;
                    itemsUnoPrecio[3]=20000;
                    String itemsDos[] = new String[4];
                    float[] itemsDosPrecio= new float[4];
                    itemsDosPrecio[0]=10000;
                    itemsDosPrecio[1]=5000;
                    itemsDosPrecio[2]=2000;
                    itemsDosPrecio[3]=20000;
                    itemsUno[0]= "Camiseta";
                    itemsUno[1]="Zapatos";
                    itemsUno[2]="Pantalon";
                    itemsUno[3]="Gafas";
                    itemsDos[0]= "Perro Caliente";
                    itemsDos[1]="Café";
                    itemsDos[2]="Pizza";
                    itemsDos[3]="Empanadas";
                    catUno= new Categoria(1, "Ropa",itemsUno, itemsUnoPrecio);
                    catDos= new Categoria(2,"Comida", itemsDos, itemsDosPrecio);
//lanzar otra actividad
                    Intent myIntent = new Intent(Login.this, ActividadCategoria.class);
                    myIntent.putExtra("nombreUsuario", getNombre);
                    myIntent.putExtra("catUno", catUno);
                    myIntent.putExtra("catDos", catDos);
                    Login.this.startActivity(myIntent);
                }else if(((String) data).equalsIgnoreCase("NoAprobadoLogin")){
                //    notificar que el usuario no es valido o no esta registrado
                    new Thread() {
                        public void run() {


                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrectos",Toast.LENGTH_SHORT);
                                    toast.show();


                                }
                            });



                        }
                    }.start();
                }




            }









    }
}
