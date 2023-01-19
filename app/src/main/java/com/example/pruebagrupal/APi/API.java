package com.example.pruebagrupal.APi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    public  Retrofit retrofit;

    // Creacion de retrofit
    public  Retrofit createService(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://prueba-backend-node-production.up.railway.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
