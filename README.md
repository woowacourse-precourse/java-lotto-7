# java-lotto-precourse

간단한 로또 발매기를 구현하는 프로젝트 입니다. 
## 프로그램 동작
로또 번호는 1~45  사이의 숫자 중 6개를 랜덤하게 생성하며, 당첨 번호와 보너스 번호를 입력 받아 당첨 결과를 계산합니다.

당첨은 1등부터 5등까지 있으며 당첨 기준과 금액은 아래와 같습니다:

- 1등: 6개 번호 일치 / 2,000,000,000원
- 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
- 3등: 5개 번호 일치 / 1,500,000원
- 4등: 4개 번호 일치 / 50,000원
- 5등: 3개 번호 일치 / 5,000원

## 기능 구현  목록
1. 로또 구입 금액 입력
    - 구입 금액을 입력 받고 입력된 금액이 유효한지 검증
      - [✅] 구입 금액은 1000원 단위로 입력 받으며 1,000원 으로 나누어 떨어지지 않는 경우 예외처리한다.
      - [✅] 구입 금액이 1000원 미만인 경우 예외처리한다.
      - [✅] 입력이 숫자가 아닌 경우 예외처리한다.
      - [✅] 사용자 입력에 대한 예외는 IllegalArgumentException 을 발생시킨다.
2. 당첨 번호 입력 
    - 로또 번호를 입력 받고 입력된 금액이 유효한지 검증
      - [✅] 당첨 번호를 입력 받는다. 번호는 쉼표 `,` 를 기준으로 구분한다
      - [✅] 당첨 번호의 숫자 범위는 1~45 사이의 숫자여야 하며 중복되지 않아야 한다.
      - [✅] 당첨 번호는 중복되지 않는 6개의 숫자와 보너스 번호 1개를 입력받는다.
        - 당첨 번호와 보너스 번호는 중복되지 않아야 한다.
      - [✅] 입력이 숫자가 아닌 경우 예외처리한다.
      - [✅] 사용자 입력에 대한 예외는 IllegalArgumentException 을 발생시킨다.
3. 로또 발매
    - 랜덤한 로또 번호 생성 기능
      - [✅] 로또 한 장을 발행할 떄 1~45 사이의 서로 다른 6개의 숫자를 랜덤하게 생성한다.
    - 로또 구입 금액에 따른 로또 발행 기능
      - [✅] 위에 로또 번호 생성을 이용하여 구입 금액에 따른 로또를 발행한다.
4. 당첨 결과 계산
    - 당첨 번호와 사용자 로또 번호를 비교하여 당첨 결과를 계산
      - [✅] 당첨 번호와 로또 번호를 비교하여 당첨 결과를 계산한다.
      - [✅] 보너스 번호를 비교하여 2등 당첨 여부를 판단한다.
    - 당첨 결과를 종합
      - [✅] 당첨 결과를 종합하여 각 등수별 당첨된 로또의 개수와 수익률을 계산한다.
        - 수익률은 소수점 둘쨰 자리에서 반올림 한다.
5. 당첨 결과 출력
    - 당첨 결과 출력
      - [✅] 각 등수별로 당첨된 로또의 개수와 해당 등수의 상금을 출력합니다.
      
## 예외 처리
- 사용자 입력에 대한 예외는 IllegalArgumentException 을 발생시킨다.
- `[ERROR]` 로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- `Exception` 이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.