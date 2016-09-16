package com.example.a1107513806.myapplication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;


public class SerializameEsta  extends Thread  {
    private DatagramSocket ds;
    private InetAddress ipServer;
    String server;
    private ArrayList<Usuario> mensajes;
    private int myId;
    private boolean identificado;
    public SerializameEsta() {
        this.mensajes = new ArrayList<Usuario>();
        try {
            ipServer = InetAddress.getByName(server);
            ds = new DatagramSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        while (true) {
            recibir();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private byte[] serializar(Object m){

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(m);
            oos.flush();
            oos.close();
            return baos.toByteArray();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }


    private Object deserializar(byte[] data) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object aux =  ois.readObject();
            return aux;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void recibir() {
        try {
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            ds.receive(dp);
            Object recibido = deserializar(dp.getData());
/*if(recibido instanceof Categoria){
    //TODO hacer algo con la categoria
}*/

            if(recibido instanceof String){

            }






        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void enviar(Object m) {
        try {
            byte[] datos = serializar(m);
            DatagramPacket paq = new DatagramPacket(datos, datos.length, ipServer, 5000);
            ds.send(paq);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




//ignorar por ahora
    public ArrayList<Usuario> getMensajes() {
        return this.mensajes;
    }

}
