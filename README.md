# java-lotto-precourse

## 구현할 기능 목록 정의
--- ---

### 로또 발급
- [ ] 사용자에게 입력 받은 금액을 1000으로 나눈 몫 만큼 번호 세트를 발급한다.
- [ ] 번호는 6개의 중복되지 않은 숫자 세트이다.

### 로또 당첨
- [ ] 당첨 번호와 로또 번호 3개가 일치하면 5,000원 당첨이다.
- [ ] 당첨 번호와 로또 번호 4개가 일치하면 50,000원 당첨이다.
- [ ] 당첨 번호와 로또 번호 5개가 일치하면 1,500,000원 당첨이다.
- [ ] 당첨 번호와 로또 번호 5개가 일치하고 로또 번호와 보너스 번호가 일치하면 30,000,000원 당첨이다.
- [ ] 당첨 번호와 로또 번호 6개가 일치하면 2,000,000,000원 당첨이다.

### 당첨 통계
- [ ] 총 당첨금을 합산해서 수익률을 계산한다.
  - [ ] 수익률은 당첨금 / 구매 금액의 백분율이다.
  - [ ] 수익률은 소수점 둘째 자리에서 반올림한다.

### 입력
- [ ] 로또 구입 금액은 1000원 단위로 입력받는다.
- [ ] **[예외 처리]** 로또 구입 금액이 1000원으로 나누어 떨어지지 않는 경우 예외처리한다.
- [ ] **[예외 처리]** 로또 구입 금액이 1000원 미만일 경우 예외 처리한다.
- [ ] 당첨 번호를 입력 받는다. 당첨 번호는 쉼표를 기준으로 구분한다.
    - [ ] 당첨 번호는 1부터 45까지의 숫자이다.
    - [ ] 당첨 번호는 총 6개이다.
    - [ ] 당첨 번호는 중복이 되어서는 안된다.
- [ ] 보너스 번호를 입력 받는다. 보너스 번호는 1개이다.
  - [ ] 보너스 번호도 1부터 45까지의 숫자이다.
  - [ ] 보너스 번호는 당첨 번호와 중복이 되어서는 안된다.
- [ ] **[예외 처리]** 당첨 번호와 보너스 번호가 1부터 45까지의 숫자가 아니면 에러 처리를 한다.
- [ ] **[예외 처리]** 당첨 번호가 6개가 아니면 예외 처리를 한다.
- [ ] **[예외 처리]** 보너스 번호가 당첨 번호와 중복이 되면 예외 처리를 한다.
- [ ] **[예외 처리]** [공통] 입력 값이 null이나 빈 문자열일 경우 예외 처리를 한다.
- [ ] **[예외 처리]** 입력 번호에 불필요한 공백이 있을 경우 예외 처리를 한다.
- [ ] 사용자가 잘못된 번호를 입력했을 때 에러 메시지를 출력하고 그 부분에서 다시 입력받는다.

### 출력
- [ ] 구입 금액을 입력 받기 전 "구입금액을 입력해주세요."라는 문구를 출력한다.
- [ ] 구입 금액에 따른 로또 번호를 만들고 출력한다.
  - 출력 예시는 다음과 같다
  ```
    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45]
    ```
- [ ] 당첨 번호를 입력 받기 전 "당첨 번호를 입력해주세요."라는 문구를 출력한다.
- [ ] 보너스 번호를 입력 받기 전 "보너스 번호를 입력해주세요."라는 문구를 출력한다.
- [ ] 당첨 통계를 출력한다.
  - 출력 예시는 다음과 같다.
  ```
   3개 일치 (5,000원) - 1개
   4개 일치 (50,000원) - 0개
   5개 일치 (1,500,000원) - 0개
   5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
   6개 일치 (2,000,000,000원) - 0개
   총 수익률은 62.5%입니다.     
  ```
- [ ] 예외 상황 발생 시 에러 문구를 출력한다. 이 때 에러 문구는 "[ERROR]"로 시작한다.