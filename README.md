# java-lotto-precourse
---

# **과제 진행 요구 사항**

1. **저장소 포크 및 클론**
    - 미션은 로또 저장소를 **포크**하고 **클론**하는 것으로 시작한다.

2. **기능 구현 전 준비**
    - 기능을 구현하기 전, **README.md**에 구현할 기능 목록을 정리하여 추가한다.

3. **커밋 단위**
    - Git의 커밋 단위는 앞 단계에서 **README.md**에 정리한 기능 목록 단위로 추가한다.

4. **커밋 메시지 작성 규칙**
    - **AngularJS Git Commit Message Conventions**을 참고하여 커밋 메시지를 작성한다.

5. **과제 진행 방법 참고**
    - 자세한 과제 진행 방법은 **프리코스 진행 가이드 문서**를 참고한다.

---

# **📚 로또**

# **기능 요구사항**
----

- 간단한 로또 발매기를 구현한다.
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있으며, 기준과 상금은 다음과 같다:
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 재입력 받는다.
- `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException`과 같은 구체적인 예외를 처리한다.

----

# **기능 목록 정리**

- [ x ] **입력기 (InputView)**

    - **역할**: 사용자로부터 구입 금액, 당첨 번호, 보너스 번호를 입력받습니다.
    - **구현 기능**:
        - `inputPurchaseAmount`: 로또 구입 금액을 입력받습니다.
        - `inputLottoNumbers`: 당첨 번호를 입력받습니다.
        - `inputBonusNumber`: 보너스 번호를 입력받습니다.
        - `close`: `Console` 자원을 해제하여 입력 스트림을 종료합니다.
    - **ViewMessage 열거형**:
        - `INPUT_PURCHASE_AMOUNT`: 구입 금액 입력 메시지 ("구입금액을 입력해 주세요.")
        - `INPUT_LOTTO_NUMBERS`: 당첨 번호 입력 메시지 ("당첨 번호를 입력해 주세요.")
        - `INPUT_BONUS_NUMBER`: 보너스 번호 입력 메시지 ("보너스 번호를 입력해 주세요.")

- [ x ] **검증기 (Validator)**

  ### **BonusNumberValidator**

    - **`validateBonusNumberRange`**:  
      보너스 번호가 1에서 45 사이의 숫자인지 검증하며, 범위를 벗어날 경우 예외를 발생시킵니다.
        - **입력값 예시**: `0`, `46`
        - **예외 메시지**: `[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.`

    - **`validateBonusNumberDuplication`**:  
      보너스 번호가 당첨 번호와 중복되지 않는지 검증하며, 중복이 있을 경우 예외를 발생시킵니다.
        - **입력값 예시**: `6` (당첨 번호: `[1, 2, 3, 4, 5, 6]`)
        - **예외 메시지**: `[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.`

  ### **InputValidator**

    - **`validateNotEmpty`**:  
      입력 값이 비어 있거나 공백일 경우 예외를 발생시킵니다.
        - **입력값 예시**: `""`, `"   "`
        - **예외 메시지**: `[ERROR] 입력값은 비어 있을 수 없습니다.`

    - **`validatePurchaseAmount`**:  
      로또 구입 금액이 양수이며, `LOTTO_PRICE`의 배수인지 확인하고, 그렇지 않으면 예외를 발생시킵니다.
        - **입력값 예시**: `1500`, `250`
        - **예외 메시지**: `[ERROR] 구입 금액은 양수이며 1,000원 단위여야 합니다.`

  ### **LottoValidator**

    - **`validateLottoNumberCount`**:  
      로또 번호가 정확히 6개인지 검증하고, 6개가 아닐 경우 예외를 발생시킵니다.
        - **입력값 예시**: `[1, 2, 3, 4, 5]`, `[1, 2, 3, 4, 5, 6, 7]`
        - **예외 메시지**: `[ERROR] 로또 번호는 6개의 숫자여야 합니다.`

    - **`validateLottoNumberRange`**:  
      로또 번호가 1에서 45 사이의 숫자인지 검증하며, 범위를 벗어날 경우 예외를 발생시킵니다.
        - **입력값 예시**: `[0, 1, 2, 3, 4, 5]`, `[1, 2, 3, 4, 5, 46]`
        - **예외 메시지**: `[ERROR] 로또 번호는 1부터 45 사이여야 합니다.`

    - **`validateNoDuplicates`**:  
      로또 번호에 중복이 없는지 검증하고, 중복이 있을 경우 예외를 발생시킵니다.
        - **입력값 예시**: `[1, 2, 3, 4, 5, 5]`
        - **예외 메시지**: `[ERROR] 로또 번호에는 중복된 숫자가 없어야 합니다.`

