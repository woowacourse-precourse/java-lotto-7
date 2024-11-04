## java-lotto-precourse

* 우아한 테크코스 3주차 프리코스 미션: 로또

---

### 📋요구 사항

* 로또 구입 금액을 입력받아 발행된 로또 수량과 로또 번호들을 출력합니다.
* 당첨 및 보너스 번호를 입력받아 당첨 내역과 총 수익률을 출력합니다.
* 입력된 값이 올바르지 않을 시 예외 상황에 대한 안내 문구를 출력합니다.

---

### 📃기능 목룍

1. **View**
    1) 입력
        - 로또 구입 금액 입력받기
        - 당첨 번호와 보너스 번호 입력받기
    2) 출력
        - 로또 티켓 수량 및 로또 티켓 번호들 출력하기
        - 로또 당첨 내역 및 총 수익률 출력하기
    3) 예외 처리
        - 예외 발생 시 정정 안내 문구 출력하기


2. **Model**
    1) 로또
        - 로또 번호 저장하기
    2) 로또 기계
        - 로또 티켓 차례로 생성하기
        - 로또 당첨 번호 생성하기
    3) 로또 티켓
        - 로또 티켓 수량 계산하기
        - 로또 티켓 번호 생성하기
    4) 로또 당첨 번호
        - 로또 당첨 번호들 저장하기
        - 로또 보너스 번호 저장하기
    5) 로또 번호 일치 개수
        - 로또 티켓별 당첨 번호 일치 개수 저장하기
        - 로또 티켓별 보너스 번호 일치 여부 저장하기
    6) 로또 당첨 내역
        - 로또 당첨 등급 저장하기
        - 로또 티켓별 당첨 내역 계산하기
        - 로또 당첨 총 수익률 계산하기


3. **Controller**
    1) 제어
        - 로또 게임 흐름 제어하기

---

### 🏁기능 검사

1. **예외 테스트**
    - 빈 문자열 및 자료형과 구분자 검사하기
    - 로또 구입 금액의 범위 및 단위 검사하기
    - 로또 번호의 개수와 범위 및 중복된 값 검사하기


2. **기능 테스트**
    - 로또 티켓 초기값 생성 검사하기
    - 로또 당첨 초기값 및 결과값 생성 검사하기
    - 로또 당첨 카운터 갱신 검사하기
    - 로또 당첨 결과 출력 검사하기

---

### 📂기능 구현

```
src
├─main
│  └─java
│      └─lotto
│          │  Application.java
│          │  
│          ├─controller
│          │      Controller.java
│          │      
│          ├─model
│          │      Jackpot.java
│          │      Lotto.java
│          │      Machine.java
│          │      Prize.java
│          │      Ranks.java
│          │      Status.java
│          │      Tickets.java
│          │      
│          └─view
│                 Exception.java
│                 Input.java
│                 Output.java
│                  
└─test
    └─java
        └─lotto
            │  ApplicationTest.java
            │  LottoTest.java
            │  
            └─model
                  JackpotTest.java
                  MachineTest.java
                  PrizeTest.java
                  RanksTest.java
                  StatusTest.java
                  TicketsTest.java
```

---