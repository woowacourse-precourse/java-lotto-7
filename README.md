# 로또

## 개요
- 로또를 발매하고 로또 구입 금액에 맞는 로또를 구입한다. 
- 구입한 로또와 발매된 로또의 번호를 비교하고 당첨 내역을 출력한다. 
- 더불어, 구입 금액과 당첨금 사이의 수익률을 게산하여 출력한다.
---
<br>

## Commit Type
- feat (feature) : 새로운 기능 추가
- fix (bug fix) : 에러 수정
- docs (documentation) : 문서, 요구사항 수정
- style (formatting, missing semi colons, …) : 코드 포맷팅, 로직은 변경되지 않았지만 코드 띄어쓰기, 세미콜론 누락과 같은 변경점
- refactor : 코드 리팩토링
- test (when adding missing tests) : 테스트 추가
- chore (maintain)
---
<br>

## 프로그램 실행 순서
1. 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
![img.png](src/image/img.png)
2. 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
![img_1.png](src/image/img_1.png)
3. 보너스 번호를 입력 받는다.
![img_2.png](src/image/img_2.png)
4. 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
![img_3.png](src/image/img_3.png)
5. 당첨 내역을 출력한다.
![img_4.png](src/image/img_4.png)
6. 수익률은 소수점 둘째 자리에서 반올림한다.  (ex. 100.0%, 51.5%, 1,000,000.0%)
![img_5.png](src/image/img_5.png)

<최종 예시>
![img_6.png](src/image/img_6.png)
---
<br>

## 클래스 다이어그램
![img.png](img.png)
---
<br>


## 기능 목록

### 입력 (예외 상황 시 IllegalArgumentException을 발생시키고 다시 입력)
- 예외 상황 시 에러 문구를 출력한다. 에러 문구는 "[ERROR]"로 시작한다. [X]
![img_7.png](src/image/img_7.png)
- 구입 금액을 입력받는다 [X]
    - 예외 상황
        - [예외] 1,000원으로 나누어 떨어지는 금액을 입력하지 않은 경우 [X]
        - [예외] 숫자가 아닌 값을 입력한 경우 [X]
        - [예외] 아무 값도 입력하지 않은 경우 [X]
<br><br>
- 당첨 번호를 입력받는다 [X]
    - 예외 상황
        - [예외] 쉼표로 구분된 숫자 범위가 1~45를 벗어나는 경우 [X]
        - [예외] 입력된 숫자에 중복이 있는 경우 [X]
        - [예외] 쉼표가 아닌 문자가 포함되어 있는 경우 [X]
        - [예외] 입력된 숫자가 6개가 아닌 경우 [X]
        - [예외] 쉼표로 구분된 부분이 빈 칸일 경우 [X]
        - [예외] 쉼표로 구분된 부분이 문자일 경우 [X]
<br><br>
- 보너스 번호를 입력받는다 [X]
    - 예외 상황 
        - [예외] 입력된 숫자가 1~45를 벗어나는 경우 [X]
        - [예외] 정수가 아닌 이외의 값을 입력 받은 경우 [X]
        - [예외] 아무 값도 입력하지 않은 경우 [X]
---
<br>

### 출력
- 발행한 로또 수량 [X]
  - 1,000 단위로 입력된 구입 금액을 1,000으로 나누어 수량 계산 [X]
  - “%d”개를 구매했습니다.\n 라는 문장을 출력 [X]
  - 대괄호 [ ] 안에 쉼표(,)를 사용하여 6개의 번호를 출력 [X]
  - 6개의 번호는 오름차순 정렬이 되어 출력 [X]
- 당첨 내역 [X]
  - 당첨 통계\n 출력 [X]
  - 문장 구분(-) 세 개 출력 [X]
  - 당첨 금액이 작은 것부터 출력 [X]
  - “%d”개 일치 (”%d”원) - “%d”\n라는 문장을 출력 [X]
- 수익률 [X]
  - 총 수익률은 "%.1f"입니다.\n라는 문장을 출력 [X]
---
<br>

### 주요 기능
- 로또를 생성한다 [X]
- 수익금으로부터 수익률을 계산한다 [X]
- 발행된 로또로부터 당첨 내역을 생성한다 [X]

<br>