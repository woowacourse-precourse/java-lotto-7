# java-lotto-precourse

## 구현 기능 목록
- 예외 메세지의 포멧은 "[ERROR]"로 시작해야 한다.
- 예외가 발생한다면 메세지를 출력하고, 발생한 시점부터 다시 입력 받아야 한다.

- [ ] 금액을 입력 받는다.
  - [ ] 1000원으로 떨어지지 않는다면 예외 처리, 메세지를 출력하고, 다시 입력 받는다.
- [ ] 구매한 로또를 출력한다.
  - 한 라인에 하나씩, `[number1, number2, ...]` format 6개의 중복되지 않은 숫자
- [ ] 당첨 번호를 입력 받는다.
  - 중복된 숫자를 입력 받는다면 예외 처리, 메세지 출력 후 다시 입력 받는다.
- [ ] 보너스 번호를 입력 받는다.
  - [ ] 당첨 번호와 중복되었다면 예외 처리, 메세지 출력 후 다시 입력 받는다.
- [ ] 당첨 통계를 출력한다.
  - 당첨된 갯수를 출력
  - 수익률을 출력한다. (소수점 둘째 자리에서 반올림)
