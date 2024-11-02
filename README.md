# 📝 기능 구현 목록

### 1. 로또 구입 금액 입력 및 로또 발행

- **구입 금액 입력 기능**
    - [x] 구입 금액 입력 메시지를 출력한다.
    - [x] 입력된 금액이 유효한지 검사한다:
        - [x] 빈 값 확인
        - [x] 숫자 형식 여부 확인
        - [x] 1,000 단위 여부 확인
        - [x] 최소 금액 확인
        - [x] 음수 여부 확인
    - [x] 유효한 입력일 경우, 발행할 로또 수량을 계산한다.

- **로또 발행 기능**
    - [x] 로또 수량에 맞게 로또를 발행한다.
    - [x] 각 로또는 중복되지 않는 6개의 숫자로 구성된다 (범위 1~45).
    - [x] 발행된 로또를 오름차순으로 정렬하여 출력한다.
    - [x] 발행 수량 계산 (금액/1,000)

---

### 2. 당첨 번호와 보너스 번호 입력

- **당첨 번호 입력 기능**
    - [ ] 당첨 번호 입력 메시지를 출력한다.
    - [ ] 입력된 번호가 유효한지 검사한다:
        - [ ] 빈 값 여부 확인
        - [ ] 쉼표로 구분된 형식 확인
        - [ ] 각 번호가 1~45 범위 내에 있는지 확인
        - [ ] 중복 여부 확인

- **보너스 번호 입력 기능**
    - [ ] 보너스 번호 입력 메시지를 출력한다.
    - [ ] 보너스 번호의 유효성을 검사한다:
        - [ ] 빈 값 여부 확인
        - [ ] 1~45 범위 내에 있는지 확인
        - [ ] 당첨 번호와 중복되지 않도록 확인

---

### 3. 당첨 내역 및 수익률 출력

- **당첨 내역 계산**
    - [ ] 발행된 로또와 당첨 번호, 보너스 번호를 비교하여 일치하는 개수를 확인한다.
    - [ ] 일치 개수에 따라 당첨 내역을 업데이트한다.

- **수익률 계산 및 출력**
    - [ ] 당첨된 금액을 통해 수익률을 계산하고, 소수점 둘째 자리에서 반올림하여 백분율로 출력한다.

- **당첨 내역 및 수익률 출력**
    - [ ] 당첨 통계 메시지를 출력하고, 등수별 당첨 내역을 출력한다.
    - [ ] 총 수익률을 출력한다.

---


