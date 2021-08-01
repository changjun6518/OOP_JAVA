package com.javastudy.blackjack.blackjack;

import com.javastudy.blackjack.blackjack.Palyer.Dealer;
import com.javastudy.blackjack.blackjack.Palyer.Gamer;
import com.javastudy.blackjack.blackjack.Palyer.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static final String STOP_RECEIVE_CARD = "0";
    private static final int INIT_RECEIVE_CARD_COUNT = 2;
/*    public void play() {
        System.out.println("========= Blackjack =========");
        Scanner sc = new Scanner(System.in);

        List<Player> players= Arrays.asList(new Gamer(),new Dealer());
        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();
        initPhase(cardDeck, players);
        playingPhase(sc, cardDeck, players);
        *//*
        Gamer는 CardDeck이 어떤 과정을 거쳐서 카드를 뽑아주는지 모른다는 것.
        객체는 다른 객체에게 요청을 할때, 이렇게 한뒤에 저렇게 하고 마지막으로 어떻게 해달라 라는 식으로 세세하게 요청해서는 안됩
        그러므로 다른 객체에게 요청하는 일은 최대한 해당 객체를 믿고 맡기는 것이 좋습니다.
        *//*
    }*/
    /*
    private void playingPhase(Scanner sc, CardDeck cardDeck, List<Player> players) {
        String gamerInput, dealerInput;
        boolean isGamerTurn = false,
                isDealerTurn = false;

        while(true){
            System.out.println("카드를 뽑겠습니까? 종료를 원하시면 0을 입력하세요.");
            gamerInput = sc.nextLine();

            if("0".equals(gamerInput)) {
                isGamerTurn = true;
            }else{
                Card card = cardDeck.draw();
                gamer.receiveCard(card);
            }

            System.out.println("카드를 뽑겠습니까? 종료를 원하시면 0을 입력하세요.");
            dealerInput = sc.nextLine();

            if("0".equals(dealerInput)) {
                isDealerTurn = true;
            }else{
                Card card = cardDeck.draw();
                dealer.receiveCard(card);
            }

            if(isGamerTurn && isDealerTurn){
                break;
            }
        }
    }*/
  /*  private void playingPhase(Scanner sc, CardDeck cardDeck, List<Player> players) {
        while(true){
            boolean isAllPlayerTurnOff = receiveCardAllPlayers(sc, cardDeck, players);

            if(isAllPlayerTurnOff){
                break;
            }
        }
    }

    private boolean receiveCardAllPlayers(Scanner sc, CardDeck cardDeck, List<Player> players) {
        boolean isAllPlayerTurnOff = true;

        for(Player player : players) {
            if(isReceiveCard(sc)) {
                Card card = cardDeck.draw();
                player.receiveCard(card);
                isAllPlayerTurnOff = false;
            }else{
                isAllPlayerTurnOff = true;
            }
        }

        return isAllPlayerTurnOff;
    }

    private boolean isReceiveCard(Scanner sc) {
        System.out.println("카드를 뽑겠습니까? 종료를 원하시면 0을 입력하세요.");
        return !STOP_RECEIVE_CARD.equals(sc.nextLine());
    }



    private void initPhase(CardDeck cardDeck, List<Player> players){
        System.out.println("처음 2장의 카드를 각자 뽑겠습니다.");
        for(int i = 0; i< INIT_RECEIVE_CARD_COUNT; i++) {
            for (Player player : players) {
                Card card = cardDeck.draw();
                player.receiveCard(card);
            }
        }
    }*/
    public void play(){
        System.out.println("========= Blackjack =========");
        Scanner sc = new Scanner(System.in);
        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();

        List<Player> players = Arrays.asList(new Gamer("사용자1"), new Dealer());
        List<Player> initAfterPlayers = initPhase(cardDeck, players);
        List<Player> playingAfterPlayers = playingPhase(sc, cardDeck, initAfterPlayers);

        Player winner = rule.getWinner(playingAfterPlayers);
        System.out.println("승자는 " + winner.getName());
    }

    private List<Player> playingPhase(Scanner sc, CardDeck cardDeck, List<Player> players) {
        List<Player> cardReceivedPlayers;
        while(true){
            cardReceivedPlayers = receiveCardAllPlayers(sc, cardDeck, players);

            if(isAllPlayerTurnOff(cardReceivedPlayers)){
                break;
            }
        }
        return cardReceivedPlayers;
    }

    private List<Player> receiveCardAllPlayers(Scanner sc, CardDeck cardDeck, List<Player> players) {
        for(Player player : players) {
            System.out.println(player.getName()+"님 차례입니다.");

            if(isReceiveCard(sc)) {
                Card card = cardDeck.draw();
                player.receiveCard(card);
                player.turnOn();
            }else{
                player.turnOff();
            }
        }

        return players;
    }

    private boolean isAllPlayerTurnOff(List<Player> players){
        for(Player player : players) {
            if(player.isTurn()) {
                return false;
            }
        }

        return true;
    }

    private boolean isReceiveCard(Scanner sc) {
        System.out.println("카드를 뽑겠습니까? 종료를 원하시면 0을 입력하세요.");
        return !STOP_RECEIVE_CARD.equals(sc.nextLine());
    }

    private List<Player> initPhase(CardDeck cardDeck, List<Player> players){
        System.out.println("처음 2장의 카드를 각자 뽑겠습니다.");
        for(int i = 0; i < INIT_RECEIVE_CARD_COUNT; i++) {
            for(Player player : players) {
                Card card = cardDeck.draw();
                player.receiveCard(card);
            }
        }

        return players;
    }


}