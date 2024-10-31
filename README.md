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
