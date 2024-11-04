# java-lotto-precourse

## 구현 메서드 정리

### Model

### (1) `Lotto` 클래스

- **역할**: 로또 번호 6개를 관리하며 번호 유효성을 검사
- **메서드**:
    - `validate(List<Integer> numbers)`: 번호 개수와 중복 없이 1~45 범위인지 검사
    - `getNumbers()`: 오름차순으로 정렬된 번호 반환

### (2) `LottoMachine` 클래스

- **역할**: 로또를 생성하고 구매한 로또와 당첨 번호를 비교하여 결과 반환
- **메서드**:
    - `generateLottos(int count)`: 입력된 개수만큼 로또 생성
    - `setWinningNumbers(List<Integer> winningNumbers)`, `setBonusNumber(int bonusNumber)`: 당첨 및 보너스 번호 설정
    - `compareLottos()`: 당첨 번호와 구매 로또를 비교하여 당첨 등수 계산

### (3) `Rank` Enum

- **역할**: 당첨 순위와 상금 액수를 정의하고, 일치하는 번호 개수와 보너스 번호 여부에 따라 순위를 반환

### View

### `LottoView` 클래스

- **역할**: 사용자로부터 입력을 받고 출력을 담당
- **메서드**:
    - `getInputAmount()`: 구매 금액 입력
    - `getInputWinningNumbers()`, `getInputBonusNumber()`: 당첨 번호와 보너스 번호 입력
    - `printLottos(List<Lotto> lottos)`: 생성된 로또 목록 출력
    - `printResults(Map<Rank, Integer> results, double profitRate)`: 당첨 결과와 수익률 출력

### Controller

### `LottoController` 클래스

- **역할**: 전체 애플리케이션 흐름을 제어하며, Model과 View를 연결하는 역할
- **필드**:
    - `LottoMachine lottoMachine`: 로또 비즈니스 로직을 수행하는 Model
    - `LottoView lottoView`: 사용자와의 상호작용을 담당하는 View
- **메서드**:
    - `run()`: 전체 프로그램 실행 흐름을 제어
        - `purchaseLottos()`: 로또 구입 금액을 받고 로또를 생성
        - `inputWinningNumbers()`: 당첨 번호와 보너스 번호 입력 처리
        - `showResults()`: 비교 결과와 수익률을 계산하고 View에 전달


## 최종 기능 명세서

### 1. `Lotto` 클래스 (Model)

- `validate(List<Integer> numbers)`: 생성자에서 호출되며, 로또 번호가 6개인지, 1~45 사이인지, 중복이 없는지를 검증한다. 조건을 만족하지 못하면 `IllegalArgumentException`을 발생시킨다.
- `isValidRange(List<Integer> numbers)`: 모든 번호가 1에서 45 사이인지 확인한다.
- `hasDuplicates(List<Integer> numbers)`: 번호 리스트에 중복된 값이 있는지 확인한다.
- `getNumbers()`: 로또 번호 리스트를 반환한다.

### 2. `Rank` Enum (Model)

- `valueOf(int matchCount, boolean matchBonus)`: 일치하는 번호 개수와 보너스 번호 일치 여부에 따라 당첨 순위를 반환한다. 1등부터 5등까지의 순위를 반환하며, 해당되지 않으면 `NONE`을 반환한다.
- `getPrize()`: 각 순위별 상금을 반환한다.
- `getDescription()`: 당첨 번호 일치 개수와 보너스 볼 일치 여부를 문자열로 반환한다.

### 3. `LottoMachine` 클래스 (Model)

- `generateLottos(int count)`: `count` 개수만큼 로또 번호를 생성하여 반환한다. 번호는 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 사용해 생성한다.
- `setWinningLotto(List<Integer> winningNumbers)`: 당첨 번호로 사용할 로또 번호 리스트를 설정한다. `Lotto` 객체로 생성되며, 유효성 검사를 수행한다.
- `setBonusNumber(int bonusNumber)`: 보너스 번호를 설정한다. `bonusNumber`가 1~45 사이의 숫자인지, 당첨 번호와 중복되지 않는지를 검증한다.
- `checkResults()`: 구매한 로또와 당첨 번호, 보너스 번호를 비교하여 당첨 결과 목록을 반환한다. `Rank` Enum을 사용해 일치 개수와 보너스 번호 여부에 따라 순위를 계산한다.

### 4. `LottoView` 클래스 (View)

- `getInputPurchaseAmount()`: 로또 구입 금액을 입력받아 반환한다. 잘못된 금액이 입력되면 `IllegalArgumentException`을 발생시키고, 에러 메시지를 출력한 뒤 다시 입력을 받는다.
- `validateAmount(int amount)`: 구입 금액이 1,000원 단위인지 확인한다. 유효하지 않으면 `IllegalArgumentException`을 발생시킨다.
- `getInputWinningNumbers()`: 당첨 번호를 쉼표로 구분된 형식으로 입력받아 리스트로 반환한다. 잘못된 형식이 입력되면 에러 메시지를 출력하고 다시 입력받는다.
- `getInputBonusNumber()`: 보너스 번호를 입력받아 반환한다. 숫자가 아닌 경우 에러 메시지를 출력하고 다시 입력받는다.
- `displayLottos(List<Lotto> lottos)`: 구매한 로또의 개수와 각 번호를 출력한다. 번호는 오름차순으로 정렬된 형태로 표시된다.
- `displayResults(List<Rank> results, double profitRate)`: 당첨 통계와 총 수익률을 출력한다. 수익률은 소수점 둘째 자리에서 반올림하여 표시한다.
- `parseNumbers(String input)`: 쉼표로 구분된 문자열을 정수 리스트로 변환한다. 숫자가 아닌 값이 포함된 경우 `IllegalArgumentException`을 발생시킨다.

### 5. `LottoController` 클래스 (Controller)

- `run()`: 전체 프로그램의 흐름을 제어하며, 아래의 과정을 따른다.
  1. 구입 금액 입력을 받고, 로또 개수에 따라 로또 번호들을 생성한다.
  2. 생성된 로또들을 화면에 출력한다.
  3. 당첨 번호와 보너스 번호를 입력받고 설정한다.
  4. 당첨 결과를 확인하고, 수익률을 계산하여 화면에 출력한다.
- `calculateProfitRate(List<Rank> results, int purchaseAmount)`: 당첨된 금액의 총합과 구입 금액을 바탕으로 수익률을 계산한다.

### 6. `Application` 클래스 (진입점)

- `main()`: 애플리케이션의 진입점으로, `LottoController`를 초기화하고 프로그램을 실행한다.
