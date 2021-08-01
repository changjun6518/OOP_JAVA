package com.javastudy.blackjack.blackjack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CardDeck {
    private Stack<Card> cards;

    public CardDeck() {
        cards = makeCards();
        Collections.shuffle(cards);
    }

    private Stack<Card> makeCards() {
        Stack<Card> cards = new Stack<>();
        for (Card.Pattern pattern : Card.Pattern.values()) {
            for(Card.Denomination denomination : Card.Denomination.values()){
                Card card = new Card(pattern, denomination);
                cards.push(card);
            }
        }
        return cards;
    }

    public Stack<Card> getCard() {
        return cards;
    }

    // 뽑기
    public Card draw()
    {
       return this.cards.pop();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Card card : cards){
            sb.append(card.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}