# java-lotto-precourse

### 로또

## 📚 구현 기능 목록

### 📌 로또 구입 금액 입력

- [x] 로또 구입 금액을 입력받는다. 구입 금액은 1,000원 단위이다.

  ```text
  구입금액을 입력해 주세요.
  8000
  ```

#### 🚫 예외처리

- [x] 아무 값도 입력하지 않은 경우, ``IllegalArgumentException``을 발생시킨다.
- [ ] 공백을 포함한 숫자 이외의 문자가 포함된 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 0을 입력한 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 로또 입력 금액이 1000 미만인 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 로또 입력 금액이 1000으로 나누어 떨어지지 않는 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 잘못된 값을 입력할 경우, ``[ERROR]``로 시작하는 에러 메시지를 출력하고 다시 입력받는다.

### 📌 로또 번호 생성 및 출력

- [x] 1~45 범위의 수 중 중복되지 않은 랜덤한 번호 6개를 생성한다.
- [x] 구입한 로또 개수를 출력한다.
- [x] 구입한 로또 개수만큼 랜덤하게 생성한 로또 번호를 오름차순으로 출력한다. 

  ```text
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

### 📌 당첨 번호 입력

- [x] 당첨 번호를 입력받는다. 번호는 쉼표(,)를 기준으로 구분한다.

  ```text
  당첨 번호를 입력해 주세요.
  1,2,3,4,5,6
  ```

#### 🚫 예외처리

- [x] 아무 값도 입력하지 않은 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 구분자가 쉼표(,)가 아닌 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 쉼표(,)가 2개 이상 연속적으로 입력된 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 쉼표(,)로 구분된 수가 공백인 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 6개의 숫자를 입력하지 않은 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 쉼표(,)로 구분된 수가 0으로 시작하는 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 중복된 숫자가 있을 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 입력된 수가 1~45의 범위가 아닌 수가 포함되어 있는 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 잘못된 값을 입력할 경우, ``[ERROR]``로 시작하는 에러 메시지를 출력하고 다시 입력받는다.
  ```text
  [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
  ```


### 📌 보너스 번호 입력

- [x] 보너스 번호를 입력받는다. 보너스 번호는 당첨 번호와 중복되지 않는 1~45 범위의 수이다.

  ```text
  보너스 번호를 입력해 주세요.
  7
  ```

#### 🚫 예외처리

- [x] 아무 값도 입력하지 않은 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 0을 입력한 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 1~45 범위의 수가 아닌 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 공백을 포함하여 숫자 이외의 값을 입력한 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 당첨 번호와 중복되는 숫자를 입력한 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 잘못된 값을 입력할 경우, ``[ERROR]``로 시작하는 에러 메시지를 출력하고 다시 입력받는다.

### 📌 당첨 내역

- [x] 입력한 당첨 번호와 구입한 로또 번호를 비교하여 아래의 당첨 기준에 따라 당첨 내역을 출력한다.
  - [x] 구입한 로또들을 비교하여 각 로또 별로 당첨 번호와 일치한 번호 수 만큼 구분하여 출력한다.

```markdown
- 1등: 6개 번호 일치 / 2,000,000,000원
- 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
- 3등: 5개 번호 일치 / 1,500,000원
- 4등: 4개 번호 일치 / 50,000원
- 5등: 3개 번호 일치 / 5,000원
```

  ```text
  당첨 통계
  ---
  3개 일치 (5,000원) - 1개
  4개 일치 (50,000원) - 0개
  5개 일치 (1,500,000원) - 0개
  5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
  6개 일치 (2,000,000,000원) - 0개
  ```

### 📌 수익률

- [x] 당첨 내역에 따른 총 수익률을 출력한다. ``총 수익률 = (당첨 금액의 합 / 로또 구입 금액) * 100``
  - [x] 수익률은 소수점 둘 째 자리에서 반올림한다. ex) 100.0%, 51.5%
  - [x] 수익률은 쉼표(,)를 사용하여 천 자리를 구분한다. ex) 1,000,000%

  ```text
  총 수익률은 62.5%입니다.
  ```
