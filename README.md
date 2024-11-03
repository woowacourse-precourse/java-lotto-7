# java-lotto-precourse
# 자동차 경주 게임 기능 명세서

## 로또 구매 금액 입출력 기능
- [x] 구입금액을 입력하라는 메시지 "구입금액을 입력해 주세요."를 출력한다.
- [x] 로또 구매 금액을 입력받는다.
- [x] 구입 금액은 1,000원 단위로 나누어 떨어지지 않는 경우 예외 처리를 한다.
    - [x] 구입 금액이 음수인 경우 에러 메시지를 출력한다
    - [x] 구입 금액이 1,000원 단위로 나누어 떨어지지 않는 경우 예외 처리를 한다.
    - [x] 예외가 발생했을 때 에러 메시지를 출력하고 그 부분부터 다시 시작할 수 있도록 한다.

## 로또 구매 기능
- [x] 사용자가 구매한 금액 만큼 로또를 구매한다.
- [x] 로또 번호를 1~45 사이에서 중복 없이 무작위로 6개를 뽑고 저장한다.
  - [x] 로또는 6개의 숫자를 저장하지 않으면 예외 출력한다.
  - [x] 로또의 숫자들이 중복되는 숫자가 있다면 예외를 출력한다.
  - [x] 로또의 숫자가 1~45 사이의 정수가 아니라면 예외를 출력한다.

## 구매 로또 출력 기능
- [x] 로또 구매 갯수를 알리는 메시지 "%d개를 구매했습니다." 를 출력한다.
- [x] 모든 로또를 다음과 같은 형태로 출력한다. "[8, 21, 23, 41, 42, 43]"

## 로또 당첨 번호 입력 기능
- [x] 로또 당첨 번호를 입력하라는 메시지 "당첨 번호를 입력해 주세요."를 출력한다.
- [x] 로또 당첨 번호를 1~45사이의 중복 없는 숫자로 받는다
    - [x] 1~45 사이의 숫자가 아닌 경우 에러 메시지를 출력한다.
    - [x] 예외가 발생했을 때 에러 메시지를 출력하고 그 부분부터 다시 입력을 받는다.
    - [x] Exception이 아닌 유형을 명확히 한다.

## 로또 보너스 번호 입력 기능
- [x] 보너스 번호를 입력하라는 메시지 "보너스 번호를 입력해 주세요."를 출력한다.
- [x] 보너스 번호를 입력받는다.
    - [x] 1~45 사이의 숫자가 아닌 경우 에러 메시지를 출력한다.
    - [x] 로또 당첨 번호와 중복이 없는지 확인한다.
    - [x] 예외가 발생했을 때 에러 메시지를 출력하고 그 부분부터 다시 입력을 받는다.
    - [x] Exception이 아닌 유형을 명확히 한다.

## 당첨 통계 출력 기능
- [] 당첨 통계의 시작을 알리는 메시지 "당첨 통계\n---"를 출력한다.
- [] 사용자가 산 로또의 번호와 로또 당첨 번호와의 비교를 통해 당첨 로또의 갯수를 구한다.
- [] 당첨 로또 개수에 기반해 메시지를 출력한다.

## 수익률 계산 기능
- [] 당첨 로또 개수에 기반해 당첨 총액을 계산한다.
- [] 당첨 총액과 구매 금액에 기반해 수익률을 계산한다.
- [] 수익률 메시지를 출력한다.