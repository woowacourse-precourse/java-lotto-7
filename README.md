# java-lotto-precourse

---

## 기능 목록

1. 로또 번호 생성
    - [X] 1부터 45까지의 숫자 중 중복되지 않는 6개의 번호를 무작위로 선택한다.
2. 로또 구매
    - [X] 사용자로부터 구입 금액을 입력받는다.
    - [X] 입력된 금액이 1,000원 단위인지 확인한다. (예외 처리)
    - [X] 구입 금액에 맞는 수량의 로또를 발행한다.
3. 당첨 번호 입력
    - [X] 사용자로부터 6개의 당첨 번호와 1개의 보너스 번호를 입력받는다.
    - [X] 입력된 번호가 유효한지 확인한다. (1~45 범위, 중복 없음, 예외 처리)
4. 당첨 확인
    - [X] 구매한 각 로또 번호와 당첨 번호를 비교한다.
    - [X] 당첨 기준(1등~5등)에 따라 당첨 여부를 판단한다.
5. 결과 출력
    - [X] 각 등수별 당첨 내역을 출력한다.
    - [X] 총 수익금을 계산한다.
    - [X] 수익률을 계산하고 출력한다.
6. 예외 처리
    - [X] 잘못된 입력에 대해 ``IllegalArgumentException``을 발생시킨다.
    - [X] "[ERROR]"로 시작하는 에러 메시지를 출력한다.
    - [X] 오류 발생 시 해당 부분부터 다시 입력받는다.
7. 프로그램 종료
    - [X] 모든 과정이 완료되면 프로그램을 종료한다.

### **입출력 요구 사항**

### **입력**

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

```
14000

```

- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

```
1,2,3,4,5,6

```

- 보너스 번호를 입력 받는다.

```
7

```

### **출력**

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.

```prolog
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

- 당첨 내역을 출력한다.

```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개

```

- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

```erlang
총 수익률은 62.5%입니다.

```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```prolog
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.

```

### **실행 결과 예시**

```prolog
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```