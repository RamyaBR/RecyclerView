package com.example.recyclerviewexample.UI;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerviewexample.Data.Movies;
import com.example.recyclerviewexample.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Movies> mDataSet;
    private Context context;
    public CustomAdapter(List<Movies> dataSet, Context activity) {
        mDataSet = dataSet;
        context = activity;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        var movies= mDataSet.get(position);
        holder.title.setText(movies.Title);
        holder.director.setText(movies.Director);
       Glide.with(context)
                .load(movies.Poster)
                .placeholder(R.drawable.ic_launcher_background) // Optional: Placeholder image
                .error(R.drawable.ic_launcher_background)             // Optional: Error image
                .into(holder.logo);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView title;
        private final TextView director;
        private final ImageView logo;

        public ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.texttitle);
            director = v.findViewById(R.id.textsubtitle);
            logo = v.findViewById(R.id.imglogo);
        }
    }
}
