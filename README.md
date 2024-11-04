# java-lotto-precourse
## 목차 📑

- 애플리케이션 소개
- 기능 목록
- Use Case 시나리오
- Use Case  다이어그램
- MVC 구조
- 확장 가능성 고려 사항
- 클래스 다이어그램


## 애플리케이션 소개 📖 
### 개요
이 애플리케이션은 간단한 로또 발매기입니다. 사용자가 로또 구입 금액을 입력하면, 해당 금액에 맞게 로또를 발행합니다.  
이후 당첨 번호와 보너스 번호를 입력하면, 당첨 여부와 당첨 금액에 대한 정보를 제공합니다.  
마지막으로, 사용자의 당첨 통계와 수익률 정보를 확인할 수 있으며 애플리케이션은 종료됩니다.  

### 추가 설명
- 지불 금액은 1000원 단위로 한정됩니다.
- 1000원당 로또 한 장이 발행됩니다.
- 로또 발행 수는 입력한 금액을 1000으로 나눈 값으로 자동 결정되며 수량은 선택할 수 없습니다.
- 당첨 번호와 보너스 번호는 1에서 45 사이의 숫자입니다.
- 수익률 계산 방법은 (총 당첨 금액 ÷ 총 구매 금액) × 100 입니다.
- 1등부터 5등까지의 당첨 기준 및 당첨 금액:  
1️⃣등: 6개 번호 일치 / 2,000,000,000원  
2️⃣등: 5개 번호 + 보너스 번호 일치 / 30,000,000원  
3️⃣등: 5개 번호 일치 / 1,500,000원  
4️⃣등: 4개 번호 일치 / 50,000원  
5️⃣등: 3개 번호 일치 / 5,000원  

## 기능 목록 📝 
1. 구입 금액 입력 받기
    - **예외처리**: 숫자가 아닐 경우 
    - **예외처리**: 자연수가 아닐 경우  
    - **예외처리**: 1000으로 나누어 떨어지지 않을 경우
2. 구입한 로또 수량 출력  
3. 발행한 로또 모두 차례대로 출력
4. 당첨 번호 입력 
    - **예외처리**: 숫자가 아닐 경우  
    - **예외처리**: 자연수가 아닐 경우  
    - **예외처리**: 당첨 번호의 개수가 7개 아닐 경우  
    - **예외처리**: 1과 45사이의 자연수가 아닐 경우 
    - **예외처리**: 중복이 있을 경우  
5. 보너스 번호 입력  
    - **예외처리**: 숫자가 아닐 경우  
    - **예외처리**: 자연수가 아닐 경우  
    - **예외처리**: 1과 45사이의 자연수가 아닐 경우 
    - **예외처리**: 당첨 번호들과 중복이 있을 경우   
4. 당첨 내역 출력
5. 수익률 출력 

## Use Case 시나리오 🧮 
### 기본 흐름

| **단계** | **로또 발매기 애플리케이션**                            |
|---------|------------------------------------|
| 1       | 시스템이 구입 금액을 입력 받기 위한 텍스트를 디스플레이한다. |
| 2       | 사용자가 구입 금액을 입력한다. |
| 3       | 시스템이 사용자가 구입한 로또의 수량을 디스플레이한다. |
| 4       | 시스템이 각 로또를 중복되지 않는 6개의 숫자로 발행한다. |
| 5       | 시스템이 각 로또를 오름차순으로 정렬한다. |
| 6       | 시스템이 발행한 로또 모두 차례대로 디스플레이한다. |
| 7       | 사용자가 당첨 반호를 입력한다. |
| 8       | 사용자가 보너스 반호를 입력한다. |
| 9       | 시스템이 사용자가 구매한 로또 번호와 당첨/보너스 번호를 비교한다. |
| 10      | 시스템이 사용자의 당첨 내역을 계산한다. |
| 11      | 시스템이 사용자의 당첨 내역을 디스플레이한다. |
| 12      | 시스템이 사용자의 수익률을 계산한다. |
| 13      | 시스템이 사용자의 수익률을 디스플레이한다. |


