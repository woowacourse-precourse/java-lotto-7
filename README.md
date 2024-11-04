# java-lotto-precourse

## 로또 발매기를 구현하고 수익률을 계산하는 프로그램을 구현한다

<strong> 로또 번호 생성 </strong>

- [ ] 1~45개의 숫자 중에서 로또 번호가 될 중복되지 않는 숫자 6개를 뽑는다.
- [ ] 추가로 1등과 2등에게 해당되는 보너스 번호 하나를 기존에 뽑은 6개와 중복되지 않는 숫자로 뽑는다

<strong> 사용자로부터 금액 입력 받기 </strong>

- [ ] 사용자의 로또 구매 금액을 입력받을 수 있고 구입 금액에 해당하는 로또 금액만큼 로또를 발행한다
  * 로또 한 장의 가격은 1000원이고, 1000원 단위로 입력 받을 수 있다.
- [ ] 1000원 단위가 아닐 경우 예외를 발생시킨다.

<strong> 사용자로부터 로또 번호 입력 받기 </strong>

- [ ] 사용자로부터 중복되지 않는 로또 번호를 ,를 기준으로 입력 받는다
- [ ] 이후 보너스 번호 하나를 입력받는다.
- [ ] 중복된 번호를 입력했을 경우 예외를 발생시키고 [ERROR]로 시작하는 에러메시지를 출력한다
- [ ] 이후, 해당 로또에 대한 번호부터 다시 입력 받는다
- [ ] 사용자가 구매한 로또 개수만큼 반복한다. 

<strong> 당첨 내역 출력하기 </strong>

- [ ] 1등부터 5등사이에서 로또에 해당되는 결과를 계산한다
  - 단, 보너스 번호의 일치여부는 5개 이상 일치했을 경우부터 활용한다.
- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률 계산한다.

<strong> 사용자가 입력한 로또 번호 출력하기 </strong>

- [ ] 발행한 로또 수량 및 번호를 출력한다
    * 단 로또 번호는 오름차순으로 정렬하여 보여준다
- [ ] 당첨 내역을 출력한다
- [ ] 수익률을 출력한다
  - 단, 수익률은 소수점 둘째 자리에서 반올림한다
