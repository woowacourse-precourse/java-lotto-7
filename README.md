# java-lotto-precourse

## 구현 목표
이 프로그램은 사용자의 입력에 따라 로또 번호를 발행하고, 당첨 번호와 비교하여 당첨 여부와 수익률을 출력하는 로또 발매기 프로그램이다. 요구 사항에 맞게 기능을 구현하며, 예외 처리를 통해 잘못된 입력을 방지한다.


## 프로젝트 구조


## 입출력 요구 사항

### 입력
1. 로또 구입 금액 입력 (1000 단위로 입력, 아닐시 예외처리)
2. 당첨 번호 입력
3. 보너스 번호 입력
4. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생, **에러가 발생한 부분부터** 입력을 다시 받는다.

### 출력
1. 발생한 로또 수량과 각각의 번호 출력 (로또 번호는 오름차순)
2. 당첨 내역 출력
3. 총 수익률 출력, `(총 수익률) = (총 당첨 금액) / (로또 구입 금액)`, 수익률은 소수점 첫째 자리까지 출력

### 실행 예시
```
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

## 구현할 기능 목록
1. **로또 구입 금액 입력 및 유효성 검사**
    - 1,000원 단위로 입력. 
    - 금액이 1000으로 나누어 떨어지지 않으면 `IllegalArgumentException` 발생.
    - 에러 발생 시 로또 구입 금액을 다시 입력 받기.
    
2. **발행한 로또 수량 출력**
    - 구입한 로또 수량을 출력.

3. **발행한 로또 번호 출력**
    - 로또 하나당 1~45 사이의 중복되지 않는 6개의 숫자로 구성.
    - 구입한 로또 수량만큼 번호를 발행해 출력.

4. **당첨 번호 입력 및 유효성 검사 기능** 
    - 쉼표(`,`)로 구분된 1~45 사이의 중복되지 않는 6개의 숫자 입력.
    - 유효성 검사 실패 시 `IllegalArgumentException` 발생.
    - 에러 발생 시 당첨 번호부터 다시 입력 받기.

    
5. **보너스 번호 입력 및 유효성 검사 기능**
    - 당첨 번호와 중복되지 않는 1~45 사이의 숫자 1개 입력.
    - 유효성 검사 실패 시 `IllegalArgumentException` 발생.
    - 에러 발생 시 보너스 번호부터 다시 입력 받기.

6. **당첨 통계 출력 기능**
    - 일치한 숫자의 개수별로 당첨된 로또 개수를 상금과 함께 출력.
    - 총 수익률 계산하여 출력. `(총 수익률) = (총 당첨 금액) / (로또 구입 금액)`

## 예외 처리
모든 에러 메시지는 "[ERROR]"로 시작한다.
사용자가 잘못된 값을 입력할 경우, 에러 메시지를 출력하고 **문제가 발생한 부분부터 다시 입력**을 받는다.

### 예외 상황 및 에러 메시지

1. **로또 구입 금액이 1,000으로 나누어 떨어지지 않는 경우**
   - 예외 메시지: `[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.`

2. **입력된 당첨 번호가 1부터 45 사이의 숫자가 아닐 때**
   - 예외 메시지: `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`

3. **입력된 당첨 번호가 6개가 아닐 때**
   - 예외 메시지: `[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개입니다.`

4. **입력된 당첨 번호에 중복된 숫자가 있을 때**
   - 예외 메시지: `[ERROR] 당첨 번호는 중복되지 않습니다.`

5. **입력된 보너스 번호가 당첨 번호와 겹칠 때**
   - 예외 메시지: `[ERROR] 보너스 번호는 당첨 번호를 제외한 1부터 45 사이의 숫자 1개입니다.`

6. **입력된 보너스 번호가 1부터 45 사이의 숫자가 아닐 때**
   - 예외 메시지: `[ERROR] 보너스 번호는 1부터 45 사이의 숫자 1개입니다.`

7. **입력된 보너스 번호가 2개 이상일 때**
   - 예외 메시지: `[ERROR] 보너스 번호는 1부터 45 사이의 숫자 1개입니다.`

## 테스트 케이스

### 테스트 항목


