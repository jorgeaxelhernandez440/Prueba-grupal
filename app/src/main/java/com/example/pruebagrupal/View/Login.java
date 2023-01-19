package com.example.pruebagrupal.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pruebagrupal.APi.API;
import com.example.pruebagrupal.APi.LoginAPI;
import com.example.pruebagrupal.MapsActivity;
import com.example.pruebagrupal.Model.UsuarioModel;
import com.example.pruebagrupal.R;
import com.example.pruebagrupal.SharedPref.SharedPrefManager;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity {

    EditText txtUsuario, txtContrasenia;
    Button btnLogin;
    Retrofit retrofit;
    API api;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login);


    api = new API();
    retrofit = api.createService();

    btnLogin.setOnClickListener(view -> {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setCorreo(txtUsuario.getText().toString());
        usuario.setContrasenia(txtContrasenia.getText().toString());
        verificarUsuario(usuario);

        System.out.println(usuario.getUsuario_id());
    });

    }
    public void verificarUsuario (UsuarioModel u) {

        LoginAPI Usuario = retrofit.create(LoginAPI.class);
        Call<UsuarioModel> call = Usuario.login(u.getUsuario(),u.getContrasenia());
        call.enqueue(new Callback<UsuarioModel>() {

            @Override
            public void onResponse(Call<UsuarioModel> call, Response<UsuarioModel> response) {
                try {
                    if (response.isSuccessful() && response.body().getUsuario_id() != 0) {
                        SharedPrefManager.getInstance(getApplicationContext()).guardarUsuario(response.body());
                       Intent login = new Intent(Login.this, MapsActivity.class);
                       startActivity(login);
                    } else {
                        new SweetAlertDialog(Login.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("ERROR")
                                .setContentText("Datos Incorrectos")
                                .show();
                        System.out.println(response.body() + " - " + response.code());
                    }
                } catch (Exception ex) {
                    new SweetAlertDialog(Login.this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("ERROR")
                            .setContentText("Datos Incorrectos")
                            .show();
                    System.out.println("ID: " + response.body() + "CODE: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<UsuarioModel> call, Throwable t) {
                new SweetAlertDialog(Login.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("ERROR")
                        .setContentText("Error de ConexiÃ³n")
                        .show();

            }
        });
    }



}
