package com.example.p1_memory;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Board {

    final Context _context;
    final List<Card> _cards;
    final Random _rand = new Random();

    public Board(Context context, int size) {

        _context = context;
        int numOfCards = size*size;

        _cards = InitializeCards(numOfCards);
        SetCardValues(numOfCards);
    }

    private void SetCardValues(int numOfCards)
    {
        LinkedList<Integer> unusedNumbers = InitializeLinkedList(numOfCards);

        int pairedCardsCount = numOfCards / 2;
        for(int i = 0; i < pairedCardsCount; ++i) {
            SetDefaultCard(_cards.get(GetLinkedListValue(unusedNumbers)), i);
            SetDefaultCard(_cards.get(GetLinkedListValue(unusedNumbers)), i);
        }

        if(unusedNumbers.size() >= 1)
        {
            Card wildCard = _cards.get(unusedNumbers.getFirst());
            wildCard._faceValue = 88;
            wildCard._isWildcard = true;
        }
    }

    private ArrayList<Card> InitializeCards(int numOfCards)
    {
        ArrayList<Card> cards = new ArrayList<>(numOfCards);
        for(int i = 0; i < numOfCards; ++i)
        {
            cards.add(new Card(_context));
        }
        return cards;
    }

    private int GetLinkedListValue(LinkedList<Integer> unusedNumbers)
    {
        int index = _rand.nextInt(unusedNumbers.size());

        return unusedNumbers.remove(index);
    }

    private LinkedList<Integer> InitializeLinkedList(int numOfCards)
    {
        LinkedList<Integer> unusedNumbers = new LinkedList<>();

        for (int j = 0; j < numOfCards; ++j) {
            unusedNumbers.add(j);
        }

        return unusedNumbers;
    }

    private void SetDefaultCard(Card card, int faceValue)
    {
        card._faceValue = faceValue;
        card.setText("?");
    }

}
