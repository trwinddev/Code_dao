package com.example.mediaplayer.ui.song;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mediaplayer.R;
import com.example.mediaplayer.model.Song;

import java.util.ArrayList;
import java.util.Random;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    ArrayList<Song> lstSong;
    Context context;
    SongUserCallback songUserCallback;
    public SongAdapter(ArrayList<Song> lstSong) {this.lstSong = lstSong;}

    public void setSongCallback(SongUserCallback songUserCallback) {
        this.songUserCallback = songUserCallback;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View userView = inflater.inflate(R.layout.item_song, parent, false);
        SongViewHolder viewHolder = new SongViewHolder(userView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song item = lstSong.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.ivPlay.setOnClickListener(view -> songUserCallback.onItemClickedPlay(item.getFilename()));
        holder.ivPause.setOnClickListener(view -> songUserCallback.onItemClickedStop());
    }


    @Override
    public int getItemCount() {
        return lstSong.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivPlay;
        ImageView ivPause;
//        ImageView ivSong;
        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_song_name);
            ivPlay = itemView.findViewById(R.id.iv_play);
            ivPause = itemView.findViewById(R.id.iv_pause);
        }
    }
    public interface SongUserCallback{
        void onItemClickedPlay(String songName);
        void onItemClickedStop();
    }
}