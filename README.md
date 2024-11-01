# java-lotto-precourse

## 요구사항

### 입력
* 로또 구입 금액을 1,000원 단위로 입력받는다.
* 쉼포(,)를 기준으로 당첨 번호 6개를 입력받는다.
* 보너스 번호 1개를 입력받는다.

### 출력
* 입력을 받기 위한 안내 메시지를 출력한다.
* 발행한 로또 수량과 오름차순으로 정렬한 로또 번호를 출력한다.
* 당첨 통계 메시지와 함께 당첨 내역을 금액 순으로 출력한다.
* 소수점 둘째 자리에서 반올림한 수익률을 출력한다.

### 기능
* 로또 번호의 숫자 범위는 1~45이다.
* 로또 발행시 중복되지 않는 6개의 숫자를 뽑는다.
* 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
* 1등부터 5등까지의 당첨 기준과 금액은 다음을 따른다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
* 입력받은 구입 금액에 해당하는 만큼 로또를 발행하며, 개당 가격은 1,000원이다.
* 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 계산한다.

### 예외처리
* 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
* Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

