package com.arcos.dino.dino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class Inicio extends AppCompatActivity {

    private GifImageView gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        verToolbar("Bienvenido",false);

        gif=(GifImageView)findViewById(R.id.gifanime);

        try {
            InputStream inputStream=getAssets().open("dino_mov_cab.gif");
            byte[] bytes= IOUtils.toByteArray(inputStream);
            gif.setBytes(bytes);
            gif.startAnimation();

        }catch (IOException e){

        }


    }

    public void verToolbar(String titlle,boolean botonRegreso ){
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        //damos soporte a versiones anteriores a api19
        setSupportActionBar(toolbar);
        //para el titulo
        getSupportActionBar().setTitle(titlle);
        //para el boton de regreso
       getSupportActionBar().setDisplayHomeAsUpEnabled(botonRegreso);
    }


    public void cambiar(View view) {
        Intent i=new Intent(Inicio.this,LoginActivity.class);
        startActivity(i);
    }
}
