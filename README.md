# java-lotto-precourse

# 기능 구현 목록

## 입출력 기능

### 입력 기능

- [x] 로또 구입 금액을 입력하는 기능
- [x] 당첨 번호를 입력받는 기능
- [ ] 보너스 번호를 입력받는 기능

### 출력 기능

예외 상황시 에러문구 출력

- [x] 발행한 로또 수량을 출력하는 기능
- [x] 발행한 로또 번호를 출력하는 기능
- [ ] 당첨 내역을 출력하는 기능
- [ ] 수익률을 출력하는 기능

## 서비스 기능

- [x] 구입 금액에 해당하는 만큼 로또를 발행하는 기능
    - [x] 발행한 로또 번호는 오름차순으로 정렬
- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교하는 기능
- [ ] 수익률 계산 기능((수익 / 투자비용) * 100)

## 예외처리 기능

- [x] 로또 구입 금액이 1,000원 으로 나누어 떨어 지지 않는 경우 예외 처리 하는 기능
- [ ] 로또 당첨 번호가 1 부터 45 사이의 숫자가 아닌 경우 예외 처리하는 기능
- [x] 로또 당첨 번호가 숫자가 아닌경우 예외 처리하는 기능
- [ ] 로또 당첨 번호가 중복되지 않는 숫자 6개가 아닌 경우 예외 처리하는 기능
- [ ] 보너스 번호가 로또 당첨번호 중에 중복인 경우 예외 처리 하는 기능

## 프로그램 흐름

1. 구입금액 입력
2. 발행한 로또 갯수 출력
2. 발행한 로또 번호 출력
3. 당첨 번호 입력
4. 보너스 번호 입력
5. 당첨 내역 출력
6. 총 수익률 출력