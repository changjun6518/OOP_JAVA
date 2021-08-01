# BlackJack (JAVA)

##목차
[목표](#목표)<br>
[객체들의 속성과 역할](#객체들의-속성과-역할)<br>
[Knowing](#Knowing)<br>
[Question](#Question)<br>

## 목표 : 객체 중심 설계

---
<br>

>- 객체 간 Message 중심 동작
>- 서로 다른 객체 간 지시하지 않고 간단하게 요청
> - 하나의 메소드는 하나의 역햘만
> - 주석이 아닌 코드로 말하기


<br>

### 객체들의 속성과 역할

---
- 카드뭉치 (카드덱)
    - 기능1: 카드 1개를 뽑아준다.
    

- 카드
    - 속성
        - 다이아몬드, 하트, 스페이드, 클럽 중 1개의 무늬를 가지고 있다.
        - A,2~10,K,Q,J 중 하나를 가지고 있다.

- 규칙 
    - 기능1: 점수를 측정.
    - 기능2: 승패를 판단
  
- 딜러 , 게이머
  - 기능1 : 카드 받기
        - 딜러의 경우, 2카드의 합계 점수가 16점 이하이면 반드시 1장을 추가로 뽑고, 17점 이상이면 받을 수 없다.
      
  - 기능2 : 카드를 오픈한다.
    


### Knowing

---
- 생성자는 초기화에 대한 역할만, 로직은 분리
  
- ArrayList의 remove는 해당 인덱스의 인스턴스를 제거하고 남은 데이터들을 다시 Copy
  
- 기능 세분화
    - 단순히 한줄의 메소드 코드를 만들어서 코드의 의미를 녹여내라.(명확한 코드로서의 의미)
    - 세세한 지시는 해당 객체 내부안에 동작
    - ex) 카드를 뽑을 시 랜덤하게 배정하는 기능
        - 기능 : 카드 뽑기 <- 랜덤하게 배정
        - 랜덤하게 배정
   
- 상수의 선언 : 코드의 모호함을 덜어낸다.
  
- 하나의 클래스에 private 메소드가 많아지면 객체 설계를 다시 고민해봐야 하는 신호
  
- 인터페이스 타입으로 Collection을 사용한다는 점.
    > * 추상 클래스와 상속은 최대한 피하는 것이 좋습니다. 참고
  프로젝트 초기에는 못느끼지만, 프로젝트가 점점 커지고 운영기간이 3년, 4년 지나면서 상속과 추상 클래스로 범벅이 된 코드는 부모 클래스를 도저히 수정할 수 없는 지경에 이르게 됩니다.
     
    > * 메소드처럼 똑같이 카드를 받는 역할이지만 구현은 다른 경우가 과연 없을까요?(:Interface) 
     
    > * 서로 다른 객체는 최대한 느슨한 관계를 가지는 것이 좋다


### Questions

---
1. 딜러의 포인트는 따로 관리하는게 낫지 않을까.
```java
 private int getPointSum(){
        int sum = 0;
        for(Card card : cards) {
            sum += card.getPoint();
        }

        return sum;
    }
    일일히 카드를 받을 때 체크하는 것보다 해당 
    총 합계 포인트를 나타내는 속성만 존재하면 좋을 것 같다
    카드 객체는 52장에 메모리 마다 포인트가 있는 것보다 효율적일 것 같다.
```
-  개인 답변 : drawing 할 때 마다 총점수의 합을 올려줘야 하므로 각 메소드의 역할이 모호해져서 분리하는 것이 더 명확할 것 같다.

2. showCard()는 익명함수나 함수형 프로그래밍으로 하는게 좋지 않을까?
    - Card의 역할이 카드를 보여주기에는 모호한것 같다. 그래서 일단 Game 클래스안에 누구나 사용할 수 있도록 분리하는것이 좋을 것 같다.
    


ToDo

---

- 규칙 수정
- stack NPE 고려
    



