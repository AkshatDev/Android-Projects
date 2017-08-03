package com.example.android.music_structure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.os.Build.VERSION_CODES.M;

public class MusicActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        setTitle("HOMEPAGE");
        final ImageView artist = (ImageView) findViewById(R.id.artist);
        ImageView playlist = (ImageView) findViewById(R.id.playlist);
        ImageView albums = (ImageView) findViewById(R.id.album);
        ImageView prod = (ImageView) findViewById(R.id.prodcast);
        artist.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(v.getContext(), artist.class);
                                          startActivity(intent);
                                      }
                                  }


        );
        playlist.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(v.getContext(), PlayList_Songs.class);
                                            startActivity(intent);
                                        }
                                    }


        );
        albums.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(v.getContext(), albums.class);
                                          startActivity(intent);
                                      }
                                  }


        );
        prod.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(v.getContext(), prodcasts.class);
                                        startActivity(intent);
                                    }
                                }


        );


    }

}
