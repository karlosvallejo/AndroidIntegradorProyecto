package com.example.a1107513806.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by sky_k on 20/09/2016.
 */
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    int numeroCategoria;
    String nombreCategoria;
    ArrayList<Item> itemsLista;

    public Categoria(int numeroCat, String nombre, ArrayList<Item> articulos){
        this.numeroCategoria=numeroCat;
        this.nombreCategoria=nombre;
        this.itemsLista=articulos;
        this.itemsLista=articulos;
    }

}
