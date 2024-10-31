# 로또

## 기능 구현 목록

---

### 입력
- [x] `구입금액을 입력해주세요.` 출력 후 int 값을 입력받는다.
  - Exception
    - [x] 티켓을 한 장도 살 수 없을 경우, 예외를 발생시킨다.
    - [x] 정수가 아닐 경우, 예외를 발생시킨다. 
    - [x] 1,000원으로 나누어떨어지지 않을 경우, 예외를 발생시킨다.

- [ ] `당첨 번호를 입력해주세요.` 출력 후 6자리의 당첨 번호를 입력받는다.
  - Exception
    - [ ] 당첨 번호가 한 개라도 1~45 사이의 숫자가 아닐 경우, 예외를 발생시킨다.
    - [ ] 당첨 번호가 중복되어 있을 경우, 예외를 발생시킨다.
    - [ ] 당첨 번호가 6자리가 아닐 경우, 예외를 발생시킨다.

- [ ] `보너스 번호를 입력해주세요.` 출력 후 보너스 번호를 입력받는다.
    - Exception
      - [ ] 보너스 번호가 1~45 사이의 숫자가 아닐 경우, 예외를 발생시킨다. 
      - [x] 당첨 번호에 보너스 번호가 포함되어 있다면 예외를 발생시킨다.

### 티켓 생성
- [x] 구입금액/티켓금액을 통해 티켓 개수를 구한다.

### 랜덤 번호 생성
- [x] 6자리의 랜덤 번호를 생성한다
- [x] 랜덤 번호에 중복되는 값이 없는지 검증한다.

### 당첨 내역 계산
- [ ] 당첨 번호와 랜덤 번호를 비교해 몇 개의 숫자가 같은지 계산한다.
  - [ ] 5개의 숫자가 같다면, 보너스 볼이 같은지 확인한다.
- [ ] 계산한 숫자를 이용해, 당첨 내역을 계산한다.
- [ ] 당첨 내역을 통해 총 얼마가 당첨되었는지를 계산한다.

### 수익률 계산
- [ ] (총 당첨 금액/구매 금액)*100 을 통해 수익률을 계산한다.  
- [ ] 수익률을 소수점 둘 째 자리에서 반올림을 한다.
 


### 출력
- [ ] `n개를 구매했습니다.` 메세지를 출력하고, n에는 구매 티켓 개수를 출력한다.
- [ ] 구매 티켓 개수만큼의 6자리 랜덤 번호를 출력한다.
- [ ] 3,4,5,6 개의 일치 번호에 대한 당첨 통계를 출력한다.
- [ ] 총 수익률을 출력한다.
