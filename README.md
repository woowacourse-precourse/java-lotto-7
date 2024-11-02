# java-lotto-precourse

## 프로젝트 소개
간단한 로또 발매기를 구현하는 프로젝트입니다.

## 주요 기능
- 로또를 1장 당 1000원에 구매할 수 있다.
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행한다.
- 1개의 로또 발생시 1~45까지의 숫자 중 중복되지 않는 6개의 숫자를 랜덤으로 뽑는다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교한다.
- 당첨 기준에 따라 당첨 내역을 계산한다.
- 당첨 내역에 따라 수익률을 계산한다.
- 로또 게임을 종료한다.

## 기능 요구사항
### 발행된 로또 번호 제약 조건
- [X] 로또 번호의 숫자 범위는 1~45이다.
- [X] 로또 번호는 중복되지 않아야 한다.
- [X] 로또 번호는 6개여야 한다.

### 로또 번호 생성 기능
- [X] 로또 번호를 생성한다.

### 당첨 기준과 금액 일치 여부 확인
- [ ] 당첨은 1등부터 5등까지 있다.
- [ ] 1등은 6개의 숫자가 일치할 때다.
- [ ] 2등은 5개의 숫자가 일치하고, 1개의 보너스 숫자가 일치할 때다.
- [ ] 3등은 5개의 숫자가 일치할 때다.
- [ ] 4등은 4개의 숫자가 일치할 때다.
- [ ] 5등은 3개의 숫자가 일치할 때다.
- [ ] 당첨 금액은 1등 기준 2,000,000,000원이다.
- [ ] 당첨 금액은 2등 기준 30,000,000원이다.
- [ ] 당첨 금액은 3등 기준 1,500,000원이다.
- [ ] 당첨 금액은 4등 기준 50,000원이다.
- [ ] 당첨 금액은 5등 기준 5,000원이다.

### 로또 구입
- [X] 로또를 구입할 금액을 입력받는다.
- [X] 입력 값이 숫자가 아닌 경우 에러 문구 출력한다.
- [X] 로또 1장의 가격은 1000원이며, 구입 금액 만큼 로또 수 계산한다.
- [X] 로또 구입 금액이 로또 개별 금액 미만인 경우 예외 처리 한다. 
- [X] 로또 구입 금액이 로또 개별 금액 단위가 아닌 경우 예외 처리 한다.
- [X] 로또를 구입한 만큼의 로또 번호를 발행한다.

### 발행한 로또 번호 출력 기능
- [ ] 발행한 로또 수량을 출력한다.
- [ ] 로또 번호는 오름 차순으로 정렬하여 보여준다.
- [ ] 로또 번호는 `,`로 구분하여 출력한다.
- [ ] 한 로또의 번호들은 `[]`로 감싸서 출력한다.


### 당첨 번호와 보너스 번호 입력
- [ ] 당첨 번호를 입력받는다.
- [ ] 보너스 번호를 입력받는다.
- [ ] 당첨 번호는 중복되지 않는 숫자 6개여야 한다.
- [ ] 당첨 번호는 ','로 구분하여 입력한다.
- [ ] 보너스 번호는 1개 여야 한다.
- [ ] 당첨 번호와 보너스 번호는 1~45 사이의 숫자여야 한다.
- [ ] 당첨 번호와 보너스 번호는 중복되지 않아야 한다.

### 당첨 결과 계산
- [ ] 로또 번호와 당첨 번호를 비교하여 당첨 등수를 계산한다.
- [ ] 등수별 당첨 횟수를 계산한다.
- [ ] 당첨 금액을 계산한다.
- [ ] 수익률을 계산한다.
- [ ] 수익률은 소수점 둘째자리에서 반올림 한다.

### 당첨 결과 출력
- [ ] 등수별 당첨 기준과 금액을 출력한다.
- [ ] 등수별 당첨 횟수를 함께 출력한다.
- [ ] 총 수익률을 출력한다.

### 예외 상황 에러 문구 출력
- [ ] 사용자가 잘못된 값 입력할 경우 IllegalArgumentException을 발생시킨다.
- [ ] 예외 상황 시 에러 문구는 "[ERROR]"로 시작한다.
- [ ] 에러 메시지 출력 후 그 부분부터 다시 입력받는다.
