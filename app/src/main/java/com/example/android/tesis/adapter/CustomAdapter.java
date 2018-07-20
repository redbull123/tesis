package com.example.android.tesis.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.tesis.R;
import com.example.android.tesis.model.Barco;
//import com.jakewharton.picasso.OkHttp3Downloader;
//import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rjsan on 7/14/2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Barco> dataList;
    //private Context context;

    public CustomAdapter(/*Context context*/List<Barco> dataList){
        //this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;

        CustomViewHolder(View itemView) {
            super(itemView);

            txtTitle = (TextView) itemView.findViewById(R.id.name);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.model_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        holder.txtTitle.setText(dataList.get(position).getNombre());

      /*  Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));*/

      /*  builder.build().load(dataList.get(position).getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);*/

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}