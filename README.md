# java-lotto-precourse
## 프로젝트 설명
간단한 로또 발매기를 구현한다.
* 로또 번호의 숫자 범위는 1~45까지이다.
* 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
* 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
* 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    * 1등: 6개 번호 일치 / 2,000,000,000원
    * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    * 3등: 5개 번호 일치 / 1,500,000원
    * 4등: 4개 번호 일치 / 50,000원
    * 5등: 3개 번호 일치 / 5,000원
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
* 로또 1장의 가격은 1,000원이다.
* 당첨 번호와 보너스 번호를 입력받는다.
* 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    * Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
      <br/>

## 전체 실행 결과 예시
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
<br/>

## 기능 구현 목록
### 기능
---
#### 구현 목록
- [ ] 로또를 발행하는 기능
    - [ ] 로또 번호의 숫자 범위는 1~45
    - [ ] 로또 1개 당 중복되지 않는 6개의 숫자
- [ ] 로또를 추첨하는 기능
    - 당첨 기준 금액
        * 1등: 6개 번호 일치 / 2,000,000,000원
        * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        * 3등: 5개 번호 일치 / 1,500,000원
        * 4등: 4개 번호 일치 / 50,000원
        * 5등: 3개 번호 일치 / 5,000원
<br/>

### 입력
---
#### 입력 예시
1. 구입 금액 입력
```text
구입금액을 입력해 주세요.
8000
```
2. 로또 번호 입력
```text
당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7
```
---
#### 구현 목록
- [ ] 사용자 구입 금액 입력
    - [ ] 1000원 단위로 입력
        - 나누어 떨어져야 함.
- [ ] 사용자 로또 번호 입력
    - [ ] 중복되지 않는 숫자 6개 입력
        - 쉼표를 기준으로 구분
    - [ ] 중복되지 않는 보너스 번호 1개 입력
<br/>

### 출력
---
#### 출력 예시
1. 구입한 로또 출력
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

2. 로또 결과 출력
```text
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```
---
#### 구현 목록
- [ ] 구입한 로또 출력
    - [ ] 발행한 로또 수량 출력
    - [ ] 발행한 로또 번호 출력
        - 오름차순 정렬하여 출력
- [ ] 로또 결과 출력
    - [ ] 당첨 내역 출력
    - [ ] 수익률 출력
        - 수익률은 소수점 둘째 자리에서 반올림
- [ ] 잘못된 값 입력시 에러메시지 출력
    - [ERROR]로 시작하는 에러메시지
    - 출력 후 그 부분부터 입력을 다시 받음
<br/>

### 🫨 생각해볼 예외사항
- [ ] 예외1. 사용자 로또 구입 금액 입력 시 1000원으로 나누어 떨어지지 않는 경우
- [ ] 예외2. 사용자 로또 구입 금액 0 이하인 경우
- [ ] 예외3. 사용자 로또 번호 입력 시 중복된 번호 입력 (+ 보너스 번호 포함)
- [ ] 예외4. 사용자 로또 번호 입력 시 숫자가 아닌 값 입력 (+ 보너스 번호 포함)
- [ ] 예외5. 사용자 로또 번호 입력 시 숫자와 쉼표 사이 공백 입력
- [ ] 예외6. 사용자 로또 번호 입력 시 6개 초과 입력
- [ ] 예외7. 사용자 로또 번호 입력 시 숫자의 범위 초과
- [ ] 예외8. 보너스 번호 입력 시 공백 입력
- [ ] 예외9. 보너스 번호 1개 초과 입력

### 프로그래밍 요구 사항 1
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
  
### 프로그래밍 요구 사항 2

- [ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ] 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- [ ] else 예약어를 쓰지 않는다.
- [ ] Java Enum을 적용하여 프로그램을 구현한다.
- [ ] 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.