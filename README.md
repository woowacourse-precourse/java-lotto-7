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
## 프로젝트 구조
```
lotto/
├── Application.java
├── controller
│   ├── PurchaseAmountController.java
│   ├── LottoController.java
│   ├── WinningNumbersController.java
│   ├── BonusNumberController.java
│   └── ProfitController.java
├── service
│   ├── handler
│   │   ├── BonusNumberHandler.java
│   │   ├── WinningNumbersHandler.java
│   │   └── PurchaseAmountHandler.java
│   ├── validator
│   │   ├── WinningNumbersValidator.java
│   │   ├── PurchaseAmountValidator.java
│   │   └── BonusNumberValidator.java
│   ├── matching
│   │   └── MatchingService.java
│   ├── calculating
│   │   └── ProfitService.java
│   └── generation
│       └── GenerateService.java
├── model
│   ├── Lotto.java
│   ├── Lottos.java
│   ├── Prize.java
│   └── PrizeRank.java
├── dto
│   ├── WinningNumbersRequestDto.java
│   ├── PurchaseAmountRequestDto.java
│   └── BonusNumberRequestDto.java
├── view
│   ├── InputView.java
│   └── OutputView.java
└── util
    ├── ErrorMessage.java
    ├── InputMessage.java
    ├── LottoNumber.java
    └── OutputMessage.java
```
## 객체 책임 설명
### Controller
- `PurchaseAmountController.java` : 구매 금액 입력을 관리합니다.
- `LottoController.java` : 로또 번호를 발급하는 로직을 처리합니다.
- `WinningNumbersController.java` : 당첨 번호에 대한 로직을 관리합니다.
- `BonusNumberController.java` : 보너스 번호와 관련된 로직을 처리합니다.
- `ProfitController.java` : 수익률 관련 로직을 관리합니다.
### Service
#### Handler
- `BonusNumberHandler.java` : 보너스 번호 관련 작업을 처리합니다.
- `WinningNumbersHandler.java` : 당첨 번호 관련 작업을 처리합니다. 
- `PurchaseAmountHandler.java` : 구매 금액 관련 작업을 처리합니다. 
#### Validator
- `WinningNumbersValidator.java` : 당첨 번호 입력을 검증합니다.
- `PurchaseAmountValidator.java` : 구매 금액 입력을 검증합니다.
- `BonusNumberValidator.java` : 보너스 번호 입력을 검증합니다.
#### Matching
- `MatchingService.java` : 발급한 로또 번호와 당첨 번호를 비교하여 당첨금을 저장합니다.
#### Calculating
- `ProfitService.java` : 당첨 결과에 따른 수익률을 계산합니다.
#### Generation
- `GenerateService.java` : 로또 번호를 생성합니다.

### Model
-	`Lotto.java` : 중복되지 않은 1부터 45 사이의 여섯 개 정수를 저장합니다.
-	`Lottos.java` : 사용자가 발급한 모든 로또 티켓을 저장합니다.
-	`Prize.java` : 당첨 금액과 당첨 개수를 포함합니다.
-	`PrizeRank.java` : 당첨 등급과 관련된 상금 정보를 관리합니다.

### DTO
- `WinningNumbersRequestDto.java` : 사용자로부터 입력받은 당첨 번호를 저장합니다.
- `PurchaseAmountRequestDto.java` : 사용자로부터 입력받은 구매 금액을 저장합니다.
- `BonusNumberRequestDto.java` : 사용자로부터 입력받은 보너스 번호를 저장합니다.

### View
- `InputView.java` : 사용자 입력을 받습니다.
- `OutputView.java` : 사용자에게 출력을 합니다.

### Util
- `ErrorMessage.java` : 에러 메시지를 관리합니다.
- `InputMessage.java` : 입력과 관련된 메시지를 처리합니다.
- `LottoNumber.java` : 로또 번호와 관련된 상수 및 유틸리티를 정의합니다.
- `OutputMessage.java` : 출력과 관련된 메시지를 관리합니다.

### 클래스 다이어그램

![lotto](https://github.com/user-attachments/assets/3b6246b4-128d-474c-9d1e-57c919a58734)
