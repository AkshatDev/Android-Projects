package com.example.android.music_structure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Lucifer on 08-11-2017.
 */

public class PlayList_Songs extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_view);
        setTitle("Playlist Of All Songs");
        Button buy = (Button) findViewById(R.id.buy);
        buy.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), buy.class);
                startActivity(intent);
            }
        });

        final ArrayList<list> words = new ArrayList();
        words.add(new list("Song1", "By:-ABC1"));
        words.add(new list("Song2", "By:-ABC2"));
        words.add(new list("Song3", "By:-ABC3"));

        DataAdapter adapeter = new DataAdapter(this, words);
        ListView root = (ListView) findViewById(R.id.list);
        root.setAdapter(adapeter);
    }
}


