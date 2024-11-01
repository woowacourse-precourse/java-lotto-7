# java-lotto-precourse

### 기능 요구 사항
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
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다

### 기능 목록
- 구입 금액 입력
- 로또 구매
- 로또 번호 선정
- 로또 출력
- 당첨 번호 입력
- 보너스 번호 입력
- 당첨 확인
- 당첨 출력
- 총 수익률 계산
- 총 수익률 출력
- 숫자 외 입력 예외 처리
- 구입 금액 예외 처리
- 당첨 번호 중복 예외 처리
- 보너스 번호 중복 예외 처리

### 예외 목록
- 로또 번호
  - 번호가 6개 보다 적거나 많을 때
  - 중복된 번호가 존재
  - 로또 번호의 범위를 넘어갈 때
- 구입 금액
  - 1000으로 나누어 떨어지지 않을 때
  - 음수일 때
  - 숫자가 아닌 값이 입력 되었을 때
  - null이나 공백일 때
- 당첨 번호
  - 숫자가 아닌 값이 입력 되었을 때
  - null이나 공백일 때
  - 로또 번호의 범위를 넘어갈 때
  - 번호가 6개 보다 적거나 많을 때
- 보너스 번호
  - 로또 번호의 범위를 넘어갈 때
  - 숫자가 아닌 값이 입력 되었을 때
  - null이나 공백일 때
  - 당첨 번호랑 중복일 때