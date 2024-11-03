# java-lotto-precourse 기능 목록
* * * 


## 사용자 입력 받기
### 1. 구입금액 입력
- "구입금액을 입력해 주세요." 라는 안내문구 출력
- 1000으로 나누어 떨어지는 1000 이상의 정수 입력
- 잘못된 값 입력시 IllegalArgumentException 발생 후, "[ERROR] 구입금액은 1000의 배수인 정수를 입력해야 합니다."를 출력하고 입력을 처음부터 다시 받는다.
### 2. 당첨번호 입력
- "당첨 번호를 입력해 주세요." 안내문구 출력
- 중복되지 않는 숫자 1 ~ 45 사이의 정수 6개
- 잘못된 값 입력시 IllegalArgumentException 발생 후, "[ERROR] 당첨 번호는 서로 중복되지 않는 1~45 사이의 6가지 수여야 합니다."를 출력하고 입력을 다시 받기 시작한다.
### 3. 보너스 번호 입력
- "보너스 번호를 입력해 주세요." 안내문구 출력
- 1 ~ 45 사이의 정수 1개 (당첨 번호와 중복되지 않는 정수)
- 잘못된 값 입력시 IllegalArgumentException 발생 후, "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 한가지 수여야 합니다."를 출력하고 입력을 다시 받기 시작한다.

* * *
## 로또 발행하기
- 구입 금액 / 1000 개 만큼의 로또를 발행
- 각 로또 번호는 1~45 사이의 중복되지 않는 6개의 정수

* * *
## 당첨 결과 계산
- 구입한 각 로또와 당첨 번호를 비교하여 당첨여부와 / 당첨 금액을 판별
- 수익률 계산
- 당첨 금액과 기준은 아래와 같다.
- 1등: 6개 번호 일치 / 2,000,000,000원   
  2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원   
  3등: 5개 번호 일치 / 1,500,000원   
  4등: 4개 번호 일치 / 50,000원   
  5등: 3개 번호 일치 / 5,000원

* * * 

## 실행결과 출력
### 1. 구입금액에 따른 총 로또 구입 개수, 로또 번호 출력
- 구입 금액에 해당하는 만큼 로또를 발행
- 로또 1장의 가격은 1,000원
- 8개를 구매했습니다.   
  [8, 21, 23, 41, 42, 43]   
  [3, 5, 11, 16, 32, 38]   
  [7, 11, 16, 35, 36, 44]   
  [1, 8, 11, 31, 41, 42]   
  [13, 14, 16, 38, 42, 45]   
  [7, 11, 30, 40, 42, 43]   
  [2, 13, 22, 32, 38, 45]   
  [1, 3, 5, 14, 22, 45]

### 2. 당첨 통계 출력
- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- 당첨 통계   
\-\-\-   
  3개 일치 (5,000원) - 1개   
  4개 일치 (50,000원) - 0개   
  5개 일치 (1,500,000원) - 0개   
  5개 일치, 보너스 볼 일치 (30,000,000원) - 0개   
  6개 일치 (2,000,000,000원) - 0개   
  총 수익률은 62.5%입니다.


