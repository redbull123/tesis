package com.example.android.tesis;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rjsan on 5/13/2018.
 */

public class ModelItinerarioAdapter extends ArrayAdapter<ModelItinerario>{


    public ModelItinerarioAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ModelItinerario> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.model_layout, parent, false);
        }

        ModelItinerario currentWork = getItem(position);

        TextView textOne = (TextView) convertView.findViewById(R.id.route);

        textOne.setText(currentWork.getRoute());

        TextView textTwo = (TextView) convertView.findViewById(R.id.day);

        textTwo.setText(currentWork.getDay());

        TextView textThree = (TextView) convertView.findViewById(R.id.puestos);

        textThree.setText(currentWork.getPuesto());

        TextView textFour = (TextView) convertView.findViewById(R.id.schedule);

        textFour.setText(currentWork.getSchedule());

        return listItemView;
    }
}
