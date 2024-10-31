# java-lotto-precourse

# 시스템 흐름
1. 구입할 로또 금액을 입력받는다
2. 당첨 금액 만큼 로또 번호를 생성해서 발행한다.
3. 당첨 번호와 보너스 번호를 입력 받는다.
4. 랜덤으로 생성된 번호와, 당첨 번호를 비교한다.
5. 구매한 모든 로또의 당첨 내역 및 수익률을 출력한다.

# 기능 목록
## 로또 구입 금액 입력
### ❗제약 조건
  - 구입할 로또 금액은 1000원 단위로 입력된다.
    - [ ] 예외 처리

### ⚙️ 기능 목록
- [ ] 로또 구매 금액을 입력받는다.
- [ ] 로또 구매 금액이 1000원 단위로 입력되었는지 확인한다.

## 로또 생성
### ❗제약 조건
- 로또 번호의 숫자 범위는 1~45까지이다.
    - [x] 예외 처리
- 로또 번호는 중복되지 않는다.
    - [x] 예외 처리
- 로또 번호는 6개의 숫자로 이루어져 있다.
    - [x] 예외 처리

### ⚙️ 기능 목록
- [x] 1 ~ 45 중 중복되지 않는 6개의 숫자를 뽑는 기능
- [ ] 구입 금액에 해당하는 만큼 로또를 발행하는 기능
- [ ] 로또 구매 시 금액 차감 기능
- [x] 로또 번호를 오름차순으로 정렬하는 기능
- [ ] 로또 생성 기능

## 당첨번호 및 보너스 번호 입력
### ❗제약 조건
- 당첨 번호는 1 ~ 45까지의 숫자로 이루어져 있다.
    - [ ] 예외 처리
- 당첨 번호는 6개의 숫자로 이루어져 있다.
    - [ ] 예외 처리
- 보너스 번호는 1 ~ 45까지의 숫자로 이루어져 있다.
    - [ ] 예외 처리
- 보너스 번호는 1개의 숫자로 이루어져 있다.
    - [ ] 예외 처리

### ⚙️ 기능 목록
- [ ] 당첨 번호 입력 기능
- [ ] 보너스 번호 입력 기능
- [ ] 당첨 번호와 보너스 번호를 저장하는 기능

## 당첨 확인

### ⚙️ 기능 목록
- [ ] 로또 번호와 당첨 번호를 비교하는 기능
- [ ] 당첨 내역을 저장하는 기능
- [ ] 수익률을 계산하는 기능

## 출력

### ⚙️ 기능 목록
- [ ] 발행한 로또 수량 및 번호를 출력하는 기능
- [ ] 당첨 내역 및 수익률을 출력하는 기능