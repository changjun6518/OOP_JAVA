package com.javastudy.blackjack.blackjack.Palyer;

import com.javastudy.blackjack.blackjack.Card;

import java.util.ArrayList;
import java.util.List;

/*
 역할
- 추가로 카드를 받는다.
- 뽑은 카드를 소유한다.
- 카드를 오픈한다.
*/
public class Gamer implements Player {
    private String name;
    private List<Card> cards;
    boolean turn;

    public Gamer(String name) {
        this.name=name;
        this.cards = new ArrayList<>();
    }

    @Override
    public void receiveCard(Card card) {
        this.cards.add(card);
        this.showCards();
    }

    @Override
    public void showCards() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gamer : 현재 보유 카드 목록 \n");

        for (Card card : cards) {
            sb.append(card.toString());
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    @Override
    public List<Card> openCards() {
        return this.cards;
    }

    @Override
    public void turnOff() {
        this.setTurn(false);
    }

    @Override
    public void turnOn() {
        this.setTurn(true);
    }

    @Override
    public boolean isTurn() {
        return this.turn;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setTurn(boolean turn) {
        this.turn = turn;
    }


}