### 대체 흐름 및 예외 흐름

| **조건**                   | **시스템 반응**                                       |
|--------------------------|-----------------------------------------------------|
| 입력된 구입 금액이 자연수가 아닐 경우   | 사용자에게 구입 금액 입력을 다시 요청한다.   |
| 입력된 구입 금액이 1000으로 나누어 떨어지지 않을 경우   | 사용자에게 구입 금액 입력을 다시 요청한다.    |
| 발행된 로또 번호가 1과 45사이의 자연수가 아닐 경우   | 로또를 다시 발행한다.    |
| 발행된 로또 번호의 개수가 6개 아닐 경우   | 로또를 다시 발행한다.    |
| 발행된 로또 번호 중에 중복이 있을 경우   | 로또를 다시 발행한다.    |
| 입력된 보너스 번호를 포함한 당첨 번호가 1과 45사이의 자연수가 아닐 경우   | 사용자에게 당첨 번호부터 입력을 다시 요청한다.    |
| 입력된 보너스 번호를 포함한 당첨 번호의 개수가 7개 아닐 경우 | 사용자에게 당첨 번호부터 입력을 다시 요청한다.    |
| 입력된 보너스 번호를 포함한 당첨 번호 중에 중복이 있을 경우 | 사용자에게 당첨 번호부터 입력을 다시 요청한다.    |

## Use Case  다이어그램 🚹
<img src="https://github.com/user-attachments/assets/72a146d8-d402-49ed-b37a-74c5fa5fbf9e" alt="미션3_유스케이스_다이어그램" width="400"/>
 
## MVC 구조 💡

### 🔵 **Model**

### Money 👉 구입 금액을 관리하는 클래스
- **필드**
  - `Integer money`: 구입 금액

- **생성자**
  - `Money(String money)`: 문자열로부터 구입 금액 생성

- **메서드**
  - `boughtLottosQuantity()`: 구매한 로또 수량 반환하기
  - `getMoney()`: 구입 금액 반환하기
 

### Lotto 👉 로또 한 장을 나타내는 클래스
- **필드**
  - `List<Integer> numbers`: 로또 번호 목록

- **생성자**
  - `Lotto(List<Integer> numbers)`: 로또 번호로부터 생성

- **메서드**
  - `validate(List<Integer> numbers)`: 로또 번호 유효성 검사하기
  - `sortedNumbersToString()`: 로또 번호를 오름차순으로 정렬하여 문자열로 반환하기
  - `compareWinningNumbers(List<Integer> winningNumbers)`: 당첨 번호와 비교하여 일치하는 개수 반환하기
  - `compareBonusNumber(Integer bonusNumber)`: 보너스 번호와 일치 여부 반환하기



### LottoFactory 👉 로또를 생성하는 팩토리 클래스
- **정적 메서드**
  - `createLottos(int quantityOfLottos)`: 지정된 수량의 로또 생성하기



### Lottos 👉 여러 로또들을 관리하는 클래스
- **필드**
  - `List<Lotto> lottos`: 로또 객체 리스트

- **생성자**
  - `Lottos(List<Lotto> lottos)`: 로또 리스트로부터 생성

- **정적 메서드**
  - `createLottos(int quantityOfLottos)`: 로또 팩토리를 통해 로또 생성하여 Lottos 객체 반환하기

- **메서드**
  - `allLottosToString()`: 모든 로또 번호를 문자열로 반환하기
  - `getLottos()`: 로또 리스트 반환하기



### WinningNumbers 👉 당첨 번호와 보너스 번호를 관리하는 클래스
- **필드**
  - `List<Integer> winningNumbers`: 당첨 번호 리스트
  - `Integer bonusNumber`: 보너스 번호

- **생성자**
  - `WinningNumbers(String winningNumbers, String bonusNumber)`: 입력된 문자열로부터 생성

