package com.example.android.tesis.my_interface;

import com.example.android.tesis.model.Barco;
import com.example.android.tesis.model.Boleto;
import com.example.android.tesis.model.Itinerario;
import com.example.android.tesis.model.Pasajero;
import com.example.android.tesis.model.Ruta;
import com.example.android.tesis.model.TipoBoleto;
import com.example.android.tesis.model.Usuario;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


/**
 * Created by rjsan on 7/9/2018.
 */

public interface APIService {

    @GET("/Tesis1.0/webresources/barco")
    Call<List<Barco>> doGetBarcosList();

    @GET("/Tesis1.0/webresources/itinerario")
    Call<List<Itinerario>> doGetItinerariosList();

    @GET("/Tesis1.0/webresources/pasajero")
    Call<List<Pasajero>> doGetPasajerosList();

    @GET("/Tesis1.0/webresources/ruta")
    Call<List<Ruta>> doGetRutasList();

    @GET("/Tesis1.0/webresources/boleta")
    Call<List<Boleto>> doGetBoletasList();

    @GET("/Tesis1.0/webresources/usuario")
    Call<List<Usuario>> doGetUsuariosList();

    @POST("/Tesis1.0/webresources/usuario")
    Call<Usuario> doSetUsuariosList(@Body Usuario user);

    @GET("/Tesis1.0/webresources/tipoboleto")
    Call<List<TipoBoleto>> doGetTipoBoletoList();

}
