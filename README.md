# java-lotto-precourse

## 기능 목록

- [x]  구입금액 입력 안내 문구를 출력한다.

   ```java
   구입금액을 입력해 주세요.
   ```


- [x]  구입금액을 입력 받는다.
    - [x]  구입금액이 숫자로만 이루어진 문자열이 아니라면 예외가 발생한다.
      - [ ]  에러 문구를 출력하고 구입금액을 다시 입력받는다.

- [x]  로또 구입 개수를 계산한다.
    - [x]  구입금액이 1000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.
      - [ ]  에러 문구를 출력하고 구입금액을 다시 입력받는다.


- [ ]  로또 구입 개수만큼 로또를 발행한다.
    - [x]  로또를 발행한다.
        - [x]  로또 번호가 6개가 아니라면 예외가 발생한다.
        - [x]  로또 번호가 1~45 범위가 아니라면 예외가 발생한다.
        - [x]  로또 번호에 중복이 있다면 예외가 발생한다.
    - [x]  발행한 로또를 저장한다.
- [x]  구매한 로또 수량을 출력한다.

   ```java
   8개를 구매했습니다.
   ```


- [x]  구매한 로또의 번호를 오름차순으로 정렬하여 출력한다.

   ```java
   [8, 21, 23, 41, 42, 43] 
   [3, 5, 11, 16, 32, 38] 
   [7, 11, 16, 35, 36, 44] 
   [1, 8, 11, 31, 41, 42] 
   [13, 14, 16, 38, 42, 45] 
   [7, 11, 30, 40, 42, 43] 
   [2, 13, 22, 32, 38, 45] 
   [1, 3, 5, 14, 22, 45]
   ```


- [x]  당첨 번호 입력 안내 문구를 출력한다.

   ```java
   당첨 번호를 입력해 주세요.
   ```


- [x]  당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
    - [ ]  당첨 번호가 6개가 아니라면 예외가 발생한다.
    - [ ]  당첨 번호가 숫자타입이 아니라면 예외가 발생한다.
    - [ ]  당첨 번호가 1~45 범위가 아니라면 예외가 발생한다.
    - [ ]  당첨 번호에 중복이 있다면 예외가 발생한다.
      - [ ]  에러 문구를 출력하고 당첨번호를 다시 입력받는다.


- [ ]  보너스 번호 입력 안내 문구를 출력한다.

   ```java
   보너스 번호를 입력해 주세요.
   ```


- [ ]  보너스 번호를 입력받는다.
    - [ ]  보너스 번호가 숫자타입이 아니라면 예외가 발생한다.
    - [ ]  보너스 번호가 1~45 범위가 아니라면 예외가 발생한다.
    - [ ]  보너스 번호가 당첨 번호와 중복이 있다면 예외가 발생한다.
      - [ ]  에러 문구를 출력하고 보너스 번호를 다시 입력받는다.


- [ ]  발행한 로또들의 당첨 번호와 비교한다.
    - [ ]  1등에 당첨되었는지 비교한다. (6개 번호 일치)
    - [ ]  당첨되지 않았다면, 2등에 당첨되었는지 비교한다. (5개 번호 + 보너스 번호 일치)
    - [ ]  당첨되지 않았다면, 3등에 당첨되었는지 비교한다. (5개 번호 일치)
    - [ ]  당첨되지 않았다면, 4등에 당첨되었는지 비교한다. (4개 번호 일치)
    - [ ]  당첨되지 않았다면, 5등에 당첨되었는지 비교한다. (3개 번호 일치)

- [ ]  당첨 내역을 출력한다.

   ```java
   3개 일치 (5,000원) - 1개
   4개 일치 (50,000원) - 0개
   5개 일치 (1,500,000원) - 0개
   5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
   6개 일치 (2,000,000,000원) - 0개
   ```


- [ ]  총 수익률을 계산한다. (수익금액 / 구입금액)

- [ ]  총 수익률을 소수점 둘째 자리에서 반올림하여 출력한다.

   ```java
   총 수익률은 62.5%입니다.
   ```