- **메서드**
  - `splitWinningNumbers(String winningNumbers)`: 당첨 번호 문자열을 분리하기
  - `parseWinningNumbers(List<String> winningNumbers)`: 분리된 당첨 번호를 정수 리스트로 파싱하기
  - `parseBonusNumber(String bonusNumber)`: 보너스 번호를 정수로 파싱하기
  - `validate(List<Integer> winningNumbers)`: 당첨 번호와 보너스 번호의 유효성 검사하기
  - `getWinningNumbers()`: 당첨 번호 리스트 반환하기
  - `getBonusNumber()`: 보너스 번호 반환하기



### WinningStatistic 👉 당첨 통계를 관리하는 클래스
- **필드**
  - `List<WinningType> winningStatistic`: 당첨 결과 리스트

- **생성자**
  - `WinningStatistic(List<WinningType> winningStatistic)`: 당첨 결과 리스트로 생성

- **정적 메서드**
  - `createWinningStatistic(WinningNumbers winningNumbers, Lottos lottos)`: 당첨 번호와 로또 리스트로부터 당첨 통계 생성하기

- **메서드**
  - `determineWinningType(Lotto lotto, WinningNumbers winningNumbers)`: 로또와 당첨 번호로부터 당첨 유형 결정하기
  - `getTopWinningType(int quantityOfSameNumbers, boolean bonusMatch)`: 상위 3등 당첨 결과 계산하기
  - `getLowerWinningType(int quantityOfSameNumbers)`: 하위 2등 당첨 결과 계산하기
  - `getWinningStatistic()`: 당첨 결과 리스트 반환하기



### TotalPrice 👉 총 당첨 금액을 관리하는 클래스 (`ReturnRate` 인터페이스 구현)
- **필드**
  - `Integer totalPrice`: 총 당첨 금액

- **생성자**
  - `TotalPrice(Integer totalPrice)`: 총 당첨 금액으로 생성

- **정적 메서드**
  - `sumAllPrice(List<WinningType> winningStatistic)`: 당첨 결과 리스트로부터 총 당첨 금액 계산하여 `TotalPrice` 객체 생성하기

- **메서드**
  - `calculateReturnRate(Money money)`: 수익률 계산하기 (`ReturnRate` 인터페이스 구현)



### ReturnRate 👉 수익률 계산을 위한 인터페이스
- **메서드**
  - `calculateReturnRate(Money money)`: 수익률 계산하기


---

### 🟡 **View**

### InputView 👉 사용자 입력을 처리하는 클래스
- **메서드**
  - `readMoney()`: 구입 금액 입력 받기
  - `readWinningNumbers()`: 당첨 번호 입력 받기
  - `readBonusNumber()`: 보너스 번호 입력 받기



### OutputView 👉 결과 출력을 처리하는 클래스
- **메서드**
  - `printQuantityOfLottos(int boughtLottosQuantity)`: 구매한 로또 수량 출력하기
  - `printAllLottos(String allLottos)`: 모든 로또 번호 출력하기
  - `printStatistic(List<WinningType> winningStatistic)`: 당첨 통계 출력하기
  - `printReturnRate(double returnRate, List<WinningType> winningStatistic)`: 수익률 출력하기

---

### 🟢 **Controller**

### LottoMachineController 👉 로또 기계의 전체 흐름을 제어하는 컨트롤러
- **필드**
  - `Lottos lottos`: 발행된 로또 객체
  - `Money money`: 구입 금액 객체
  - `TotalPrice totalPrice`: 총 당첨 금액 객체
  - `WinningNumbers winningNumbers`: 당첨 번호 객체
  - `WinningStatistic winningStatistic`: 당첨 통계 객체
  - `InputView inputView`: 입력 뷰 객체
  - `OutputView outputView`: 출력 뷰 객체
  - `LottoMachineFactory factory`: 로또 기계 팩토리 객체

- **생성자**
  - `LottoMachineController(LottoMachineFactory factory)`: 팩토리 객체로부터 생성

