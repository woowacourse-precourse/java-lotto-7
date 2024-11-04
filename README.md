# 기능 요구 사항
- [x] 🎰 간단한 로또 발매기를 구현한다.

---

# 로또 구입 💵
로또 구입 기능은 사용자가 로또를 구입할 때 필요한 금액을 입력받고, 유효한 금액인지 검증하는 역할을 수행한다.

## 기능

- [x] 구입 금액을 입력받는 형식을 출력한다.
- [x] 로또 구입 금액을 입력 받는다.
- [x] 구입 금액은 1,000원 단위로 입력 받는다.

## 예외 상황
- [x] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
- [x] 입력값이 `null`인 경우 예외 처리한다. (예: 사용자가 아무것도 입력하지 않고 제출)
- [x] 빈 문자열 입력 시 예외 처리한다. (예: 사용자가 빈 문자열을 입력)
- [x] 입력된 구입 금액이 정수가 아닌 경우 예외 처리한다.
- [x] 음수 입력 시 예외 처리한다. (예: -1000과 같은 음수)
- [x] 0 입력 시 예외 처리한다. (예: 0원 입력)
- [x] 입력된 금액이 너무 큰 경우 예외 처리한다. (예: 1억이 넘는 경우)
- [x] 구입 금액이 1,000원 단위가 아닐 경우 예외 처리한다.
- [x] 입력값에 문제가 발생하면 오류 메시지를 출력하고, 해당 입력 부분부터 다시 입력받는다.


---

# 로또 발행 🎟️
로또 발행 기능은 사용자가 입력한 금액에 따라 로또를 발행하고, 발행한 로또 번호를 출력하는 역할을 수행한다.

## 기능

- [x] 구매한 로또 티켓 수를 계산한다.
- [x] 구매한 로또 티켓 수를 안내하는 메시지를 출력한다.
- [x] 로또를 발행한다.
  - [x] 로또 번호는 6개, 보너스 번호는 1개로 구성되며, 보너스 번호는 로또 번호에 포함되지 않아야 한다.
  - [x] 구입 금액에 해당하는 만큼의 로또를 발행한다.
  - [x] 당첨 번호는 1~45 사이의 중복 없는 숫자로 이루어진다.
- [x] 발행한 로또 수량 및 번호를 출력한다.
  - [x] 로또 번호는 오름차순으로 정렬하여 보여준다.
  - [x] 로도 번호들을 출력 형식에 맞춰 출력한다.

## 예외 상황
- [x] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
- [x] 계산된 로또 티켓 수가 알맞지 않은 경우 예외 처리한다.
- [x] 발행된 로또 번호가 중복되는 경우 예외 처리한다. (로또 번호 생성 시 발생할 수 있는 오류 방지)

---

# 로또 🎯
로또 기능은 추첨에 사용될 6개의 번호를 입력받고, 유효한지 검증하는 역할을 수행한다.

## 기능

- [x] 로또 번호를 입력받는 형식을 출력한다.
- [x] 6개의 로또 번호를 입력 받는다.
  - [x] 번호는 쉼표(,)를 기준으로 입력 받는다.
  - [x] 입력 받은 로또 번호는 중복되지 않는다.

## 예외 상황
- [x] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
- [x] 입력값이 `null`인 경우 예외 처리한다. (예: 사용자가 아무것도 입력하지 않고 제출)
- [x] 빈 문자열 입력 시 예외 처리한다. (예: 사용자가 빈 문자열을 입력)
- [x] 숫자가 아닌 값을 입력할 경우 예외 처리한다.
- [x] 쉼표(,)로 나누어지지 않은 경우 예외 처리한다. 
- [x] 입력된 로또 번호 중 숫자가 범위를 벗어나는 경우 예외 처리한다. (예: 1~45 사이가 아닌 숫자)
- [x] 입력된 로또 번호가 6개 미만 또는 초과인 경우 예외 처리한다.
- [x] 중복된 숫자가 입력된 경우 예외 처리한다.
- [x] 입력값에 문제가 발생하면 오류 메시지를 출력하고, 해당 입력 부분부터 다시 입력받는다.

---

# 보너스 🎁
보너스 기능은 당첨 번호와 중복되지 않는 보너스 번호를 입력받고 관리하는 역할을 수행한다.

## 기능

- [x] 보너스 번호를 입력받는 형식을 출력한다.
- [x] 보너스 번호를 입력 받는다.
  - [x] 보너스 번호는 당첨 번호와 중복되지 않는다.

## 예외 상황
- [x] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
- [x] 입력값이 `null`인 경우 예외 처리한다. (예: 사용자가 아무것도 입력하지 않고 제출)
- [x] 빈 문자열 입력 시 예외 처리한다. (예: 사용자가 빈 문자열을 입력)
- [x] 정수가 아닌 값이 입력될 경우 예외 처리한다.
- [x] 입력된 보너스 번호가 1~45 범위를 벗어나는 경우 예외 처리한다.
- [x] 보너스 번호와 당첨 번호가 중복될 경우 예외 처리한다.
- [x] 입력값에 문제가 발생하면 오류 메시지를 출력하고, 해당 입력 부분부터 다시 입력받는다.

---

# 당첨 통계 📊
당첨 통계 기능은 추첨 결과에 따라 당첨 여부를 계산하고, 수익률을 산출하여 출력하는 역할을 수행한다.

## 기능

- [x] 당첨 통계 형식 헤더를 출력한다.
- [x] 당첨 내역을 계산한다.
  - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - [x] 1등: 6개 번호 일치 / 2,000,000,000원
    - [x] 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - [x] 3등: 5개 번호 일치 / 1,500,000원
    - [x] 4등: 4개 번호 일치 / 50,000원
    - [x] 5등: 3개 번호 일치 / 5,000원
- [x] 당첨 내역을 출력한다.
- [x] 수익률을 계산한다.
  - [x] 수익률은 소수점 둘째 자리에서 반올림한다.
- [x] 수익률 형식을 출력한다.
  - [x] 수익률은 소수 첫째 자리까지 표시하고, % 기호를 포함해 출력한다.
  - [ ] 수익률 형식을 1000단위 콤마로 구분하여 표시한다.

## 예외 상황
- [x] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
- [x] 총 구매 금액이 0일 경우 예외 처리한다.
