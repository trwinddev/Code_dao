package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.mediaplayer.ui.contact.ContactActivity;
import com.example.mediaplayer.ui.song.SongActivity;

public class MainActivity extends AppCompatActivity {
    Button btMediaPlayer;
    Button btContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btMediaPlayer = findViewById(R.id.btMediaPlayer);
        btContact = findViewById(R.id.btContact);

        btMediaPlayer.setOnClickListener(v->startActivity(new Intent(this, SongActivity.class)));
        btContact.setOnClickListener(v->startActivity(new Intent(this, ContactActivity.class)));
    }

}