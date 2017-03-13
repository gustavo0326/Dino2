package com.arcos.dino.dino;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.arcos.dino.dino.view.AllGameActivity;
import com.arcos.dino.dino.view.ContainerActivity;
import com.arcos.dino.dino.view.CrearCuenta;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
private GoogleApiClient googleApiClient;
    private SignInButton loginGoogleBtn;
    public static final int codigoLogin=777;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //objeto de opciones para obtener los datos
        GoogleSignInOptions options=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


        //autenticacion
        googleApiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,options)
                .build();
        loginGoogleBtn =(SignInButton)findViewById(R.id.googleBtn);
        loginGoogleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,codigoLogin);
            }
        });
    }

    public void crearCuenta(View view){
        Intent intent=new Intent(LoginActivity.this, CrearCuenta.class);
        startActivity(intent);

    }

    public void bottom(View view) {
        Intent intent=new Intent(LoginActivity.this, ContainerActivity.class);
        startActivity(intent);
    }
//metodo que valiidad si la conexion falla
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    //metodo llegan los resultados
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==codigoLogin){
            //selector o inicio de session
           GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            //despues de obtener el resultado se lo enviamos a otro metodo
            datosLogin(result);
        }
    }

    private void datosLogin(GoogleSignInResult result) {
        //verifica si la operacion es exitosa
        if (result.isSuccess()){
            //abrimos la activity donde mostrar los datos
            showData();

        }else {
            Toast.makeText(this, "No fue posible iniciar session", Toast.LENGTH_SHORT).show();
        }
    }

    private void showData() {
        //inicia la actividad con loas banderas
        Intent intent=new Intent(this,AllGameActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
