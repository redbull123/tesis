package com.example.android.tesis;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.android.tesis.com.example.android.tesis.data.data.remote.APIService;
import com.example.android.tesis.com.example.android.tesis.data.data.remote.Barco;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by rjsan on 5/13/2018.
 */
public class Schedule extends AppCompatActivity{
    private final String baseUrl = "http://192.168.1.3:8080/";
    private ListView prueba;
    private List<Barco> listBarco = new ArrayList<Barco>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_layout);
        prueba = (ListView) findViewById(R.id.list);


        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);

        Call<List<Barco>> lista = apiService.getBarco();

        lista.enqueue(new Callback<List<Barco>>() {
            @Override
            public void onResponse(Call<List<Barco>> call, Response<List<Barco>> response) {
                if(response.isSuccessful()){
                    listBarco = response.body();
                }
            }
            @Override
            public void onFailure(Call<List<Barco>> call, Throwable t) {
            }
        });

        ModelItinerarioAdapter adapter = new ModelItinerarioAdapter(this, 0, listBarco);
        prueba.setAdapter(adapter);
    }


}
