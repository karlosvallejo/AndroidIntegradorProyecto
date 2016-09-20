package com.example.a1107513806.myapplication;

import android.widget.EditText;

import java.io.Serializable;

public class Usuario implements Serializable{
    String nombre;
    String contrasena;
    String email;
    boolean esRegistro;
    public Usuario(String nombre, String contrasena, boolean registro){
        this.nombre=nombre;
        this.contrasena=contrasena;
        this.esRegistro=registro;
    }

    public Usuario(String nombre, String contrasena, String email, boolean registro){
        this.nombre=nombre;
        this.contrasena=contrasena;
        this.email=email;
        this.esRegistro=registro;
    }


}
