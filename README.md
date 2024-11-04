# java-lotto-precourse

---

## 기능 목록

---

### 1. System
1. 로또 판매
   + 로또 번호는 1 ~45 범위 내의 숫자이다.
   + 로또 한 장 가격은 1000원이다.
     + 구입금액이 1000원 단위가 아니면 예외 처리
   + 중복되지 않은 6개의 숫자와 보너스 번호를 뽑는다.
   + 사용자 구입금액만큼 로또를 발행한다.
2. 출력
   + 출력문 : `구입금액을 입력해주세요.`
   + 사용자가 구입금액을 입력했을 때
     + 출력 문구 : `{n}개를 구매했습니다.`
     + 각 로또의 번호는 오름차순 정렬
   + 출력문 : `당첨 번호를 입력해 주세요.`
   + 출력문 : `보너스 번호를 입력해 주세요.`
   + 당첨 통계
      당첨 기준

       | 순위 | 일치 | 보너스 번호 일치 |당첨 금액|
       |:--:|:--:|:---------:|:---:|
       | 1  | 6  |   false   |2,000,000,000|
       | 2  | 5  |   true    |30,000,000|
       | 3  | 5  |   false   |1,500,000|
       | 4  | 4  |   false   |50,000|
       | 5  | 3  |   false   |5,000|
   + 출력문
     + `{x}개 일치 ({reward}) - {n}개`
     + `{x}개 일치, 보너스 볼 일치 ({reward}) - {n}개`
   + 수익률
     + 출력문 : `총 수익률은 {xx.x}%입니다.`
     + 소수점 둘째 자리에서 반올림한다.
3. 예외 상황 발생
   + 에러 문구는 `[ERROR]`로 시작
   + 사용자가 잘못된 값을 입력할 경우, 에러 문구 출력 후 해당 부분부터 다시 입력을 받아야 한다.


### 2. User
1. 로또 구입
    + 로또 구입 금액을 입력 한다.
      + 로또 한 장 가격은 1000원
      + 구입 금액은 1000원 단위
    + 당첨 번호를 6개 입력 한다.
      + 1 ~ 45의 범위 내의 숫자
      + 쉼표(,)를 기준으로 구분
    + 보너스 번호를 1개 입력 한다.
      + 1 ~ 45의 범위 내의 숫자
      + 당첨 번호와 중복되지 않음

2. 로또 발행 확인
    + 구입 금액만큼 로또 발행

3. 로또 결과 확인
    + 당첨 통계
    + 수익률 (소수점 둘째 자리에서 반올림)


---


## 예외 처리
1. 구입금액
   + 입력하지 않은 경우
   + 양수 외(문자, 음수, 소수)의 형태일 경우 
   + 0을 입력한 경우
   + 1000원으로 나누어 떨어지지 않는 경우
2. 당첨 번호
   + 입력하지 않은 경우
   + 숫자 외에 문자를 입력한 경우
   + 6개 미만으로 입력한 경우
   + 6개 초과로 입력한 경우
   + 1 ~ 45 범위가 아닌 숫자를 입력한 경우
   + 중복된 숫자를 입력한 경우
3. 보너스 번호
   + 입력하지 않은 경우
   + 숫자 외에 문자를 입력한 경우
   + 1개 초과로 입력한 경우
   + 1 ~ 45 범위가 아닌 숫자를 입력한 경우
   + 당첨 번호와 중복된 숫자를 입력한 경우
---
