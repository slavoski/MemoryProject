package com.example.p1_memory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.p1_memory.databinding.ActivityGameFinalBinding;
public class GameFinalActivity extends AppCompatActivity  {

    private final ViewModel data = new ViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.p1_memory.databinding.ActivityGameFinalBinding binding = ActivityGameFinalBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.setViewModel(data);

        data.finalScore = getIntent().getIntExtra("finalScore", 0);

        binding.restartButton.setOnClickListener(this::RestartGameButtonOnClick);

    }

    public void RestartGameButtonOnClick(View view)
    {
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
    }

}
