package com.example.p1_memory;

import com.google.android.gms.common.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Board {

    List<Card> _cards;
    Random _rand = new Random();

    public Board(int size) {

        int numOfCards = size*size;

        _cards = InitializeCards(numOfCards);
        SetCardValues(numOfCards);
    }

    private void SetCardValues(int numOfCards)
    {
        LinkedList<Integer> unusedNumbers = InitializeLinkedList(numOfCards);

        int pairedCardsCount = numOfCards / 2;
        for(int i = 0; i < pairedCardsCount; ++i) {
            _cards.get(GetLinkedListValue(unusedNumbers))._faceValue = i;
            _cards.get(GetLinkedListValue(unusedNumbers))._faceValue = i;
        }

        if(unusedNumbers.size() >= 1)
        {
            Card wildCard = _cards.get(unusedNumbers.getFirst().intValue());
            wildCard._faceValue = 88;
            wildCard._isWildcard = true;
        }
    }

    private ArrayList<Card> InitializeCards(int numOfCards)
    {
        ArrayList<Card> cards = new ArrayList<Card>(numOfCards);
        for(int i = 0; i < numOfCards; ++i)
        {
            cards.add(new Card());
        }
        return cards;
    }

    private int GetLinkedListValue(LinkedList<Integer> unusedNumbers)
    {
        int index = _rand.nextInt(unusedNumbers.size());
        Integer result = unusedNumbers.remove(index);

        return result.intValue();
    }

    private LinkedList<Integer> InitializeLinkedList(int numOfCards)
    {
        LinkedList<Integer> unusedNumbers = new LinkedList<Integer>();

        for (int j = 0; j < numOfCards; ++j) {
            unusedNumbers.add(j);
        }

        return unusedNumbers;
    }

}
