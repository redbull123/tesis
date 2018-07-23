package com.example.android.tesis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.android.tesis.R;
import com.example.android.tesis.activity.Schedule;
import com.example.android.tesis.model.Barco;
import com.example.android.tesis.model.Itinerario;
import com.example.android.tesis.model.Ruta;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by rjsan on 5/13/2018.
 */

public class ModelItinerarioAdapter extends ArrayAdapter<Itinerario>{


    public ModelItinerarioAdapter(Context scheduleClass, int resource, List<Itinerario> listItinerario) {

        super(scheduleClass, resource, listItinerario);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;

        if(listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.model_layout, parent, false);
        }

        Itinerario currentWork = getItem(position);

        TextView textOne = (TextView) listItemView.findViewById(R.id.name);

        textOne.setText(currentWork.getBarcoId().getNombre());


        TextView textTwo = (TextView) listItemView.findViewById(R.id.fecha);

        textTwo.setText(currentWork.getFecha());

        TextView textThree = (TextView) listItemView.findViewById(R.id.ruta);

        textThree.setText(currentWork.getRutaId().getRuta());


        TextView textFour = (TextView) listItemView.findViewById(R.id.time);

        textFour.setText(currentWork.getTime());


        return listItemView;
    }
}
