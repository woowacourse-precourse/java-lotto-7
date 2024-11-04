# java-lotto-precourse

## 목표
- 객체지향적 설계
- TDD와 같이 테스트를 먼저 만들고 테스트에 맞춰 구현
- git comment 일관성 있게 작성

## 요구 사항
### 기능 요구 사항
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
- 로또는 최대 100개까지 구매할 수 있다.
- 로또 구입 금액은 1,000원의 배수이다.
- 로또는 최소 1개이상 구입해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌`IllegalArgumentException`,`IllegalStateException`등과 같은 명확한 유형을 처리한다.

### 예외 요구 사항
- 로또 구입 금액을 입력 받는 경우
  - 숫자가 아닌 문자가 있는 경우 예외 처리
  - 10만원 이상의 금액을 입력할 경우 예외 처리
  - 1,000원으로 나누어 떨어지지 않는 경우 예외 처리
  - 1,000원 보다 낮은 숫자인 경우 예외 처리
- 당첨 번호를 입력 받는 경우
  - 숫자, 쉼표를 제외한 문자가 있는 경우 예외 처리
  - 숫자가 6개가 아닌 경우 예외 처리
  - 숫자가 1~45가 아닌 경우 예외 처리
  - 숫자가 중복되는 경우 예외 처리
- 보너스 번호를 입력 받는 경우
  - 숫자가 아닌 문자가 있는 경우 예외 처리
  - 숫자가 1~45가 아닌 경우 예외 처리
  - 숫자가 당첨 번호에 존재하는 번호일 경우 예외 처리

## 패키지 구조
- Application.java
- controller
  - LottoController.java
- exception
  - ErrorMessage.java
  - LottoException.java
- model
  - Lotto.java
  - LottoMachine.java
  - Rank.java
  - Result.java
- view
  - InputHelper.java
  - OutputHelper.java
- validate
  - Validator.java

## UML
![InputHelper](https://github.com/user-attachments/assets/8771e0f8-1d6e-4704-bc51-bf36ddc838d8)