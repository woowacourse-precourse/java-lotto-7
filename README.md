# java-lotto-precourse

# 📎 기능 요구 사항
간단한 로또 발매기를 구현한다.

## ㅁ 제약 조건
- 1개의 로또를 <U>발행</U>할 때 <span style="color: red">중복되지 않는</span> 6개의 숫자를 뽑는다. <span style="color: red">(숫자 범위: 1~45)</span>  
- 당첨 번호 <U>추첨</U> 시 중복되지 않는 <span style="color: red">숫자 6개</span>와 보너스 <span style="color: red">번호 1개</span>를 뽑는다.  

---

## ㅁ 당첨 기준

- 당첨은 <span style="color: red">1등부터 5등</span>까지 있다.  
```java
  < 당첨 기준과 금액 >
  1등: 6개 번호 일치 / 2,000,000,000원
  2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  3등: 5개 번호 일치 / 1,500,000원
  4등: 4개 번호 일치 / 50,000원
  5등: 3개 번호 일치 / 5,000원  
```

---
## ㅁ 구매 조건

- 로또 구입 금액을 입력하면 <U>구입 금액에 해당하는 만큼</U> 로또를 발행해야 한다.  
- 로또 <span style="color:red">1장의 가격은 1,000원</span>이다. 

---

## ㅁ 당첨 번호 입력
- <U>당첨 번호와 보너스 번호를 입력</U>받는다.  
  ㄴ> <span style="color:red">쉼표(,)를 기준</span>으로 구분
- 사용자가 구매한 로또 번호와 당첨 번호를 <span style="color:red">1) 비교</span>하여 <span style="color:red">당첨 내역 및 수익률을 2) 출력</span>하고 로또 게임을 <span style="color:red">3) 종료</span>한다.  
  ㄴ> **2.1) 출력** : 오름차순으로 정렬  
  ㄴ> **2.2) 출력** : 수익률은 소수점 둘째 자리에서 <span style="color:red">반올림</span>
---

## ㅁ 예외 조건
- 사용자가 잘못된 값을 입력할 경우 ```IllegalArgumentException```을 <span style="color:red">1) 발생</span>시키고, "[ERROR]"로 시작하는 <span style="color:red">2) 에러 메시지를 출력</span> 후 <span style="color:red">3) 그 부분부터 입력을 다시</span> 받는다.  
  ㄴ> 2.1)에러 메시지 : 에러 문구는 <span style="color:red">"[ERROR]"로 시작</span>
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 <U>명확한 유형</U>을 처리한다.
- 1,000원으로  <span style="color:red">나누어 떨어지지 않는 경우</span> 예외 처리
- 