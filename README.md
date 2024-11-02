# java-lotto-precourse

## 기능 요구사항

1. 입력
   - [X] 1,000 원 단위의 로또의 구입 금액을 입력 받는다.
       - [X] 1,000원으로 나누어 떨어지지 않는 경우 예외를 발생시킨다.
   - [X] 1 ~ 45 사이의 중복되지 않는 숫자 6개의 당첨 번호를 입력 받는다.
     - [X] 번호는 쉼표(,)를 기준으로 구분한다.
       - [X] 쉼표로 구분 된 번호가 1 ~ 45 의 숫자가 아닐 경우 예외를 발생시킨다.
       - [X] 숫자가 중복 될 경우 예외를 발생시킨다.
   - [X] 1 ~ 45 사이의 보너스 번호를 입력 받는다.
     - [X] 번호가 1 ~ 45 의 숫자가 아닐 경우 예외를 발생시킨다.
     - [X] 당첨 번호와 중복 될 경우 예외를 발생시킨다.

2. 로또 발행
   - [X] 구입 금액의 1,000원 당 1개의 비율로 로또를 발행한다.
     - [X] 로또 하나당 1 ~ 45 사이의 증복되지 않는 숫자 6개를 랜덤으로 뽑는다.

3. 당첨 결과 계산
   - [ ] 당첨은 1등부터 5등까지 있고 당첨 기준과 금액은 아래와 같다.
     - [ ] 1등: 6개 번호가 일치하면 2,000,000,000원.
     - [ ] 2등: 5개 번호 + 보너스 번호 일치하면 30,000,000원.
     - [ ] 3등: 5개 번호 일치하면 1,500,000원.
     - [ ] 4등: 4개 번호 일치하면 50,000원.
     - [ ] 5등: 3개 번호 일치하면 5,000원.

4. 출력
   - [ ] 발행 한 로또 수량 및 번호를 출력한다.
   - [ ] 로또 번호는 오름차순으로 정렬하여 보여준다.
   - [ ] 당첨 내역을 출력한다.
   - [ ] 수익률을 출력한다.
     - [ ] 수익률은 소수점 둘째 자리에서 반올림한다.
   - [ ] 예외 상황 시 에러 문구를 출력한다.
     - [ ] 에러 문구는 [ERROR] 로 시작한다.
