package com.allan.teamwork.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.allan.teamwork.R;
import com.allan.teamwork.data.models.PhotoResponse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class PhotoRecyclerAdapter extends RecyclerView.Adapter<PhotoRecyclerAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<PhotoResponse> data = Collections.emptyList();

    public PhotoRecyclerAdapter(Context context, List<PhotoResponse> data){
        inflater  = LayoutInflater.from(context);
        this.data = data;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.photo_row_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PhotoResponse current = data.get(position);
        holder.id.setText("ID: " + current.getId());
        holder.title.setText("Title: " + current.getTitle());
        URL url = null;
        try {
            url = new URL(current.getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            holder.thumbnail.setImageBitmap(bmp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id, title;
        ImageView thumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.album_id);
            title = itemView.findViewById(R.id.title);
            thumbnail = itemView.findViewById(R.id.image);
        }
    }
}
