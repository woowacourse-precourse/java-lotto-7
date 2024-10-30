# java-lotto-precourse

## 요구사항

간단한 로또 발매기를 구현한다.

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
```
1등: 6개 번호 일치 / 2,000,000,000원
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
3등: 5개 번호 일치 / 1,500,000원
4등: 4개 번호 일치 / 50,000원
5등: 3개 번호 일치 / 5,000원
```
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
  
## 구현 기능 목록 

### 입력
- [ ] 구입 금액을 입력 받는다.
- [ ] 당첨 번호를 입력 받는다.
- [ ] 보너스 번호를 입력 받는다.

### 입력 검증
- [ ] 구입 금액은 1000원 단위여야 한다.
- [ ] 로또 번호는 1부터 45 사이의 숫자여야 한다.
- [ ] 로또 번호는 중복될 수 없다.

### 유저
- [ ] 구매한 로또들을 저장한다.
- [ ] 로또 구매량을 저장한다.

### 로또 게임
- [ ] 당첨 번호와 보너스 번호를 가진다.

### 로또
- [ ] 로또 번호를 저장한다.

### 랭크
- [ ] 번호 일치 별 당첨금을 저장한다.

### 로또 서비스
- [ ] 구매 개수 만큼 로또 번호 생성 기능
- [ ] 당첨금 계산 기능
- [ ] 수익률 계산 기능

### 출력
- [ ] 구매한 로또들을 출력한다.
- [ ] 당첨 통계를 출력한다.
- [ ] 총 수익률을 소수점 둘째자리에서 반올림하여 출력한다.
