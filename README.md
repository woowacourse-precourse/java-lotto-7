# java-lotto-precourse

## 구현 기능 목록
이번 과제는 로또 발매기를 구현하는 프로젝트입니다. 구현 기능 목록은 프로그램이 돌아가는 순서로 작성해보았습니다.

### 로또 구매 금액 입력
사용자로부터 로또 구입 금액을 입력받습니다. 검증해야 하는 로직은 다음과 같습니다.

> 1. 입력은 정수여야만 한다.
> 2. 구매 단위는 1,000원 단위로 받는다.

만약 이 조건을 어긴다면 예외 처리를 합니다. 이 조건에 따라 입력을 받을 `InputView`, 받은 입력을 검증할 `Validator`, 그리고 이 로직을 실행할 `Handler`가 필요합니다. 이 `Handler`는 `Controller`에서 호출되며, 검증된 입력은 `LottoPurchaseRequestDto` DTO를 통해 저장됩니다.

### 발행한 로또 출력
사용자로부터 로또 구매 입력을 받으면, 금액의 1,000원 단위 몫만큼 로또를 생성합니다. 로또를 발행한 다음, Console에 발행한 로또 개수와 무작위로 생성한 로또 번호를 출력합니다.

이 기능은 `LottoPurchaseRequestDto`를 통해 구매 금액을 받아서 1,000원 단위 몫만큼 로또를 생성합니다.

### 당첨 번호 입력
사용자로부터 당첨 번호를 입력받습니다. 검증해야 하는 로직은 다음과 같습니다.

> 1. 입력으로 받은 숫자가 `,` 구분자로 나누어져야 한다.
> 2. 총 6개의 숫자여야 한다.
> 3. 각 숫자는 1-45 사이의 정수여야 한다.
> 4. 숫자는 중복되지 않아야 한다.

### 보너스 번호 입력
사용자로부터 보너스 번호를 입력받습니다. 검증해야 하는 로직은 다음과 같습니다.

> 1. 입력은 1부터 45 사이의 정수여야 한다.
> 2. 당첨 번호와 중복되지 않아야 한다.

여기서 입력 처리를 위해, 단일 책임 원칙(SRP)을 고려해 당첨 번호와 보너스 번호 처리를 별도 클래스로 분리했습니다.

### 당첨 내역 출력
발행한 로또와 당첨 번호를 비교한 후, 당첨 내역을 통계로 출력합니다.

#### 당첨 조건
> - 1등: 6개 번호 일치 **(보너스 번호 불필요)** → 20억원
> - 2등: 5개 번호 + 보너스 번호 일치 → 3천만원
> - 3등: 5개 번호 일치 **(보너스 번호 불필요)** → 150만원
> - 4등: 4개 번호 일치 → 5만원
> - 5등: 3개 번호 일치 → 5,000원

컨트롤러에서 번호 매칭 서비스를 호출해 발행한 로또를 하나씩 당첨 번호와 비교하여 상금을 계산할 예정입니다.

### 수익률 출력
수익률 공식은 다음과 같습니다.

$$\text{Profit Rate} = \frac{\text{Amount of Prize Earned}}{\text{Amount of Lotto Purchase}} \times 100$$

수익률은 소수점 둘째 자리에서 반올림합니다.

