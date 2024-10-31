# java-lotto-precourse

## 기능목록

---

### 1. 입력
- [X] 로또 구입 금액을 입력 받는다. - InputView#getPurchaseMoney
- [X] 당첨 번호를 입력 받는다. - InputView#getPrizeNumber
- [X] 보너스 번호를 입력 받는다. - InputView#getBonusNumber

---

### 2. 사용자 입력에 대한 유효성 검사
#### 구입 금액
- [X] 구입 금액을 정수형 숫자로 변환 - InputValidator#convertInteger
- [X] 구입 금액이 1000원 단위인지 검사 - InputValidator#isValidUnit
- [X] 올바른 구입 금액 입력 받기 - InputValidator#getValidPurchaseMoney

#### 당첨 번호
- [X] 쉼표를 기준으로 문자열 분리 - InputValidator#splitString
- [X] 분리된 문자열 배열을 정수형 숫자로 변환 - InputValidator#convertIntegers
- [X] 입력된 당첨 번호가 6개인지 검사 - InputValidator#isValidLength
- [X] 중복되지 않는 번호인지 검사 - InputValidator#isDuplicate

#### 보너스 번호
- [X] 보너스 번호를 정수형 숫자로 변환 - InputValidator#convertInteger
- [X] 입력 받은 당첨 번호와 중복되지 않는지 검사 - InputValidator#isDuplicateWithPrizeNumber

---

### 2. 로또 시스템
#### 로또 번호 발행
- [ ] 1-45 사이의 중복되지 않은 정수 6개를 생성
- [ ] 발행한 로또 번호 6개를 오름차순 정렬하여 리스트에 담아 반환
- [ ] 구매한 로또 개수만큼 로또를 발행

#### 로또 당첨 내역 조회
- [ ] 로또 번호 6개 중 당첨 번호와 일치하는 번호 개수를 반환
- [ ] 일치하는 번호 개수를 통해 등수 확인
- [ ] 구매한 로또들의 등수 계산(등수 카운팅)

#### 수익
- [ ] 로또 구입 금액과 당첨 금액을 통해 수익률 계산
  - [ ] 수익률은 소수점 둘째 자리에서 반올림

---

### 3. 출력
- [ ] 구매한 로또 번호 출력
- [ ] 당첨 통계 출력
- [ ] 수익률 출력

---

### 4. 요구사항
- [ ] indent depth는 2까지 허용한다.
- [ ] 3항 연산자를 사용하지 않는다.
- [ ] 함수가 한 가지 일만 하도록 최대한 작게 만든다.
- [ ] 메서드의 길이가 15라인을 넘지 않도록 구현한다.
- [ ] else문을 사용하지 않는다.
- [ ] Java Enum을 적용한다.
- [ ] 구현한 기능에 대한 단위 테스트를 작성한다.
- [ ] 제공된 Lotto 클래스를 사용하여 구현해야 한다.

