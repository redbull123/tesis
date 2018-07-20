package com.example.android.tesis.my_interface;

import com.example.android.tesis.model.Barco;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by rjsan on 7/9/2018.
 */

public interface APIService {

    @GET("/ConferryTesisWebApp/webresources/org.tesis.model.barco")
    Call<List<Barco>> doGetBarcosList();
}
