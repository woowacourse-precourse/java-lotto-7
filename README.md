# 로또 게임 어플리케이션

![클래스 다이어그램](src/main/resources/class_diagram.png)

이 어플리케이션은 콘솔을 통해 사용자로부터 구입 금액과 당첨 번호를 입력받고, 사용자가 구매한 로또 티켓의 당첨 여부를 확인하여 최종 수익률을 계산하는 게임입니다.

---

## 어플리케이션 흐름

1. **게임 초기화**
  - 컨트롤러가 사용자로부터 구입 금액을 입력받고, 유효성을 검증합니다.
  - 구입 금액에 따라 로또 티켓의 개수를 계산하고, 해당 개수만큼 로또 번호를 생성합니다.

2. **당첨 번호 입력**
  - 컨트롤러가 사용자로부터 당첨 번호와 보너스 번호를 입력받고, 유효성을 검증합니다.

3. **게임 실행 및 결과 처리**
  - 각 로또 티켓에 대해 당첨 번호와 비교하여 일치하는 번호 개수를 확인합니다.
  - 당첨 내역을 기반으로 당첨 금액을 계산하고, 최종 수익률을 산출합니다.
  - 게임 결과와 수익률을 출력합니다.

---

## 도메인 요구사항

### 1. 로또 

- **행동**
  - 중복되지 않은 숫자로 구성된 6개의 번호를 가진 로또 티켓을 생성한다.
  - 당첨 번호와 보너스 번호를 입력받아, 해당 로또 티켓의 일치 개수를 판별한다.
- **상태**
  - 로또 번호: 1~45 범위의 중복되지 않은 6개의 숫자를 가짐.
  - 로또 번호는 라이브러리를 통해 무작위로 생성되며, 중복을 허용하지 않는다.

### 2. 로또 번들

- **행동**
  - 여러 장의 로또 티켓을 관리한다.
  - 모든 로또 티켓의 당첨 결과를 판별하고, 각 등수별 당첨 개수를 리턴한다.
  - 총 당첨금을 계산한다.
- **상태**
  - 로또 티켓 컬렉션: 사용자가 구매한 로또 티켓들의 모음.

### 3. 로또 생성 전략 

- **행동**
  - 무작위로 중복되지 않은 6개의 번호를 생성하여 반환한다.

### 4. 유저 계좌 

- **행동**
  - 구입 금액을 입력받아 구매할 로또 티켓의 개수를 계산한다.
  - 총 당첨금과 구입 금액을 기반으로 수익률을 계산하여 반환한다.
- **상태**
  - 구입 금액: 사용자가 로또를 구매하는 데 사용한 금액.

### 5. 로또 게임 

- **행동**
  - 게임을 실행하고, 당첨 통계를 생성하여 최종 결과를 반환한다.
  - 수익률을 계산한다.
- **상태**
  - 로또 티켓 번들: 사용자가 구매한 로또 티켓 컬렉션.
  - 당첨 번호 및 보너스 번호.
  - 유저 계좌: 구입 금액과 수익률 계산을 관리.

---

## 입출력 요구사항

1. **구입 금액 입력**
  - 구입 금액 입력 전 `"구입금액을 입력해 주세요."` 문구 출력.
  - 구입 금액이 양의 정수가 아니거나 1000으로 나누어 떨어지지 않으면 예외 발생.

2. **구매한 로또 개수 및 번호 내역 출력**
  - 구입 금액에 따라 구매한 로또 개수와 로또 번호 목록을 출력.

3. **당첨 번호 입력**
  - 당첨 번호 입력 전 `"당첨 번호를 입력해 주세요."` 문구 출력.
  - ','로 구분된 6개의 번호가 양의 정수인지, 중복되지 않았는지, 1~45 범위에 있는지 검증.

4. **보너스 번호 입력**
  - 보너스 번호 입력 전 `"보너스 번호를 입력해 주세요."` 문구 출력.
  - 보너스 번호가 양의 정수인지, 1~45 범위에 있는지, 당첨 번호와 중복되지 않았는지 검증.

5. **당첨 내역 출력**
  - 당첨 개수와 등수별 당첨 내역을 출력.
  - 출력 형식 예:
    ```
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    ```

6. **수익률 출력**
  - 수익률을 계산하여, 소수점 첫째 자리에서 반올림하여 출력.
  - 출력 형식 예: `"총 수익률은 62.5%입니다."`

---

## 당첨 조건 및 당첨금

| 등수 | 조건                              | 당첨금         |
|------|----------------------------------|---------------|
| 1등  | 6개 번호 일치                    | 2,000,000,000원 |
| 2등  | 5개 번호 + 보너스 번호 일치       | 30,000,000원   |
| 3등  | 5개 번호 일치                    | 1,500,000원    |
| 4등  | 4개 번호 일치                    | 50,000원       |
| 5등  | 3개 번호 일치                    | 5,000원        |

