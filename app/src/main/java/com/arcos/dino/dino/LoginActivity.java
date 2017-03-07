package com.arcos.dino.dino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.arcos.dino.dino.view.CrearCuenta;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void crearCuenta(View view){
        Intent intent=new Intent(LoginActivity.this, CrearCuenta.class);
        startActivity(intent);

    }
}
