package com.example.android.music_structure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Lucifer on 05-10-2017.
 */

public class artist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_view);
        setTitle("Artists");
        final ArrayList<list> words = new ArrayList();
        words.add(new list("Artist1", "By:-ABC1"));
        words.add(new list("Artist2", "By:-ABC2"));
        words.add(new list("Artist3", "By:-ABC3"));
        words.add(new list("Artist4", "By:-ABC2"));
        words.add(new list("Artist5", "By:-ABC3"));
        Button button = (Button) findViewById(R.id.buy);
        button.setText("View Prodcasts");
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), prodcasts.class);
                startActivity(intent);
            }
        });

        DataAdapter adapeter = new DataAdapter(this, words);
        ListView root = (ListView) findViewById(R.id.list);
        root.setAdapter(adapeter);


    }
}
