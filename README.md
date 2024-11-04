# java-lotto-precourse
### 프리코스 3주 차 [오예현]

# 🔆 로또
간단한 로또 발매기를 구현한다.

## ✅ 기능 요구사항
- 로또 번호 : `1` ~ `45`
    > 사용자 로또 번호 : 6개 랜덤 생성     
    당첨 번호 : 6 + 1(보너스 번호) 입력 받음


- 당첨 기준과 금액
    > 1등 : `6개` 일치 > `2,000,000,000원`  
     2등 : `5개` + `1개(보너스 번호)` 일치 > `30,000,000원`  
     3등 : `5개` 일치 > `1,500,000원`  
     4등 : `4개` 일치 > `50,000원`  
     5등 : `3개` 일치 > `5,000원`
 
- 로또 1장의 가격은 `1000원` > 구입 금액에 해당하는 만큼 로또를 발행


- 사용자로부터 `당첨 번호`, `보너스 번호`, `로또 구입 금액` 입력 받는다.


- `당첨 내역`, `수익률` 출력 후 게임 종료


- 사용자가 잘못된 값 입력한 경우 
    >1. `IllegalArgumentException` 발생  
    >2. `[ERROR]`로 시작하는 에러 메시지 출력  
    >3. 해당 부분부터 입력 다시 받음

## ✅ 입출력 요구사항

- 입력
    - `로또 구입 금액` : `1,000원` 단위로 입력 받고, 나눠 떨어지지 않는 금액은 예외 처리
    - `당첨 번호` : `,`를 기준으로 구분
    - `보너스 번호`


- 출력
    - `로또 수량`과 `번호` : 번호는 오름차순 정렬
    - `당첨 내역`
    - `수익률` : 소수점 둘째 자리에서 반올림(소수점 첫째 자리만 보이게)
    - `에러 메시지` : `[ERROR]`로 시작


- 실행 결과

    ```
    구입금액을 입력해 주세요.
    8000

    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45]

    당첨 번호를 입력해 주세요.
    1,2,3,4,5,6

    보너스 번호를 입력해 주세요.
    7

    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.
    ```

## ☑️ 구현할 기능 목록
- `Application` 클래스

- [X] : 로또 시작하는 함수


- `Lotto` 클래스

- [X] : 번호를 생성하는 함수

- [X] : 로또 번호와 당첨 번호를 비교하는 함수

- [X] : 로또 번호와 보너스 번호를 비교하는 함수


- `LottoTicketsGenerator` 클래스

- [X] : 6개의 로또 번호를 랜덤으로 생성하는 함수


- `LottoService` 클래스

- [X] : 당첨 금액을 가져오는 함수

- [X] : 수익률을 가져오는 함수


- `WinningResultsCalculator` 클래스

- [X] : 당첨 결과를 계산하는 함수


- `WinningAmountCalculator` 클래스

- [X] : 당첨 금액을 계산하는 함수


- `EarningRateCalculator` 클래스

- [X] : 수익률 계산하는 함수


- `RankInfo` 클래스

- [X] : 각 등수 별 정보를 객체로 생성하는 함수


- `RankInfoFactory` 클래스

- [X] : RankInfo를 다른 컴포넌트에서 접근하게 쉽도록 하는 함수


- `EarningRateCalculator` 클래스

- [X] : 수익률 계산하는 함수


- `NumbersValidator` 클래스

- [X] : 번호 중복을 확인하는 함수

- [X] : 번호에 공백에 포함되었는지 확인하는 함수

- [X] : 번호가 숫자인지 확인하는 함수

- [X] : 번호가 1 ~ 45 사이인지 확인하는 함수

- [X] : 번호 개수를 확인하는 함수

- [X] : 보너스 번호가 당첨 번호랑 중복되는지 확인하는 함수



- `PurchaseAmountValidator` 클래스

- [X] : 구입 금액에 공백이 포함되었는지 확인하는 함수

- [X] : 구입 금액이 숫자인지 확인하는 함수

- [X] : 구입 금액이 0원 이상인지 확인하는 함수

- [X] : 구입 금액이 1000원 단위인지 확인하는 함수


- `LottoErrorMessages` 클래스

- [X] : 에러 메시지를 담는 enum


- `LottoInputView` 클래스

- [X] : 구입 금액을 입력 받는 함수

- [X] : 당첨 번호를 입력 받는 함수

- [X] : 보너스 번호를 입력 받는 함수


- `LottoOutputView` 클래스

- [X] : 로또 수량을 출력하는 함수

- [X] : 로또 번호를 출력하는 함수

- [X] : 당첨 내역을 출력하는 함수

- [x] : 수익률을 출력하는 함수


- `LottoController` 클래스

- [x] : InputView의 구입 금액 입력 실행

- [x] : OutputView의 로또 수량 출력 실행

