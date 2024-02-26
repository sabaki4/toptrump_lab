package com.example.top_trumps_start_code.services;

import com.example.top_trumps_start_code.models.Card;
import com.example.top_trumps_start_code.models.Rank;
import com.example.top_trumps_start_code.models.Suit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TopTrumpsService {

    private ArrayList<Card> decks;

    public TopTrumpsService() {
    }

    public String checkWinner(ArrayList<Card> cards){
        if(cards.get(0).getCardValue() == cards.get(1).getCardValue()){
            return "DRAW";
        }

        if(cards.get(0).getCardValue() > cards.get(1).getCardValue()){
            return cards.get(0).getRank() + " of " + cards.get(0).getSuit() + " wins!";
        }else{
            return cards.get(1).getRank() + " of " + cards.get(1).getSuit() + " wins!";
        }
    }

    public boolean validCard(ArrayList<Card> cards){
        boolean validCard = false;
        boolean validCard2 = false;
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        for (Card card: this.decks){
            if(card.getRank()==card1.getRank() && card.getSuit()==card1.getSuit()){
                validCard=true;
            }
            if(card.getRank()==card2.getRank() && card.getSuit()==card2.getSuit()){
                validCard2=true;
            }
        }

        if(validCard2 && validCard){
            return true;
        }else{
            return false;
        }
    }
    public void setDecks(){
        //CREATE CARD
        //ADD IT TO DECK
        this.decks = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit: Suit.values()){
                Card card = new Card(rank,  suit);
                decks.add(card);
            }
        }
    }

    public void showDeck(){
        for (Card card: this.decks){
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
    }

    public void removeFromDeck(ArrayList<Card> cards){
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        this.decks.remove(card1);
        this.decks.remove(card2);
    }

    public String processRound(ArrayList<Card> cards){

        //VALID FUNCTION
        boolean valid = validCard(cards);
        if(valid){
            //check winner
            //remove card from deck
            if(cards.get(0).getCardValue() == cards.get(1).getCardValue()){
                removeFromDeck(cards);
                return "DRAW";
            }

            if(cards.get(0).getCardValue() > cards.get(1).getCardValue()){
                removeFromDeck(cards);
                return cards.get(0).getRank() + " of " + cards.get(0).getSuit() + " wins!";
            }else{
                removeFromDeck(cards);
                return cards.get(1).getRank() + " of " + cards.get(1).getSuit() + " wins!";
            }
        }else{
            return "Invalid cards";
        }
    }

}
