# java-lotto-precourse

## 📝  **로또 게임 규칙**

- 로또 번호의 숫자 범위는 1~45 까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.

## **🔍  로또 게임 동작 순서**

1. 로또 구입 금액을 입력 받는다
2. 로또를 발매한다.
3. 발매한 로또 수량 및 번호를 출력한다.
4. 당첨 번호를 입력 받는다.
5. 보너스 번호를 입력 받는다.
6. 당첨 내역을 출력한다.
7. 수익률을 출력한다.

**실행 결과 예시**
```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

## **🚀** 객체별 기능 목록

1. **손님(Customer)**
    - [ ]  로또를 구입할 금액 입력한다.
    - [ ]  금액 만큼 로또를 발급받는다.
    - [ ]  로또 당첨 확인을 요청한다.


2. **로또 판매원(LottoSeller)**
    - [X]  구입 금액을 입력받는다.
    - [X]  구입 금액을 검증한다.
        - [X]  입력된 금액이 양수인지 검증한다.
        - [X]  입력된 금액이 1,000으로 나누어떨어지는지 검증한다.
        - [X]  (입력된 금액 / 1000)만큼 로또 발행한다.
    - [X]  발행한 로또 번호들을 출력한다.


3. **로또 발생기(Lotto)**
    - [X]  6자리의 로또 번호 생성한다.
    - [X]  6자리의 로또 번호를 입력받아 검증한다.
        - [X]  양수로만 이루어져있는지 검증한다.
        - [X]  중복이 있는지 검증한다.
        - [X]  입력받은 숫자가 6개인지 검증한다.
        - [X]  1~45 사이의 숫자로 이루어져있는지 검증한다.
    - [X]  오름차순으로 정렬한다.


5. **로또 게임 진행자(LottoHost)**
    - [ ]  사용자에게 로또 당첨번호를 입력받는다.
        - [ ]  입력받은 문자열을 쉼표(,)를 기준으로 분리한다.
        - [ ]  분리된 문자들을 검증한다.
    - [ ]  사용자에게 보너스 번호를 입력받는다.
        - [ ]  입력받은 보너스 번호를 검증한다.
    - [ ]  당첨 결과를 출력한다.
        - [ ]  손님에게 로또 번호들을 입력받아 당첨 여부를 확인한다.
    - [ ]  수익률을 출력한다.
        - [ ]  수익률을 계산한다.