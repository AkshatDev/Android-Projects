package com.example.android.single_screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.android.single_screen.R.string.address;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.business_name);
    }
}