- **메서드**
  - `runLottoMachine()`: 로또 기계 실행하기
  - `tryReadMoney()`: 구입 금액 입력 받기 및 예외 처리
  - `getLottosQuantity()`: 구매한 로또 수량 계산하기
  - `printQuantityOfLottos(int buyedLottosQuantity)`: 구매한 로또 수량 출력하기
  - `tryMakeLotto(int buyedLottosQuantity)`: 로또 생성 및 예외 처리
  - `printAllLottos(String allLottos)`: 모든 로또 번호 출력하기
  - `tryReadBonusAndWinningNumbers()`: 당첨 번호와 보너스 번호 입력 받기 및 예외 처리
  - `getWinningStatistic(WinningNumbers winningNumbers, Lottos lottos)`: 당첨 통계 계산하기
  - `printStatistic(List<WinningType> winningResults)`: 당첨 통계 출력하기
  - `getReturnRate(List<WinningType> winningResults)`: 수익률 계산하기
  - `printReturnRate(double returnRate, List<WinningType> winningResults)`: 수익률 출력하기



### LottoMachineFactory 👉 로또 기계의 객체들을 생성하는 팩토리 클래스
- **메서드**
  - `createInputView()`: `InputView` 객체 생성하기
  - `createOutputView()`: `OutputView` 객체 생성하기
  - `createLottos(int quantity)`: `Lottos` 객체 생성하기
  - `createWinningStatistic(WinningNumbers winningNumbers, Lottos lottos)`: `WinningStatistic` 객체 생성하기
  - `createTotalPrice(List<WinningType> winningResults)`: `TotalPrice` 객체 생성하기

---

### 🔴 **Validation**

### MoneyValidator 👉 구입 금액의 유효성을 검사하는 클래스
- **메서드**
  - `validateMoney(Integer money)`: 구입 금액의 유효성 검사하기



### LottoNumberValidator 👉 로또 번호의 유효성을 검사하는 클래스
- **메서드**
  - `validateLottoNumbers(List<Integer> numbers)`: 로또 번호 유효성 검사 메인 메서드
  - `validateNumbers(List<Integer> numbers)`: 로또 번호 개수 및 범위 검사하기
  - `validateDuplicate(List<Integer> numbers)`: 중복 번호 검사하기



### WinningAndBonusNumbersValidator 👉 당첨 번호와 보너스 번호의 유효성을 검사하는 클래스
- **메서드**
  - `validateWinningAndBonusNumbers(List<Integer> winningAndBonusNumbers)`: 당첨 번호 및 보너스 번호 유효성 검사 메인 메서드
  - `validateNumbers(List<Integer> winningAndBonusNumbers)`: 번호 개수 및 범위 검사하기
  - `validateDuplicate(List<Integer> winningAndBonusNumbers)`: 중복 번호 검사하기

---

### 🟣 **Enum**

### WinningType 👉 당첨 유형을 나타내는 enum
- **상수**
  - `FIRST_PLACE`
  - `SECOND_PLACE`
  - `THIRD_PLACE`
  - `FOURTH_PLACE`
  - `FIFTH_PLACE`



### SystemMessage 👉 시스템 메시지 인터페이스
- **메서드**
  - `getMessage()`: 메시지 반환하기



### ErrorMessage 👉 에러 메시지를 관리하는 enum (`SystemMessage` 구현)
- **상수**
  - `INVALID_INT_NUMBER`
  - `NOT_NATURAL_NUMBER`
  - `INVALID_MONEY_UNIT`
  - `INVALID_WINNING_NUMBER`
  - `DUPLICATE_WINNING_NUMBER`
  - `INVALID_WINNING_NUMBERS_QUANTITY`
  - `INVALID_LOTTO_QUANTITY`
  - `DUPLICATE_LOTTO_NUMBER`
  - `INVALID_LOTTO_NUMBER`
  - `INVALID_CALCULATE`

  - **필드**
  - `String ERROR_LOG_LEVEL`: 에러 오그 레벨
  - `String message`: 에러 메세지

- **메서드**
  - `getMessage()`: 에러 메시지 반환하기



