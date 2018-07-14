package com.example.android.tesis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by rjsan on 5/13/2018.
 */

public class Schedule extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_layout);

        ListView prueba = (ListView) findViewById(R.id.list);

        ArrayList<ModelItinerario> itinerarios = new ArrayList<ModelItinerario>();
        itinerarios.add(new ModelItinerario("Catia la mar - Margarita", "15/05/2018", 30, "15:30"));
        itinerarios.add(new ModelItinerario("Margarita - Catia la mar", "15/05/2018", 50, "17:30"));
        itinerarios.add(new ModelItinerario("Catia la mar - Margarita", "16/05/2018", 20, "17:30"));
        itinerarios.add(new ModelItinerario("Catia la mar - Margarita", "16/05/2018", 60, "20:30"));

        ModelItinerarioAdapter adapter = new ModelItinerarioAdapter(this, 0, itinerarios);

        prueba.setAdapter(adapter);

    }


}
