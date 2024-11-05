# java-lotto-precourse

## 예외 발생 상황 정의
### 1. 로또 구입 금액 입력 관련
- 입력받은 구입 금액이 1000원 미만이거나, **10만원을 초과하는 경우**
  - 입력받은 구입 금액이 int 범위를 초과해 Integer.parseInt() 호출 시 오버 플로우 발생하는 상황에 대한 처리 추가적으로 필요
- 입력받은 구입 금액이 1000원으로 나누어 떨어지지 않는 경우
- 입력이 숫자 형태가 아니거나, 입력에 숫자 외의 문자가 포함되어 있는 경우

### 2. 당첨 번호 입력 관련
- 입력받은 당첨 번호가 6개가 아닌 경우
- 입력받은 당첨 번호 중 숫자 형태가 아니거나, 숫자 외의 문자가 포함되어 있는 것이 존재하는 경우
- 입력받은 당첨 번호 중 1 이상 45 이하의 정수 범위에 해당하지 않는 것이 존재하는 경우
  - 당첨 번호가 int 범위를 초과해 Integer.parseInt() 호출 시 오버 플로우 발생하는 상황에 대한 처리 추가적으로 필요
- 입력받은 당첨 번호 중 중복된 수가 존재하는 경우

### 3. 보너스 번호 입력 관련
- 입력받은 보너스 번호가 숫자 형태가 아니거나, 숫자 외의 문자가 포함되어 있는 경우
- 입력받은 보너스 번호가 1 이상 45 이하의 정수 범위에 해당하지 않는 경우
  - 보너스 번호가 int 범위를 초과해 Integer.parseInt() 호출 시 오버 플로우 발생하는 상황에 대한 처리 추가적으로 필요
- 입력받은 보너스 번호가 당첨 번호 중 하나와 중복되는 경우

## 기능 목록
### Purchase
- [x] **public void checkEachLottosResult()** \: 구매한 각 로또들의 당첨 결과를 조회하는 기능
  - [x] boughtLottos의 각 Lotto 객체마다 `Lotto.getResult()`를 호출해 당첨 결과 조회 

### Lotto
- [x] **private void sortNumbers()** \: 로또 번호를 오름차순으로 정렬하는 기능

- [x] **public void getResult(List\<Integer> winningNums, int bonusNum)** \: 몇 등 당첨인지 확인하는 기능
  - [x] `findMatchCounts()` 호출해 자신의 로또 번호와 winningNums가 일치하는 개수 확인
    - [x] 일치하는 개수가 5개라면 보너스 번호 일치 여부에 따라 2등 혹은 3등으로 Prize 값 결정
    - [x] 일치하는 개수가 5개가 아니라면 보너스 번호 일치 여부에 관계 없이 winningNums가 일치하는 개수에 따라 Prize 값 결정
  
- [x] **private int findMatchCounts(List<Integer> winningNums)** \: 당첨 번호와 자신의 로또 번호가 몇 개 일치하는지 확인하는 기능
  - [x] 자신의 로또 번호인 numbers의 원소를 하나씩 확인
    - [x] 현재 확인하고 있는 원소를 winningNums도 가지고 있다면 count 1 증가
  - [x] count 값 반환

### PurchaseController
- [x] **public void processLottoGame()** \: 구입 발생 시마다 로또 게임을 진행하는 기능
  - [x] `makePurchase()` 호출해 로또 구매
  - [x] `countResult()` 호출해 로또별 당첨 결과 산출
  - [x] `showStatistic()` 호출해 당첨 통계 산출 및 출력

- [x] **private Purchase makePurchase()** \: 로또를 구매하는 기능
  - [x] `InputView.getBuyingAmount()` 호출해 구입 금액 입력받기
  - [x] `LottoNumberGenerator.issueLottos()` 호출해 구입 금액만큼의 로또 발행 및 Lotto 객체 생성
  - [x] `getBoughtLottoNumbers()` 호출해 각 Lotto 객체에서 로또 번호 추출
  - [x] `OutputView.printBoughtLottoNumbers()` 호출해 추출된 로또 번호 출력
  - [x] Purchase 객체 생성 및 반환

- [x] **private List\<Prize> countResult(Purchase purchase)** \: 각 로또의 당첨 결과를 산출하는 기능
  - [x] `InputView.getWinningNumbers()`와 `InputView.getBonusNumber()`를 호출해 당첨 번호와 보너스 번호 입력받기
  - [x] `Purchase.checkEachLottosResult()` 호출해 Purchase 객체 내 각 로또에 대해 결과 확인
  - [x] 확인된 결과를 리스트에 담아 반환

- [x] **private void showStatistic(List\<Prize> prizes, int buyingAmount)** \: 당첨 결과를 바탕으로 통계 산정 및 출력하는 기능
  - [x] `ResultController.makeWinningStatistic()` 호출해 각 등수별 당첨 횟수를 반환받기
  - [x] `ResultController.calculateEarningRatio()` 호출해 수익률 연산
  - [x] `OutputView.printWinningStatistic()` 호출해 당첨 통계 출력

### LottoNumberGenerator
- [x] **public List\<Lotto> issueLottos(int amount)** \: 주어진 수량만큼 로또를 발행하는 기능
    - [x] for (int i = 0; i < amount; i++)
        - [x] `getRandomLottoNumbers()` 호출해 로또 번호 6개 추출
        - [x] Lotto 객체 생성 → 리스트에 추가
    - [x] Lotto 객체가 저장된 리스트 반환

