package com.example.android.tesis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.tesis.com.example.android.tesis.data.data.remote.APIService;
import com.example.android.tesis.com.example.android.tesis.data.data.remote.Barco;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjsan on 7/5/2018.
 */

public class Login extends AppCompatActivity {

    private final String baseUrl = "http://192.168.1.3:8080/";
    private APIService mAPIService;
    List<Barco> listBarco = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

       /* Retrofit retrofit = null;
        retrofit = getClient(baseUrl);

        APIService apiService = retrofit.create(APIService.class);

        Call<List<Barco>> lista = apiService.getBarco();

        lista.enqueue(new Callback<List<Barco>>() {
            @Override
            public void onResponse(Call<List<Barco>> call, Response<List<Barco>> response) {
                if(response.isSuccessful()){
                listBarco = response.body();}
            }

            @Override
            public void onFailure(Call<List<Barco>> call, Throwable t) {

            }
        });
*/

    }
}