- [ x ] **에러 메시지 열거형 (ErrorMessage Enum)**

    - **역할**: 로또 프로그램의 입력 검증 중 발생하는 다양한 예외 메시지를 정의합니다.
    - **구현 메시지**:
        - `PURCHASE_AMOUNT_INVALID`: `[ERROR] 구입 금액은 양수이며 1,000원 단위여야 합니다.`
            - **설명**: 구입 금액이 양수이고 1,000원 단위인지 확인합니다.
        - `LOTTO_NUMBER_RANGE_INVALID`: `[ERROR] 로또 번호는 1부터 45 사이여야 합니다.`
            - **설명**: 로또 번호가 1에서 45 사이의 범위인지 확인합니다.
        - `LOTTO_NUMBER_COUNT_INVALID`: `[ERROR] 로또 번호는 6개의 숫자여야 합니다.`
            - **설명**: 로또 번호가 6개의 숫자로 이루어졌는지 확인합니다.
        - `LOTTO_NUMBER_DUPLICATE_INVALID`: `[ERROR] 로또 번호에는 중복된 숫자가 없어야 합니다.`
            - **설명**: 로또 번호에 중복된 숫자가 있는지 확인합니다.
        - `BONUS_NUMBER_DUPLICATE_INVALID`: `[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.`
            - **설명**: 보너스 번호가 당첨 번호와 중복되지 않는지 확인합니다.
        - `BONUS_NUMBER_OUT_OF_RANGE`: `[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.`
            - **설명**: 보너스 번호가 1에서 45 사이의 범위인지 확인합니다.
        - `LOTTO_NUMBERS_FORMAT_INVALID`: `[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자 형식이어야 합니다.`
            - **설명**: 당첨 번호 형식이 올바르게 입력되었는지 확인합니다.
        - `EMPTY_INPUT_INVALID`: `[ERROR] 입력값은 비어 있을 수 없습니다.`
            - **설명**: 입력값이 비어 있지 않은지 확인합니다.
        - `INVALID_NUMBER_FORMAT`: `[ERROR] 입력값은 숫자여야 합니다.`
            - **설명**: 입력값이 숫자인지 확인합니다.

- [ x ] **Service (LottoService)**
    - **역할**: 로또 발행, 당첨 결과 및 수익률 계산을 수행합니다.

    - **구현 기능**:

  ### **로또 번호 발행**
    - `generateLottoTickets`: 구입 금액에 맞게 `Lotto` 객체 리스트를 생성하여 `lottoTickets` 필드에 저장합니다.
        - **번호 생성 규칙**: 각 티켓은 1~45 범위에서 중복되지 않는 6개의 숫자로 구성됩니다.
    - `getLottoTickets`: 생성된 로또 티켓 리스트를 반환합니다.

  ### **당첨 번호 및 보너스 번호 설정**
    - `setWinningNumbers`: 당첨 번호 리스트와 보너스 번호를 설정하여 `winningTicket`과 `bonusNumber`에 저장합니다.
    - `getWinningTicket`: 설정된 당첨 번호가 저장된 `winningTicket`을 반환합니다.

  ### **당첨 내역 및 수익률 계산**
    - `calculateResults`: 사용자 티켓과 당첨 번호를 비교하여 각 티켓의 당첨 등급(`PrizeTier`)을 계산한 후, 각 등급별 티켓 수를 집계하여 반환합니다.
    - `calculateProfitRate`: 총 당첨 금액과 구입 금액을 기준으로 수익률을 계산하여 소수 둘째 자리에서 반올림하여 반환합니다.

  ### **세부 구현**
    - `calculatePrizeResults`: `lottoTickets`와 `winningTicket`, `bonusNumber`를 기반으로 각 티켓의 당첨 등급(`PrizeTier`)을 계산하여 리스트로
      반환합니다.
    - `calculateTotalPrize`: `calculatePrizeResults`를 통해 얻은 당첨 등급 리스트의 총 당첨 금액을 계산합니다.

