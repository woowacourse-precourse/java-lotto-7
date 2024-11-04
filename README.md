# java-lotto-precourse

## 기능 요구 사항

### 1. 구입 금액으로 로또 구입
- 구입 금액을 입력받아 로또를 생성할 수 있는 개수를 계산합니다.
- 로또는 1,000원 단위로 구매되며, 구입 가능한 로또 개수는 `(구입 금액) / 1000`으로 산출됩니다.
- 각 로또 번호는 `Randoms.pickUniqueNumbersInRange(1, 45, 6)`를 사용하여 중복 없이 생성됩니다.


### 2. 로또 번호 생성기
- `Randoms.pickUniqueNumbersInRange(시작번호, 마지막번호, 개수)` 메서드를 사용하여 중복 없는 로또 번호를 생성합니다.
- 구입 개수만큼 반복하여 로또 번호를 생성합니다.


### 3. 당첨 로직 구현
- 당첨 결과를 계산하기 위해 모든 로또의 당첨 여부를 확인하고, 수익률을 계산합니다.
- **Rank** 열거형(Enum)을 사용하여 당첨 순위를 정의합니다.
- 각 로또에 대해:
  - 당첨 번호와 일치하는 개수를 확인합니다.
  - 보너스 번호가 로또 번호에 포함되어 있는지 확인합니다.
  - 당첨 순위를 `Map<Rank, Integer>`로 기록하여 각 순위별 개수를 관리합니다.
  - 당첨된 금액은 `Member` 클래스의 수익금에 추가됩니다.
- 보너스 번호는 당첨 번호 일치 개수에 포함하지 않으며, 일치 여부만 `boolean`으로 반환됩니다.


### 4. 수익률 계산
- 모든 로또의 당첨 결과를 확인한 후 수익률을 계산합니다.


## 주요 클래스 설명

### 1. Lotto 클래스
- **역할**: 로또 번호를 관리하고 유효성을 검증합니다.
- **주요 메서드**:
  - `Lotto(List<Integer> numbers)`: 주어진 로또 번호 리스트를 검증하고 정렬합니다.
  - `validate(List<Integer> numbers)`: 중복, 개수, 범위 등 로또 번호의 유효성을 검사합니다.
  - `isOutOfRange(List<Integer> winningLottery)`: 각 번호가 지정된 범위 내에 있는지 확인합니다.
  - `generate()`: 무작위로 6개의 중복 없는 로또 번호를 생성하여 반환합니다.
- **특징**: 로또 번호의 생성과 유효성 검증을 자체적으로 수행하여 잘못된 번호 생성이 방지됩니다.

### 2. MyLottoInfo 클래스
- **역할**: 사용자가 구매한 로또와 그 결과를 관리합니다.
- **주요 메서드**:
  - `MyLottoInfo(List<Lotto> myLotteries)`: 구매한 로또 리스트를 초기화하고 결과 맵을 설정합니다.
  - `getResultPerLotto(WinningLotto winningLotto)`: 각 로또와 당첨 번호를 비교하여 당첨 결과를 반환합니다.
  - `updateResult(List<Rank> ranks)`: 당첨 순위를 업데이트합니다.
  - `from(int count)`: 주어진 개수만큼 로또를 생성하여 `MyLottoInfo` 객체를 반환합니다.
- **특징**: 사용자가 구매한 로또와 각 당첨 순위를 관리하여 게임의 결과를 제공합니다.

### 3. Purchase 클래스
- **역할**: 로또 구입 금액과 로또 개수를 관리합니다.
- **주요 메서드**:
  - `Purchase(int purchaseAmount, int purchaseLottoCount)`: 주어진 구입 금액과 구입한 로또 개수를 초기화합니다.
  - `from(PurchaseAmountDto dto)`: DTO 객체로부터 `Purchase` 객체를 생성합니다.
- **특징**: 사용자의 구입 금액을 기준으로 로또 개수를 계산하여 저장합니다.

### 4. Rank 클래스
- **역할**: 로또 게임의 당첨 순위를 관리하고 각 순위의 당첨 조건 및 상금을 정의합니다.
- **주요 메서드**:
  - `Rank(int matchingCount, boolean containsBonusNumber, int winningPrice)`: 각 당첨 순위의 조건을 초기화합니다.
  - `findRank(int matchingCount, boolean isBonusNumberMatches)`: 주어진 일치 개수와 보너스 번호 일치 여부로 당첨 순위를 반환합니다.
- **특징**: Enum으로 정의되어 있으며, 각 순위마다 고유의 조건과 상금을 갖고 있습니다.

