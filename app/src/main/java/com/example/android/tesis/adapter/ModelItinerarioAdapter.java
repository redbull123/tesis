package com.example.android.tesis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.tesis.R;
import com.example.android.tesis.model.Itinerario;

import java.util.List;

import static android.R.attr.text;


/**
 * Created by rjsan on 5/13/2018.
 */

public class ModelItinerarioAdapter extends ArrayAdapter<Itinerario>{

    int conta=0;
    String num;
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


            TextView textOne = (TextView) listItemView.findViewById(R.id.route);

            textOne.setText(currentWork.getRutaId().getRuta());

            TextView textTwo = (TextView) listItemView.findViewById(R.id.ship);

            textTwo.setText(currentWork.getBarcoId().getNombre());


            TextView textThree = (TextView) listItemView.findViewById(R.id.date_ship);

            textThree.setText(currentWork.getFecha());

            TextView textFour = (TextView) listItemView.findViewById(R.id.time_ship);

            textFour.setText(currentWork.getTime());

        return listItemView;
    }
}