- [ x ] **Model (Lotto)**
    - **역할**: 로또 번호를 저장하고, 입력된 번호의 유효성을 검사합니다.
    - **구현 기능**:
        - **번호 저장**: 로또 번호를 저장하는 `numbers` 필드를 관리합니다.
        - **유효성 검사**: 입력된 번호가 6개인지, 1부터 45 사이의 숫자인지를 검사하여 잘못된 입력에 대해서는 예외를 발생시킵니다.
        - **기능 구현**:
            - `getNumbers`: 저장된 로또 번호 리스트를 반환합니다.
            - `getMatchCount`: 당첨 번호와 저장된 번호를 비교하여 일치하는 개수를 반환합니다.
            - `containsBonus`: 보너스 번호가 로또 번호에 포함되는지 여부를 확인합니다.
            - `generateRandomNumbers`: 중복되지 않는 6개의 랜덤 로또 번호를 생성하여 반환합니다.
            - `formatNumbers`: 로또 번호를 `[1, 2, 3, 4, 5, 6]` 형식의 문자열로 변환하여 반환합니다.

- [ x ] **출력기 (OutputView)**
    - **역할**: 로또 구매 내역, 당첨 결과, 수익률 등을 출력합니다.
    - **구현 기능**:
        - **로또 구매 내역 출력**:
            - `printLottoPurchase`: 구입한 로또 개수와 번호 목록을 출력합니다.
        - **당첨 결과 출력**:
            - `printWinningResults`: 당첨 등수별로 당첨 개수를 출력합니다.
        - **수익률 출력**:
            - `printProfitRate`: 총 수익률을 소수점 첫째 자리까지 반올림하여 출력합니다.
    - **ViewMessage 열거형**:
        - `LOTTO_COUNT_PURCHASED`: 로또 구매 개수 출력 메시지 ("8개를 구매했습니다.")
        - `RESULT_HEADER`: 당첨 통계의 시작 메시지 ("당첨 통계\n---")
        - `PROFIT_RATE`: 총 수익률 출력 메시지 ("총 수익률은 %.1f%%입니다.")
        - `THREE_MATCH`: 3개 일치 당첨 결과 메시지 (예: “3개 일치 (5,000원) - 1개”)
        - `FOUR_MATCH`: 4개 일치 당첨 결과 메시지 (예: “4개 일치 (50,000원) - 0개”)
        - `FIVE_MATCH`: 5개 일치 당첨 결과 메시지 (예: “5개 일치 (1,500,000원) - 0개”)
        - `FIVE_MATCH_BONUS`: 5개 일치, 보너스 볼 일치 당첨 결과 메시지 (예: “5개 일치, 보너스 볼 일치 (30,000,000원) - 0개”)
        - `SIX_MATCH`: 6개 일치 당첨 결과 메시지 (예: “6개 일치 (2,000,000,000원) - 0개”)

- [ x ] **Controller (LottoGameController)**
    - **역할**: 사용자 입력을 받아 서비스에 전달하고 로또 발행 및 결과 출력을 제어합니다.
    - **구현 기능**:

      ### **사용자 입력 처리 및 검증**
        - `inputHandler.getPurchaseAmount`: 로또 구입 금액을 입력받고 검증 후 반환합니다.
        - `inputHandler.getWinningNumbers` 및 `inputHandler.getBonusNumber`: 당첨 번호와 보너스 번호를 입력받고 검증 후 반환합니다.

      ### **로또 티켓 발행**
        - `lottoService.generateLottoTickets`: 구입 금액에 따라 로또 티켓을 생성하고, 생성된 티켓 목록을 `resultHandler.printLottoPurchase`를 통해
          출력합니다.

      ### **당첨 결과 계산 및 출력**
        - `resultHandler.calculateAndPrintResults`: 생성된 로또 티켓과 당첨 번호를 비교하여 결과를 계산하고 당첨 내역을 출력합니다.
        - `resultHandler.printProfitRate`: 총 수익률을 계산하고 소수점 첫째 자리까지 반올림하여 출력합니다.

      ### **에러 메시지 처리**
        - `errorView.printErrorMessage`: 잘못된 입력에 대한 에러 메시지를 출력하고 재입력을 받습니다.

      ### **자원 해제**
        - `inputHandler.close`: 콘솔 자원을 해제하여 입력 스트림을 종료합니다.