---

# 구현에 있어서 신경 쓴 점

## 1. 도메인 응집도
도메인이 자기 설명적(self-explanatory) 인지, 즉 스스로의 역할을 명확히 나타내고 있는지에 주안점을 두었습니다. 특히, '로또게임' 도메인은 비교적 할 일이 적어 보일 수 있지만, 이를 유지한 이유는 게임이 당첨 번호, 로또 묶음 등을 소유하고 호출함으로써 각 도메인이 하는 일을 더 쉽게 이해할 수 있도록 하기 위함입니다.

또한, 메서드를 가능한 분리하고, 유사한 책임을 가진 메서드를 모아 하나의 도메인으로 구성하여 응집도를 높였습니다. 이를 통해 확장이나 변경 시 수정 범위를 최소화하려 했습니다.

## 2. 중복 제거
코드와 테스트 코드 작성 후 중복 제거에 많은 신경을 썼습니다. 클래스 내에서 반복되는 메서드나 코드 라인을 찾아내고 이를 리팩토링하여 관리 포인트를 줄이는 것을 목표로 했습니다.

예를 들어, 에러 메시지를 Enum으로 관리하여 아래와 같은 장점을 얻었습니다:

테스트 코드에서 Enum을 통해 쉽게 검증할 수 있음.
확장성: public static 상수보다 Enum을 사용함으로써 유연하게 추가/변경 가능.
```java
public enum ErrorMessage {
INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
DUPLICATED_NUMBERS_IN_LOTTO("로또 번호에 중복된 숫자가 있습니다."),
INVALID_MONEY("구입 금액은 1,000 원 단위여야 합니다"),
NO_LINES_FOUND("입력이 없습니다"),
INVALID_NUMBER_FORMAT("금액 형식이 올바르지 않습니다."),
INVALID_NUMBERS("당첨 번호 형식이 올바르지 않습니다."),
INVALID_SIZE_OF_NUMBERS("당첨 번호는 6개여야 합니다."),
INVALID_NUMBER_RANGE("로또 번호는 1~45 사이의 숫자여야 합니다."),
DUPLICATED_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
```

여기서, [ERROR] 접두사를 추가하는 요구사항이 있었습니다. 각 메시지에서 개별적으로 "[ERROR]"를 붙이기보다, Enum 내부에서 일괄적으로 적용하여 일관성을 유지하고 관리 포인트를 줄였습니다.

```java
public class InputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String PROMPT_MONEY = "구입금액을 입력해 주세요.";
    private static final String PROMPT_WINNING_NUMBERS = LINE_SEPARATOR + "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = LINE_SEPARATOR + "보너스 번호를 입력해 주세요.";

    private InputView() {
        throw new UnsupportedOperationException();
    }

    public static String getMoney() {
        System.out.println(PROMPT_MONEY);
        return getValidatedInput(InputValidator::validateMoneyInput);
    }

    public static String getWinningNumbers() {
        System.out.println(PROMPT_WINNING_NUMBERS);
        return getValidatedInput(InputValidator::validateLottoNumbersInput);
    }

    public static String getBonusNumber(List<Integer> winningNumbers) {
        System.out.println(PROMPT_BONUS_NUMBER);
        return getValidatedInput(input -> InputValidator.validateBonusNumberInput(input, winningNumbers));
    }

    private static String getValidatedInput(Consumer<String> validator) {
        String input = readLine();
        try {
            validator.accept(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidatedInput(validator);
        }
    }

    private static String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            System.out.println(ErrorMessage.NO_LINES_FOUND.getMessage());
            throw new NoSuchElementException(ErrorMessage.NO_LINES_FOUND.getMessage());
        }
    }
}
```

해당 클래스의 "getValidatedInput" 메서드도 같은 맥락입니다.

요구 사항 중 "사용자가 잘못된 값을 입력할 경우 ... 그 부분부터 입력을 다시 받는다." 라는 것이 있습니다.
이에 따라, 검증 해야 할 제약 사항이 더 많아지더라도 유연하게 확장 가능하며, 메서드마다 재귀/while 문을 사용하지 않고 한 곳에서 처리했습니다. (FunctionalInterface를 사용했습니다)

## 3. 확장성과 복잡도 관리
객체지향 설계는 종종 복잡성을 증가시키기 때문에, 그 복잡도를 관리하는 데 초점을 맞췄습니다. 이에 따라 과도한 디자인 패턴이나 커스텀 DI Factory 등을 사용하지 않고, 기본적인 객체 지향 원칙을 유지했습니다.

특히, 클래스의 수를 최소화하고, 각 도메인의 코드 길이를 약 50라인 내외로 유지하여 코드의 흐름을 따라가기 쉽게 작성했습니다.
