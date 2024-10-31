# java-lotto-precourse

## 🎱 기능 목록

- [X] 로또 구입 금액 입력 안내 문구를 보여준다.
- [X] 로또 구입 금액을 입력받는다.
    - [X] 로또 구입 금액은 1,000원 단위로 입력 받는다.
    - [X] 로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.
    - [X] 로또 구입 금액이 null일 경우 예외가 발생한다.
    - [X] 로또 구입 금액에 문자가 포함될 경우 예외가 발생한다.
    - [X] 로또 구입 금액이 2,000,000,000원을 초과할 경우 예외가 발생한다.
- [X] 로또를 구입 금액에 해당하는 만큼 발행한다.
    - [X] 로또 1장의 가격은 1,000원이다.
    - [X] 1장의 로또는 6개의 번호를 가진다.
    - [X] 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.
    - [X] 로또 번호가 1에서 45 사이가 아닌 경우 예외가 발생한다.
    - [X] 로또 번호가 null일 경우 예외가 발생한다.
- [X] 발행한 로또 수량을 보여준다.
- [X] 발행한 로또 번호를 보여준다.
    - [X] 로또 번호는 오름차순 정렬하여 보여준다.
- [X] 당첨 번호 입력 안내 문구를 보여준다.
- [X] 당첨 번호를 입력 받는다.
    - [X] 당첨 번호는 6개의 숫자이다.
    - [X] 당첨 번호에 중복된 숫자가 있을 경우 예외가 발생한다.
    - [X] 당첨 번호의 숫자 범위는 1~45이다.
    - [X] 당첨 번호는 쉼표(,)를 기준으로 구분한다.
    - [X] 쉼표(,) 사이에 아무 숫자가 없을 경우 예외가 발생한다.
    - [X] 당첨 번호에 숫자와 쉼표를 제외한 문자가 입력될 경우 예외가 발생한다.
    - [X] 당첨 번호가 null일 경우 예외가 발생한다.
- [X] 보너스 번호 입력 안내 문구를 보여준다.
- [ ] 보너스 번호를 입력 받는다.
    - [ ] 보너스 번호는 1개 입력한다.
    - [ ] 보너스 번호의 숫자 범위는 1~45이다.
    - [ ] 보너스 번호가 null일 경우 예외가 발생한다.
    - [ ] 보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.
- [ ] 당첨 통계 헤더를 보여준다.
- [ ] 당첨 내역을 보여준다.
    - [ ] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
        - [ ] 1등: 6개 번호 일치 / 2,000,000,000원
        - [ ] 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - [ ] 3등: 5개 번호 일치 / 1,500,000원
        - [ ] 4등: 4개 번호 일치 / 50,000원
        - [ ] 5등: 3개 번호 일치 / 5,000원
- [ ] 수익률을 보여준다.
    - [ ] 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- [ ] 숫자를 출력할 경우 천(1000) 단위로 쉼표(,)를 사용한다.
- [ ] 사용자가 잘못된 값을 입력할 시 에러 문구를 출력하고, 해당 부분부터 입력을 다시 받는다.
    - [ ] 에러 문구는 “[ERROR]”로 시작한다.
    - [ ] `IllegalArgumentException` 예외를 발생시킨다.
