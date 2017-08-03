package com.example.android.music_structure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Lucifer on 05-10-2017.
 */

public class prodcasts extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_view);
        setTitle("Prodcast");
        Button button = (Button) findViewById(R.id.buy);
        button.setText("View Songs");
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayList_Songs.class);
                startActivity(intent);
            }
        });

        final ArrayList<list> words = new ArrayList();
        words.add(new list("Prodcast1", "By:-ABC1"));
        words.add(new list("Prodcast2", "By:-ABC2"));
        words.add(new list("Prodcast3", "By:-ABC3"));
        words.add(new list("Prodcast4", "By:-ABC2"));
        words.add(new list("Prodcast5", "By:-ABC3"));
        words.add(new list("Prodcast6", "By:-ABC2"));
        words.add(new list("Prodcast7", "By:-ABC3"));

        DataAdapter adapeter = new DataAdapter(this, words);
        ListView root = (ListView) findViewById(R.id.list);
        root.setAdapter(adapeter);


    }
}
