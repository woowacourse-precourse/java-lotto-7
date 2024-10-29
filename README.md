# java-lotto-precourse

InputView
- [ ] 1 ~ 45 랜덤 숫자를 입력받는다. (로또 숫자 범위는 1 ~ 45)
  - [ ] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
  - [ ] 보너스 번호 1개를 뽑는다.
    - exception
    - [ ] 음수 입력받는 경우 "[ERROR]"와 함께 IllegalArgumentException을 발생시킨다.
      - [ ] 에러 부분부터 입력을 다시 받는다
- [ x ] 로또 구입 금액을 입력받는다.
  - exception
  - [ x ] 숫자가 아닐경우 커스텀 예외를 발생시킨다.
  - [ x ] 음수일 경우 커스텀 예외를 발생시킨다.
  - [ x ] 예외 지점에서 다시 입력받는다.
- [ ] 구입 금액에 해당하는 만큼 로또를 발행해야 한다.

OutputView
- [ ] 당첨 내역 및 수익률을 출력한다.

Controller
- [ ] View, Model을 관리한다. 

Model
- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교한다.
- [ ] 수익률을 계산한다.

Config
- [ x ] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    1등: 6개 번호 일치 / 2,000,000,000원
    2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    3등: 5개 번호 일치 / 1,500,000원
    4등: 4개 번호 일치 / 50,000원
    5등: 3개 번호 일치 / 5,000원
- [ x ] 로또 1장의 가격은 1,000원이다.
- [ x ] 랜덤 시작 숫자 고정
- [ x ] 랜던 끝 숫자 고정
- [ x ] 뽑는 개수 고정
- [ x ] "ERROR" prefix 생성

Exception
- [ ] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
- [ x ] InputException 생성
  - [ x ] 숫자가 아닌 경우 예외를 발생시킨다.
  - [ x ] 음수일 경우 예외를 발생시킨다.