package com.example.pruebagrupal.APi;
import com.example.pruebagrupal.Model.UsuarioModel;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.POST;

public interface LoginAPI {

//  Login
    @POST("/auth/login")
    Call<UsuarioModel> login(@Body String usuario, @Body String contrasenia);

}