- [x] **private List\<Integer> getRandomLottoNumbers()** \: 로또 번호 6개를 추첨하는 기능
    - [x] `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange(1, 45, 6)` 호출한 결과 반환

### ResultController
- [x] **public Map<Prize, Integer> makeWinningStatistic(List\<Prize> prizeStatus)** \: 등수별 당첨 횟수를 합산하는 기능
  - [x] `initMap()` 호출해 각 등수별 당첨 횟수를 0으로 초기화
  - [x] prizeStatus에 저장된 모든 당첨 현황 확인
    - [x] 당첨된 로또에 대해 해당 등수의 당첨 횟수를 1 증가 (미당첨인 경우 증가하지 않음)
  - [x] 등수별 당첨 횟수가 저장된 map 반환

- [x] **public float calculateEarningRatio(Map\<Prize, Integer> statistic, int buyingAmount)** \: 수익률 연산하는 기능
    - [x] (각 등수별 수익 * 등수별 당첨 횟수) 연산 결과를 sum에 누적해 총 수익 연산
    - [x] sum / buyingAmount * 100을 연산해 수익률 도출
    - [x] 수익률을 소수 둘째자리에서 반올림해 반환

### BuyingAmountValidator
- [x] **public int validateBuyingAmount(String input)** \: 구입 금액 입력 검증 기능
  - [x] `validateFormat()`을 호출해 입력이 1000원 이상, 10만원 이하의 숫자 형태인지 여부 검증
    - [x] 입력이 1000원 이상 10만원 이하라면 이를 int 타입으로 파싱해 반환
    - [x] 입력이 범위 밖이거나 숫자 형태가 아니라면 예외 발생
  - [x] `validateDivisionIntoThousand()`를 호출해 입력이 1000으로 나누어 떨어지는지 검증
    - [x] 나누어 떨어지지 않는다면 예외 발생

### WinningNumberValidator
- [x] **public List\<Integer> validateWinningNumbers(String input)** \: 당첨 번호 검증 기능
    - [x] `validteQuantity()` 호출해 input을 쉼표 기준으로 분할 후, 개수가 6개인지 확인
      - [x] 6개로 분할되지 않았다면 예외 발생
    - [x] 분할된 각각의 로또 번호들에 대해 `validateFormat()` 호출해 int로 파싱 및 검증 수행
      - [x] 1 이상 45 이하의 정수 형태가 아닌 로또 번호가 있다면 예외 발생
      - [x] 모든 로또 번호가 유효하다면 리스트에 추가
    - [x] `validateUniqueness()` 호출해 중복 검사 수행
      - [x] 중복되는 로또 번호가 있다면 예외 발생
    - [x] 검증 완료된 당첨 번호 리스트를 리턴

- [x] **public int validateBonusNumber(List\<Integer> winningNums, String input)** \: 보너스 번호 검증 기능
  - [x] `validateFormat()` 호출해 input을 int 타입으로 파싱한 후 검증 수행
    - [x] 보너스 번호가 1 이상 45 이하의 정수 형태가 아니라면 예외 발생
    - [x] 맞다면 파싱된 보너스 번호를 리턴
  - [x] `validateUniqueness()` 호출해 보너스 번호가 당첨 번호와 중복되는지 확인
    - [x] 중복된다면 예외 발생
    - [x] 중복되지 않는다면 보너스 번호를 리턴

### InputView
- [x]  **public int getBuyingAmount()** \: 구입 금액을 입력받는 기능
    - [x] `구입금액을 입력해 주세요.` 출력
    - [x] `camp.nextstep.edu.missionutils.Console`의 `readLine()` 을 활용해 사용자로부터 구입 금액 입력받기
    - [x] `BuyingAmountValidator.validateBuyingAmount()`를 호출하여 입력 값 검증
      - [x] 검증 결과 유효하지 않은 입력인 경우 재귀 호출하여 금액을 다시 입력받기
      - [x] 유효한 입력인 경우 해당 입력을 int 타입으로 파싱한 결과를 리턴


- [x] **public List\<Integer> getWinningNumbers()** \: 당첨 번호를 입력받는 기능
    - [x] `당첨 번호를 입력해 주세요.` 출력
    - [x] `camp.nextstep.edu.missionutils.Console`의 `readLine()` 을 활용해 사용자로부터 당첨 번호 입력받기
    - [x] `WinningNumberValidator.validateWinningNumbers()` 호출하여 입력 값 검증
      - [x] 검증 결과 유효하지 않은 입력인 경우 재귀 호출하여 당첨 번호를 다시 입력받기
      - [x] 유효한 입력인 경우 당첨 번호 리스트를 리턴


- [x] **public int getBonusNumber(List\<Integer> winningNumbers)** \: 보너스 번호를 입력받는 기능
    - [x] `보너스 번호를 입력해 주세요.` 출력
    - [x] `camp.nextstep.edu.missionutils.Console`의 `readLine()` 을 활용해 사용자로부터 보너스 번호 입력받기
        - [x] 검증 결과 유효하지 않은 입력인 경우 재귀 호출하여 보너스 번호를 다시 입력받기
        - [x] 유효한 입력인 경우 보너스 번호를 리턴


### OutputView
- [x] **public void printBoughtLottoNumbers(List<List\<Integer>> lottos)** \: 구매한 로또 번호를 출력하는 기능
- [x] **public void printWinningStatistic(Map<Prize, Integer> matchCounts, String earningRatio)** \: 당첨 통계를 출력하는 기능