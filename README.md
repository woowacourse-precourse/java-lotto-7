# java-lotto-precourse

## 요구 사항
- 각 로또는 1부터 45까지의 고유한 6개의 숫자로 구성
- 로또 번호는 중복되지 않아야 함
- 사용자가 입력한 금액에 따라 로또를 구매
- 당첨 번호와 보너스 번호를 입력받아 당첨 결과를 계산
- 수익률을 계산하여 출력
- 모든 입력은 유효성을 검사하고, 잘못된 입력 시 에러 메시지를 출력

## 클래스 구조

### Application
- 프로그램의 진입점
- **메서드**:
  - `main(String[] args)` - 프로그램 실행
- **역할**:
  - 전체 프로그램의 흐름을 제어
  - 예외 발생 시 에러 메시지를 출력하고 재입력을 유도

### Lotto
- 로또의 번호를 저장하고 검증
- **필드**:
  - `List<Integer> numbers` - 로또 번호
- **메서드**:
  - `Lotto(List<Integer> numbers)` - 생성자, 번호 검증 및 정렬
  - `getNumbers()` - 로또 번호 반환
  - `toString()` - 로또 번호 문자열 반환

### Rank
- 로또의 당첨 등수를 정의
- **열거형 값**:
  - `FIRST`, `SECOND`, `THIRD`, `FOURTH`, `FIFTH`, `NONE`
- **필드**:
  - `int matchCount` - 일치하는 번호 개수
  - `long prize` - 당첨 상금
- **메서드**:
  - `getPrize()` - 상금 반환
  - `valueOf(int matchCount, boolean bonusMatch)` - 일치 개수와 보너스 여부에 따른 등수 반환
  - `orderedRanks()` - 출력 순서에 따른 등수 배열 반환

### WinningNumbers
- 당첨 번호와 보너스 번호를 관리
- **필드**:
  - `List<Integer> winningNumbers` - 당첨 번호
  - `int bonusNumber` - 보너스 번호
- **메서드**:
  - `WinningNumbers(List<Integer> winningNumbers, int bonusNumber)` - 생성자, 번호 검증
  - `getWinningNumbers()` - 당첨 번호 반환
  - `getBonusNumber()` - 보너스 번호 반환

### Statistics
- 당첨 결과와 수익률을 관리
- **필드**:
  - `int firstPrizeCount`
  - `int secondPrizeCount`
  - `int thirdPrizeCount`
  - `int fourthPrizeCount`
  - `int fifthPrizeCount`
  - `int totalPurchaseAmount`
- **메서드**:
  - `Statistics(int first, int second, int third, int fourth, int fifth, int totalPurchaseAmount)` - 생성자
  - `getRateOfReturn()` - 수익률 계산 반환

### ResultCalculator
- 당첨 결과를 계산
- **필드**:
  - `WinningNumbers winningNumbers`
  - `List<Lotto> lottos`
- **메서드**:
  - `ResultCalculator(WinningNumbers winningNumbers, List<Lotto> lottos)` - 생성자
  - `calculate()` - 당첨 결과 계산 후 `Statistics` 반환

### LottoGenerator
- 로또를 생성하는 로직을 담당
- **필드**:
  - `static final int LOTTO_PRICE = 1000`
- **메서드**:
  - `generateLottos(int amount)` - 로또 목록 생성 반환

### InputView
- 사용자 입력을 담당
- **메서드**:
  - `readPurchaseAmount()` - 구매 금액 입력 및 검증
  - `readWinningNumbers()` - 당첨 번호 입력 및 검증
  - `readBonusNumber(List<Integer> winningNumbers)` - 보너스 번호 입력 및 검증

### OutputView
- 출력 형식을 담당
- **메서드**:
  - `printLottoCount(int count)` - 구매한 로또 개수 출력
  - `printLottos(List<Lotto> lottos)` - 로또 번호들 출력
  - `printStatistics(Statistics statistics)` - 당첨 통계 및 수익률 출력

### Validation
- **메서드**:
  - `validatePurchaseAmount(String input)` - 구매 금액 유효성 검사
  - `validateWinningNumbers(String input)` - 당첨 번호 유효성 검사
  - `validateBonusNumber(String input, List<Integer> winningNumbers)` - 보너스 번호 유효성 검사

## 테스트
- **기능 테스트**
  - 로또 구매, 당첨 번호 입력, 결과 계산 등의 전체 기능이 정상 동작하는지 테스트
- **예외 테스트**
  - 잘못된 입력에 대해 적절한 예외가 발생하는지 테스트
  - 로또 번호의 개수, 중복, 범위 초과 시 예외 발생 확인
- **수익률 계산 테스트**
  - 다양한 당첨 결과에 따른 수익률이 정확히 계산되는지 테스트
- **동시 우승자 테스트**
  - 여러 명의 우승자가 발생할 경우 올바르게 처리되는지 테스트

## 주의사항
- **들여쓰기 깊이(depth)**: 최대 2까지만 사용
- **3항 연산자 사용 금지**: 코드의 가독성을 위해 사용하지 않음
- **메서드 역할 제한**: 각 메서드는 최대한 한 가지 역할만 수행
- **코드 스타일 준수**: Java Style Guide를 따르며, 일관된 코드 작성
- **불변 객체 사용**: `Lotto` 클래스는 불변 객체로 설계
- **단위 테스트 작성**: 핵심 로직에 대한 단위 테스트를 JUnit 5와 AssertJ를 사용하여 작성
- **외부 라이브러리 사용 제한**: 제공된 라이브러리 외의 외부 라이브러리는 사용하지 않음
- **System.exit() 호출 금지**: 프로그램 종료 시 `System.exit()`를 사용하지 않음
