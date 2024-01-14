package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int _numOfPresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void DontPushOnClick(View view) {
        Button myCurrentButton = findViewById(R.id.dontPushMe);

        switch (_numOfPresses) {
            case 0:
                myCurrentButton.setText("Why did you do that?");
            break;
            case 1:
                myCurrentButton.setText("Please Stop!");
                break;
            case 2:
                myCurrentButton.setText("Ouch!!!!");
                break;
            case 3:
                myCurrentButton.setText("I am going to leave if you don't stop!");
                break;
            default:
                myCurrentButton.setText("");
                EditText useless = findViewById(R.id.useless);
                useless.setText("He left...");
                break;
        }

        _numOfPresses++;
    }
}