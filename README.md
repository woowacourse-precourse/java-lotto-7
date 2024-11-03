## 기능 목록

### 로또 구입 금액 입력

- 로또 구입 금액을 입력받는다.
    - 공백은 무시한다. (숫자 양옆 공백뿐만 아니라 숫자 사이 공백까지)
- 입력 금액이 1,000원 단위가 아닌 경우 IllegalArgumentException을 발생시킨다.
- 입력 금액이 1,000원 미만인 경우 IllegalArgumentException을 발생시킨다.
- 입력 금액이 100,000원 초과인 경우 IllegalArgumentException을 발생시킨다.
- 정수가 입력되지 않은 경우 IllegalArgumentException을 발생시킨다.

### 로또 번호 생성

- 입력된 금액에 따라 1부터 45 사이에 중복되지 않은 로또 번호(6개 숫자)를 생성한다.

### 당첨 번호 입력

- 당첨 번호를 입력받는다.
    - 공백은 무시한다. (문자열 양옆 공백뿐만 아니라 쉼표가 여러 번 사용 되었을 때 공백과 숫자 양옆 공백까지)
- 입력된 번호가 1부터 45 사이에 속하지 않은 경우 IllegalArgumentException을 발생시킨다.
- 입력된 번호가 중복된 경우 IllegalArgumentException을 발생시킨다.
- 정수가 입력되지 않은 경우 IllegalArgumentException을 발생시킨다.
- 당첨 번호가 6개가 아닌 경우 IllegalArgumentException을 발생시킨다.

### 보너스 번호 입력

- 사용자에게 보너스 번호를 입력받는다.
    - 공백은 무시한다. (숫자 양옆 공백뿐만 아니라 숫자 사이 공백까지)
- 입력된 번호가 1부터 45 사이에 속하지 않은 경우 IllegalArgumentException을 발생시킨다.
- 정수가 입력되지 않은 경우 IllegalArgumentException을 발생시킨다.
- 보너스 번호가 당첨 번호와 중복된 경우 IllegalArgumentException을 발생시킨다.

### 당첨 통계 계산

- 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역과 수익률을 계산한다.

### 결과 출력

- 계산된 결과를 토대로 당첨 통계를 출력한다.