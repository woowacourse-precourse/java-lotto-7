# java-lotto-precourse

# **로또**

---

## 📌 개요

로또는 45개(1~45)의 숫자 중 순서와 상관없이 추첨 결과와 일치하는 숫자의 개수에 따라 당첨금을 지급하는 프로그램입니다.

- **로또 구입 금액을 입력할 수 있습니다.**
    - 구입 금액은 1,000원 단위로 입력해야 합니다.
        - ex) `15000`, `10000`, `1000`
- **당첨 번호와 보너스 번호를 입력할 수 있습니다.**
    - **당첨 번호**
        - 1~45 사이의 숫자를 중복 없이 6개 입력합니다.
        - 쉼표(,)로 구분합니다.
        - ex) `1,2,3,4,5,6`
    - **보너스 번호**
        - 당첨 번호를 제외하고 남아 있는 숫자 중에서 한 개의 숫자만 입력합니다.
        - ex) `7`
- **발행한 로또 수량 및 번호를 출력합니다.**
    - 로또 번호는 오름차순으로 정렬해서 보여줍니다.
    - ex) 로또 4개를 발행했을 경우
    ```
    4개를 구입했습니다.
    [1, 2, 3, 4, 5, 6]
    [5, 10, 15, 20, 25, 30]
    [3, 6, 9, 12, 15, 18]
    [40, 41, 42, 43, 44, 45]
    ```
- **당첨 내역을 출력합니다.**
    - 숫자가 몇 개 일치했는지 보여줍니다.
    - 당첨금에 따라 몇 개가 당첨됐는지 보여줍니다.
    - ex) 번호가 6개 일치했을 경우
    ```
    3개 일치 (5,000원) - 0개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 1개
    ```
- **총수익률을 출력합니다.**
    - 총수익률은 소수점 둘째 자리까지 보여줍니다.
    - ex) 4,000원을 소비하고 2,000,000,000원이 당첨됐을 경우
    - `총 수익률은 50,000,000%입니다.`
- 잘못된 값을 입력할 경우, 프로그램은`IllegalArgumentException` 예외를 발생시키고, `[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받습니다.

## 📝 기능 구현

---

### 1. 애플리케이션 시작

- **첫 번째 메시지 출력**: `"구입금액을 입력해 주세요."`
- **두 번째 메시지 출력**: `"당첨 번호를 입력해 주세요."`
- **세 번째 메시지 출력**: `"보너스 번호를 입력해 주세요."`

### 2. 사용자 입력

- **입력 검증**:
    - **첫 번째 메시지에 대한 입력**
        - 1,000원 단위로 입력하지 않을 경우, 에러 메시지로 `"[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다."`를 출력합니다.
        - 숫자(양수)를 입력하지 않을 경우, 에러 메시지로 `"[ERROR] 입력한 값은 숫자(양수)여야 합니다."`를 출력합니다.
        - 100,000원이 초과한 값을 입력할 경우, 에러 메시지로 `"[ERROR] 로또 구입 금액은 1인당 100,000원을 넘길 수 없습니다."`를 출력합니다.
    - **두 번째 메시지에 대한 입력**
        - 숫자(양수)를 입력하지 않을 경우, 에러 메시지로 `"[ERROR] 입력한 값은 숫자(양수)여야 합니다."`를 출력합니다.
        - 1~45 사이의 숫자를 입력하지 않을 경우, 에러 메시지로 `"[ERROR] 로또 번호는 1~45 사이여야 합니다."`를 출력합니다.
        - 중복된 숫자가 있을 경우, 에러 메시지로 `"[ERROR] 로또 번호는 중복되지 않아야 합니다."`를 출력합니다.
        - 숫자를 6개 미만 또는 초과했을 경우, 에러 메시지로 `"[ERROR] 로또 번호는 6개여야 합니다."`를 출력합니다.
    - **세 번째 메시지에 대한 입력**
        - 숫자(양수)를 입력하지 않을 경우, 에러 메시지로 `"[ERROR] 입력한 값은 숫자(양수)여야 합니다."`를 출력합니다.
        - 1~45 사이의 숫자를 입력하지 않을 경우, 에러 메시지로 `"[ERROR] 보너스 번호는 1~45 사이여야 합니다."`를 출력합니다.
        - 로또 번호와 중복되는 숫자가 있을 경우, 에러 메시지로 `"[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다."`를 출력합니다.
        - 숫자를 1개 미만 또는 초과했을 경우, 에러 메시지로 `"[ERROR] 보너스 번호는 1개 입력해야 합니다."`를 출력합니다.

### 3. 구입한 로또 번호 생성

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`를 이용해 `1~45` 사이의 중복되지 않은 무작위 값을 생성합니다.
- 생성한 무작위 값이 `6개`가 되면 로또 1개가 발급됩니다.
- 구입 금액에 맞게 로또가 발급됩니다.

### 4. 당첨 통계

- 구입한 로또의 번호가 몇 개가 일치했는지 보여줍니다.
- 총수익률이 몇 %인지 보여줍니다.
    - 소수점 둘째 자리까지 보여줍니다.
    - 계산 방식: `(당첨금 총액 / 구입 금액) * 100`

### 5. 예외 처리 및 프로그램 종료

- 사용자가 올바른 입력을 했을 경우, 결과를 출력한 후 프로그램이 정상적으로 종료됩니다.
    - 입력 → 출력 → 프로그램 종료
- 잘못된 입력을 했을 경우, **에러 메시지**를 출력한 후 다시 입력받습니다.
    - 입력 → 에러 메시지 출력 → 다시 입력