- [x] : LottoGenerator에서 Lotto로 로또 수량만큼 생성하고, OutputView의 로또 번호 출력 실행

- [x] : InputView의 당첨 번호 입력 실행

- [x] : InputView의 보너스 번호 입력 실행

- [x] : LottoService에서 받은 당첨 내역과 수익률로 OutputView의 당첨 내역과 수익률 출력

## ☑️ 프료그램 구조
```
src/
├── constants/
│   └── LottoConstants
├── controller/
│   └── LottoController
├── domain/
│   ├── calculator/
│   │   ├── EarningRateCalculator
│   │   ├── WinningAmountCalculator
│   │   └── WinningResultsCalculator
│   ├── factory/
│   │   └── RankInfoFactory
│   ├── generator/
│   │   └── LottoTicketGenerator
│   └── model/
│       └── RankInfo
├── service/
│   └── LottoService
├── validator/
│   ├── LottoErrorMessages
│   ├── NumbersValidator
│   └── PurchaseAmountValidator
├── view/
│   ├── LottoInputView
│   └── LottoOutputView
├── Application
└───Lotto
```
### MVC 패턴
- Model (모델) : 도메인 내 데이터와 비즈니스 로직의 핵심을 다룬다.
  > domain 패키지의 model, calculator, factory, generator   
  > 데이터 구조 : RankInfo, Lotto  
  > 비즈니스 로직 : EarningRateCalculator, WinningAmountCalculator, WinningResultsCalculator

- View (뷰) : 사용자와의 입출력을 담당하며, 데이터를 입력받고 처리 결과를 출력하는 역할을 수행한다.
  > view 패키지의 LottoInputView, LottoOutputView

- Controller (컨트롤러) : 사용자 입력을 받아 모델과 상호작용하고, 처리 결과를 View에 전달하는 흐름을 관리한다.
  > controller 패키지의 LottoController

- Service (서비스) : 애플리케이션 로직을 조율하는 서비스 계층으로, Model과 Controller 간의 복잡한 로직을 간소화해주는 역할을 수행한다.
  > service 패키지의 LottoService

## ☑️ 프료그램 설명
### Lotto 클래스
```java
public class Lotto {
    private final List<Integer> numbers;
 
    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }
 
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
 
    public int getMatchCount(Lotto winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers.getNumbers()::contains).count();
    }
 
    public boolean isBonusNumberMatched(Lotto bonusNumber) {
        return numbers.contains(bonusNumber.getNumbers().getFirst());
    }
}
```
우선, 사용자가 입력한 `당첨 번호`, `보너스 번호`, `랜덤 생성 번호`를 모두 `Lotto` 객체를 이용하여 생성하도록 하고,  
로또 번호와 관련된 로직들을 `Lotto` 클래스 안에 작성하여 `일급 컬렉션`의 형태로 구현하였다.

### RankInfo 클래스와 RankInfoFactory 클래스
```java
public class RankInfo {
    private final int rank;
    private final int matchCount;
    private final int prizeAmount;
    private final String description;
    private final boolean hasBonusBall;

    public RankInfo(int rank, int matchCount, int prizeAmount, String description, boolean hasBonusBall) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.description = description;
        this.hasBonusBall = hasBonusBall;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasBonusBall() {
        return hasBonusBall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RankInfo rankInfo)) return false;
        return rank == rankInfo.rank && matchCount == rankInfo.matchCount &&
                prizeAmount == rankInfo.prizeAmount && hasBonusBall == rankInfo.hasBonusBall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, matchCount, prizeAmount, hasBonusBall);
    }
}
```
1등(1등, 6개 일치, 2,000,000,000원, 당첨 결과 문구, 보너스볼 유무)  
2등(2등, 5개 일치, 30,000,000원, 당첨 결과 문구, 보너스볼 유무)  
3등(3등, 5개 일치, 30,000,000원 , 당첨 결과 문구, 보너스볼 유무)  
...  
이런 식으로 데이터를 객체로 저장할 수 있는 `RankInfo` 클래스를 생성하였다.  

그리고 `equals`와 `hashCode`를 오버라이드하여  
`winningResult`(Map<RankInfo, Integer>: 해당 등수 정보, 횟수)를 저장한 데이터를 찾을 때  
winningResult.get(firstRank) 하면 매칭되어 찾아질 수 있게끔 했다.  

