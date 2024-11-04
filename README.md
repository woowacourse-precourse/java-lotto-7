# java-lotto-precourse

## 클래스 설명

### Controller

- **`run()`**  
  프로그램의 주요 실행 흐름을 제어하며, 로또 구매, 당첨 번호 입력, 그리고 수익률 계산의 순서로 실행.

- **`purchaseLotto()`**
   - 구입 금액을 입력받고 유효성 검사를 통과한 금액으로 로또 티켓을 생성.
   - 로또 티켓의 수량 및 각 티켓의 번호를 출력한 후 생성된 `LottoTickets` 객체를 반환.

- **`getWinningNumbers()`**
   - 당첨 번호와 보너스 번호를 각각 입력받아 유효성을 검사한 후 `WinningNumbers` 객체로 반환.

- **`getWinningNumbersOnly()`**
   - 당첨 번호 입력 안내 메시지를 출력하고, 사용자가 입력한 당첨 번호를 리스트로 반환.
   - 입력받은 번호의 유효성을 검사하여 문제가 없는 경우 리스트 반환.

- **`getBonusNumber(List<Integer> winningNumbers)`**
   - 보너스 번호 입력 안내 메시지를 출력하고, 보너스 번호를 입력받아 반환.
   - 입력받은 보너스 번호가 당첨 번호와 중복되지 않도록 유효성 검사 후 반환.

- **`calculateProfit(LottoTickets lottoTickets, WinningNumbers winningNumbers)`**
   - 로또 티켓과 당첨 번호를 사용하여 당첨 통계를 계산하고, 해당 통계를 바탕으로 최종 수익률을 출력.
   - `LottoStatistics` 객체에서 통계 결과를 출력하고, 통계와 구입 금액을 기반으로 수익률을 계산하여 출력.

---

### Enum

**ErrorMessage**

- **`ERROR_PREFIX`**  
  `[ERROR] ` 문자열로, 모든 오류 메시지에 일관된 접두사 제공.

- **`PURCHASE_EMPTY_INPUT`**  
  금액이 입력되지 않았을 때 보여주는 오류 메시지: `"금액을 입력해 주세요."`

- **`PURCHASE_INVALID_NUMBER_FORMAT`**  
  유효하지 않은 숫자 형식일 때 오류 메시지: `"유효한 숫자를 입력해 주세요."`

- **`PURCHASE_MIN_PRICE`**  
  최소 구입 금액(1000원) 미만일 때 오류 메시지: `"최소 구입 금액은 1000원 이상이어야 합니다."`

- **`PURCHASE_MAX_PRICE`**  
  최대 구입 금액(100000원)을 초과했을 때 오류 메시지: `"최대 구입 금액은 100000원을 초과할 수 없습니다."`

- **`PURCHASE_INVALID_DIVISIBILITY`**  
  구입 금액이 1000원 단위로 나눠지지 않을 때 오류 메시지: `"구입 금액은 1000원 단위여야 합니다."`

- **`LOTTO_INVALID_NUMBER_COUNT`**  
  로또 번호가 6개가 아닐 때 오류 메시지: `"로또 번호는 6개여야 합니다."`

- **`LOTTO_DUPLICATE_NUMBER`**  
  로또 번호에 중복된 숫자가 있을 때 오류 메시지: `"로또 번호는 중복될 수 없습니다."`

- **`LOTTO_NUMBER_OUT_OF_RANGE`**  
  로또 번호가 1에서 45 사이가 아닐 때 오류 메시지: `"로또 번호는 1부터 45 사이의 숫자여야 합니다."`

- **`WINNING_NUMBER_INVALID_FORMAT`**  
  당첨 번호가 쉼표로 구분되지 않은 경우 오류 메시지: `"당첨 번호는 쉼표(,)로 구분된 1~45 사이의 숫자여야 합니다."`

- **`BONUS_NUMBER_DUPLICATE`**  
  보너스 번호가 당첨 번호와 중복될 때 오류 메시지: `"보너스 번호는 당첨 번호와 중복될 수 없습니다."`

**Rank**

- **`FIRST`**  
  6개 숫자 일치, 보너스 번호 필요 없음. 상금: 2,000,000,000원.

- **`SECOND`**  
  5개 숫자 일치, 보너스 번호 일치. 상금: 30,000,000원.

- **`THIRD`**  
  5개 숫자 일치, 보너스 번호 불일치. 상금: 1,500,000원.

- **`FOURTH`**  
  4개 숫자 일치. 상금: 50,000원.

- **`FIFTH`**  
  3개 숫자 일치. 상금: 5,000원.

- **`NONE`**  
  당첨되지 않은 경우, 상금 없음.

- **`determineRank(int matchCount, boolean matchBonus)`**  
  매칭된 숫자 개수와 보너스 일치 여부로 `Rank`를 결정하여 반환. 특히 5개 일치 시 보너스 번호 여부에 따라 `SECOND`와 `THIRD`로 구분.

- **`getPrize()`**  
  각 `Rank`의 상금 금액 반환.

