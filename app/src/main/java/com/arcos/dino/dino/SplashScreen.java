package com.arcos.dino.dino;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class SplashScreen extends Activity {

    private GifImageView gif;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        gif=(GifImageView)findViewById(R.id.gifanime);
        progressBar=(ProgressBar)findViewById(R.id.progresbar);
        progressBar.setVisibility(progressBar.VISIBLE);

        try {
            InputStream inputStream=getAssets().open("hua.gif");
            byte[] bytes= IOUtils.toByteArray(inputStream);
            gif.setBytes(bytes);
            gif.startAnimation();

        }catch (IOException e){

        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(SplashScreen.this,Inicio.class);
                startActivity(i);
            }
        },3500);

    }
}
