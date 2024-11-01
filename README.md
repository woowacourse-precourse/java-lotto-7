# java-lotto-precourse

## 기능 목록
 - 사용자가 입력한 금액을 바탕으로 몇 개의 로또를 발행할 지 결정합니다.
 - 각각의 로또를 1 ~ 45사이의 무작위 정수 6개로 구성하여 발행하고, 번호를 오름차순 정렬하여 출력합니다.
 - 당첨 번호와 보너스 번호를 입력 받습니다.
 - 발행된 로또 번호와 당첨 및 보너스 번호를 대조하여 당첨 여부를 결정하고, 결과를 출력합니다.
 - 구입 금액과 상금을 바탕으로 수익률을 계산하고 당첨 내역 하단에 출력합니다.
 - ~~게임 내 **예외 상황** 발생 시 에러 문구를 출력합니다.~~
 - 게임 내 **예외 상황** 발생 시 에러 문구를 출력하고, 그 부분부터 입력을 다시 받습니다.

## **예외 상황**(구현 도중에 새로운 예외 상황을 발견할 경우 추가할 예정입니다.)
- 로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우.
- 사용자가 당첨 번호에 6가지 숫자를 입력하지 않은 경우.
- 사용자가 당첨 번호를 중복해서 입력한 경우.
- 당첨 번호에 1 ~ 45 사이의 정수가 아닌 숫자가 입력된 경우.
- 당첨 번호에 숫자 이외의 값이 들어온 경우.
- 보너스 번호에 1개의 숫자를 입력하지 않은 경우.
- 보너스 번호에 1 ~ 45 사이의 정수가 아닌 다른 숫자를 입력한 경우.
- 보너스 번호에 숫자 이외의 값이 입력된 경우.

## 구현 순서
- [x] 기본 기능 구현하기
- [ ] 예외 상황 처리하기
- [ ] 코드 리펙토링