- **`generateResultMessage(int count)`**  
  해당 `Rank`의 결과 메시지를 형식화하여 반환.

---

### Generator

**LottoNumberGenerator**

- **`generateLottoNumbers()`**
   - 로또 번호(1부터 45 사이의 숫자) 6개를 중복 없이 무작위로 선택하고, 이를 오름차순으로 정렬한 `List<Integer>` 형태로 반환.
   - 이 메소드는 무작위 숫자를 생성하기 위해 `Randoms.pickUniqueNumbersInRange()`를 사용하며, 생성된 숫자 리스트는 정렬하여 일관된 순서로 반환.

---

### Model

**Lotto**

- **`Lotto(List<Integer> numbers)`**: 로또 번호를 생성하며, 유효성을 검사. 번호의 개수는 6개여야 하며 중복된 번호가 없어야 함.
- **`validate(List<Integer> numbers)`**: 번호 리스트가 6개인지 확인하고 중복 번호가 있는지 검사하여, 규칙에 어긋날 경우 예외 발생.
- **`countMatchingNumbers(List<Integer> winningNumbers)`**: 현재 로또 번호와 당첨 번호 리스트를 비교하여 일치하는 번호의 개수 반환.
- **`matchingBonusNumber(int bonusNumber)`**: 보너스 번호가 현재 로또 번호에 포함되어 있는지 확인하여 결과 반환.
- **`toString()`**: 로또 번호 리스트를 문자열 형식으로 변환하여 반환.

---

**LottoStatistics**

- **`LottoStatistics()`**: 당첨 결과를 저장할 `resultMap`을 초기화. 각 `Rank` 값에 대해 0으로 초기화된 통계 설정.
- **`calculateStatistics(List<Lotto> lottos, WinningNumbers winningNumbers)`**: 모든 로또 번호와 당첨 번호를 비교하여, 각 `Rank` 별로 당첨 개수를 업데이트.
- **`calculateProfit(int purchaseAmount)`**: 당첨 금액의 총합을 구입 금액 대비 백분율로 환산하여 수익률 반환.
- **`getResultMap()`**: 당첨 통계 맵 반환.

---

**LottoTickets**

- **`LottoTickets(PurchaseAmount purchaseAmount)`**: 구매 금액을 받아 해당 금액으로 생성할 수 있는 로또 티켓 리스트 초기화.
- **`generateLottos(int lottoCount)`**: 지정된 수의 로또를 무작위로 생성하여 리스트로 반환.
- **`getLottoCount()`**: 구입한 로또의 개수 반환.
- **`getLottos()`**: 생성된 로또 티켓 리스트 반환.
- **`getPurchaseAmount()`**: 구입 금액 반환.

---

**PurchaseAmount**

- **`PurchaseAmount(int amount)`**: 구입 금액을 받아 로또 구입 개수와 구입 금액을 설정.
- **`calculateLottoCount(int amount)`**: 구입 금액을 로또 한 장 가격으로 나누어 구입할 수 있는 로또 개수를 계산.
- **`getLottoCount()`**: 구입한 로또의 개수 반환.
- **`getAmount()`**: 구입한 금액 반환.

**WinningNumbers**

- **`WinningNumbers(List<Integer> numbers, int bonusNumber)`**: 당첨 번호 리스트와 보너스 번호를 받아서 초기화.
- **`getNumbers()`**: 당첨 번호 리스트 반환.
- **`getBonusNumber()`**: 보너스 번호 반환.

---

### Service

**LottoPurchaseService**

- **`purchaseLotto(int amount)`**: 구입 금액을 받아 유효성을 검사한 후, 해당 금액으로 생성한 로또 티켓 리스트 반환. 구입 금액이 유효하지 않은 경우 예외 발생.

**StatisticService**

- **`calculateStatistics(List<Lotto> lottos, WinningNumbers winningNumbers)`**: 로또 리스트와 당첨 번호를 비교하여 각 등수에 해당하는 통계를 생성하고 반환.
- **`calculateProfit(LottoStatistics lottoStatistics, int purchaseAmount)`**: 당첨 통계를 바탕으로 구입 금액 대비 총 수익률을 계산하여 반환.

**WinningNumbersService**

- **`validateWinningNumbers(List<Integer> winningNumbers)`**: 당첨 번호 리스트의 유효성을 검사

하여 규칙에 어긋날 경우 예외 발생.
- **`validateBonusNumber(List<Integer> winningNumbers, int bonusNumber)`**: 보너스 번호의 유효성을 검사하며, 당첨 번호 리스트에 중복되는 경우 예외 발생.
- **`generateWinningNumbers(List<Integer> winningNumbers, int bonusNumber)`**: 유효성을 검증한 당첨 번호와 보너스 번호를 기반으로 `WinningNumbers` 객체를 생성하여 반환.

---

### Validator

**PurchaseAmountValidator**

