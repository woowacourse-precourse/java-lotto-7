# java-lotto-precourse

## 프로세스

#### 로또 구입 금액 입력 - 1,000원 당 로또 한 개 발행 - 당첨 번호 및 보너스 번호 입력 - 번호를 비교하여 당첨 내역 및 수익률 출력

## 기능 목록

### 1. 사용자 입력
- [x] 로또 구입 금액 입력
- [x] 당첨 번호 입력
- [x] 보너스 번호 입력
### 2. 로또 발행
- [x] 1~45 사이의 랜덤한 숫자 6개 추출
- [x] 금액에 맞는 로또 발행
- [x] 로또 번호 오름차순 정렬
### 3. 로또 번호 비교
- [x] 로또 번호와 당첨 번호 비교 로직
- [x] 수익률 계산 로직
### 4. 출력
- [x] 발행한 로또 수량 및 번호 출력
- [x] 당첨 내역 출력
- [x] 수익률 출력
- [ ] 에러 메세지 출력
### 5. 예외 상황
- [x] 구입 금액이 1,000원으로 나누어 떨어지지 않거나 1,000원 미만인 경우
- [ ] 구입 금액에 숫자가 아닌 값을 입력한 경우
- [x] 당첨 번호가 1부터 45 사이의 정수가 아닌 경우
- [ ] 로또 번호의 개수가 6개가 아닌 경우
- [ ] 로또 번호에 중복된 숫자가 있는 경우
- [x] 보너스 번호가 당첨 번호와 중복되는 경우
- [x] 보너스 번호에 올바른 숫자를 입력하지 않은 경우

## 단위 테스트
- [ ] 각 예외 상황 테스트
- [x] 랜덤 숫자 추출 테스트
- [ ] 로또 번호 비교 로직 테스트
- [ ] 수익률 계산 로직 테스트
- [ ] 올바른 수량의 로또를 발행하는지 테스트
- [x] 당첨 갯수에 따른 등수와 상금 확인 테스트
