# java-lotto-precourse

# 프로젝트 구조

```plaintext
└── lotto
    ├── Application.java
    ├── controller
    │   └── LottoController.java
    ├── domain
    │   ├── Lotto.java
    │   ├── LottoGenerator.java
    │   ├── LottoPrize.java
    │   ├── LottoProfit.java
    │   ├── LottoRank.java
    │   ├── LottoTickets.java
    │   ├── Money.java
    │   ├── Rank.java
    │   └── WinningLotto.java
    ├── handler
    │   ├── ConstantHandler.java
    │   ├── ErrorHandler.java
    │   ├── InputHandler.java
    │   ├── OutputHandler.java
    │   └── PatternHandler.java
    └── view
        ├── input
        │   ├── InputBonusNumberView.java
        │   ├── InputMoneyView.java
        │   ├── InputView.java
        │   └── InputWinningNumbersView.java
        └── output
            ├── OutputErrorMessageView.java
            ├── OutputLottoTicketsView.java
            └── OutputWinningStatisticView.java
```

---

# 구현할 기능 목록

## 🗂️ Domain

### Money (구입 금액)
- **구입 금액 정보 관리**
    - 구입 금액의 값을 저장한다.
    - 구입 금액이 유효한지 검증한다.
        - 구입 금액이 0보다 큰지 검증한다.
        - 구입 금액이 로또 1장 가격(1000원)으로 나누어 떨어지는지 검증한다.
    - 구매 가능한 로또 티켓 수를 계산한다.

### Lotto (로또)
- **로또 번호 관리**
    - 로또(1장)의 번호를 저장한다.
    - 로또 번호가 유효한지 검증한다.
        - 로또 번호가 6개인지 검증한다.
        - 로또 번호에 중복이 없는지 검증한다.
        - 로또 번호가 1~45 범위에 속하는지 검증한다.

### LottoGenerator (로또 발급기)
- **로또 번호 생성**
    - 1~45 범위에서 6개의 숫자를 랜덤으로 생성하여 로또 번호를 발급한다.

### LottoTickets (구입한 로또 티켓)
- **로또 티켓 관리**
    - 구입한 로또 티켓들을 저장한다.
    - 구입한 로또 티켓 수를 계산한다.

### Rank (로또 당첨 정보)
- **당첨 정보 관리**
    - 일치하는 번호 개수와 상금을 기반으로 등수를 저장한다.
    - 일치하는 번호 개수에 따른 로또 당첨 정보를 계산한다.

### LottoRank (로또 당첨 결과)
- **당첨 결과 계산**
    - 구입한 로또 티켓의 당첨 결과를 계산한다.

### LottoPrize (로또 당첨금)
- **당첨금 계산**
    - 로또 당첨 결과에 따라 당첨금의 총합을 계산한다.

### LottoProfit (로또 수익률)
- **수익률 계산**
    - 당첨금의 총합과 구입 금액을 사용하여 수익률을 계산한다.

### WinningLotto (당첨 로또)
- **당첨 로또 정보 관리**
    - 당첨 번호와 보너스 번호를 저장한다.
    - 당첨 번호가 유효한지 검증한다.
        - 당첨 번호 6개가 로또 번호와 동일하게 유효한지 확인한다.
        - 당첨 번호와 보너스 번호가 중복되지 않는지 검증한다.
        - 보너스 번호가 1~45 범위에 속하는지 검증한다.

---

## 👀 View

### InputView (입력 뷰)
- 사용자로부터 입력을 받는 모든 기능을 제공한다.

#### InputMoneyView (구입 금액 입력 뷰)
- **구입 금액 입력**
    - 구입 금액을 입력받는다.

#### InputWinningNumbersView (당첨 번호 입력 뷰)
- **당첨 번호 입력**
    - 당첨 로또의 당첨 번호를 입력받는다.

#### InputBonusNumberView (보너스 번호 입력 뷰)
- **보너스 번호 입력**
    - 당첨 로또의 보너스 번호를 입력받는다.

---

### OutputErrorMessageView (에러 메시지 출력 뷰)
- **에러 메시지 출력**
    - 유효성 검증 실패 시 에러 메시지를 출력한다.

### OutputLottoTicketsView (구입한 로또 티켓 출력 뷰)
- **구입한 로또 티켓 정보 출력**
    - 구입한 로또 티켓 수를 출력한다.
    - 구입한 로또 티켓의 번호 목록을 출력한다.

### OutputWinningStatisticView (당첨 통계 출력 뷰)
- **당첨 통계 출력**
    - 구입한 로또 티켓의 당첨 결과를 출력한다.
    - 구입한 로또 티켓의 수익률을 출력한다.

---

## 🕹️ Controller

### LottoController (로또 컨트롤러)
- **로또 프로그램의 입력 관리**
    - **구입 금액 입력**
        - 구입 금액을 입력받는다.
        - 입력된 구입 금액을 검증한다.
    - **당첨 번호 입력**
        - 당첨 번호를 입력받는다.
        - 입력된 당첨 번호를 검증한다.
    - **보너스 번호 입력**
        - 보너스 번호를 입력받는다.
        - 입력된 보너스 번호를 검증한다.

- **로또 결과 계산 과정 관리**
    - 구입 금액으로 로또 티켓을 구입한다.
    - 구입한 로또 티켓과 당첨 로또를 비교하여 결과를 계산한다.
    - 구입한 로또 티켓의 수익률을 계산한다.

- **로또 프로그램의 출력 관리**
    - 구입한 로또 티켓을 출력한다.
    - 당첨 통계를 출력한다.
        - 당첨 결과를 출력한다.
        - 당첨 수익률을 출력한다.

---

## 💬 Handler

### ConstantHandler (상수 핸들러)
- 로또 프로그램에서 사용하는 상수를 제공한다.

### ErrorHandler (에러 핸들러)
- **에러 관련 메시지 제공**
    - 오류 메시지가 `[ERROR]`로 시작하도록 한다.
    - 각 오류에 대해 `IllegalArgumentException`을 생성하여 예외를 발생시킨다.

### InputHandler (입력 메시지 핸들러)
- 입력 관련 메시지를 제공하여 사용자에게 입력을 요청한다.

### OutputHandler (출력 메시지 핸들러)
- 출력 관련 메시지를 제공하여 결과를 사용자에게 전달한다.

### PatternHandler (정규식 패턴 핸들러)
- **입력 검증을 위한 정규식 패턴 제공**
    - 구입 금액을 검증하는 정규식 패턴을 제공한다.
    - 당첨 번호를 검증하는 정규식 패턴을 제공한다.
    - 보너스 번호를 검증하는 정규식 패턴을 제공한다.