## Object Layouts
### Controller
- `LottoController` : 로또 번호를 발급하는 로직을 실행합니다.
- `WinningNumbersController` : 당첨 번호와 보너스 번호에 관한 로직을 실행합니다.
- `ProfitController` : 수익률에 관한 로직을 실행합니다.
### View
- `InputView` : 사용자로부터 입력을 받습니다.
- `OutputView` : 출력을 합니다.
### Service
- `MatchingService` : 발행한 로또 번호와 당첨 번호를 비교해 상금을 저장합니다.
- `ExceptionService` : 사용자로부터 받은 입력의 예외 처리를 담당합니다.
- `GenerateService` : 로또를 생성합니다.
### DTO
- `LottoPurchaseRequestDto` : 사용자로부터 받은 로또 구매 금액을 저장합니다.
- `WinningNumbersRequestDto` : 사용자로부터 받은 당첨 번호를 저장합니다.
- `BonusNumberRequestDto` : 사용자로부터 받은 보너스 번호를 저장합니다.
### Model
- `Lotto` : 중복이 되지않은 1-45 6개의 정수를 저장합니다.
- `Lottos` : 사용자가 발급한 모든 로또를 저장합니다
- `Prize` : 당첨 금액과 당첨 수량을 포함합니다.
- `Prizes` : 모든 `Prize` 객체를 포함하고 있습니다.
- `WinningNumbers` : 사용자가 지정한 6개의 고유한 번호와 보너스 번호 1개를 저장합니다.

### 클래스 다이어그램

```mermaid
classDiagram
    class LottoController {
        +void purchaseLotto()
        +void showLotto()
    }

    class WinningNumbersController {
        +void inputWinningNumbers()
        +void inputBonusNumber()
    }

    class ProfitController {
        +void calculateProfitRate()
    }

    class InputView {
        +int getLottoPurchaseAmount()
        +List~int~ getWinningNumbers()
        +int getBonusNumber()
    }

    class OutputView {
        +void showLotto(List~Lotto~ lottos)
        +void showWinningStatistics(Prizes prizes)
        +void showProfitRate(double rate)
    }

    class MatchingService {
        +void matchLottosWithWinningNumbers()
        +Prizes calculatePrizes(Lottos lottos, WinningNumbers winningNumbers)
    }

    class ExceptionService {
        +void validateLottoPurchaseAmount(int amount)
        +void validateWinningNumbers(List~int~ numbers)
        +void validateBonusNumber(int number, WinningNumbers winningNumbers)
    }

    class GenerateService {
        +Lotto generateLotto()
        +Lottos generateLottos(int quantity)
    }

    class LottoPurchaseRequestDto {
        -int purchaseAmount
        +getPurchaseAmount(): int
    }

    class WinningNumbersRequestDto {
        -List~int~ winningNumbers
        +getWinningNumbers(): List~int~
    }

    class BonusNumberRequestDto {
        -int bonusNumber
        +getBonusNumber(): int
    }

    class Lotto {
        -List~int~ numbers
        +getNumbers(): List~int~
    }

    class Lottos {
        -List~Lotto~ lottoList
        +getLottoList(): List~Lotto~
    }

    class Prize {
        -int matchCount
        -int rewardAmount
        +getMatchCount(): int
        +getRewardAmount(): int
    }

    class Prizes {
        -List~Prize~ prizeList
        +getPrizeList(): List~Prize~
        +calculateTotalRewards(): int
    }

    class WinningNumbers {
        -List~int~ numbers
        -int bonusNumber
        +getNumbers(): List~int~
        +getBonusNumber(): int
    }

    LottoController --> InputView
    LottoController --> OutputView
    LottoController --> GenerateService
    LottoController --> LottoPurchaseRequestDto
    LottoController --> Lottos
    LottoController --> MatchingService

    WinningNumbersController --> InputView
    WinningNumbersController --> OutputView
    WinningNumbersController --> WinningNumbersRequestDto
    WinningNumbersController --> BonusNumberRequestDto
    WinningNumbersController --> ExceptionService
    WinningNumbersController --> WinningNumbers

    ProfitController --> Prizes
    ProfitController --> OutputView

    MatchingService --> Lottos
    MatchingService --> WinningNumbers
    MatchingService --> Prizes

    GenerateService --> Lotto
    GenerateService --> Lottos

    ExceptionService --> LottoPurchaseRequestDto
    ExceptionService --> WinningNumbersRequestDto
    ExceptionService --> BonusNumberRequestDto