```java
public class RankInfoFactory {
    private static final RankInfo FIRST_RANK = new RankInfo(1, 6, 2000000000, DESCRIPTION, false);
    private static final RankInfo SECOND_RANK = new RankInfo(2, 5, 30000000, SECOND_RANK_DESCRIPTION, true);
    private static final RankInfo THIRD_RANK = new RankInfo(3, 5, 1500000, DESCRIPTION, false);
    private static final RankInfo FOURTH_RANK = new RankInfo(4, 4, 50000, DESCRIPTION, false);
    private static final RankInfo FIFTH_RANK = new RankInfo(5, 3, 5000, DESCRIPTION, false);

    public static RankInfo getFirstRank() {
        return FIRST_RANK;
    }

    public static RankInfo getSecondRank() {
        return SECOND_RANK;
    }

    public static RankInfo getThirdRank() {
        return THIRD_RANK;
    }

    public static RankInfo getFourthRank() {
        return FOURTH_RANK;
    }

    public static RankInfo getFifthRank() {
        return FIFTH_RANK;
    }

    public static List<RankInfo> getAllRanks() {
        return Arrays.asList(FIFTH_RANK, FOURTH_RANK, THIRD_RANK, SECOND_RANK, FIRST_RANK);
    }
}
```
`FIRST_RANK`, `SECOND_RANK`, `THIRD_RANK`, `FOURTH_RANK`, `FIFTH_RANK`의 정보를 저장하고 해당 객체를 가지고 키로 사용하도록 하였다.  
(Map<RankInfo, Integer> winningResult 여기서 <FIRST_RANK, 1>, <SECOND_RANK, 0> 이런 식으로 저장하는 데 사용하였다.)

### LottoService 클래스
```java
public class LottoService {
    private Map<RankInfo, Integer> winningResults;
    private BigDecimal winningAmount;
    private String earningsRate;

    public LottoService(List<Lotto> lottoTickets, Lotto winningNumbers, Lotto bonusNumber, int purchaseAmount) {
        calculateWinningResults(lottoTickets, winningNumbers, bonusNumber);
        calculateWinningAmount(winningResults);
        calculateEarningResults(BigDecimal.valueOf(purchaseAmount), winningAmount);
    }

    private void calculateWinningResults(List<Lotto> lottoTickets, Lotto winningNumbers, Lotto bonusNumber) {
        WinningResultsCalculator winningResultsCalculator = new WinningResultsCalculator(lottoTickets, winningNumbers, bonusNumber);
        this.winningResults = winningResultsCalculator.getWinningResults();
    }

    private void calculateWinningAmount(Map<RankInfo, Integer> winningResults) {
        WinningAmountCalculator winningAmountCalculator = new WinningAmountCalculator(winningResults);
        this.winningAmount = winningAmountCalculator.getWinningAmount();
    }

    private void calculateEarningResults(BigDecimal purchaseAmount, BigDecimal winningAmount) {
        EarningsRateCalculator earningsRateCalculator = new EarningsRateCalculator(purchaseAmount, winningAmount);
        this.earningsRate = earningsRateCalculator.getEarningsRate();
    }

    // 테스트용 함수
    public String getWinningAmount() {
        return this.winningAmount.toPlainString();
    }

    public String getEarningsRate() {
        return this.earningsRate;
    }

    public Map<RankInfo, Integer> getWinningResults() {
        return new HashMap<>(winningResults);
    }
}
```
`EarningsRateCalcultator`, `WinningAmountCalculator`, `WinningResultsCalculator` 클래스를 실행하고,  
이를 통해 얻은 `earningsRate`, `winningAmount`, `winningResults`를 저장하여 가져올 수 있는 클래스이다.

### LottoErrorMessages 클래스

```java
public enum LottoErrorMessages {
    MUST_BE_TARGET_LENGTH("%s %s 번호는 %d개이어야 합니다."),
    MUST_BE_NUMBER("%s %s은(는) 숫자 형식이어야 합니다."),
    MUST_BE_UNIQUE("%s 로또 번호가 중복되었습니다."),
    MUST_BE_NO_SPACE("%s %s에 공백을 허용하지 않습니다."),
    MUST_BE_RANGE("%s 로또 번호는 " + RANDOM_MIN + " ~ " + RANDOM_MAX + " 사이 숫자이어야 합니다."),
    MUST_BE_OVER_THRESHOLD("%s 구입 금액은 " + PURCHASE_AMOUNT_THRESHOLD + "원 이상이어야 합니다."),
    MUST_BE_UNIT("%s 구입 금액은 " + PURCHASE_AMOUNT_UNIT + "원 단위이어야 합니다.");

    private final String message;

    LottoErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(LINE_SPACE + message, ERROR_MESSAGE_BEGINNING);
    }

    public String getMessage(String input) {
        return String.format(LINE_SPACE + message, ERROR_MESSAGE_BEGINNING, input);
    }

    public String getMessage(String type, int length) {
        return String.format(LINE_SPACE + message, ERROR_MESSAGE_BEGINNING, type, length);
    }
}
```
`String.format`을 사용하여, 당첨 번호와 보너스 번호에 모두 적용 가능한 에러 메시지를 `enum`으로 생성하였다.