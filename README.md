# java-lotto-precourse

## 구현할 기능 목록

### 구입금액 입력 안내 메시지 출력

- 로또 구입금액에 대한 문자열 입력을 안내하는 문장을 출력

### 구입금액 입력

- `readLine()`을 이용하여 로또 구입금액에 대한 문자열을 입력받음

  > 예외 처리 사항
  >
  > - 구입금액에 정수가 아닌 문자열이 입력된 경우 `IllegalArgumentException` 발생
  > - 구입금액에 1000 이하의 금액이 입력된 경우 `IllegalArgumentException` 발생

### 구매한 로또의 개수 출력

- 구입한 금액을 1000으로 나눈 몫만큼 구입한 로또의 갯수를 출력

### 로또 번호 발급

- `pickUniqueNumbersInRange()`를 이용하여 중복되지 않는 6개의 로또 번호를 발급
- 앞서 구한 구매한 로또의 수만큼 발급

### 당첨 번호 입력

- `readLine()`을 이용하여 당첨 번호에 대한 문자열을 입력받음

  > 예외 처리 사항
  >
  > - 입력된 당첨 번호가 6자리 이상이면 `IllegalArgumentException` 발생
  > - 입력된 당첨 번호가 1~45범위 밖이면 `IllegalArgumentException` 발생
  > - 쉼표와 당첨 번호 이외의 문자열이 입력된 경우 `IllegalArgumentException` 발생
  > - 입력된 당첨 번호에 중복이 존재하면 `IllegalArgumentException` 발생

### 보너스 번호 입력

- `readLine()`을 이용하여 보너스 번호에 대한 문자열을 입력받음

  > 예외 처리 사항
  >
  > - 입력된 보너스 번호가 1~45범위 밖이면 `IllegalArgumentException` 발생
  > - 보너스 번호 이외의 문자열이 입력된 경우 `IllegalArgumentException` 발생
  > - 당첨 번호에 이미 보너스 번호와 중복되는 값이 존재하면 `IllegalArgumentException` 발생

### 당첨 여부 판별

- 앞서 로또 구입으로 발급된 로또 번호들과 사용자가 입력한 번호를 대조하여 당첨 여부를 판별

### 결과 출력

- 사용자가 입력한 당첨 번호가 3개 이상 일치하면 당첨의 종류와 당첨된 갯수를 출력
- 구입 금액과 대조하여 총 수익률을 계산후 출력(소수점 둘째 자리에서 반올림)