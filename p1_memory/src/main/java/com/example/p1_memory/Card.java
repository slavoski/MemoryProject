package com.example.p1_memory;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class Card extends androidx.appcompat.widget.AppCompatButton {
    boolean _isFlipped = false;
    int _faceValue = 0;
    boolean _isWildcard = false;

    public Card(Context context) {
        super(context);
    }

    public void SetFlippedCard(boolean flipFaceUp)
    {
        _isFlipped = flipFaceUp;
        setText( _isFlipped ? String.valueOf(_faceValue) : "?" );
    }

    public void FoundMatch(boolean foundMatch, Drawable background)
    {
       setEnabled(!foundMatch);
       SetFlippedCard(foundMatch);
       setBackground(background);
    }

}
