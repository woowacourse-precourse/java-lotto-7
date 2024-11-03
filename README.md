# 3주차 프리코스 - 로또 만들기

## 프로그래밍 요구 사항

### 요구 사항 1
- **JDK 21** 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 **Application의 main()**이다.
- `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 **외부 라이브러리 사용 금지**.
- 프로그램 종료 시 **System.exit() 호출 금지**.
- 별도 명시가 없는 한 **파일, 패키지 등의 이름을 변경하거나 이동하지 않는다**.
- **Java 코드 컨벤션**에 맞게 작성한다. 기본적으로 **Java Style Guide**를 준수한다.

### 요구 사항 2
- **Indent(인덴트, 들여쓰기) depth는 2까지만 허용**하며, 3 이상 사용 금지.
    - 예: `while`문 안에 `if`문이 있는 경우 들여쓰기는 2.
    - 힌트: 인덴트 depth를 줄이기 위해 **함수(또는 메서드)로 분리**.
- **3항 연산자 사용 금지**.
- 함수(또는 메서드)는 **한 가지 일만 하도록 최대한 작게 작성**.
- **JUnit 5와 AssertJ**를 이용하여 작성한 기능 목록이 정상적으로 작동하는지 **테스트 코드로 확인**.
    - 테스트 도구가 익숙하지 않다면 아래 문서를 참고하여 학습 후 테스트 구현.
    - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
    - [AssertJ User Guide](https://assertj.github.io/doc/)
    - [AssertJ Exception Assertions](https://assertj.github.io/doc/#assertj-exception-assertions)
    - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### 요구 사항 3
- 함수(또는 메서드)의 **길이는 15라인을 넘지 않도록 구현**.
- 함수(또는 메서드)가 **한 가지 일만 하도록 구현**.
- **else 예약어를 사용하지 않는다**.
    - `else` 대신, **if 조건절에서 값을 return**하는 방식으로 구현.
    - `switch/case` 사용도 허용하지 않는다.
- **Java Enum**을 적용하여 프로그램 구현.
- **구현한 기능에 대한 단위 테스트 작성** (UI(System.out, System.in, Scanner) 로직 제외).
    - 단위 테스트 작성이 익숙하지 않다면 `LottoTest`를 참고하여 학습 후 테스트 작성.

---

## 기능 요구 사항

간단한 로또 발매기를 구현한다.

1. **로또 번호의 숫자 범위는 1~45**까지이다.
2. **1개의 로또 발행 시 중복되지 않는 6개의 숫자**를 뽑는다.
3. **당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개**를 뽑는다.
4. **당첨은 1등부터 5등까지** 있다.
    - **당첨 기준 및 상금**
        - **1등**: 6개 번호 일치 / **2,000,000,000원**
        - **2등**: 5개 번호 + 보너스 번호 일치 / **30,000,000원**
        - **3등**: 5개 번호 일치 / **1,500,000원**
        - **4등**: 4개 번호 일치 / **50,000원**
        - **5등**: 3개 번호 일치 / **5,000원**
5. **로또 구입 금액**을 입력하면 구입 금액에 해당하는 **만큼 로또를 발행**.
    - **로또 1장 가격은 1,000원**.
6. **당첨 번호와 보너스 번호를 입력**받는다.
7. **사용자가 구매한 로또 번호와 당첨 번호를 비교**하여 당첨 내역 및 **수익률을 출력** 후 로또 게임 종료.
8. **잘못된 값 입력 시 IllegalArgumentException 발생**:
    - "[ERROR]"로 시작하는 에러 메시지를 출력 후 해당 부분부터 **입력을 다시 받는다**.
    - **Exception이 아닌 명확한 예외 유형**인 `IllegalArgumentException`, `IllegalStateException` 등 처리.

    


## 클래스 개요

### `Consumer` (엔티티)
사용자 입력을 처리하고 구매 금액을 검증하며, 로또 티켓을 생성하고 정보를 제공합니다.

- **필드**
    - `totalLottoCost`: 사용자가 로또 티켓에 지불한 총 금액.
    - `lottoCount`: 총 금액을 기준으로 구매한 티켓 수.
    - `lottoTickets`: 생성된 로또 티켓 목록.

- **메서드**
    - `inputTotalLottoCost()`: 사용자에게 구매 금액을 입력받고 검증합니다.
    - `calculateLottoCount(int)`: 총 금액을 기준으로 티켓 수를 계산합니다.
    - `validateTotalLottoCost(int)`: 금액이 1,000원 단위인지 확인합니다.
    - `generateLottoTickets()`: `lottoCount`만큼 로또 티켓을 생성합니다.
    - `generateSingleTicket()`: 단일 로또 티켓(번호 6개)을 무작위로 생성합니다.
    - `printLottoCount()`: 구매한 티켓 수를 출력합니다.
    - `printLottoTickets()`: 구매한 티켓 번호를 출력합니다.

### `LottoYieldCalculator` (엔티티)
사용자가 투자한 금액과 당첨금액을 기준으로 수익률을 계산합니다.

- **필드**
    - `totalInvestment`: 사용자가 로또 구매에 투자한 총 금액.
    - `totalPrize`: 누적된 당첨 금액.

- **메서드**
    - `addPrize(long)`: 당첨된 금액을 누적합니다.
    - `calculateYield()`: 수익률을 계산하여 반환합니다.
    - `printYield()`: 수익률을 소수점 첫째 자리까지 출력합니다.

### `Rank` (열거형)
로또 당첨 등급을 나타내며, 각 등급에 대한 일치 번호 개수, 보너스 필요 여부, 상금을 정의합니다.

- **필드**
    - `matchCount`: 해당 등급의 일치 번호 개수.
    - `hasBonus`: 보너스 번호 필요 여부.
    - `prize`: 해당 등급의 상금.
    - `criteria`: 등급을 결정하는 조건을 정의하는 `BiPredicate`.

- **메서드**
    - `getRank(int, boolean)`: 일치 번호 개수와 보너스 일치 여부를 기준으로 등급을 반환합니다.
    - `getPrize()`: 해당 등급의 상금을 반환합니다.

### `WinningLotto` (엔티티)
당첨 로또 번호와 보너스 번호를 저장하고, 사용자의 로또 번호와 비교하여 당첨 등급을 판정합니다.

- **필드**
    - `winningNumbers`: 당첨 번호 집합.
    - `bonusNumber`: 보너스 번호.

- **메서드**
    - `getRank(Set<Integer>)`: 사용자의 번호와 비교하여 일치 개수를 계산하고, 보너스 번호 포함 여부에 따라 등급을 반환합니다.
    - `printWinningStatistics(int[])`: 각 등급별 당첨 개수를 출력합니다.

### `Lotto` (엔티티)
로또 번호와 보너스 번호를 관리하고, 랜덤으로 번호를 생성합니다.

- **필드**
    - `numbers`: 로또 번호 목록.
    - `bonusNumber`: 보너스 번호.

- **메서드**
    - `generateRandomLotto()`: 무작위로 로또 번호와 보너스 번호를 생성하여 반환합니다.
    - `validate(List<Integer>, int)`: 로또 번호와 보너스 번호의 유효성을 검증합니다.
    - `getWinningNumbers()`: 사용자로부터 당첨 번호를 입력받아 반환합니다.
    - `getBonusNumberInput()`: 사용자로부터 보너스 번호를 입력받아 반환합니다.

### `Application` (메인 클래스)
프로그램의 실행 흐름을 관리합니다. 사용자의 티켓을 생성하고, 당첨 번호와 비교하여 당첨 통계를 출력하고 수익률을 계산합니다.

- **메서드**
    - `main(String[])`: 애플리케이션의 시작점으로, 각 클래스를 호출하여 로또 시뮬레이션을 진행합니다.
    - `calculateMatchCounts(List<List<Integer>>, WinningLotto, LottoYieldCalculator)`: 각 티켓과 당첨 번호를 비교하여 일치 개수를 계산하고 등급별로 통계를 생성합니다.
