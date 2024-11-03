# java-lotto-precourse

## 목표 

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
  - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 조건
1. 3항 연산자를 쓰지 않는다.
2. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다
3. 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만든다.(길이가 15라인을 넘어가지 않도록)
4. JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다
5. Java Enum을 적용하여 프로그램을 구현한다.
6. else 예약어를 쓰지 않는다. 
   1. 대신 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
   2. 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
7. 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다
8. 제공된 Lotto 클래스를 사용하여 구현해야 한다.

---

## 디렉토리 구조

```bash
src
└── lotto
    ├── controller
    │   └── LottoController.java    
    ├── model
    │   ├── lotto
    │   │   ├── Lotto.java             # 로또 번호를 관리
    │   │   ├── LottoGenerator.java    # 로또 번호 생성기
    │   │   └── LottoNumber.java       # 로또 번호의 유효성을 검사하는 Enum
    │   └── result
    │       ├── LottoResult.java       # 당첨 결과 계산 및 관리
    │       └── Rank.java              # 당첨 등수와 상금을 관리하는 Enum
    ├── view
    │   ├── InputView.java             
    │   └── OutputView.java   
    └── App.java                
```

## 