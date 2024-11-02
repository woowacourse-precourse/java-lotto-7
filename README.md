# java-lotto-precourse

## 목차

1. [학습 목표](#학습-목표)
2. [과제 요구 사항](#과제-요구-사항)
3. [패키지 구조](#패키지-구조)
4. [테스트 코드](#테스트-코드)

## 학습 목표

- 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
- 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.
- 2주 차 공통 피드백을 최대한 반영한다.

## 과제 요구 사항

### 주의 사항

> 1. 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 **추가**한다.
> 2. **Git의 커밋 단위**는 앞 단계에서 README.md에 정리한 **기능 목록 단위로 추가**한다.

**과제 진행 요구 사항**에 따라 첫 Commit(docs: 요구사항 명세 및 Docs 작성) 이후,<br>
후술할 기능 목록 각각을 단위로 Commit한다.

> 📝 **과제에 대한 자세한 설명은 [ASSIGNMENT.md](docs/ASSIGNMENT.md)에서 확인할 수 있습니다.**

### 📝 기능 목록

프리코스 3주차 과제는 "로또 게임"입니다.<br>
해당 과제의 기능을 분석한 "기능 목록"은 다음과 같습니다.<br>
기능 목록은 다음과 같이 프로젝트 마일스톤을 기반으로 나누어 작성했습니다.

**Milestone 1: 로또 구입 🎰**

- [x] | `구입 금액` 입력
- [x] | 입력된 `구입 금액` 을 객체로 저장
- [x] | 공통 검증기들을 조합하여 입력값을 순차적으로 검증
- [x] | 입력된 `구입 금액`이 1,000원으로 나누어 떨어지는지 검증
- [x] | 잘못된 입력 시 재입력 요청
- [x] | `구입 금액`에 해당하는 `로또` 구매
- [x] | 발행된 `로또` 수량 및 번호를 출력
- [x] | `로또`의 `번호`를 오름차순으로 정렬
- [x] | 로또 구입 테스트 코드 추가

**Milestone 2: 당첨 번호 관리 📂**

- [x] | `당첨 번호` 입력
- [x] | 입력된 `당첨 번호`를 쉼표(,) 기준으로 파싱
- [x] | 입력된 `당첨 번호`의 `공통 예외 입력` 검증
- [x] | 입력된 `당첨 번호`가 1~45 범위 내 숫자인지 검증
- [x] | `보너스 번호` 입력
- [x] | 입력된 `보너스 번호`와 `당첨 번호`의 중복 검증
- [x] | 당첨 번호 관리 테스트 코드 추가

**Milestone 3: 당첨 결과 처리 🎁**

- [x] | 당첨된 `로또`를 `당첨 내역`에 추가
- [x] | `당첨 내역` 출력
- [x] | `당첨 내역`으로부터 `수익률` 계산
- [ ] | `수익률` 출력
- [ ] | 당첨 결과 처리 테스트 코드 추가

### ⚠️ 예외 처리 상세

예외 처리는 기능 요구 사항에 따라 다음 기준을 준수한다.
> 사용자가 잘못된 값을 입력할 경우 **IllegalArgumentException**을 발생시키고,<br>
> "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 **입력을 다시 받는다.**<br>
> Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 **명확한 유형**을 처리한다.

- `공통 예외 입력`에 대한 IllegalArgumentException
    - [x] | 입력값이 빈칸이거나 공백인 경우
    - [x] | 입력값이 양의 정수가 아닌 경우
        - 이때, 입력값이 앞뒤로 공백이 있는 경우는 예외 처리하지 않는다. (ex. "1000 ", "1 , 2 , 3")<br>
          이 경우, 과제 요구사항에 직접적으로 명시되지 않았기에 이와 같이 처리했다. <br>
          사용자가 단어를 완성할 때 습관적으로 띄어쓰기를 사용하는 경우도 있을 수 있기 때문이다.<br>
          하지만 위와 같이 "100 0"와 "1 1,2"와 같이 의미적으로 잘못 판단 될 수 있는 경우는 **예외 처리**가 되어야한다.<br>
          **(이 경우, 양의 정수가 아닌 경우에 대한 에 대한 IllegalArgumentException에 포함된다.)**<br>
          이에 기반하여, 사용자의 편의성을 고려하여 예외처리를 세분화했다.


- `구입 금액`에 대한 IllegalArgumentException
    - [x] | 입력된 `구입 금액`이 1000원으로 나누어 떨어지는지지 않을 경우

- `로또 번호`에 대한 IllegalArgumentException
    - [x] | 입력된 `당첨 번호`가 1~45 범위 외인 경우
    - [x] | `당첨 번호` 등록 시 중복된 숫자가 있을 경우

- `보너스 번호`에 대한 IllegalArgumentException
    - [x] | 입력된 `보너스 번호`가 당첨 번호와 중복되는 경우

## 패키지 구조

```
 lotto/
    ├── common/                             # 공통 유틸리티 패키지
    │   ├── constant/                           # 상수 관련 패키지
    │   └── util/                               # 유틸리티 클래스 패키지
    ├── controller/                         # 컨트롤러 패키지
    ├── domain/                             # 도메인 패키지
    │   ├── entity/                         # 핵심 엔티티 패키지
    │   │   └── Lotto.java                      # 로또 티켓 엔티티
    │   ├── factory/                        # 엔티티의 팩토리 패키지
    │   ├── validator/                      # 입력값 검증 패키지
    │   │   ├── CompositeValidator.java         # 복합 검증 클래스
    │   │   └── InputValidator.java             # 입력값 검증 인터페이스
    │   └── vo/                             # Value Object 패키지
    ├── view/                               # 사용자 인터페이스 패키지
    └── Application.java                    # 프로그램 시작점
```

*신경 쓴 클래스의 경우엔 위 목록에 추가로 표시하였습니다.*

- 전통적인 MVC 패턴의 Model 영역을 DDD의 도메인 계층으로 구현했습니다. <br>
  이를 통해 사용자 인터페이스(View)와 제어 흐름(Controller)은 MVC 패턴을 따르되, <br>
  비즈니스 로직은 DDD의 도메인 주도 설계 원칙에 따라 구현했습니다.

## 테스트 코드

> - 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.
> - 2주 차 공통 피드백을 최대한 반영한다.

두 학습 목표를 달성하기 위해, 다음과 같은 테스트 코드 작성 기준을 준수합니다.

> 실제 클래스와 **1:1로 대응되는 테스트 클래스**를 만들어 해당 클래스의 모든 **기능과 예외 상황을 테스트**한다.<br>
> 또한, 이와 별도로 **학습 테스트 패키지를 분리**하여 프로젝트에서 사용할 기술이나 라이브러리의 동작을<br>
> 이해하고 검증하기 위한 테스트 코드를 기술/라이브러리 종류별로 패키지화하여 관리한다.

이때 프로그래밍 요구 사항 3에 따라 UI 로직에 대한 검증은 제외한다.
> 💡 **단, UI(System.out, System.in, Scanner) 로직은 제외한다.**

이에 따라, 추가된 테스트 코드 목록은 다음과 같습니다.

## 🧪 단위 테스트

### 📂 common/exception/

- **ErrorMessagesTest**

- [x] | 에러메세지는 반드시 접두사([ERROR])를 포함한다

### 📂 common/util/

- **RandomsWrapperTest**

- [x] | RandomsWrapper.getInt는 1~45내 숫자를 반환한다

### 📂 controller/

- **LottoControllerTest**

- [x] | 5000원으로 로또 구매 시 5개의 로또를 발급한다
- [x] | 1000원으로 나누어떨어지지 않는 금액 입력 시 에러가 발생하고 재입력을 받는다
- [x] | 숫자가 아닌 입력 시 에러가 발생하고 재입력을 받는다
- [x] | 0원 이하의 금액 입력 시 에러가 발생하고 재입력을 받는다
- [x] | 중복된 당첨 번호 입력시 에러가 발생하고 재입력을 받는다
- [x] | 당첨 번호와 중복된 보너스 번호 입력시 에러가 발생하고 재입력을 받는다

### 📂 domain/entity

- **LottoTest**

- [x] | 로또 번호는 자동으로 오름차순 정렬된다
- [x] | 로또 번호가 6개가 아닌 경우 예외가 발생한다
- [x] | 로또 번호에 중복된 숫자가 있는 경우 예외가 발생한다
- [x] | 로또 번호에 공백이 있는 경우 예외가 발생한다

### 📂 domain/factory

- **LottoFactoryTest**

- [x] | 로또 번호들을 자동으로 생성할 수 있다
- [x] | 문자열로 로또를 생성한다

### 📂 domain/validator

- **CompositeValidator**

- [x] | 모든 validator가 검증을 통과하면 예외가 발생하지 않는다
- [x] | 하나의 validator라도 실패하면 예외가 발생한다
- [x] | 빈 validator 리스트로 생성된 경우 검증을 통과한다


- **LottoValidatorTest**

- [x] | 정상적인 임력값은 검증을 통과한다
- [x] | 공백과 정수 검증하여 예외를 발생시킨다
- [x] | 로또 번호 길이 검증하여 예외를 발생시킨다
- [x] | 로또 번호 중복 검증하여 예외를 발생시킨다
- [x] | 로또 번호가 1~45 범위를 벗어났을 경우 예외를 발생시킨다


- **NonBlankValidator**

- [x] | 정상적인 입력값은 검증을 통과한다
- [x] | null 입력값은 예외가 발생한다
- [x] | 빈 문자열은 예외가 발생한다
- [x] | 공백 문자열은 예외가 발생한다


- **NumberFormatValidator**

- [x] | 양의 정수는 검증을 통과한다
- [x] | 양끝에 공백이 포함된 양의 정수도 검증을 통과한다
- [x] | 음수는 예외가 발생한다
- [x] | 0은 예외가 발생한다
- [x] | 소수점이 있는 숫자는 예외가 발생한다
- [x] | 문자가 포함된 입력은 예외가 발생한다

### 📂 domain/vo

- **BonusNumberTest**

- [x] | BonusNumber 선언은 로또 범위 검증을 포함한다

- **LottoNumbersTest**

- [x] | 로또 번호 포함 여부를 판단한다

- **PurchaseAmountTest**

- [x] | 구입 금액을 입력받아 생성할 수 있다
- [x] | 구입 금액으로 구매 가능한 로또 수량을 계산할 수 있다
- [x] | 구입 금액이 1000원 단위가 아닌 경우 예외가 발생한다


- **WalletTest**

- [x] | 구입 금액에 따라 로또를 발급한다
- [x] | 내부의 로또 리스트는 생성 시점에 불변 리스트로 복사되어 저장된다


- **WinningLottoTest**

- [x] | WinningLotto 선언은 공백 검증을 포함한다
- [x] | WinningLotto 선언은 입력값 마지막에 쉼표(,)가 오는 지 검증을 포함한다
- [x] | 당첨 번호와 보너스 번호의 중복 검증한다

## 학습 테스트 📚

### 📗 ParseIntTest

- [x] | Integer.parseInt는 문자열을 정수로 변환한다
- [x] | Integer.parseInt는 숫자가 아닌 문자열에 대해 NumberFormatException을 발생시킨다

### 📘 RecodeTest

- [x] | Record는 getter 메서드를 자동으로 생성한다
- [x] | Record는 equals와 hashCode를 자동으로 구현한다

### 📙 StreamTest

- [x] | Stream의 sorted()로 리스트의 정수를 정렬할 수 있다

### 📗 RandomsTest

- [x] | pickNumberInRange는 지정된 범위 내의 난수를 생성한다
- [x] | pickNumberInRange는 최솟값과 최댓값을 포함한다
- [x] | pickNumberInRange는 최솟값과 최댓값을 같아도 작동한다
- [x] | pickNumberInRange는 범위 지정이 잘못되면 예외가 발생한다

---



[🔝 맨 위로 돌아가기](#java-lotto-precourse)