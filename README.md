# 로또

## 구현해야할 기능 목록

- [ ] 로또 구입 금액을 입력받는다.
    - [ ] 구입 금액은 1,000원 단위로 제한하며, 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
- [ ] 로또 구입 금액에 해당하는 로또를 발행한다.
    - [ ] 로또가 발급되는 로또 번호의 숫자 범위는 1~45까지이다.
    - [ ] 하나의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- [ ] 당첨 번호를 입력받는다.
    - [ ] 당첨 번호는 총 6개로 쉼표(,)를 기준으로 구분한다.
    - [ ] 당첨 번호 입력시 중복되지 않는 숫자 6개를 입력받는다.
- [ ] 보너스 번호를 입력받는다.
    - [ ] 보너스 번호는 당첨번호와 중복되지 않는다.
- [ ] 1등부터 5등까지의 당첨 결과를 계산한다.
- [ ] 발행한 로또 수량 및 번호를 출력한다.
  - 로또 번호는 오름차으로 정렬하여 보여준다.
- [ ] 수익률을 소수점 둘째 자리에서 반올림한다.
- [ ] 당첨 내역을 출력한다.
- [ ] 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
