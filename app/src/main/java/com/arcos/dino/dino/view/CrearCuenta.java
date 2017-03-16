package com.arcos.dino.dino.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.arcos.dino.dino.R;

public class CrearCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        verToolbar("Crear Cuenta",true);
    }
//creamos metodo para el toolbar que nos permita reutilizarlo 1
    public void verToolbar(String titlle,boolean botonRegreso ){
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        //damos soporte a versiones anteriores a api19
        setSupportActionBar(toolbar);
        //para el titulo
        getSupportActionBar().setTitle(titlle);
        //para el boton de regreso
        getSupportActionBar().setDisplayHomeAsUpEnabled(botonRegreso);
    }

    public void enviar(View view) {
        Intent i=new Intent(CrearCuenta.this,ContainerActivity.class);
        startActivity(i);
    }
}
