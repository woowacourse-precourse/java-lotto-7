# 🍀 프리코스 3주차 <로또>

## 💡 프로젝트 소개

- 간단한 **로또 발매기**를 구현합니다.
    - 사용자는 로또를 얼마치 구매할 것인지 입력할 수 있습니다.
    - 이후, 당첨 번호를 입력합니다.
    - 프로그램은 사용자가 구매한 로또의 번호와 당첨 번호가 얼마나 일치하는지 계산합니다.
    - 이를 통해 수익률을 출력합니다.

## ⚙️ 기능 목록

### 📌 로또 구입 금액 입력

- `구입금액을 입력해 주세요.`라는 문구와 함께 로또 구입 금액을 입력 받습니다.
- 구입 금액은 1,000원 단위로 입력 받습니다.
    - ex) `14000`

### 📌 발행 로또 수량 구하기 : `findNumberOfLotto()`

- 입력한 로또 구입 금액을 1,000원(로또 1개 가격)으로 나누어 구입한 로또 개수를 구합니다.

### 📌 로또 번호 발행하기 : `outLotteryNumbers()`

- 구입한 로또의 번호를 정합니다.
- 발행되는 로또 번호는 중복되지 않는 6개의 숫자입니다.
- 숫자 범위는 `1~45`입니다.

### 📌 당첨 번호 입력 : `getWinningNumber()`

- 중복되지 않는 당첨 번호를 6개 입력 받습니다.
- 번호는 `,`를 기준으로 구분하며, 숫자 범위는 `1~45`입니다.
- ex) `1,2,3,4,5,6`

### 📌 보너스 번호 입력 : `getBonusNumber()`

- 당첨 번호를 6개 입력 받습니다.
- 번호는 `,`를 기준으로 구분합니다.
    - ex) `1,2,3,4,5,6`

### 📌 당첨 번호 일치 개수 반환

- 사용자가 구매한 로또 번호와 6개의 당첨 번호가 몇 개 일치하는지 구합니다.

### 📌 보너스 번호 일치 여부 확인

- 사용자가 구매한 로또 번호와 1개의 보너스 번호가 일치하는지 확인합니다.

### 📌 수익률 구하기

- 로또의 수익률을 구합니다.
    - 수익률 = 당첨 금액 / 지불 비용

### 📌 발행 로또 수량 출력

- 발행한 로또가 몇 개인지 출력합니다.
    - 출력 예시) `1개를 구매했습니다.`

### 📌 발행 로또 번호 출력

- 오름차순으로 정렬해서 출력합니다.
    - 출력 예시) `[8, 21, 23, 41, 42, 43]`

### 📌 당첨 내역 출력

- 당첨 내역을 출력합니다.

### 📌 수익률 출력

- 수익률을 출력합니다.
- 수익률은 소수점 둘째 자리에서 반올림합니다.
    - 출력 예시) `총 수익률은 62.5%입니다.`

### 📌 예외처리

- 아래 상황에 대한 예외처리를 합니다.
  - 로또 구입 금액이 1,000원 단위가 아닌 경우
  - 로또 구입 금액에 숫자 말고 다른 문자가 있는 경우
  - 로또 구입 금액이 빈 문자열인 경우

### 📌 에러 문구 출력

- 예외 상황 시, 에러 문구를 출력합니다.
    - 에러 문구는 `[ERROR]`로 시작해야 합니다.
    - 출력 예시) `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`
