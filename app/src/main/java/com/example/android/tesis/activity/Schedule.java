package com.example.android.tesis.activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.android.tesis.adapter.CustomAdapter;
import com.example.android.tesis.R;
import com.example.android.tesis.model.Barco;
import com.example.android.tesis.my_interface.APIService;
import com.example.android.tesis.network.ApiUtils;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rjsan on 5/13/2018.
 */
public class Schedule extends AppCompatActivity {

  //  private ListView prueba;
    private List<Barco> listBarco = new ArrayList<Barco>();

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    private RecyclerView recyclerView;
    private APIService APIService;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_layout);



        progressDoalog = new ProgressDialog(Schedule.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        // new Peticion().execute();

        APIService = ApiUtils.getAPIService();

        Call<List<Barco>> lista = APIService.getBarco();

//        ArrayList<ModelItinerario> iti = new ArrayList<>();
//                    try {
//                for (Barco barco : lista.execute().body()){
//
//                    //listBarco.add(new Barco(barco.getNombre(),barco.getId()));
//                Log.e("Respuesta:    ", barco.getNombre()+ "  "+ barco.getId());
//                    TextView textOne = (TextView) findViewById(R.id.name);
//
//                    textOne.setText(barco.getNombre());
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }



        lista.enqueue(new Callback<List<Barco>>() {
            @Override
            public void onResponse(Call<List<Barco>> call, Response<List<Barco>> response) {
                if(response.isSuccessful()){
                     listBarco = response.body();
                }

            }
            @Override
            public void onFailure(Call<List<Barco>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(Schedule.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
