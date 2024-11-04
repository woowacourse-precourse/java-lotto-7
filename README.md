

# 📝 구현해야 할 기능 목록

## ⌨️ 입력 기능
- [x] 로또 구입 금액 입력 받기
    ````
    ❌️ 예외
    1. 숫자가 아닌 경우(중간에 공백존재 포함)
    2. 1000원으로 나누어 떨어지지 않는 경우
    3. 1000원 이하거나 10만원이 초과하는 경우
    ````
- [x] 당첨 번호, 보너스 번호 입력 받기
   ````
   ❌️ 예외
   1. 숫자가 아닌경우(중간에 공백 존재 포함)
   2. 1~45의 범위안에 없는 경우
   3. 중복되는 경우
   ````
  
## 🎯 핵심 기능
- [x] 1~45까지 6가지 숫자 랜덤으로 생성하여 로또 생성하기
- [x] 로또 구매 금액만큼 로또 발행하기
- [x] 로또번호 비교하여 당첨 내역 저장하기
- [x] 총 수익률 계산하기
- [x] 예외 발생 시 에러 메세지 출력 후 재입력 받기 


## 🖥️ 출력 기능
- [x] 입력 요청 메세지 출력하기
- [x] 구매 티켓 출력하기
- [x] 당첨 통계 출력하기
- [x] 총 수익률 출력하기