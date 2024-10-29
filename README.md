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

# **구현할 기능 목록 정리**

- [ ] **입력기 (InputView)**

    - **역할**: 사용자로부터 구입 금액, 당첨 번호, 보너스 번호를 입력받습니다.
    - **구현 기능**:
        - `inputPurchaseAmount`: 로또 구입 금액을 입력받기
        - `inputLottoNumbers`: 당첨 번호를 입력받기
        - `inputBonusNumber`: 보너스 번호를 입력받기
        - `close`: `Console` 자원을 해제하여 입력 스트림 종료
    - **ViewMessage 열거형**:
        - `INPUT_PURCHASE_AMOUNT`: 구입 금액 입력 메시지 ("구입금액을 입력해 주세요.")
        - `INPUT_LOTTO_NUMBERS`: 당첨 번호 입력 메시지 ("당첨 번호를 입력해 주세요.")
        - `INPUT_BONUS_NUMBER`: 보너스 번호 입력 메시지 ("보너스 번호를 입력해 주세요.")

- [ ] **검증기 (Validator)**

    - **역할**: 로또 구입 금액, 당첨 번호, 보너스 번호의 유효성을 검증하여 잘못된 입력 시 예외 처리합니다.
    - **구현 기능**:
        - `PurchaseAmountValidator`: 로또 구입 금액이 숫자이며, 1,000원 단위로 입력되었는지 검증합니다.
            - **예외 메시지**: `ErrorMessage.PURCHASE_AMOUNT_INVALID` - `[ERROR] 구입 금액은 숫자이며 1,000원 단위여야 합니다.`
        - `LottoNumberRangeValidator`: 로또 번호가 1~45 사이의 숫자인지 확인합니다.
            - **예외 메시지**: `ErrorMessage.LOTTO_NUMBER_RANGE_INVALID` - `[ERROR] 로또 번호는 1부터 45 사이여야 합니다.`
        - `LottoNumberCountValidator`: 로또 번호가 중복되지 않는 6개의 숫자로 구성되었는지 검증합니다.
            - **예외 메시지**: `ErrorMessage.LOTTO_NUMBER_COUNT_INVALID` - `[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.`
        - `BonusNumberValidator`: 보너스 번호가 당첨 번호와 중복되지 않는 1~45 범위의 숫자인지 검증합니다.
            - **예외 메시지**: `ErrorMessage.BONUS_NUMBER_DUPLICATE_INVALID` - `[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.`
        - `LottoNumbersFormatValidator`: 당첨 번호가 쉼표로 구분된 6개의 숫자 형식인지 확인합니다.
            - **예외 메시지**: `ErrorMessage.LOTTO_NUMBERS_FORMAT_INVALID` - `[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자 형식이어야 합니다.`
        - `EmptyInputValidator`: 입력값이 비어 있는지 확인합니다.
            - **예외 메시지**: `ErrorMessage.EMPTY_INPUT_INVALID` - `[ERROR] 입력값은 비어 있을 수 없습니다.`

- [ ] **Service (LottoService)**
    - **역할**: 로또 발행 및 당첨 결과 계산, 수익률 계산을 수행합니다.
    - **구현 기능**:
        - **로또 번호 발행**:
            - `generateLottoTickets`: 구입 금액에 맞게 `Lotto` 객체 리스트를 생성하여 저장합니다.
            - **번호 생성 규칙**: 각 티켓은 1~45 범위에서 중복되지 않는 6개의 숫자로 구성됩니다.
        - **당첨 번호 및 보너스 번호 설정**:
            - `setWinningNumbers`: 당첨 번호와 보너스 번호를 저장합니다.
        - **당첨 내역 및 수익률 계산**:
            - `calculateResults`: 사용자가 구매한 티켓과 당첨 번호를 비교하여 당첨 결과를 계산합니다.
            - `calculateProfitRate`: 총 당첨 금액과 구입 금액을 기준으로 수익률을 계산하고 소수 둘째 자리에서 반올림합니다.

- [ ] **Model (Lotto)**
    - **역할**: 로또 번호를 저장하고, 입력된 번호의 유효성을 검사합니다.
    - **구현 기능**:
        - **번호 저장**: 로또 번호를 저장하는 `numbers` 필드를 관리합니다.
        - **유효성 검사**: 입력된 번호가 6개인지, 1부터 45 사이의 숫자인지를 검사하여 잘못된 입력에 대해서는 예외를 발생시킵니다.
        - **기능 구현**:
            - **번호 출력**: `getNumbers`: 로또 번호 리스트를 반환합니다.
            - **번호 일치 여부 확인**: `matches`: 당첨 번호와 사용자가 구매한 번호를 비교하여 일치하는 개수를 반환하는 기능을 추가합니다.
            - **랜덤 번호 생성**: `generateRandomNumbers`: 중복되지 않는 6개의 랜덤 로또 번호를 생성하는 기능을 추가합니다.

- [ ] **출력기 (OutputView)**
    - **역할**: 로또 구매 내역, 당첨 결과, 수익률 등을 출력합니다.
    - **구현 기능**:
        - **로또 구매 내역 출력**:
            - `printLottoPurchase`: 구입한 로또 개수와 번호 목록을 출력합니다.
        - **당첨 결과 출력**:
            - `printWinningResults`: 등수별 당첨 내역을 출력합니다.
        - **수익률 출력**:
            - `printProfitRate`: 총 수익률을 소수점 둘째 자리까지 반올림하여 출력합니다.
        - **에러 메시지 출력**:
            - `printErrorMessage`: 예외 발생 시 "[ERROR]"로 시작하는 메시지를 출력합니다.
    - **ViewMessage 열거형**:
        - `LOTTO_COUNT_PURCHASED`: 로또 구매 개수 출력 메시지 (예시: "8개를 구매했습니다.")
        - `LOTTO_TICKET_NUMBERS`: 로또 티켓 번호 출력 메시지 (예시: "[8, 21, 23, 41, 42, 43]")
        - `RESULT_HEADER`: 당첨 통계 시작 메시지 ("당첨 통계\n---")
        - `PROFIT_RATE`: 총 수익률 출력 메시지 ("총 수익률은 %.1f%%입니다.")

- [ ] **Controller (LottoGameController)**
    - **역할**: 사용자 입력을 받아 서비스에 전달하고 로또 발행 및 결과 출력을 제어합니다.
    - **구현 기능**:
        - **사용자 입력 처리 및 검증**:
            - `getPurchaseAmount`: 로또 구입 금액을 입력받고 검증 후 반환합니다.
            - `getWinningNumbers`: 당첨 번호와 보너스 번호를 입력받고 검증 후 반환합니다.
        - **로또 티켓 발행**:
            - `generateLottoTickets`: 로또 티켓을 생성하고 결과를 출력합니다.
        - **당첨 결과 계산 및 출력**:
            - `calculateResults` 및 `printProfitRate`: 당첨 결과 및 수익률을 계산하여 출력합니다.
        - **에러 메시지 처리**:
            - `printErrorMessage`로 잘못된 입력에 대한 에러 메시지를 출력하고 재입력을 받습니다.
        - **자원 해제**:
            - `inputView.close`: 콘솔 자원을 해제하여 입력 스트림을 종료합니다.

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
