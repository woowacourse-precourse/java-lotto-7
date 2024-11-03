# java-lotto-precourse

# 기능 목록

## 1. 로또 구매 금액을 입력받는다.

- [x] 로또 구매 금액은 `1,000`으로 나누어 떨어지는 양의 정수를 입력받는다.
    - [x] 아닐 경우 예외 처리후 다시 입력받는다.

## 2. 로또 구매 금액에 알맞는 수 만큼 로또를 발행한다.

- [x] 로또는 `로또 구매 금액 / 1000`만큼 구매한다.
- [x] 로또는 `1` 이상 `45` 이하의 정수 6개로 구성된다.
- [x] 로또에는 중복되는 수가 존재하지 않는다.
    - [x] 중복되는 수가 존재할 경우, 중복되는 수가 존재하지 않도록 다시 생성한다.

## 3. 발행한 로또 수량과 번호를 출력한다.

- [x] 로또는 오름차순 순서로 정렬하여 출력한다.

## 4. 당첨 번호, 보너스 번호를 입력받는다.
- [x] 당첨 번호는 `,`로 구분하여 입력받는다.
- [x] 당첨 번호와 보너스 번호는 모두 `1` 이상 `45` 이하의 정수이다.
- [x] 당첨 번호는 `6`개, 보너스 번호는 `1`개의 수로 구성된다.
- [x] 당첨 번호와 보너스 번호 총 `7`개의 수에는 중복되는 수가 존재하지 않는다.
    - [x] 아닐 경우 예외 처리후 다시 입력받는다.

## 5. 발행한 로또와 당첨 번호, 보너스 번호를 비교한다.

- [x] 당첨 내역에 따라 결과를 기록한다.

## 6. 당첨 내역과 수익률을 출력한다.

- [x] 수익률은 소수점 둘째 자리에서 반올림 한다.

## 이외 고려 사항

- [x] 모든 예외에는 `[ERROR]`로 시작하는 에러 문구를 출력해야 한다.
