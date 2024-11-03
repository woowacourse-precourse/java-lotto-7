# 프로젝트 소개

사용자가 로또 구입 금액과 당첨 번호, 보너스 번호를 입력하면 랜덤으로 로또를 발급한 후,  
구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역과 수익률을 출력하는 로또 발매기 프로그램입니다.

## 요구사항

### 기능 요구사항

- [ ]  로또 번호의 숫자 범위는 1~45까지이다.
- [ ]  1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- [ ]  당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- [ ]  당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- [ ]  로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- [ ]  로또 1장의 가격은 1,000원이다.
- [ ]  당첨 번호와 보너스 번호를 입력받는다.
- [ ]  사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- [ ]  사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

### 입출력 요구사항

- [ ] 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
- [ ] 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다. 번호는 쉼표(,)를 기준으로 구분한다.
- [ ] 보너스 번호를 입력 받는다.
- [ ] 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
- [ ] 당첨 내역을 출력한다.
- [ ] 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- [ ] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

## 실행 예시

```text
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

## 기능 목록

### 1. 로또 객체 생성

1부터 45 사이의 중복 없는 6개의 정수를 갖는 로또 객체를 생성한다.

**예외 상황**

1. 로또의 숫자가 6개 아닌 경우  
   \"[ERROR] 로또 번호는 6개여야 합니다.\"를 에러 메시지로 포함한`IllegalArgumentException`을 발생시킨다.


2. 로또의 숫자 중에 중복된 숫자가 있는 경우  
   \"[ERROR] 로또 번호가 중복되었습니다.\"를 에러 메시지로 포함한`IllegalArgumentException`을 발생시킨다.


3. 로또의 숫자가 1부터 45 사이의 정수가 아닌 경우  
   \"[ERROR] 로또의 숫자는 1에서 45 사이의 숫자여야합니다.\"를 에러 메시지로 포함한 `IllegalArgumentException`을 발생시킨다.

### 2. 구입 금액 입력 받기

사용자에게 구입 금액을 입력받는다.

**예외 상황**

1. 사용자가 입력한 구입 금액이 빈 문자열이거나 NULL인 경우  
   \"[ERROR] 로또 구입 금액은 0원보다 커야합니다.\"를 에러 메시지로 포함한 `IllegalArgumentException`을 발생시킨 후,  
   다시 입력받는다.


2. 사용자가 입력한 구입 금액이 숫자 형식이 아닌 경우  
   \"[ERROR] 로또 구입 금액을 숫자로 입력해주세요.\"를 에러 메시지로 포함한 `IllegalArgumentException`을 발생시킨 후,  
   다시 입력받는다.


3. 사용자가 입력한 구입 금액이 음수이거나 소수인 경우  
   \"[ERROR] 로또 구입 금액은 1000원 이상의 자연수로 입력해주세요.\"를 에러 메시지로 포함한 `IllegalArgumentException`을 발생시킨 후,  
   다시 입력받는다.

### 3. 로또 발급

구입 금액을 1,000원 단위로 나눈 개수만큼 로또를 발급한다.

**예외 상황**

1. 로또 구입 금액이 0원인 경우  
   \"[ERROR] 로또 구입 금액은 0원보다 커야합니다.\"를 에러 메시지로 포함한 `IllegalArgumentException`을 발생시킨다.


2. 로또 구입 금액이 1000으로 나누어 떨어지지 않는 경우  
   \"[ERROR] 로또 구입 금액은 1000원 단위로 나누어 떨어져야합니다.\"를 에러 메시지로 포함한 `IllegalArgumentException`을 발생시킨다.

### 4. 당첨 번호와 보너스 번호 입력 받기

사용자에게 당첨 번호와 보너스 번호를 입력받는다.  
당첨 번호는 쉼표를 기준으로 구분한다.

**예외 상황**

1. 사용자가 입력한 당첨 번호가 빈 문자열이거나 NULL인 경우  
   \"[ERROR] 당첨 번호를 입력해주세요.\"를 에러 메시지로 포함한 `IllegalArgumentException`을 발생시킨 후,  
   다시 입력받는다.


2. 사용자가 입력한 당첨 번호에 쉼표가 없는 아닌 경우  
   \"[ERROR] 로또 구입 금액을 숫자로 입력해주세요.\"를 에러 메시지로 포함한 `IllegalArgumentException`을 발생시킨 후,  
   다시 입력받는다.


3. 사용자가 입력한 구입 금액이 음수이거나 소수인 경우  
   \"[ERROR] 로또 구입 금액은 1000원 이상의 자연수로 입력해주세요.\"를 에러 메시지로 포함한 `IllegalArgumentException`을 발생시킨 후,  
   다시 입력받는다.

### 5. 로또 추첨

사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 결과를 결정한다.

**예외 상황**

1. 구매한 로또 리스트가 NULL이거나 빈 리스트인 경우  
   \"[ERROR] 구매한 로또가 없습니다.\"를 에러 메시지로 포함한 `IllegalArgumentException`을 발생시킨다.


2. 당첨 숫자 집합이 NULL이거나 비어있는 경우  
   \"[ERROR] 당첨 번호가 없습니다.\"를 에러 메시지로 포함한 `IllegalArgumentException`을 발생시킨다.


3. 당첨 숫자 개수가 6개가 아닌 경우  
   \"[ERROR] 당첨 번호는 6개여야합니다.\"를 에러 메시지로 포함한 `IllegalArgumentException`을 발생시킨다.


4. 당첨 숫자가 1에서 45 사이의 숫자가 아닌 경우  
   \"[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.\"를 에러 메시지로 포함한 `IllegalArgumentException`을 발생시킨다.


5. 보너스 숫자가 1에서 45 사이의 숫자가 아닌 경우  
   \"[ERROR] 보너스 숫자는 1에서 45 사이의 숫자여야 합니다.\"를 에러 메시지로 포함한 `IllegalArgumentException`을 발생시킨다.
