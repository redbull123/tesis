package com.example.android.tesis.com.example.android.tesis.data.data.remote;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
/**
 * Created by rjsan on 7/9/2018.
 */

public interface APIService {

    @GET("/CustomerDB/webresources/entities.barco")
    Call<List<Barco>> getBarco();
}
