# java-lotto-precourse

# 기능 요구사항 정리

## 입력

입력1) 로또 구입 금액을 입력 받고, 1000으로 나누어 발행할 로또 수량을 구한다  
✔️입력1 예외사항
- 양의 정수를 입력하지 않으면 IllegalArgumentException을 발생시킨다
- 1000으로 나누어떨어지지 않으면 IllegalArgumentException을 발생시킨다

입력2) 당첨 번호를 입력받는다.  
✔️입력2 예외사항
- 로또 번호 중 하나라도 1부터 45 사이에 존재하지 않으면 IllegalArgumentException을 발생시킨다
- 중복된 번호가 있으면 IllegalArgumentException을 발생시킨다
- 6개를 입력하지 않으면 IllegalArgumentException을 발생시킨다
- 문자열에 숫자 또는 쉼표가 아닌 것이 존재하면 IllegalArgumentException을 발생시킨다

입력3) 보너스 번호를 입력 받는다  
✔️입력3 예외사항  
- 양의 정수를 입력하지 않으면 IllegalArgumentException을 발생시킨다
- 보너스 번호가 당첨 번호 중 하나와 같다면 IllegalArgumentException을 발생시킨다
- 1부터 45 사이에 존재하지 않으면 IllegalArgumentException을 발생시킨다
- 문자열에 숫자가 아닌 것이 존재하면 IllegalArgumentException을 발생시킨다

## 로또 발행하기
로또 수량만큼 1부터 45 사이 서로 다른 여섯개 숫자를 뽑는다.  
✔️ 발행한 로또를 오름차순으로 정렬한다

## 당첨 내역 확인하기  
과정1) 각각의 로또가 당첨 번호와 몇개가 일치하는지 구한다  
과정2) 일치하는 개수와 해당 개수에 대응하는 상금을 HashMap에 저장한다  
✔️0개,1개,2개가 일치하면 HashMap에 저장하지 않는다

## 수익률 구하기  
로또 구입 금액과 당첨 내역을 바탕으로 수익률을 구한다  
✔️ 수익률은 소수점 둘째 자리에서 반올림한다


