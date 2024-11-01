# java-lotto-precourse

## 간단한 로또 발매기를 구현한다.

- 로또의 값은 개당 천 원이다.
- 사용자가 구매할 값을 입력하면, 지불한 값에 맞는 개수의 로또를 반환한다.
- 이후 당첨 번호와 보너스 번호를 입력받는다.
- 당첨 기준에 맞게, 사용자가 구매한 로또의 당첨 여부를 체크한다.
- 이후 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.

## 기능 목록

- [ ] 로또 구입 금액을 입력 받는다.
  - [ ] 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
  - [ ] 구입 금액이 int 범위를 벗어날 경우 예외처리 한다.


-  [ ] 구매한 수량에 맞는 로또 번호를 발급한다.
  - [ ] 로또 번호가 6개가 아닌 경우 예외처리 한다.
  - [ ] 중복된 숫자가 있을 경우 예외처리 한다.
  - [ ] 1~45 사이를 벗어난 값이 있다면 예외처리 한다.


-  [ ] 발급한 로또 번호를 출력한다.


-  [ ] 당첨 번호를 입력 받는다.
  - [ ] 당첨 번호가 6개가 아닌 경우 예외처리 한다.
  - [ ] 중복된 숫자가 있을 경우 예외처리 한다.
  - [ ] 당첨 번호에 1~45 사이를 벗어난 값이 있으면 예외 처리 한다.


-  [ ] 보너스 번호를 입력 받는다.
  - [ ] 보너스 번호가 한 개가 아닌 경우 예외 처리한다.
  - [ ] 보너스 번호가 1~45 사이를 벗어났다면 예외처리 한다.


-  [ ] 당첨 내역을 계산한다.
-  [ ] 당첨 내역을 출력한다.


-  [ ] 수익률을 계산한다.
-  [ ] 수익률을 출력한다.


-  [ ] 사용자가 잘못 입력한 부분이 존재한다면, ERROR로 시작하는 에러 메시지를 출력 후, 그 부분부터 입력을 다시 받는다.