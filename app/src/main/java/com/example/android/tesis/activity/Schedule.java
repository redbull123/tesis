package com.example.android.tesis.activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.tesis.adapter.CustomAdapter;
import com.example.android.tesis.R;
import com.example.android.tesis.adapter.ModelItinerarioAdapter;
import com.example.android.tesis.model.Barco;
import com.example.android.tesis.my_interface.APIService;
import com.example.android.tesis.network.ApiUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rjsan on 5/13/2018.
 */
public class Schedule extends AppCompatActivity {

    private ListView prueba;
    private List<Barco> listBarco = new ArrayList<Barco>();
    private static APIService APIService;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_layout);


        new Peticion().execute();




//
//       / lista.enqueue(new Callback<List<Barco>>() {
//            @Override
//            public void onResponse(Call<List<Barco>> call, Response<List<Barco>> response) {
//                if(response.isSuccessful()){
//                    Toast.makeText(Schedule.this, "Succesfull!", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//            @Override
//            public void onFailure(Call<List<Barco>> call, Throwable t) {
//                Toast.makeText(Schedule.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }


    public static class Peticion extends AsyncTask<Void, Void, Void>{


        @Override
        protected Void doInBackground(Void... params) {
            APIService = ApiUtils.getAPIService();

            Call<List<Barco>> lista = APIService.getBarco();

            try {
                for(Barco barco : lista.execute().body()){
                    Log.e("Respuesta : ", barco.getId()+"  "+ barco.getNombre());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }


}
