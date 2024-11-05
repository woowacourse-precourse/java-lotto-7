# java-lotto-precourse

## 입력 기능
- 로또 구입 금액을 입력 받는 기능
- 당첨 번호 입력을 입력 받는 기능
- 보너스 번호를 입력 받는 기능

## 세부 기능
- 입력 받은 구매 금액에 맞는 로또 번호를 생성하는 기능
    - 서로 중복되면 안되고, 오름차순으로 정렬되어야 한다.
- 당첨 번호와 로또 번호를 비교하는 기능
- 당첨 금액을 계산하는 기능
- 당첨 금액이 있으면 구입 금액의 수익률을 계산하는 기능

## 출력 기능
- 로또 번호을 출력하는 기능
- 당첨 내역을 출력하는 기능
- 수익률을 출력하는 기능
- 예외 상황을 출력하는 기능

## 예외 상황
### 로또 구입 금액 예외 상황
- 양수로 입력하지 않으면 예외
- 1000 단위로 입력하지 않으면 예외

### 당첨 번호 입력 예외 상황
- 당첨 번호의 개수가 6개가 아니면 예외
- 양수로 입력하지 않으면 예외
- 중복된 숫자를 입력하면 예외
- 1 ~ 45 사이의 숫자가 아니면 예외

### 보너스 번호 입력 예외 상황
- 당첨 번호와 중복된 숫자를 입력하면 예외
- 양수로 입력하지 않으면 예외
- 1 ~ 45 사이의 숫자가 아니며 예외