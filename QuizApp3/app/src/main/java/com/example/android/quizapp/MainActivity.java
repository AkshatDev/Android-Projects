package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.math.BigInteger;

import static android.R.attr.duration;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    int correct = 0;
    int wrong = 0;
    String Manswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void call(View view) {
        calculate();
    }

    private void calculate() {
        EditText answer = (EditText) findViewById(R.id.ans);
        score = 0;
        correct = 0;
        wrong = 0;
        Manswer = answer.getText().toString();
        EditText name = (EditText) findViewById(R.id.na);
        RadioButton jRadioButton3 = (RadioButton) findViewById(R.id.R3);
        RadioButton jRadioButton5 = (RadioButton) findViewById(R.id.R5);
        RadioButton jRadioButton7 = (RadioButton) findViewById(R.id.R7);
        RadioButton jRadioButton9 = (RadioButton) findViewById(R.id.R9);
        RadioButton jRadioButton12 = (RadioButton) findViewById(R.id.R12);
        RadioButton jRadioButton14 = (RadioButton) findViewById(R.id.R14);
        RadioButton jRadioButton15 = (RadioButton) findViewById(R.id.R15);
        RadioButton jRadioButton17 = (RadioButton) findViewById(R.id.R17);
        RadioButton jRadioButton20 = (RadioButton) findViewById(R.id.R20);
        CheckBox jCheckBox1 = (CheckBox) findViewById(R.id.cb1);
        CheckBox jCheckBox2 = (CheckBox) findViewById(R.id.cb2);
        CheckBox jCheckBox3 = (CheckBox) findViewById(R.id.cb3);
        CheckBox jCheckBox4 = (CheckBox) findViewById(R.id.cb4);
        if (Manswer.equals("a")) {
            score = score + 1;
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (jRadioButton3.isChecked()) {
            score = score + 1;
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (jRadioButton5.isChecked()) {
            score = score + 1;
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (jRadioButton7.isChecked()) {
            score = score + 1;
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (jRadioButton9.isChecked()) {
            score = score + 1;
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (jRadioButton12.isChecked()) {
            score = score + 1;
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (jRadioButton14.isChecked()) {
            score = score + 1;
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (jRadioButton15.isChecked()) {
            score = score + 1;
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (jRadioButton17.isChecked()) {
            score = score + 1;
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (jRadioButton20.isChecked()) {
            score = score + 1;
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (jCheckBox1.isChecked() && jCheckBox2.isChecked() && jCheckBox3.isChecked() && jCheckBox4.isChecked()) {
            score = score + 1;
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        Toast.makeText(this, "Congrats " + name.getText() + "\n " + "Your score is : " + score + "\nCorrect answers: " + correct + "\nWrong Answers: " + wrong, Toast.LENGTH_LONG).show();
    }
}
