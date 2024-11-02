# java-lotto-precourse

## 기능 구현 목록

---

### 입력 (Input)
- [ ] **로또 구입 금액 입력**
    - [ ] 사용자로부터 구입 금액을 입력받기
    - [ ] 구입 금액이 1,000원 단위인지 `LottoValidationService`에서 검증
    - [ ] `camp.nextstep.edu.missionutils.Console.readLine()`을 활용하여 입력 받기

- [ ] **당첨 번호 입력**
    - [ ] 6개의 당첨 번호를 쉼표(,)로 구분하여 입력받기
    - [ ] `WinningNumbers` 객체 생성 시 번호 유효성 검증 포함
    - [ ] `camp.nextstep.edu.missionutils.Console.readLine()`을 활용하여 입력 받기

- [ ] **보너스 번호 입력**
    - [ ] 사용자로부터 보너스 번호를 입력받기
    - [ ] `WinningNumbers` 객체 생성 시 보너스 번호 유효성 검증 포함
    - [ ] `camp.nextstep.edu.missionutils.Console.readLine()`을 활용하여 입력 받기

### 출력 (Output)
- [ ] **구입한 로또 번호 출력**
    - [ ] 구입 금액에 따라 발행한 로또 수량과 각 로또 번호를 오름차순으로 정렬하여 출력
    - [ ] “구매한 로또 수량: [로또 번호 목록]” 형태로 출력

- [ ] **당첨 결과 출력**
    - [ ] 각 당첨 등급(1등 ~ 5등)의 당첨 횟수 출력
    - [ ] 수익률을 소수점 둘째 자리에서 반올림하여 출력

### 로또 번호 발행
- [ ] **랜덤 로또 번호 생성**
    - [ ] `camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6)`을 사용하여 중복되지 않는 6개의 번호 생성
    - [ ] 생성된 번호를 오름차순으로 정렬하여 저장

### 당첨 결과 계산
- [ ] **당첨 등급 계산**
    - [ ] `LottoTicket`과 `WinningNumbers` 객체를 비교하여 일치하는 숫자 개수 계산
    - [ ] 당첨 등급을 1등부터 5등까지 구분하여 각 등급의 당첨 횟수 계산
    - [ ] 보너스 번호 일치 여부를 고려하여 2등과 3등 구분

- [ ] **수익률 계산**
    - [ ] 당첨 금액의 총합을 구입 금액으로 나누어 수익률 계산
    - [ ] 소수점 둘째 자리에서 반올림하여 출력 형식에 맞게 표시

### 객체 생성 시 검증 포함
- [ ] **`LottoTicket` 객체 생성 시 검증**
    - [ ] 로또 번호는 1~45 범위에서 중복되지 않는 6개의 숫자만 허용
    - [ ] 번호가 유효하지 않을 경우 `IllegalArgumentException` 발생

- [ ] **`WinningNumbers` 객체 생성 시 검증**
    - [ ] 당첨 번호는 1~45 범위의 6개 숫자만 허용
    - [ ] 보너스 번호가 당첨 번호와 중복되지 않도록 검증
    - [ ] 유효하지 않을 경우 `IllegalArgumentException` 발생
