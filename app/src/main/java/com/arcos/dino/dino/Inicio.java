package com.arcos.dino.dino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }


    public void cambiar(View view) {
        Intent i=new Intent(Inicio.this,LoginActivity.class);
        startActivity(i);
    }
}