- **`validateAmount(int amount)`**: 구입 금액의 유효성을 검증. 금액이 최소 금액보다 적거나 최대 금액을 초과하거나, 단위 금액(1000원)으로 나눠지지 않을 경우 예외 발생.
   - **`validateMinPrice(int amount)`**: 구입 금액이 최소 금액인 1000원보다 작을 경우 예외 발생.
   - **`validateMaxPrice(int amount)`**: 구입 금액이 최대 금액인 100,000원을 초과할 경우 예외 발생.
   - **`validateDivisibility(int amount)`**: 구입 금액이 1000원 단위로 나누어 떨어지지 않는 경우 예외 발생.

**WinningNumbersValidator**

- **`validateWinningNumbers(List<Integer> numbers)`**: 당첨 번호의 유효성을 검사. 번호가 6개가 아니거나 범위(1~45)를 벗어나거나 중복된 번호가 있을 경우 예외 발생.
   - **`validateWinningNumberSize(List<Integer> numbers)`**: 당첨 번호 리스트가 정확히 6개인지 확인.
   - **`validateNumberRange(List<Integer> numbers)`**: 각 번호가 1에서 45 사이의 값인지 검사.
   - **`validateNumberDuplicate(List<Integer> numbers)`**: 중복된 번호가 포함되었는지 검사.
- **`validateBonusNumber(List<Integer> numbers, int bonusNumber)`**: 보너스 번호의 유효성을 검사. 보너스 번호가 범위를 벗어나거나, 당첨 번호와 중복될 경우 예외 발생.
   - **`validateBonusRange(int bonusNumber)`**: 보너스 번호가 1에서 45 사이의 값인지 검사.
   - **`validateBonusDuplicate(List<Integer> numbers, int bonusNumber)`**: 보너스 번호가 당첨 번호와 중복되는지 확인.

---

### View

**InputView**

- **`getPurchaseAmount()`**: 콘솔에서 구입 금액을 입력받아 정수로 변환하여 반환. 유효하지 않은 형식이 입력되면 예외 발생.
- **`getWinningNumbers()`**: 콘솔에서 당첨 번호를 쉼표로 구분하여 입력받고, 정수 리스트로 변환하여 반환. 유효하지 않은 형식이 입력되면 예외 발생.
- **`getBonusNumber()`**: 콘솔에서 보너스 번호를 입력받아 정수로 변환하여 반환. 유효하지 않은 형식이 입력되면 예외 발생.

**OutputView**

- **`printInputPurchaseAmount()`**: 구입 금액 입력 메시지 출력.
- **`printInputWinnerNumber()`**: 당첨 번호 입력 메시지 출력.
- **`printInputBonusNumber()`**: 보너스 번호 입력 메시지 출력.
- **`printOutputLottoCount(int lottoCount)`**: 구매한 로또의 개수 출력.
- **`printOutputLottoNumbers(List<Lotto> lottos)`**: 구매한 로또 번호들을 출력.
- **`printOutputLottoStatistics(Map<Rank, Integer> resultMap)`**: 당첨 통계를 출력. 각 순위에 해당하는 당첨 개수를 출력하며, 당첨이 없는 순위는 제외.
- **`printOutputProfit(double profit)`**: 총 수익률을 소수점 한 자리까지 출력.

---

### Factory

**ApplicationFactory**

- **`createLottoController()`**: `LottoController` 인스턴스를 생성하고 필요한 모든 종속성을 주입하여 반환. 프로그램의 메인 진입점에서 컨트롤러 생성과 관련된 복잡성을 간소화.
- `ApplicationFactory`는 프로그램 실행의 핵심 구성 요소를 생성하고 설정하는 역할을 담당하여 전체 코드의 의존성 관리와 생성의 단순화를 돕습니다.

---

## 기능 목록

1. 구입 금액 입력
   - 1000원으로 나누어 떨어지지 않는 경우 예외처리
   - 음수 입력 시 예외처리
   - 빈 값 입력 시 예외처리
2. 예외처리 시 1번(구입 금액 입력)으로 돌아감
3. 구입금액만큼 7개 당첨번호가 담긴 로또 객체 생성
   - 오름차순 정렬
4. 구매한 로또 번호를 `오름차순`으로 출력
5. 당첨 번호 입력
   - 문자 입력 시 예외처리
   - 음수 입력 시 예외처리
   - 빈 값 입력 시 예외처리
   - 6개 미만이나 초과 입력 시 예외처리
   - 구분자가 쉼표가 아닐 시 예외처리
6. 예외처리 시 5번(당첨 번호 입력)으로 돌아감
7. 보너스 번호 입력
   - 문자 입력 시 예외처리
   - 음수 입력 시 예외처리
   - 빈 값 입력 시 예외처리
8. 예외처리 시 7번(보너스 번호 입력)으로 돌아감
9. 로또 당첨 번호가 담긴 객체 생성
10. 당첨 번호와 로또 번호 비교
   - 3개 이상 일치 시 당첨 통계 객체에 갯수 추가
11. 당첨 통계 출력
12. 수익률 계산
13. 수익률 출력