- **PrizeTier Enum**

    - **역할**: 당첨 일치 개수와 보너스 번호 일치 여부에 따라 각 당첨 등급을 정의하고, 해당 등급에 따른 상금을 제공합니다.
    - **구현 기능**:
        - `findPrize`: 주어진 일치 번호 개수와 보너스 번호 일치 여부에 맞는 `PrizeTier`를 반환합니다.
        - `getPrizeAmount`: 등급에 해당하는 상금을 반환합니다.

- **LottoInputHandler**
    - **역할**: 사용자로부터 로또 구입 금액, 당첨 번호, 보너스 번호 입력을 받아 파싱하고, 검증을 수행합니다. 검증에 실패할 경우 에러 메시지를 출력하고 입력을 재시도합니다.
    - **주요 기능**:
        - `getPurchaseAmount`: 구입 금액을 입력받아 검증합니다.
        - `getWinningNumbers`: 당첨 번호를 입력받아 검증합니다.
        - `getBonusNumber`: 보너스 번호를 입력받아 검증합니다.
        - `close`: 입력 스트림을 종료합니다.

- **ResultHandler**
    - **역할**: 로또 서비스에서 계산된 당첨 결과와 수익률을 출력합니다.
    - **주요 기능**:
        - `printLottoPurchase`: 구입한 로또 티켓 목록을 출력합니다.
        - `calculateAndPrintResults`: 당첨 결과를 계산하고 각 등급별 당첨 횟수를 출력합니다.
        - `printProfitRate`: 총 수익률을 계산하여 출력합니다.

- **LottoConstants**

- **역할**: 로또 관련 상수를 관리하는 클래스. 로또 번호 범위, 로또 번호 개수, 로또 가격 등의 값을 정의합니다.
- **상수 목록**:
    - `LOTTO_MIN_NUMBER`: 로또 번호의 최소 값 (1)
    - `LOTTO_MAX_NUMBER`: 로또 번호의 최대 값 (45)
    - `LOTTO_NUMBER_COUNT`: 로또 티켓당 번호 개수 (6)
    - `LOTTO_PRICE`: 로또 티켓 가격 (1,000원)
- **특징**: 클래스의 인스턴스화 방지를 위해 `private` 생성자를 정의합니다.

- **PrizeCalculator**

- **역할**: 로또 티켓의 당첨 등급을 계산하고, 총 당첨 금액과 수익률을 산출합니다.
- **구현 기능**:
    - `determinePrize`: 티켓의 일치하는 번호 개수와 보너스 번호 여부를 통해 당첨 등급(`PrizeTier`)을 결정합니다.
    - `calculateResults`: 여러 티켓의 당첨 등급을 계산하여 리스트로 반환합니다.
    - `calculateTotalPrize`: 당첨 등급 리스트를 기반으로 총 당첨 금액을 계산합니다.
    - `calculateProfitRate`: 총 당첨 금액과 구입 금액을 바탕으로 수익률을 소수점 두 자리까지 반올림하여 계산합니다.
    - `roundToTwoDecimalPlaces`: 소수점 두 자리로 반올림하는 보조 메서드입니다.
- **LottoTicketGenerator**

- **역할**: 로또 티켓을 생성하고, 구입 금액에 따른 티켓 개수를 계산합니다.
- **구현 기능**:
    - `createTickets`: 구매 금액에 따라 로또 번호 조합을 생성하고, 각 조합을 포함하는 `Lotto` 객체 리스트를 반환합니다.
    - `calculateTicketCount`: 구입 금액을 바탕으로 발행 가능한 티켓 개수를 계산합니다.
- **ParsingUtils**

- **역할**: 문자열 입력을 정수 또는 정수 리스트로 변환하며, 파싱 오류 시 예외를 처리합니다.
- **구현 기능**:
    - `parseStringToInteger`: 문자열을 정수로 변환하고, 변환에 실패할 경우 예외 메시지를 포함한 `IllegalArgumentException`을 발생시킵니다.
    - `parseStringToIntegerList`: 쉼표로 구분된 문자열을 정수 리스트로 변환하며, 변환에 실패 시 예외를 발생시킵니다.
    - `splitAndParseToList`: 문자열을 분할하고 각 요소를 정수로 파싱하여 리스트로 반환하는 보조 메서드입니다.

