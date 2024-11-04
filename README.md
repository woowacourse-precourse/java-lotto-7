# java-lotto-precourse

## 구현할 기능 목록

- [ ] 로또 발매기
  - [X] 로또 구입 금액을 입력받는다.
    - [X] 로또는 한 장에 1,000원이다.
    - [X] 로또 구입 금액이 1,000으로 나누어 떨어져야 한다.
      - 가능한 예시:
        - 14000
        - 8000
      - 불가능한 예시:
        - 1500
        - 1000i
    - [X] 1,000원으로 나눈 값이 구매한 로또 개수이다.
  - [X] 로또를 발행한다.
    - [X] 구매한 로또 개수만큼 로또를 발행한다.
    - [X] 한 장의 로또에는 중복되지 않는 숫자 6개가 발행된다.
    - [X] 발행되는 로또 숫자의 범위는 1~45 범위 내에 있어야 한다.
      - 가능한 예시:
        - 8, 21, 23, 41, 42, 43
      - 불가능한 예시:
        - 8, 21, 23, 41, 42, 46
    - [X] 발행한 로또 숫자는 `[`와 `]` 안에 쉼표로 구분해 출력한다.
      - 예시 :
        - \[8, 21, 23, 41, 42, 43\]
  - [ ] 로또를 추첨한다.
    - [X] 사용자에게 당첨 번호 6개를 입력 받는다.
      - [X] 번호는 쉼표를 기준으로 구분한다.
        - 예시:
          - 1,2,3,4,5,6
    - [ ] 수익률은 로또 구입 금액과 당첨금의 비율로 계산한다.
      - [ ] 수익률은 소수점 둘째 자리에서 반올림한다.
    - [ ] 당첨 통계를 출력한다.
      - [X] 각 숫자는 1~45 범위 내에 있어야 한다. 
    - [X] 사용자에게 보너스 번호 하나를 입력받는다.
      - [X] 보너스 번호의 숫자는 1~45 범위 내에 있어야 한다.
  - [X] 당첨 내역과 수익률을 산출한다.
    - [X] 사용자가 구매한 로또 번호와 당첨 번호를 비교한다.
    - [X] 당첨 기준과 수익률은 다음과 같다.
      - [X] 1등 : 6개 번호 일치 (2,000,000,000원)
      - [X] 2등 : 5개 번호 + 보너스 번호 일치 (30,000,000원)
      - [X] 3등 : 5개 번호 일치 (1,500,000원)
      - [X] 4등 : 4개 번호 일치 (50,000원)
      - [X] 5등 : 3개 번호 일치 (5,000원)
      - 예시 : 
        ```
        당첨통계
        ---
        3개 일치 (5,000원) - 1개
        4개 일치 (50,000원) - 0개
        5개 일치 (1,500,000원) - 0개
        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
        6개 일치 (2,000,000,000원) - 0개
        총 수익률은 62.5%입니다.
        ```
