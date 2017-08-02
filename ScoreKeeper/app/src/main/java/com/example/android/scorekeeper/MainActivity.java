package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scorea=0;
    int scoreb=0;
    int foula=0;
    int foulb=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void reset(View view) {
        resetscore();
    }
    public void displayscore2(View view) {
        displayForTeamA2();
    }

    public void displayscore3(View view) {
        displayForTeamA3();
    }
    public void displayfoulfor1(View view) {
        displayForTeamA1();
    }
    public void displayForTeamA2() {
        scorea=scorea+2;
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(Integer.toString(scorea));
    }
    public void displayForTeamA3() {
        scorea=scorea+3;
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(Integer.toString(scorea));
    }
    public void displayForTeamA1() {
        foula=foula+1;
        TextView foulView = (TextView) findViewById(R.id.team_a_fouls);
        foulView.setText(Integer.toString(foula));

    }


    public void displayscoreB2(View view) {
        displayForTeamB2();
    }

    public void displayscoreB3(View view) {
        displayForTeamB3();
    }
    public void displayfoulfor2(View view) {
        displayForTeamB1();
    }
    public void displayForTeamB2() {
        scoreb=scoreb+2;
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(Integer.toString(scoreb));
    }
    public void displayForTeamB3() {
        scoreb=scoreb+3;
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(Integer.toString(scoreb));
    }
    public void displayForTeamB1() {
        foulb=foulb+1;
        TextView foulView = (TextView) findViewById(R.id.team_b_fouls);
        foulView.setText(Integer.toString(foulb));

    }
    public void resetscore() {
        scorea=0;
        scoreb=0;
        foula=0;
        foulb=0;
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(Integer.toString(scorea));
        TextView scoreView2 = (TextView) findViewById(R.id.team_b_score);
        scoreView2.setText(Integer.toString(scoreb));


        TextView foulView1 = (TextView) findViewById(R.id.team_a_fouls);
        foulView1.setText(Integer.toString(foula));

        TextView foulView2 = (TextView) findViewById(R.id.team_b_fouls);
        foulView2.setText(Integer.toString(foulb));

    }

}
