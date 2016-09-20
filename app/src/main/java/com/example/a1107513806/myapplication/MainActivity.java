package com.example.a1107513806.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText ip;
    String ipServidor;
    InetAddress i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ip= (EditText) findViewById (R.id.editText);
if(ip.getText().toString().equalsIgnoreCase("Ip del host")) {
    ip.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ip.setText("");

        }
    });
}
        ip.addTextChangedListener(new TextWatcher() {
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void beforeTextChanged(CharSequence s,int start,int count,int after) {}

            private String mPreviousText = "";
            @Override
            public void afterTextChanged(Editable s) {
                if(PARTIAl_IP_ADDRESS.matcher(s).matches()) {
                    mPreviousText = s.toString();
                } else {
                    s.replace(0, s.length(), mPreviousText);
                }
            }
        });


        ip.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    System.out.println("hecho");
                    ipServidor=ip.getText().toString();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {

                                i= InetAddress.getByName(ipServidor);
                                if(i.isReachable(300)) {
                                    Intent myIntent = new Intent(MainActivity.this, Login.class);
                                    myIntent.putExtra("ipeson", ipServidor); //Optional parameters
                                    MainActivity.this.startActivity(myIntent);


                                }else{
                                    new Thread() {
                                        public void run() {


                                            runOnUiThread(new Runnable() {

                                                @Override
                                                public void run() {
                                                    Toast toast = Toast.makeText(getApplicationContext(), "servidor no encontrado",Toast.LENGTH_SHORT);
                                                    toast.show();
                                                }
                                            });



                                        }
                                    }.start();

                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                new Thread() {
                                    public void run() {


                                                runOnUiThread(new Runnable() {

                                                    @Override
                                                    public void run() {
                                                        Toast toast = Toast.makeText(getApplicationContext(), "servidor no encontrado",Toast.LENGTH_SHORT);
                                                        toast.show();
                                                    }
                                                });



                                    }
                                }.start();


                            }
                        }
                    }).start();



                    return true;

                }


                return true;
            }
        });


    }

    private static final Pattern PARTIAl_IP_ADDRESS =
            Pattern.compile("^((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])\\.){0,3}"+
                    "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])){0,1}$");



}
