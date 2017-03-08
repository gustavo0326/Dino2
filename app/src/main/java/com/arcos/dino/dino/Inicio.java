package com.arcos.dino.dino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        gif=(GifImageView)findViewById(R.id.gifanime);

        try {
            InputStream inputStream=getAssets().open("dino_mov_cab.gif");
            byte[] bytes= IOUtils.toByteArray(inputStream);
            gif.setBytes(bytes);
            gif.startAnimation();

        }catch (IOException e){

        }


    }




    public void cambiar(View view) {
        Intent i=new Intent(Inicio.this,LoginActivity.class);
        startActivity(i);
    }
}
