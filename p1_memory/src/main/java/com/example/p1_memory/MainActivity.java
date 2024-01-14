package com.example.p1_memory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Board _gameBoard;
    private ListView _gameBoardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.easy).setOnClickListener(this::easyButtonOnClick);
        findViewById(R.id.average).setOnClickListener(this::normalButtonOnClick);
        findViewById(R.id.hard).setOnClickListener(this::hardButtonOnClick);

        _gameBoardView = findViewById(R.id.gameboardList);

    }


    public void easyButtonOnClick(View view) {
        CreateGrid(3);
    }

    public void normalButtonOnClick(View view) {
        CreateGrid(4);
    }

    public void hardButtonOnClick(View view) {
        CreateGrid(5);
    }

    private void CreateGrid(int size)
    {
        _gameBoard = new Board(size);

    }


}