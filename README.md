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
- [X] 올바른 구입 금액 입력 받기 - InputValidator#getValidPurchaseMoney
- [X] 구입 금액을 정수형 숫자로 변환 - InputValidator#convertInteger
- [X] 구입 금액이 1000원 단위인지 검사 - InputValidator#isValidUnit

#### 당첨 번호
- [X] 올바른 당첨 번호 입력 받기 - InputValidator#getValidPrizeNumber
- [X] 쉼표를 기준으로 문자열 분리 - InputValidator#splitString
- [X] 분리된 문자열 배열을 정수형 숫자로 변환 - InputValidator#convertIntegers
- [X] 입력된 당첨 번호가 1-45 범위 내에 있는지 검사 - InputValidator#isValidRange
- [X] 입력된 당첨 번호가 6개인지 검사 - InputValidator#isValidLength
- [X] 중복되지 않는 번호인지 검사 - InputValidator#isDuplicate

#### 보너스 번호
- [X] 올바른 보너스 번호 입력 받기 - InputValidator#getValidBonusNumber
- [X] 보너스 번호를 정수형 숫자로 변환 - InputValidator#convertInteger
- [X] 입력된 보너스 번호가 1-45 범위 내에 있는지 검사 - InputValidator#isValidRange
- [X] 입력 받은 당첨 번호와 중복되지 않는지 검사 - InputValidator#isDuplicateWithPrizeNumber

---

### 3. 로또 시스템
#### 로또 번호 발행
- [X] 1-45 사이의 중복되지 않는 정수 6개를 생성 - Lotto#generateLottoNumber
- [X] 발행한 로또 번호 6개를 오름차순 정렬 - Lotto#sortNumbers
- [X] 발행한 로또 번호를 반환 - Lotto#getNumbers

#### 로또 당첨 내역
- [X] 구입한 모든 로또들의 당첨 내역을 당첨 통계에 업데이트 - PrizeSystem#checkPrizeResult
- [X] 로또 번호 6개 중 당첨 번호와 일치하는 번호 개수를 반환 - PrizeSystem#getMatchCount
- [X] 일치하는 번호 개수를 통해 당첨 통계에 업데이트 - PrizeSystem#updatePrizeCount
- [X] 보너스 번호를 비교하여 2등, 3등 가리기 - PrizeSystem#bonusCase

#### 수익
- [X] 로또 당첨 금액 정보 관리 - PrizeMoney(Enum)
- [X] 총 당첨 금액 계산 - PrizeSystem#getPrizeMoney
- [X] 로또 구입 금액과 총 당첨 금액을 통해 수익률 계산 - PrizeSystem#getProfit
- [X] 당첨 통계 정보를 반환 - PrizeSystem#getPrizeCount

---

### 4. 출력
- [X] 구매한 로또 번호 출력 - OutputView#printMyLottos
- [X] 당첨 통계 출력 - OutputView#printPrizeResult
- [X] 수익률 출력 - OutputView#printProfit
  - [X] 수익률은 소수점 둘째 자리에서 반올림하여 첫째 자리까지 출력 - OutputView#printProfit

---

### 5. 컨트롤러
- [X] 컨트롤러 실행 - LottoController#start
- [X] 사용자로부터 구입 금액 입력 받기 - LottoController#getPurchaseMoney
- [X] 구입 금액만큼 로또 발행 - LottoController#generateLotto
- [X] 당첨 번호 및 보너스 보호 입력 받기 - LottoController#getPrizeNumberAndBonusNumber

---

### 6. 요구사항
- [X] indent depth는 2까지 허용한다.
- [X] 3항 연산자를 사용하지 않는다.
- [X] 함수가 한 가지 일만 하도록 최대한 작게 만든다.
- [X] 메서드의 길이가 15라인을 넘지 않도록 구현한다.
- [X] else문을 사용하지 않는다.
- [X] Java Enum을 적용한다.
  - [X] 오류 메시지 Enum - ErrorMessage
  - [X] 당첨 상금 Enum - PrizeMoney
- [X] 구현한 기능에 대한 단위 테스트를 작성한다.
- [X] 제공된 Lotto 클래스를 사용하여 구현해야 한다.
- [X] 값을 하드코딩 하지 않는다.

