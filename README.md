# java-lotto-precourse
<hr>

## ⛓️ 패키지 구조
````
.
├── Application.java
├── controller
│   └── LottoController.java
├── domain
│   ├── Lotto.java
│   ├── Money.java
│   ├── Prize.java
│   ├── PrizeResult.java
│   ├── ProfitCalculator.java
│   ├── WinningLotto.java
│   └── generator
│       └── LottoGenerator.java
├── exception
│   ├── Money
│   │   ├── DivideMoneyException.java
│   │   └── NegativeMoneyException.java
│   ├── input
│   │   └── NotIntegerException.java
│   ├── lotto
│   │   ├── DuplicatedLottoNumberException.java
│   │   ├── InvalidRangeLottoNumberException.java
│   │   └── InvalidSizeLottoNumberException.java
│   └── winningLotto
│       ├── DuplicatedWinningNumberException.java
│       └── InvalidRangeWinningNumberException.java
├── parsers
│   └── Parser.java
└── view
    ├── input
    │   ├── InputBonusNumberView.java
    │   ├── InputMoneyView.java
    │   ├── InputView.java
    │   └── InputWinningNumberView.java
    └── output
        ├── LottoOutputView.java
        ├── PrizeOutputView.java
        ├── ProfitOutputView.java
        └── TicketOutputView.java
````

<hr>

## ⌨️ 입력
- [x] 구입 금액을 입력받는다
  - [x] 구입 금액만큼 티켓을 구매한다
  - [x] 숫자가 아닐 경우 예외를 반환하고 재입력 받는다
  - [x] 1,000원 단위가 아닐 경우 예외를 반환하고 재입력 받는다
- [x] 당첨 번호를 입력받는다
  - [x] 숫자가 아닐 경우 **해당 시점부터** 재입력 받는다
  - [x] 중복된 값을 입력할 경우 예외를 반환하고 **해당 시점부터** 재입력 받는다
- [x] 보너스 번호를 입력받는다
  - [x] 숫자가 아닐 경우 **해당 시점부터** 재입력 받는다
  - [x] 보너스 번호가 당첨 번호에 이미 있는 경우 예외를 반환하고 재입력 받는다

## 🖥️ 출력
- [x] 중복되지 않은 로또 번호들을 출력한다
- [x] 3개 ~ 6개까지 각각 당첨된 개수와 상금을 출력한다
- [x] 총 수익률을 출력한다

## ⚙️ 메인 로직
- [x] 로또를 금액만큼의 티켓 개수를 구하여 구입한다
- [x] 티켓만큼 6자리의 로또 번호를 랜덤으로 발생시킨다
- [x] 6자리의 당첨 번호와 1자리의 보너스 번호를 통해 총 당첨 번호를 생성한다
- [x] 랜덤하게 발급받은 로또 번호와 총 당첨 번호를 비교한다
  - [x] 특히 5개의 번호가 일치할 경우, 보너스 번호 적중 여부를 고려한다
  - [x] 3개 미만의 번호 일치에 대해서는 고민하지 않는다.
- [x] 총 수익률을 계산하여 반환한다.

<hr>

## ⛏️리팩토링 사항
- [X] 사용하지 않는 메서드 및 클래스 삭제하기
- [X] 수익률 구현로직과 출력로직 분리하기
- [X] 랜덤하게 발생시킨 6자리의 로또 올림차순 정렬하기
- [X] 상금 출력시 , 로 구분하여 금액 출력하기
- [X] 각 예외처리 클래스 명명하여 구분하기
- [ ] 당첨 로또 번호 관련
  - [ ] 6자리 당첨번호와 1자리 보너스번호를 통해 총 로또번호를 생성할때 검증을 하기때문에, <br>
    각각의 입력에서 검증을 진행하도록 변경하기
<hr>

## 🧩 테스트 시나리오 및 예외 반환
- [X] 금액 관련
  - [X] 금액에 문자가 포함되면 예외반환
  - [X] 금액 입력값이 음수면 예외반환
  - [X] 금액 입력값이 1000원으로 나누어떨어지지 않으면 예외반환
- [X] 티켓 관련 
  - [X] 금액만큼의 티켓수를 구입하는지 테스트
- [X] 로또 번호 관련
  - [X] 6자리가 맞는지 확인한 후 아니면 예외 반환
  - [X] 번호가 0이하 이거나 46이상이면 예외 반환
  - [X] 번호가 중복되면 예외 반환
- [X] 보너스 번호 관련
  - [X] 번호가 0이하 이거나 46이상이면 예외 반환
  - [X] 보너스 번호가 당첨로또번호와 중복되면 예외 반환
-[X] 매칭 개수 관련 
  - [X] 각 로또번호 별로 당첨로또와 매치하여 알맞은 당첨개수 출력하는지 테스트
- [X] 수익률 관련
  - [X] 당첨금액을 구하는 테스트 
  - [X] 구매금액 대비 당첨금액 계산 테스트
  - [X] 요구사항의 출력형식 알맞게 출력하는지 테스트