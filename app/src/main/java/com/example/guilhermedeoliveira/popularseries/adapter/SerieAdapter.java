package com.example.guilhermedeoliveira.popularseries.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guilhermedeoliveira.popularseries.R;
import com.example.guilhermedeoliveira.popularseries.model.Serie;

import java.util.List;

/**
 * Created by guilhermeoliveira on 10/10/16.
 */

public class SerieAdapter extends RecyclerView.Adapter<SerieAdapter.ViewHolder> {

    List<Serie> mSerieList;

    public SerieAdapter(List<Serie> series) {
        this.mSerieList = series;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(mSerieList.get(position).getTitle());
        holder.year.setText(mSerieList.get(position).getYear());
    }


    @Override
    public int getItemCount() {
        return mSerieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView year;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            year = (TextView) itemView.findViewById(R.id.year);
        }
    }
}
