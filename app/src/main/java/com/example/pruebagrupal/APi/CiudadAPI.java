package com.example.pruebagrupal.APi;

import com.example.pruebagrupal.Model.Ciudad;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CiudadAPI {
    //    ciudades
    @GET("/ciudades")
    Call<Ciudad> getCiudades(@Path("ciudades") String municipio);

    @GET("/ciudades/{id}")
    Call<ArrayList<Ciudad>> getCiudadeByid(@Path("id") int id);

    @GET("/ciudades/porEstado/{idEstado}")
    Call<ArrayList<Ciudad>> getCiudadesByEstado(@Path("idEstado") int idEstado);

}
