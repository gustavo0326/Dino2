package com.arcos.dino.dino.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.arcos.dino.dino.R;

public class CrearCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        verToolbar(getResources().getString(R.string.crear_toolbar),true);
    }
//creamos metodo para el toolbar que nos permita reutilizarlo
    public void verToolbar(String titlle,boolean botonRegreso ){
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        //damos soporte a versiones anteriores a api19
        setSupportActionBar(toolbar);
        //para el titulo
        getSupportActionBar().setTitle(titlle);
        //para el boton de regreso
        getSupportActionBar().setDisplayHomeAsUpEnabled(botonRegreso);



    }
}
