package com.example.pruebagrupal.APi;


import com.example.pruebagrupal.Model.Estado;
import com.example.pruebagrupal.Model.EstadoList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EstadoAPI {
    //    Estados
        @GET("/estados")
        Call<EstadoList> getAllEstados();

        @GET("/estados/{id}")
        Call<Estado> getEstado(@Path("estado") String estado);
}
