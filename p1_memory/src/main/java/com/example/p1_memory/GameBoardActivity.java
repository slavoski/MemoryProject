package com.example.p1_memory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.GridLayout;


public class GameBoardActivity extends AppCompatActivity {

    private Card _firstSelectedCard;
    private Card _secondSelectedCard;
    private Drawable _background;
    private int _buttonClicks = 0;

    private int numberOfMatches = 0;
    private int totalMatches = 0;

    private boolean _isChecking = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_board);

        int size = getIntent().getIntExtra("size", 0);

        GridLayout gameBoardView = findViewById(R.id.gridBoardLayout);
        gameBoardView.setColumnCount(size);

        Board _gameBoard = new Board(this, size);

        for(int i =0; i < size*size; ++i)
        {
            Card currentCard = _gameBoard._cards.get(i);
            currentCard.setLayoutParams(new GridLayout.LayoutParams());
            currentCard.setOnClickListener(this::OnCardClick);
            gameBoardView.addView(currentCard);
        }
        totalMatches = size * size / 2;
        _background = _gameBoard._cards.get(0).getBackground();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("numberOfMatches", numberOfMatches);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    public void OnCardClick(View view)
    {
        if(!_isChecking) {

            _buttonClicks++;

            Card selectedCard = (Card) view;

            if (!selectedCard._isWildcard) {
                if (_firstSelectedCard == null) {
                    _firstSelectedCard = selectedCard;
                    _firstSelectedCard.SetFlippedCard(true);
                } else if(_firstSelectedCard != selectedCard){

                    _isChecking = true;
                    _secondSelectedCard = selectedCard;
                    _secondSelectedCard.SetFlippedCard(true);

                    boolean foundMatch = _firstSelectedCard._faceValue == selectedCard._faceValue;
                    Animation(foundMatch);

                    new Handler(Looper.getMainLooper()).postDelayed(() -> {

                        CheckStatusAfterAnimation(foundMatch);
                        CheckIfGameIsOver(foundMatch);
                        _isChecking = false;
                    }, 1000);
                }
            }
        }
    }

    private void Animation(boolean success) {
        _firstSelectedCard.setEnabled(false);
        _secondSelectedCard.setEnabled(false);

        int color = success ? R.color.good_choice : R.color.bad_choice;

        _firstSelectedCard.setBackgroundColor(getResources().getColor(color));
        _secondSelectedCard.setBackgroundColor(getResources().getColor(color));
    }

    private void CheckStatusAfterAnimation(boolean foundMatch)
    {
        _firstSelectedCard.FoundMatch(foundMatch, _background);
        _secondSelectedCard.FoundMatch(foundMatch, _background);

        _firstSelectedCard = _secondSelectedCard = null;
    }

    private void CheckIfGameIsOver(boolean foundMatch)
    {
        if(foundMatch)
        {
            numberOfMatches++;

            if(numberOfMatches == totalMatches)
            {
                Intent intent = new Intent(this, GameFinalActivity.class );
                intent.putExtra("finalScore", _buttonClicks);
                startActivity((intent));
            }
        }
    }

}
