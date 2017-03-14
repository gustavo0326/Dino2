package com.arcos.dino.dino.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arcos.dino.dino.LoginActivity;
import com.arcos.dino.dino.R;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class AllGameActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private ImageView photo;
    private TextView mail,id,name;
    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_game);

        photo= (ImageView) findViewById(R.id.perfil);
        mail= (TextView) findViewById(R.id.mail);
        id= (TextView) findViewById(R.id.id);
        name= (TextView) findViewById(R.id.name);
        verToolbar("Mas Movimientos",false);


        GoogleSignInOptions options=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


        googleApiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,options)
                .build();
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

    @Override
    protected void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult> ini=Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if (ini.isDone()){
GoogleSignInResult result=ini.get();
            resultadosLogin(result);
        }else {
ini.setResultCallback(new ResultCallback<GoogleSignInResult>() {
    @Override
    public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
        resultadosLogin(googleSignInResult);
    }
});
        }

    }

    private void resultadosLogin(GoogleSignInResult result) {
        if (result.isSuccess()){
            GoogleSignInAccount cuenta=result.getSignInAccount();
            name.setText(cuenta.getDisplayName());
            mail.setText(cuenta.getEmail());
            id.setText(cuenta.getId());
            Glide.with(this).load(cuenta.getPhotoUrl()).into(photo);

        }else {
            sinDatos();

        }
    }

    private void sinDatos() {
        Intent i=new Intent(this, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    public void salir(View view) {
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                if (status.isSuccess()){
                    sinDatos();
                }else {
                    Toast.makeText(getApplicationContext(), "no se pudo cerrar sesion", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void revocar(View view) {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
