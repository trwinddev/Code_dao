package com.example.mediaplayer.ui.song;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mediaplayer.R;
import com.example.mediaplayer.model.Song;
import com.example.mediaplayer.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SongActivity extends AppCompatActivity implements SongAdapter.SongUserCallback {
    ArrayList<Song> lstSong;
    RecyclerView rvSong;
    SongAdapter songAdapter;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        rvSong = findViewById(R.id.rcv_song);

        Gson gson = new Gson();
        String data = Utils.getAssetJsonData(this);
        Type type = new TypeToken<ArrayList<Song>>() {
        }.getType();
        lstSong = gson.fromJson(data, type);
        songAdapter = new SongAdapter(lstSong);
        songAdapter.setSongCallback(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvSong.setAdapter(songAdapter);
        rvSong.setLayoutManager(linearLayoutManager);
    }


    @Override
    public void onItemClickedPlay(String songName) {
        try {
            AssetFileDescriptor afd = getAssets().openFd("sound/" + songName);
            if(player==null) {
                player = new MediaPlayer();
            }
            player.stop();
            player.reset();
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            player.prepare();
            player.start();
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void stopMusicPlayer() {
        if(player == null) return;
        player.stop();
        player.release();
        player = null;
    }
    @Override
    public void onItemClickedStop() {
        stopMusicPlayer();
    }
}