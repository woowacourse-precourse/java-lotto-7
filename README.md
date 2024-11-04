# java-lotto-precourse


## 로또 구입 금액 입력
- [x] 로또 구입 금액을 입력받는다.(금액은 1,000원 단위로 입력받는다.)
- [x] 빈 문자가 입력됐을 경우 에외를 발생시킨다.
- [x] 로또 구입 금액이 1,000원 단위로 나누어 떨어지지 않을 경우 예외를 발생시킨다.
- [x] 로또 구입 금액에 숫자가 아닌 문자가 입력되었을 경우 예외를 발생시킨다.
- [x] 로또 구입 금액이 0보다 작을 경우 예외를 발생시킨다.

## 로또 당첨 번호 입력
- [x] 1부터 45 사이의 숫자 중 당첨 번호 6개를 입력받는다.(번호는 쉼표를 기준으로 구분한다.)
  - [x] 입력받은 서로 다른 6개의 당첨 번호는 오름차순으로 정렬한다.
- [x] 빈 문자가 입력됐을 경우 예외를 발생시킨다.
- [x] 쉼표 이외의 문자가 입력되었을 경우 예외를 발생시킨다.
- [x] 입력된 당첨 번호의 갯수가 6개가 아닐 경우 예외를 발생시킨다.
- [x] 입력된 당첨 번호가 1과 45 사이의 숫자가 아닐 경우 예외를 발생시킨다.

## 보너스 번호 입력
- [x] 1부터 45 사이의 보너스 번호 1개를 입력받는다.
- [x] 빈 문자가 입력됐을 경우 예외를 발생시킨다.
- [x] 입력된 당첨 번호가 숫자가 아닌 문자가 입력되었을 경우 예외를 발생시킨다.
- [x] 입력된 보너스 번호가 1과 45 사이의 숫자가 아닐 경우 예외를 발생시킨다.
- [x] 입력된 보너스 번호가 당첨 번호와 중복되는 경우 예외를 발생시킨다.

## 로또 발행
- [x] 1과 45 사이의 중복되지 않는 6개의 숫자를 뽑는다.
  - [x] 로또 번호는 오름차순으로 정렬한다.
  - [x] 발행된 로또 번호를 출력한다.
- [x] 발행된 로또 번호가 6개의 숫자가 아닐 경우 에외를 발생시킨다.
- [x] 6개의 숫자 사이에 중복된 숫자가 있을 경우 예외를 발생시킨다.
- [x] 발행된 로또 번호가 1과 45 사이의 숫자가 아닐 경우 예외를 발생시킨다.

## 당첨 계산 및 통계 출력
- [x] 발행된 로또를 당첨 번호, 보너스 번호와 비교해 당첨 내역을 확인한다.
  - [x] 일치하는 번호의 개수를 확인한다.
  - [x] 일치하는 번호의 개수만큼 수익을 측정한다.
    - [x] 3개의 당첨 번호가 일치하면 5,000원이며, 5등이다.
    - [x] 4개의 당첨 번호가 일치하면 50,000원이며, 4등이다.
    - [x] 5개의 당첨 번호가 일치하면 1,500,000원이며, 3등이다.
    - [x] 5개의 당첨 번호와 보너스 번호가 일치하면 30,000,000원이며, 2등이다.
    - [x] 6개의 당첨 번호가 일치하면 2,000,000,000이며, 1등이다.

## 수익률 출력
- [x] 사용자가 구입한 로또 금액과 당첨 금액으로 수익률을 확인한다.
  - [x] 수익률은 소수점 둘째 자리에서 반올림한다.

## message
- [x] 입출력 메시지를 enum으로 지정한다.
- [x] 에러 메시지를 enum으로 지정한다.
- [x] 로또 당첨 갯수에 따른 보상을 enum으로 지정한다.


# 예외처리

- [x] 빈 문자가 입력된 경우
- [x] 구매 금액으로 로또를 구매할 수 없는 경우
- [x] 로또 당첨 번호가 6개가 아닌 경우
- [x] 로또 당첨 번호의 범위가 1과 45 사이가 아닌 경우
- [x] 로또 당첨 번호가 중복되는 경우
- [x] 보너스 번호의 범위가 1과 45 사이가 아닌 경우
- [x] 보너스 번호가 당첨 번호와 중복되는 경우
- [x] 구매 금액, 당첨 번호, 보너스 번호에 숫자가 아닌 문자가 입력되었을 경우

# 테스트 케이스

## LottoTest
- [x] 로또 번호의 개수가 6개가 넘어가면 예외 발생
- [x] 로또 번호에 중복된 숫자가 있으면 예외 발생
- [x] 로또 번호에 빈 문자가 들어오면 예외 발생
- [x] 로또 번호에 1부터 45 사이가 아닌 숫자 또는 문자가 들어오면 예외 발생
- [x] 숫자 6개가 일치하면 1등에 당첨된다.
- [x] 숫자 5개가 일치하고 보너스 번호가 일치하면 2등에 당첨된다.
- [x] 숫자 5개가 일치하면 3등에 당첨된다.
- [x] 숫자 4개가 일치하면 4등에 당천된다.
- [x] 숫자 3개가 일치하면 5등에 당첨된다.
