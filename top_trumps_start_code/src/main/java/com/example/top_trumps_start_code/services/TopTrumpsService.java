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

    public String checkWinner(){
        if(this.cards.get(0).getCardValue() == this.cards.get(1).getCardValue()){
            return "DRAW";
        }

        if(this.cards.get(0).getCardValue() > this.cards.get(1).getCardValue()){
            return this.cards.get(0).getRank() + " of " + this.cards.get(0).getSuit() + " wins!";
        }else{
            return this.cards.get(1).getRank() + " of " + this.cards.get(1).getSuit() + " wins!";
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