- **ErrorView**

- **역할**: 오류 메시지를 출력하는 역할을 담당합니다.
- **구현 기능**:
    - `printErrorMessage`: 전달받은 오류 메시지를 콘솔에 출력합니다.

----

# 프로그래밍 요구 사항

## 프로그래밍 요구 사항 1

- **JDK 버전**: JDK 21 버전에서 실행 가능해야 합니다.
- **프로그램 시작점**: 프로그램 실행의 시작점은 `Application` 클래스의 `main()` 메서드입니다.
- **외부 라이브러리 제한**: `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않습니다.
- **프로그램 종료**: `System.exit()`를 호출하지 않습니다.
- **파일 및 패키지 이름 유지**: 요구 사항에서 별도로 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않습니다.
- **코드 컨벤션 준수**: 자바 코드 컨벤션을 지키며 프로그래밍하고, 기본적으로 Java Style Guide를 원칙으로 합니다.

## 프로그래밍 요구 사항 2

- **들여쓰기 깊이 제한**: indent(인덴트, 들여쓰기) depth는 최대 2까지만 허용하며, 3을 넘지 않도록 구현합니다.
    - 예: `while`문 안에 `if`문이 있는 경우 들여쓰기는 2입니다.
    - **힌트**: 들여쓰기 깊이를 줄이려면 함수(또는 메서드)로 분리하는 방법이 유용합니다.
- **3항 연산자 금지**: 3항 연산자는 사용하지 않습니다.
- **함수의 단일 책임 원칙**: 함수(또는 메서드)는 최대한 작게 만들어 한 가지 일만 하도록 합니다.
- **테스트 코드 작성**: JUnit 5와 AssertJ를 이용해 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인합니다.
    - **참고 자료**:
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
        - [AssertJ User Guide](https://assertj.github.io/doc/)
        - [AssertJ Exception Assertions](https://assertj.github.io/doc/#assertj-core-assertions-exception-assertions)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

## 프로그래밍 요구 사항 3

- **함수/메서드 길이 제한**: 함수(또는 메서드)의 길이는 15줄을 넘지 않도록 합니다.
- **함수의 단일 책임 원칙**: 함수(또는 메서드)는 한 가지 일만 잘 수행하도록 구현합니다.
- **else 예약어 사용 금지**: `else` 예약어는 사용하지 않습니다.
    - `else`를 사용하지 않는 대신 `switch/case`를 사용하는 경우가 있으나, `switch/case`도 사용하지 않습니다.
    - **힌트**: `if` 조건절에서 값을 `return`하여 `else`를 사용하지 않고 구현할 수 있습니다.
- **Enum 적용**: Java Enum을 활용하여 프로그램을 구현합니다.
- **단위 테스트 작성**: 구현한 기능에 대한 단위 테스트를 작성합니다. 단, UI(System.out, System.in, Scanner) 로직은 제외합니다.
    - **참고 자료**: `LottoTest`를 참고하여 테스트 작성.

## 라이브러리

- **Randoms 및 Console API 사용**: `camp.nextstep.edu.missionutils`에서 제공하는 Randoms 및 Console API를 활용하여 구현합니다.
    - **Random 값 추출**: `Randoms.pickUniqueNumbersInRange(1, 45, 6)`를 사용하여 1에서 45 사이의 중복되지 않은 정수 6개를 반환합니다.
    - **사용자 입력**: `Console.readLine()`을 사용하여 사용자 입력을 처리합니다.

### Lotto 클래스

- **클래스 사용 규칙**: 제공된 `Lotto` 클래스를 사용하여 구현해야 합니다.
- **필드 제한**: `Lotto` 클래스에는 `numbers` 이외의 필드(인스턴스 변수)를 추가할 수 없습니다.
- **접근 제어자**: `numbers`의 접근 제어자인 `private`은 변경할 수 없습니다.
- **패키지 위치**: `Lotto`의 패키지는 변경할 수 있습니다.

#### Lotto 클래스 예시

```java
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
