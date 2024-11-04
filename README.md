# java-lotto-precourse
---
**구현 기능 리스트**
---
- 로또 구입 금액을 입력 받는다.
    - 구입 금액은 1000원 단위로 입력 받으며, 1000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
    - 숫자 외의 값을 입력 받는 경우 예외 처리한다.
    - 빈 값을 넣은 경우
    - 양수가 아닌 수를 입력 받는 경우 예외 처리한다.
- 발행한 로또 수량 및 번호를 출력한다.
  - 로또 번호는 오름차순으로 정렬하여 보여준다.
- 당첨 번호를 입력 받는다.
  - 로또 번호는 쉼표(,)를 기준으로 구분한다.
- 보너스 번호를 입력 받는다.
- 당첨 내역을 출력한다.
    - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 수익률을 출력한다.
    - 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
---
**테스트 코드**
---
  - 구입할 로또 금액 입력 기능 테스트 코드 작성
  - 당첨 번호 입력 기능 테스트 코드 작성
  - 보너스 번호 입력 기능 테스트 코드 작성
  - 당첨 결과 계산 테스트 코드 작성
  - 총 수익률 계산 테스트 코드 작성
---
**예외 처리 리스트**
---
- 예외 상황 에러 문구는 "[ERROR]"로 시작해야 한다.
    - ex) [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
- 로또 구입 금액을 입력 받는 경우
    - 1000으로 나누어 떨어지지 않는 경우
    - 숫자 이외의 값을 넣은 경우
    - 빈 값을 넣은 경우
    - 양수가 아닌 숫자를 넣은 경우
- 당첨 번호를 입력 받는 경우
  - 당첨 번호가 6개가 아닌 경우
  - 정수가 아닌 경우
  - 당첨 번호가 1~45 사이의 숫자가 아닌 경우
  - 당첨 번호가 중복 되는 경우
  - 값이 비어 있는 경우
  - 문자열이 구분자로 시작하거나 끝나는 경우
- 보너스 번호를 입력 받는 경우
  - 값이 비어 있는 경우
  - 정수가 아닌 경우
  - 1~45 사이의 숫자가 아닌 경우
  - 당첨 번호와 중복되는 경우
- 
---
**실행 결과 예시**
---
- 구입 금액을 입력해  주세요.
```
8000
```
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
- 당첨 번호를 입력해 주세요.
```
1,2,3,4,5,6
```
- 보너스 번호를 입력해 주세요.
```
7
```
- 보너스 번호를 입력해 주세요.
```
7
```
```
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```
