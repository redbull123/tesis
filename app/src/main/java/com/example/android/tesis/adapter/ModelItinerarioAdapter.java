package com.example.android.tesis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.tesis.R;
import com.example.android.tesis.model.Barco;

import java.util.List;

/**
 * Created by rjsan on 5/13/2018.
 */

public class ModelItinerarioAdapter extends ArrayAdapter<Barco>{




    public ModelItinerarioAdapter(Context scheduleClass, int resource, List<Barco> listBarco) {
        super(scheduleClass, resource, listBarco);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){


        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.model_layout, parent, false);
        }

        Barco currentWork = getItem(position);

        TextView textOne = (TextView) listItemView.findViewById(R.id.name);

        textOne.setText(currentWork.getNombre());


        return listItemView;
    }
}
