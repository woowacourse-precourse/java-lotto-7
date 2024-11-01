# java-lotto-precourse

---

### 3주차 미션 - 로또
### 프로젝트 설명
자바로 구현한 로또 발매기 프로그램입니다. 
### 주요 기능
주요 기능은 다음과 같습니다.
1. 로또 구입
2. 로또 발행
3. 로또 추첨
4. 당첨 결과 및 수익률 안내

### 커스텀 기능 요구사항
- 1인 최대 구입 금액을 100,000원으로 제한한다

### 기능 목록
- [x] 로또 구입 금액을 입력 받는다
  

- [x] 구입 금액에 해당하는 개수의 로또를 발행한다
  

- [x] 발행된 로또의 수량을 안내한다
  

- [x] 발행된 모든 로또의 번호를 안내한다
  

- [x] 당첨 번호를 입력 받는다
  

- [ ] 보너스 번호를 입력 받는다
  

- [ ] 로또 번호와 당첨 번호를 비교하여 당첨 정보를 확인한다
  

- [ ] 발행된 모든 로또의 총 당첨 내역을 계산한다
  

- [ ] 당첨 내역을 안내한다
  

- [ ] 총 당첨 금액을 계산한다
  

- [ ] 구입 금액과 총 당첨 금액을 기반으로 수익률을 계산한다
  

- [ ] 수익률을 안내한다
  

- 잘못된 로또 구입 금액을 입력할 경우 예외를 발생한다
  - [x] 정수 외의 것을 입력한 경우
  - [ ] 음수를 입력한 경우
  - [ ] 로또 1장의 가격으로 나누어 떨어지지 않는 경우
  - [ ] 1인 최대 구입 금액을 초과한 경우


- 잘못된 당첨 번호를 입력할 경우 예외를 발생한다
  - [ ] 정수 외의 것을 입력한 경우
  - [ ] 당첨 번호의 개수가 다른 경우
  - [ ] 로또 번호의 범위를 벗어나는 경우
  - [ ] 번호가 중복되는 경우


- 잘못된 보너스 번호를 입력할 경우 예외를 발생한다
  - [ ] 정수 외의 것을 입력한 경우
  - [ ] 보너스 번호의 개수가 다른 경우
  - [ ] 로또 번호의 범위를 벗어나는 경우
  - [ ] 당첨 번호와 중복되는 경우