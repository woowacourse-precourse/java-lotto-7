# 로또

## 기능 목록

### 1. 로또 구입 금액을 입력 받는다.

- 정상 동작
    - 1000원 단위의 구입 금액 입력
    - 구매 금액 저장
- 예외 동작
    - 1000원으로 나누어 떨어지지 않을 경우
    - 자연수가 아닐 경우 (0원 또는 음수)
    - 정수가 아닐 경우 (실수, 숫자가 아닌 글자가 포함)
    - 비어있거나 공백일 경우
    - null일 경우

### 2. 로또를 발행한다.

- 정상 동작
    - 로또 구매 금액으로부터 구매할 로또 수량 계산
    - 로또 수량만큼
        - 1~45 사이의 중복되지 않은 6개의 숫자 뽑음
        - 로또 저장
    - 발행한 로또 수량 출력
    - 발행한 로또 번호 오름차순으로 정렬하여 출력
- 예외 동작
    - 로또 수량이 자연수가 아닌 경우
    - 발행한 로또 번호가 중복일 경우
    - 발행한 로또 번호가 6개가 아닌 경우

### 3. 당첨 번호를 입력 받는다.

- 정상 동작
    - 쉼표(,)로 구분된 당첨 번호 입력
    - 쉼표를 기준으로 분리하여 당첨 번호 저장
- 예외 동작
    - 당첨 번호의 숫자 범위가 1보다 작거나 45보다 클 때
    - 당첨 번호가 6개 미만이거나 6개 초과일 때
    - 중복되는 당첨 번호가 존재할 때
    - 당첨 번호가 비어있거나 공백일 경우
    - 당첨 번호가 null일 경우
    - 정수가 아닐 경우

### 4. 보너스 번호를 입력 받는다.

- 정상 동작
    - 보너스 번호 입력
- 예외 동작
    - 보너스 번호의 숫자 범위가 1보다 작거나 45보다 클 때
    - 보너스 번호가 당첨 번호 중 하나와 같을 때
    - 보너스 번호가 비어있거나 공백일 경우
    - 보너스 번호가 null일 경우
    - 정수가 아닐 경우

### 5. 당첨 내역 출력

- 정상 동작
    - 로또 수량만큼
        - 당첨 번호와 발행한 로또 번호가 일치한 개수 계산
        - 보너스 번호가 발행한 로또 번호 중 하나에 일치하는지 계산
        - 등수를 구하여 당첨 내역에 저장
    - 로또 당첨 내역 출력

### 6. 수익률 출력

- 정상 동작
    - 당첨 내역에 따라 총 당첨 금액 계산
    - 구입 금액과 당첨 금액을 이용해 수익률 계산
    - 수익률 출력

## 입출력 예시

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
