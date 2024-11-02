# java-lotto-precourse

## 🚀 기능 목록

### 🎰 LottoGame

- [x] 로또 번호를 생성한다.
  - [x] 금액을 1000으로 나누어 로또 개수를 구한다.
  - [x] 로또 개수 만큼 랜덤 번호를 생성한다.
    - [x] 생성된 랜덤 번호로 Lotto 인스턴스를 생성한다.
  - [x] 생성된 로또 번호를 출력한다.
- [x] 당첨 통계를 확인한다.
  - [x] 각 Lotto 인스턴스에 로또 당첨 번호를 비교한다.

### 🎟️ Lotto

- [x] WinnerLotto를 입력받아 비교하여 Rank를 반환한다.
  - [x] 일치하는 번호가 3개보다 적다면 Optioonal.empty를 반환한다.
  - [x] 일치하는 번호가 5개이고, 보너스 볼이 일치한다면 Second Rank를 반환한다.
  - [x] 일치하는 번호가 3개 이상이라면이라면 Rank를 반환한다.

## 🏅 WinningLotto

- [x] Lotto 인스턴스를 상속받는다.
- [x] Lotto에서 멤버 변수에 접근이 가능하도록 한다.

### 🛠️ InputHandler

- [x] 구매 금액을 입력 받는다.
  - [x] 구매 금액 입력 힌트를 출력한다.
- [x] 로또 당첨 번호를 입력받는다.
  - [x] 로또 당첨 번호 입력 힌트를 출력한다.
- [x] 보너스 볼을 입력받는다.
  - [x] 로또 당첨 번호 입력 힌트를 출력한다.

### 🏆 Rank - enum

- [x]  매치 개수에 따라 순위를 반환한다.
- [x] 각 순위에 맞게 당첨 금액을 반환한다.

### 📋 WinnerResult

- [x] 3개 이상 일치하는 로또의 수를 저장한다.
- [x] 구입 금액과 당첨된 로또 금액을 계산하여 수익률을 반환한다.

### 🛠️ Validator️️️️

- [x] 금액 유효성을 검사한다.
  - [x] 숫자인지 검사한다.
    - [x] 숫자가 아니라면 `IllegalArgumentException`을 발생시킨다.
  - [x] 금액이 1000원 단위인지 검사한다.
    - [x] 금액이 1000원 단위가 아니라면 `IllegalArgumentException`을 발생시킨다.
  - [x] 당첨 번호 유효성을 검사한다.
    - [x] 숫자인지 검사한다.
      - [x] 숫자가 아니라면 `IllegalArgumentException`을 발생시킨다.
    - [x] 당첨 번호가 6개인지 검사한다.
      - [x] 당첨 번호가 6개가 아니라면 `IllegalArgumentException`을 발생시킨다.
    - [x] 로또 당첨 번호가 1~45 사이의 숫자인지 검사한다.
      - [x] 로또 당첨 번호가 1~45 사이의 숫자가 아니라면 `IllegalArgumentException`을 발생시킨다.

### ⚠️ ErrorMessage

- [x] 각 값에 맞는 error message를 정의한다.
- [x] error message 반환 시 `[ERROR]` 접두사를 붙인다.

### 🚨 LottoGameIllegalArgumentException

- [x] `IllegalArgumentException`을 상속받아 `IllegalArgumentException`예외처럼 처리할 수 있도록 한다.
- [x] `ErrorMessage`를 받아, 예외를 초기화 한다.
- [x] 초기화 시 예외 메시지를 출력한다.
