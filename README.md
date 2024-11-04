# java-lotto-precourse

---

# 💰간단한 로또 발매기

## 기능 목록

---

- [x] 로또 구입 금액을 입력받는다.
  - 입력 값이 공백일 경우 IllegalArgumentException을 발생시킨다.
  - 양의 정수가 아닐 경우 IllegalArgumentException을 발생시킨다.
- [x] 사용자가 잘못된 값을 입력할 경우 예외를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력하고, 그 부분부터 입력을 다시 받는다.
- [x] 로또 구입 금액에 해당하는 만큼 로또를 발행한다.
    - 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 IllegalArgumentException을 발생시킨다.
    - 로또 번호의 숫자 범위가 1~45가 아닐 경우 IllegalArgumentException을 발생시킨다.
    - 로또 번호 중 중복되는 수가 있을 경우 IllegalArgumentException을 발생시킨다.
    - 로또 번호의 개수가 6개가 아니면 IllegalArgumentException을 발생시킨다.
- [x] 로또 1장의 가격은 1,000원이다.
- [x] 로또의 6개의 숫자는 오름차순으로 정렬되어 있어야한다.
- [x] 사용자가 구매한 로또를 출력한다.
- [x] 당첨 번호 6개를 입력받는다.
  - 입력 값이 공백일 경우 IllegalArgumentException을 발생시킨다.
  - 당첨 번호가 0 이상인 정수가 아니면 IllegalArgumentException을 발생시킨다.
  - 당첨 번호가 6개가 아니면, IllegalArgumentException을 발생시킨다.
  - 당첨 번호 중 중복되는 것이 있다면, IllegalArgumentException을 발생시킨다.
  - 당첨 번호가 1~45까지가 아니면, IllegalArgumentException을 발생시킨다.
- [x] 보너스 번호를 입력받는다.
    - 입력 값이 공백일 경우 IllegalArgumentException을 발생시킨다.
    - 보너스 번호를 입력받을 때 0 이상의 정수가 아니면 IllegalArgumentException을 발생시킨다.
    - 보넌스 번호가 1~45까지가 아니면, IllegalArgumentException을 발생시킨다.
- [x] 등수에 따른 금액을 명시한다
    - 1등: 2,000,000,000원
    - 2등: 30,000,000원
    - 3등: 1,500,000원
    - 4등: 50,000원
    - 5등: 5,000원
- [x] 로또 당첨 기준을 정한다.
    - 1등: 6개 번호 일치
    - 2등: 5개 번호 + 보너스 번호 일치
    - 3등: 5개 번호 일치
    - 4등: 4개 번호 일치
    - 5등: 3개 번호 일치
- [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 반환한다.
- [x] 로또 결과와 투자 금액을 비교해 수익률을 반환한다.
- [x] 당첨 내역을 출력한다.
- [x] 수익률을 출력한다.