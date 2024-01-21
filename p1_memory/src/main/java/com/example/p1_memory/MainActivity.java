package com.example.p1_memory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.easy).setOnClickListener(this::easyButtonOnClick);
        findViewById(R.id.average).setOnClickListener(this::normalButtonOnClick);
        findViewById(R.id.hard).setOnClickListener(this::hardButtonOnClick);
    }


    public void easyButtonOnClick(View view) {
        CreateGrid(2);
    }

    public void normalButtonOnClick(View view) {
        CreateGrid(4);
    }

    public void hardButtonOnClick(View view) {
        CreateGrid(6);
    }

    private void CreateGrid(int size)
    {
        Intent intent = new Intent(this, GameBoardActivity.class );
        intent.putExtra("size", size);
        startActivity(intent);
    }


}