# java-lotto-precourse

### 기능 설명

1. 먼저 금액을 입력 받는다. 금액은 1000원 단위로 입력 받는다.
2. 받은 금액에 따라 랜덤한 번호를 6개 뽑는다.
3. 번호는 1~45 사이의 중복이 없는 숫자이다.
4. 예를 들어 금액이 8000원이면 8 round 즉 48개의 숫자를 뽑는다.
5. 그리고 당첨 번호를 입력 받는다.
6. 보너스 번호를 입력받는다.
7. 각 라운드에서 뽑은 6개의 숫자와 당첨번호, 보너스 번호를 비교하여 몇 등인지 파악한다.
8. 파악한 데이터를 토대로 수익률을 계산하여 유저에게 보여준다.

### 금액 계산
- 5등 : 5천원 (3개 번호 일치)
- 4등 : 5만원 (4개 번호 일치)
- 3등 : 150만원 (5개 번호 일치)
- 2등 : 3천만원 (5개 번호와 보너스 번호 일치)
- 1등 : 20억원 (6개 번호 일치)

