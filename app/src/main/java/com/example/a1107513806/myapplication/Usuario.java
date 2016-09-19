package com.example.a1107513806.myapplication;

import android.widget.EditText;

import java.io.Serializable;

public class Usuario implements Serializable{
    String nombre;
    String contrasena;

    public Usuario(String nombre, String contrasena){
        this.nombre=nombre;
        this.contrasena=contrasena;
    }


}
