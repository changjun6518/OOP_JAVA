package com.javastudy.blackjack.blackjack.Palyer;

import com.javastudy.blackjack.blackjack.Card;

import java.util.List;
/*
- 인터페이스는 상수와 추상메소드만 가질 수
- 추상 클래스는 상수,변수,일반메소드,추상메소드 모두를 가질 수 있

    *****
        한가지 주의하셔야 할 점은, 추상 클래스와 상속은 최대한 피하는 것이 좋습니다. 참고
        프로젝트 초기에는 못느끼지만, 프로젝트가 점점 커지고 운영기간이 3년, 4년 지나면서 상속과 추상 클래스로 범벅이 된 코드는 부모 클래스를 도저히 수정할 수 없는 지경에 이르게 됩니다.
        현재는 Dealer와 Gamer의 showCards 메소드와 openCards 메소드가 동일하지만, 시간이 지나서도 2개의 메소드 코드는 동일할 수 있을까요?
        receiveCard 메소드처럼 똑같이 카드를 받는 역할이지만 구현은 다른 경우가 과연 없을까요?
        서로 다른 객체는 최대한 느슨한 관계를 가지는 것이 좋습니다.
    *****
*/
public interface Player {
    void receiveCard(Card card);

    void showCards();

    List<Card> openCards();

    void turnOff();

    void turnOn();

    boolean isTurn();

    String getName();
}
