# 로또 생성기



## 기능 구현 목록


* 로또 구입 금액 입력 기능 구현
  * 예외처리
    * 로또 1장의 가격은 1,000원이며, 입력한 구입 금액은 1,000원으로 나누어 떨어져야 한다.
    * (추가) 입력한 구입 금액은 숫자만 입력되어야 한다.
    * (추가) 로또는 최대 50장 까지 살 수 있다.


* 당첨 번호와 보너스 번호 입력 기능 구현.
  * 쉼표를 기준으로 입력받는다.
  * (추가) 숫자와 쉽표만 입력되어야 한다.
  * (추가) 당첨 번호는 숫자가 반드시 6개로 구분되어야 한다.
  * (추가) 숫자가 중복되면 안된다.
  * (추가) 보너스 번호 또한 당첨 번호 숫자와 중복되면 안된다.


* 입력받은 금액만큼 로또번호 생성 및 출력 기능 구현


* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
* Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.


* 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.


* 1개의 로또를 발행할 때 6개의 숫자와 보너스 번호 1개를 뽑는다.
  * 로또 번호의 숫자 범위는 1~45까지이다.
  * 로또 번호 및 보너스 번호는 모두 서로 중복되면 안된다.


* 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  * 1등: 6개 번호 일치 / 2,000,000,000원
  * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  * 3등: 5개 번호 일치 / 1,500,000원
  * 4등: 4개 번호 일치 / 50,000원
  * 5등: 3개 번호 일치 / 5,000원


* 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
