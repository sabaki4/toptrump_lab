package com.example.top_trumps_start_code.services;

import com.example.top_trumps_start_code.models.Card;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TopTrumpsService {
    private ArrayList<Card> cards;

    public TopTrumpsService(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public TopTrumpsService() {
    }

    public void checkWinner(){

    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
