# java-lotto-precourse

## 기능 구현 목록 작성
1. 로또 번호를 생성하는 기능을 구현한다. 
2. 로또 번호를 생성하는 기능이 올바른지 검증한다.
   - [x] 리스트의 크기가 6이 넘으면 'IllegalArgumentException' 을 발생시킨다.
   - [x] 리스트에 중복된 숫자가 존재하면 'IllegalArgumentException' 을 발생시킨다.
   - [x] 로또 번호가 1 ~ 45 이내의 수가 아니면 'IllegalArgumentException' 을 발생시킨다.
3. 로또 번호는 오름차순으로 생성한다.
4. 당첨 등수와 상금을 열거형 타입으로 저장한다.
5. 구매한 로또 번호와 당첨 번호가 몇 개 일치하는지 확인하는 기능을 구현한다.
6. 구매한 모든 로또를 돌면서 각 로또가 당첨 번호와 몇 개 일치하는지 count 한 후 반환한다.
7. 각각의 등수에 필요한 번호 개수와 보너스 번호가 일치하는지 확인한 후 해당 등수를 반환한다.
8. 비교한 결과를 저장하는 기능을 구현한다.
9. 구매한 로또에 대한 총 상금을 계산하는 기능을 구현한다.
10. 총 상금에 대한 수익률을 계산한다.
11. 당첨 통계를 출력하는 메서드를 구현한다.
12. 구매 금액을 입력받는 기능을 구현한다.
    - [x] 구매 금액이 숫자 이외의 입력값이면 'IllegalArgumentException' 을 발생시킨다.
    - [x] 구매 금액이 1000 단위가 아니면 'IllegalArgumentException' 을 발생시킨다.
    - [x] 구매 금액이 공백이면 'IllegalArgumentException' 을 발생시킨다.
13. 당첨 번호를 입력받는 기능을 구현한다.
    - [x] 당첨 금액이 숫자 이외의 입력값이면 'IllegalArgumentException' 을 발생시킨다.
    - [x] 당첨 금액이 공백이면 'IllegalArgumentException' 을 발생시킨다.
14. 보너스 번호를 입력받는 기능을 구현한다.
    - [x] 보너스 번호가 공백이면 'IllegalArgumentException' 을 발생시킨다.
    - [x] 보너스 번호가 숫자 이외의 입력값이면 'IllegalArgumentException' 을 발생시킨다.
    - [x] 보너스 번호가 지정된 범위를 넘으면 'IllegalArgumentException' 을 발생시킨다.
    - [x] 보너스 번호가 담청 번호가 중복되면 'IllegalArgumentException' 을 발생시킨다.