### IOMessage 👉 입출력 메시지를 관리하는 enum (`SystemMessage` 구현)
- **상수**
  - `INPUT_PURCHASE_AMOUNT`
  - `INPUT_WINNING_NUMBER`
  - `INPUT_BONUS_NUMBER`
  - `PRINT_QUANTITY_OF_LOTTOS`
  - `PRINT_WINNING_STATISTIC`
  - `PRINT_WINNING_STATISTIC_SEPARATER`
  - `PRINT_UNIT_OF_QUANTITY`
  - `PRINT_THREE_MATCHING_QUANTITY`
  - `PRINT_FOUR_MATCHING_QUANTITY`
  - `PRINT_FIVE_MATCHING_QUANTITY`
  - `PRINT_FIVE_MATCHING_QUANTITY_AND_BONUS`
  - `PRINT_SIX_MATCHING_QUANTITY`
  - `PRINT_TOTAL_RETURN_RATE`
  - `PRINT_NO_MONEY_EARNED`

- **필드**
  - `String message`: IO 메세지

- **메서드**
  - `getMessage()`: 메시지 반환하기

---

### 🟤 **Utilities**

### Parser 👉 문자열을 정수로 파싱하는 유틸리티 클래스
- **메서드**
  - `parseNumberToInt(String number)`: 문자열을 정수로 파싱하기
  - `parseNumbersToInt(List<String> numbers)`: 문자열 리스트를 정수 리스트로 파싱하기



### Random 👉 로또 번호를 생성하는 유틸리티 클래스
- **상수**
  - `int QUANTITY_OF_NUMBERS`: 한장 로또의 번호 개수

- **메서드**
  - `lottoGenerator()`: 랜덤 로또 번호 생성하기



### Sorter 👉 리스트를 정렬하는 유틸리티 클래스
- **메서드**
  - `inAscendingOrder(List<Integer> listOfLottoNumbers)`: 리스트를 오름차순으로 정렬하기



### Splitter 👉 문자열을 분리하는 유틸리티 클래스
- **상수**
  - `String DELIMITER`: 당첨 번호 구분자

- **메서드**
  - `splitWinningNumbers(String winningNumbers)`: 당첨 번호 문자열을 분리하기

---

### ⚪️ **Constants**

### MoneyConstants 👉 금액 관련 상수를 관리하는 클래스
- **상수**
  - `LOTTO_PRICE`: 로또 한 장의 가격 (1000원)



### RandomNumberConstants 👉 랜덤 번호 관련 상수를 관리하는 클래스
- **상수**
  - `MINIMUM_RANDOM_NUMBER`: 로또 번호의 최소값 (1)
  - `MAXIMUM_RANDOM_NUMBER`: 로또 번호의 최대값 (45)

## 확장 가능성 고려 사항 🆙
1. 로또 가격 변경
2. 보너스 번호 수 증가
3. 수익률 계산 방식 변경

## 클래스 다이어그램 📊 (View클래스,Enum클래스,상수 관리하는 클래스 생략)
### 클래스 간의 관계 설명
<img src="https://github.com/user-attachments/assets/cf2a3b9e-2a8c-4b00-a319-6849a1b6327b" alt="클래스 간의 관계 설명" width="600"/>

### Lotto클래스와 Lottos클래스의 관계
<img src="https://github.com/user-attachments/assets/b9d767dd-25ec-45cc-bbc1-0117ce879c48" alt="Lotto클래스와 Lottos클래스의 관계" width="600"/>

### WinningNumbers클래스와 WinningStatistic클래스의 관계
<img src="https://github.com/user-attachments/assets/c684dc4a-6ecb-41ca-89d6-682cd28d1561" alt="WinningNumbers클래스와 WinningStatistic클래스의 관계" width="800"/>

### Money클래스와 TotalPrice클래스의 관계
<img src="https://github.com/user-attachments/assets/b534d764-3bf6-482d-95f0-1ae7861c80a3" alt="Money클래스와 TotalPrice클래스의 관계" width="800"/>

### Model클래스들과 메인Controller 클래스와의 관계
<img src="https://github.com/user-attachments/assets/77417b10-1d5e-4836-90f7-58a1a8696b2e" alt="Model클래스들과 메인Controller 클래스와의 관계" width="700"/>





