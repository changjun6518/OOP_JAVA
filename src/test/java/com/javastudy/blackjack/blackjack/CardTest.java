package com.javastudy.blackjack.blackjack;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

class CardTest {

    private CardDeck cardDeck;
    private List<Card> cards;

    @BeforeEach
    public void createCard (){
        // given
        cardDeck = new CardDeck();
        cards=cardDeck.getCard();
        // when
        // then
    }

    @Test
    @DisplayName("List -> Stack CardDeck Feat.draw Checking")
    public void cardPatternCheck(){
        // given

        // when

        // then
        Stack<Card> card = cardDeck.getCard();
        card.forEach(System.out::println);
        assertThat(cards.size()).isEqualTo(52);
        cardDeck.draw();
        assertThat(cards.size()).isEqualTo(51);
        cardDeck.draw();
        assertThat(cards.size()).isEqualTo(50);
        cardDeck.draw();

    }


}