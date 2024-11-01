### 구현할 기능 정리

- [x] 로또 구입 금액을 입력받는다.
    - [x] 예외처리: 숫자가 입력되지 않은 경우
    - [x] 예외처리: 음수가 입력된 경우
    - [x] 예외처리: 1,000원으로 나누어 떨어지지 않는 경우
- [x] 로또 구매 개수를 출력한다.
    - [x] 로또 구입 금액에 해당하는 만큼의 로또 구매 개수를 계산한다.
- [x] 로또 구매 개수만큼 로또를 발행하여 출력한다.
    - [x] 로또는 중복되지 않는 숫자 6개로 구성된다.
- [x] 당첨 번호 6개를 입력받는다.
    - [x] 번호는 쉼표(,)를 기준으로 구분한다.
    - [x] 예외처리: 숫자가 입력되지 않은 경우
    - [x] 예외처리: 6개의 숫자가 입력되지 않은 경우
    - [x] 예외처리: 중복된 숫자가 입력된 경우
    - [x] 예외처리: 로또 번호의 숫자 범위를 벗어날 경우
- [x] 보너스 번호를 1개 입력 받는다.
    - [x] 예외처리: 숫자가 입력되지 않은 경우
    - [x] 예외처리: 1개의 숫자를 제외하고 다른 문자가 입력된 경우
    - [x] 예외처리: 당첨 번호와 중복된 숫자가 입력된 경우
    - [x] 예외처리: 로또 번호의 숫자 범위를 벗어날 경우
- [ ] 로또의 당첨 결과를 결정한다.
    - [ ] 6개 번호가 일치하면 1등으로 처리한다.
    - [ ] 5개 번호가 일치하면 보너스 번호를 확인한다.
        - [ ] 보너스 번호까지 일치하면 2등으로 처리한다.
        - [ ] 보너스 번호가 일치하지 않다면 3등으로 처리한다.
    - [ ] 4개 번호가 일치하면 4등으로 처리한다.
    - [ ] 3개 번호가 일치하면 5등으로 처리한다.
- [ ] 당첨 내역을 출력한다.
- [ ] 수익률을 출력한다.
    - [ ] 수익률은 `(당첨 금액)/(구매한 로또 금액) * 100`으로 계산한다.
    - [ ] 수익률은 소수점 둘째 자리에서 반올림한다.
- [ ] 예외 발생 시 명확한 유형의 예외를 발생시킨다.
    - [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨다.
    - [ ] `[ERROR]`로 시작하는 에러 메시지를 출력한다.
    - [ ] 예외가 발생한 부분부터 입력을 다시 받는다.