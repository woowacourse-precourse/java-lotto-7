# 로또

## 기능 요구 사항
간단한 로또 발매기를 구현한다.

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

---
## 프로그램 실행 흐름, 초기 검증 목록
1. 사용자가 구입 금액을 입력한다
   1. 구입 금액이 1,000원 으로 나누어 떨어지지 않을 경우 예외 처리
   2. 구입 금액에 허용되지 않는 문자가 입력됐을 경우 예외 처리
      1. 문자
      2. 공백
      3. 특수문자
      4. 실수
      5. 공백을 포함한 숫자 (시작, 중간, 끝)
      6. 0으로 시작되는 숫자
   3. 구입 금액의 최대치를 초과하는 값이 입력됐을 경우 예외 처리
   4. 1,000원 이하의 금액이 입력됐을 경우 예외 처리
2. 구입 금액에 따른 로또를 발행한다
3. 발행된 로또를 구입한 횟수만큼 출력한다
4. 사용자가 로또 당첨 번호 6개를 입력한다
   1. 당첨 번호에 허용되지 않는 문자가 입력될 경우 예외 처리
      1. 쉼표(,) 를 제외한 특수문자
      2. 문자 (음수, 실수가 자동으로 포함)
      3. 공백
      4. 공백을 포함한 숫자 (1 2, 3 6)
   2. 중복되는 숫자가 입력됐을 경우 예외 처리
   3. 6개보다 많은 숫자가 입력됐을 경우 예외 처리
   4. 6개보다 적은 숫자가 입력됐을 경우 예외 처리
   5. 1 ~ 45 사이의 값이 아닌 숫자가 입력됐을 경우 예외 처리
5. 사용자가 보너스 번호 1개를 입력한다
    1. 당첨 번호에 허용되지 않는 문자가 입력될 경우 예외 처리
       1. 특수문자
       2. 문자 (음수, 실수가 자동으로 포함) 
       3. 공백
       4. 공백을 포함한 숫자 (1 2, 3 6)
    2. 1 ~ 45 사이의 값이 아닌 숫자가 입력됐을 경우 예외 처리
6. 발행된 로또들과 당첨 번호를 비교한다
7. 당첨 내역 및 수익률을 출력한다

---
### 주요 객체의 역할 및 상태

로또
- 상태
  - 6개의 로또 번호를 가진다
    
로또 가게
- 속성
  - 로또 한장의 가격을 가진다.
- 역할
  - 받은 금액만큼 로또를 발행한다

로또 결과
- 역할
  - 발행된 로또들과 당첨 번호를 비교해서 당첨 내역 및 수익률을 계산한다.

## 진행 상황
1. [x] 사용자가 구입 금액을 입력한다
    1. [ ] 구입 금액이 1,000원 으로 나누어 떨어지지 않을 경우 예외 처리
    2. [ ] 구입 금액에 허용되지 않는 문자가 입력됐을 경우 예외 처리
        1. [ ] 문자
        2. [ ] 공백
        3. [ ] 특수문자
        4. [ ] 실수
        5. [ ] 공백을 포함한 숫자 (시작, 중간, 끝)
        6. [ ] 0으로 시작되는 숫자
    3. [ ] 구입 금액의 최대치를 초과하는 값이 입력됐을 경우 예외 처리
    4. [ ] 1,000원 이하의 금액이 입력됐을 경우 예외 처리
2. [x] 구입 금액에 따른 로또를 발행한다
3. [x] 발행된 로또를 구입한 횟수만큼 출력한다
4. [x] 사용자가 로또 당첨 번호 6개를 입력한다
    1. [x] 당첨 번호에 허용되지 않는 문자가 입력될 경우 예외 처리
        1. [x] 쉼표(,) 를 제외한 특수문자
        2. [x] 문자 (음수, 실수가 자동으로 포함)
        3. [x] 공백
        4. [x] 공백을 포함한 숫자 (1 2, 3 6)
    2. [x] 중복되는 숫자가 입력됐을 경우 예외 처리
    3. [x] 6개보다 많은 숫자가 입력됐을 경우 예외 처리
    4. [x] 6개보다 적은 숫자가 입력됐을 경우 예외 처리
    5. [x] 1 ~ 45 사이의 값이 아닌 숫자가 입력됐을 경우 예외 처리
5. [x] 사용자가 보너스 번호 1개를 입력한다
    1. [x] 당첨 번호에 허용되지 않는 문자가 입력될 경우 예외 처리
        1. [x] 특수문자
        2. [x] 문자 (음수, 실수가 자동으로 포함)
        3. [x] 공백
        4. [x] 공백을 포함한 숫자 (1 2, 3 6)
    2. [x] 1 ~ 45 사이의 값이 아닌 숫자가 입력됐을 경우 예외 처리
6. [x] 발행된 로또들과 당첨 번호를 비교한다
7. [x] 당첨 내역 및 수익률을 출력한다