### 5. Revenue 클래스
- **역할**: 로또 게임의 총 수익 금액과 수익률을 관리합니다.
- **주요 메서드**:
  - `updateRevenueRate(int purchaseAmount)`: 구매 금액에 따라 수익률을 계산하고 반올림합니다.
  - `from(List<Rank> ranks)`: 당첨된 로또 순위를 기반으로 총 수익을 계산하여 `Revenue` 객체를 반환합니다.
- **특징**: 수익 금액과 수익률을 관리하며, 전체 수익률을 반올림 처리하여 정확하게 반환합니다.

### 6. WinningLotto 클래스
- **역할**: 당첨 로또 번호와 보너스 번호를 관리합니다.
- **주요 메서드**:
  - `WinningLotto(Lotto winningLotto, int bonusNumber)`: 당첨 번호와 보너스 번호를 초기화하며, 중복 여부를 검증합니다.
  - `isDuplicateWithWinningNumbers(Lotto winningLotto, int bonusNumber)`: 보너스 번호가 당첨 번호에 포함되어 있는지 확인합니다.
  - `from(WinningLotteryDto winningLotteryDto, BonusNumberDto bonusNumberDto)`: DTO 객체에서 `WinningLotto` 객체를 생성합니다.
- **특징**: 보너스 번호와 당첨 번호의 중복 여부를 검증하여 잘못된 당첨 번호 구성을 방지합니다.

## 예외 상황 및 오류 메시지
프로그램은 다양한 입력 유효성 검사를 수행하며, 입력이 잘못되었을 경우 아래와 같은 예외 메시지를 출력합니다.

### 1. 구입 금액 관련 예외
- **`INVALID_LOTTO_PURCHASE_AMOUNT`**: "구입 금액이 올바르지 않습니다. 로또 하나당 금액은 1000원입니다."
  - 입력된 구입 금액이 1000원 단위가 아닐 때 발생합니다.
- **`INVALID_LOTTO_PURCHASE_NUMBER_FORMAT`**: "구입금액은 정수만 입력 가능합니다."
  - 구입 금액 입력이 정수가 아닌 경우 발생합니다.

### 2. 당첨 번호 관련 예외
- **`INVALID_WINNING_NUMBER_RANGE`**: "당첨 로또 번호가 올바르지 않습니다. 번호는 1 ~ 45 사이 숫자만 가능합니다."
  - 당첨 번호가 1 ~ 45 사이의 숫자가 아닐 경우 발생합니다.
- **`INVALID_WINNING_NUMBER_FORMAT`**: "당첨 로또 번호에는 정수만 입력 가능합니다."
  - 당첨 번호에 정수가 아닌 값이 포함된 경우 발생합니다.
- **`INVALID_WINNING_NUMBER_DUPLICATE`**: "중복된 당첨 로또 번호가 존재합니다."
  - 당첨 번호에 중복된 숫자가 있을 때 발생합니다.
- **`INVALID_WINNING_NUMBER_SIZE`**: "당첨 로또 번호는 6개여야 합니다."
  - 입력된 당첨 번호가 6개가 아닐 때 발생합니다.

### 3. 보너스 번호 관련 예외
- **`INVALID_BONUS_NUMBER_RANGE`**: "보너스 번호가 올바르지 않습니다. 번호는 1 ~ 45 사이 숫자만 가능합니다."
  - 보너스 번호가 1 ~ 45 사이의 숫자가 아닐 경우 발생합니다.
- **`INVALID_BONUS_NUMBER_DUPLICATE_WITH_WINNING`**: "보너스 번호가 당첨 로또 번호와 중복됩니다."
  - 보너스 번호가 당첨 로또 번호와 중복될 경우 발생합니다.

### 4. 생성된 로또 번호 관련 예외
- **`INVALID_GENERATED_LOTTO_NUMBERS_SIZE`**: "로또 번호는 6개여야 합니다."
  - 생성된 로또 번호가 6개가 아닌 경우 발생합니다.
- **`INVALID_GENERATED_LOTTO_NUMBERS_RANGE`**: "로또 번호는 1 ~ 45 사이 숫자만 가능합니다."
  - 생성된 로또 번호에 1 ~ 45 범위를 벗어나는 숫자가 포함된 경우 발생합니다.
- **`INVALID_GENERATED_LOTTO_NUMBERS_DUPLICATE`**: "중복된 로또 번호가 존재합니다."
  - 생성된 로또 번호에 중복된 숫자가 있을 때 발생합니다.
