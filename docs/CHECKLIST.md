# 과제 기본 요구사항 체크리스트
> 과제 페이지에 명시된 기본 요구사항을 반영한 체크리스트입니다.
## ✅ 학습 목표
- [x]  관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
- [x]  클래스/함수에 대한 단위테스트를 통해 의도한대로 정확하게 작동하는 영역을 확보한다.
- [x]  2주차 공통 피드백을 최대한 반영한다.

## ✅ 과제 진행 요구 사항
- [x]  기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- [x]  README.md의 기능목록 단위로 커밋한다.
  <br><span style="color:yellowgreen">🔎 1차 구현부터 기능 목록 단위로 커밋했으며, 리팩토링 이후로는 리팩토링이 수정한 기능 단위로 커밋했습니다.</span>

## ✅ 프로그래밍 요구 사항

- [x]  JDK21 버전에서 실행 가능하다.
- [x]  build.gradle 파일을 변경하지 않는다.
- [x]  프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [x]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [x]  자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [x]  인덴트 뎁스를 2까지만 구현한다.
- [x]  3항 연산자를 쓰지 않는다.
- [x]  메서드가 한 가지 일만 하도록 최대한 작게 만든다.
- [x]  JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
  <br><span style="color:yellowgreen">🔎 특히 `assertj.Assertions`의 모듈을 다양하게 학습하고 적용해보았습니다.</span>
  <br><span style="color:yellowgreen">🔎 `ParameterizedTest의 @MethodSource, @CsvSource`, `@BeforeAll` 등을 배워 적용하자 테스트 난이도가 훨씬 낮아졌습니다.</span>
- [x]  메서드의 길이가 15라인을 넘어가지 않도록 구현한다.
- [x]  else 예약어, switch/case를 사용하지 않는다.
- [x]  Java Enum을 적용한다.
  <br><span style="color:yellowgreen">🔎 1~5등 상태 그리고 당첨되지 않은 상태를 관리하기 위해 `Rank`라는 ENUM 클래스를 만들었습니다.</span>
  <br><span style="color:yellowgreen">🔎 상태 관리가 매우 쉽고, 상태 자체를 관리하는 클래스와 상태를 활용하여 비즈니스 로직을 실행하는 것이 용이해졌습니다.</span>
  <br><span style="color:yellowgreen">✏️ 다만, ENUM 클래스이다보니 객체를 참조하는 것이 매우 열려있었는데, 이를 어디까지 열어도 될지 고민을 했습니다.</span>
- [x]  구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(`System.out`,`System.in`, `Scanner`) 로직은 제외한다.
- [x]  제공된 Lotto 클래스를 사용하여 구현한다.
    - [x]  `Lotto`에 `numbers`이외의 필드(인스턴스 변수)를 추가하지 않는다.
    - [x]  `numbers`의 접근 제어자인`private`은 변경하지 않는다.


## ✅ 2주차 공통피드백

- [ ]  README를 작성할 때 프로젝트의 소개를 목적으로 상세히 작성한다.
- [x]  기능 목록에 기술적인 내용은 배제한다.
- [x]  기능 목록에 정상적인 경우와 예외상황을 모두 명시한다.
  <br><span style="color:yellowgreen">🔎 기능 목록 표에서 정상 흐름을 설명하는 [세부기능]과, 예외상황을 처리하는 [예외흐름]을 나누어 작성했습니다.</span>
- [x]  기능 목록을 지속적으로 업데이트한다.
  <br><span style="color:yellowgreen">🔎 `docs/README_CHANGELOG.md`를 만들어 리드미 변경 시 변경 이력과 변경 이유를 설명해서, 더욱 살아있는 문서로 만들었습니다.</span>
- [x]  문자열이나 숫자 값을 하드 코딩하지 않는다.
  <br><span style="color:yellowgreen">🔎 숫자나 문자열 자체로 의미가 읽기 어렵고 변경 가능성이 있는 매직 넘버, 매직 리터럴을 상수처리했습니다.</span>
  <br><span style="color:yellowgreen">🔎 그러나, 콘솔 출력 문자열의 경우 상수로 바꾸면 가독성이 안 좋아져서 상수화하지 않았습니다.</span>
  <br><span style="color:yellowgreen">🔎 대신 `String.format()`을 사용해 정적 문자열을 통합하고, 수정이 쉽도록 만들었습니다.</span>
- [x]  상수-멤버변수-생성자-메서드 순의 코딩 컨벤션을 지키고, 메서드는 논리적인 이유로 정렬한다.
  <br><span style="color:yellowgreen">🔎 코딩 컨벤션을 지키고, 메서드의 경우 `public 메서드 > 호출 순으로 private 메서드 > getter` 순으로 정렬했습니다.</span>
- [x]  변수 이름에 자료형을 사용하지 않는다.
  <br><span style="color:yellowgreen">🔎 모든 메인 코드 변수 이름에 자료형을 사용하지 않았습니다.</span>
  <br><span style="color:yellowgreen">🔎 그러나 자료형 자체가 중요한 common/Converter와 몇가지 테스트 메서드는 자료형을 사용해 의미를 강조했습니다.</span>
- [x]  한 메서드가 한 가지 기능만 담당하게 한다.
- [x]  메서드가 한 가지 기능을 하는지 확인하는 나만의 기준을 만든다.
  <br><span style="color:yellowgreen">🔎 `단위 테스트를 만들 때 불편함이 없는가?` 즉 `단위 테스트의 대상만 테스트 데이터로 생성해도 테스트가 가능한가?` 를 기준으로 메서드를 계속해서 분리했습니다.</span>
  <br><span style="color:yellowgreen">✏️ 아직은 하나의 테스트를 위해 너무 많은 객체를 생성하는 테스트도 있어서, 역할 분리가 더 필요하다고 느끼는 지점도 있습니다.</span>
- [x]  학습테스트를 통해 JUnit을 학습한다.
  <br><span style="color:yellowgreen">🔎 구현을 시작하기 이전에, 공통 피드백에서 제공됐던 학습 테스트 자료를 통해 학습을 진행했습니다.</span>
  <br><span style="color:yellowgreen">🔎 학습한 코드는 `test/java/study`에 있습니다.</span>
- [ ]  [테스트를 작성하는 이유](#테스트를-작성하는-이유)에 대해 정리하고 디스코드에 공유해본다.
- [x]  테스트를 메서드 등의 작은 단위부터 만든다.
  <br><span style="color:yellowgreen">🔎 1차 구현때는 기능목록의 세부 기능 기준으로 테스트를 만들었습니다.</span>
  <br><span style="color:yellowgreen">🔎 이후 리팩토링하면서 메서드가 늘어나고, 리팩토링이 어느정도 완료된 이후 모든 public 메서드에 대해 테스트를 작성했습니다.</span>
  <br><span style="color:yellowgreen">✏️ 그러나 리팩토링 과정에서는 항상 메서드의 성능을 어느정도 확인 한 이후, 뒤늦게 테스트를 작성한 적이 많았습니다.
<br>아직 테스트를 바로 작성하는 습관이 들지 않아서 다소 아쉬웠습니다.</span>

<br>

## ✏️테스트를 작성하는 이유

---

# 개인 체크리스트
> 1주차~2주차의 개선점을 바탕으로 세운 개인적인 목표를 반영한 체크리스트입니다.

## 🏁 과제 전반 체크리스트

- [x]  `과제의 기본 요구사항 충족`을 최우선으로 1차 구현한다.
- [x]  `학습목표 충족`을 최우선으로 리팩토링한다.
- [x]  1주차, 2주차 공통피드백을 모두 충족시킨다.
- [x]  “~이 좋다더라”, “~하면 안된다더라” 와 같은 **단정짓는 생각을 지양하고 상황에 따른 판단을 한다.**
  <br><span style="color:yellowgreen">🔎 코드 리뷰 과정에서 단순히 `보통 이렇게 하니까 이렇게 해보세요`, `이렇게 하는 건 MVC패턴에 위반돼요` 와 같은 단정적인 리뷰를 그대로 수용하거나, 제가 쓴 적이 많았습니다.</span>
  <br><span style="color:yellowgreen">🔎 이를 반성하며 단정적인 생각을 절대 하지 않도록, 모든 상황에 대한 판단 이유를 노션에 메모하며 진행했습니다.</span>
- [x]  **책임을 최대한 섬세하게 나누되, 각각의 클래스와 메서드의 역할이 분명하도록 한다.**
  <br><span style="color:yellowgreen">🔎 2주차 과제 리뷰를 통해 가장 반성한 점입니다.</span>
  <br><span style="color:yellowgreen">🔎 클래스나 메서드의 양을 최소화하는 것에 부담을 느끼지 않고, 오히려 아주 섬세하게 나눠서 객체 간의 협력 구조가 섬세하게 드러나는 것을 목표로 진행했습니다.</span>
- [x]  `스태틱 메서드`와 `싱글톤 패턴`을 구분해서 사용한다.
- [x]  읽는 사람이 `두 번 생각하게 하는 로직은 지양`한다.
- [x]  작은 것이라도 `축약하지 않는다`.
- [x]  조건문에 `부정연산자 사용을 지양`한다.
- [x]  `주석을 사용하지 않는다`. 사용할 상황이어도 최대한 코드를 활용해 문서화한다.
  <br><span style="color:yellowgreen">🔎 코드의 가독성을 높이기 위해선 `코드를 문서처럼 작성하는 것`이 중요함을 깨달았습니다.</span>
  <br><span style="color:yellowgreen">🔎 주석 지양 외에도 변수명, 메서드명을 잘 짓거나, ENUM에서 카테고리를 설명하는 필드를 추가하면서 문서화를 진행했습니다.</span>

## 📑 문서 체크리스트

- [ ]  리드미에 기능구현목록 뿐만 아니라 `프로젝트 소개`도 작성하여 프로젝트를 잘 드러낸다.
- [x]  `리드미`와 `체크리스트`를 분리해서 작성한다.
  <br><span style="color:yellowgreen">🔎 1주차 과제에서 체크리스트를 리드미에 작성했는데, 리드미의 가독성이 떨어진다고 판단이 들어 파일을 분리했습니다.</span>
- [x]  리드미를 수정할 일이 있다면 `변경 이력`을 함께 작성한다.
  <br><span style="color:yellowgreen">🔎 리드미를 더욱 살아있는 문서로 만들기 위해 `docs/REAME_CHANGELOG.md`에 변경 이력을 작성했습니다.</span>

## 🛠️ 리팩토링 체크리스트

- [x]  1차 구현 이후, `일급 개념`이 어떤 것이 될 수 있는지 체크한다.
  <br><span style="color:yellowgreen">🔎 2주차 과제 리뷰에서 배운 점으로, 일급 개념을 명확히 해야 각 개념 별 책임 분리도 쉬워지고 코드 이해도 쉬워짐을 느꼈습니다.</span>
  <br><span style="color:yellowgreen">🔎 이번 과제의 일급 개념은 `로또 번호`와 `당첨 번호`로 나누었습니다.</span>
  <br><span style="color:yellowgreen">✏️ 그러나 리팩토링의 거의 마무리 단계에서 일급 개념이 확정된 것이 아쉽습니다. 클래스의 관계를 파악하는 눈을 더 기를 것입니다.</span>
- [ ]  1차 구현 이후, 클래스다이어그램을 사용해 `상속, 구현, 의존, 연관, 합성관계`를 표시한다.
- [x]  리팩토링 시 `관련 함수를 묶어` 클래스를 만들고, `객체들이 협력하여` 하나의 큰 기능을 수행하도록 한다.
  <br><span style="color:yellowgreen">🔎 1차 구현에서는 표면적 요구사항의 충족을 최우선으로 하고, 리팩토링부터는 객체 지향 프로그래밍을 최우선 목표로 두었습니다.</span>
- [x]  **리팩토링 구현 과정에서 진행이 어렵다면, 항상 책임 분리를 더 할 수 있는지 체크한다.**
  <br><span style="color:yellowgreen">🔎 2주차 과제 리뷰에서 깨달은 가장 중요한 점입니다. </span>
  <br><span style="color:yellowgreen">🔎 코드를 짜다가 `불편한 점이 생기면, 이는 책임을 더 분리해야 한다는 신호`임을 깨달아, 의식적으로 이 생각을 하며 구현습니다.</span>
  <br><span style="color:yellowgreen">🔎 코드 짜기 불편하다는 생각이 들 때마다 클래스를 분리했고, 목표했던 `섬세한 책임 분리`에 큰 도움이 되었다고 생각합니다.</span>
- [x]  `의존성`이 발생할 때마다 `추상화`를 고려한다. 이후 추상화를 하면 `의존성 주입`을 고려한다.
  <br><span style="color:yellowgreen">🔎 이 역시 지난 과제에서 많이 반성한 점 중 하나입니다. </span>
  <br><span style="color:yellowgreen">🔎 의존성 관리가 필요한 이유를 제대로 학습하지 못하고 의존성 관리를 도입한 점이 아쉬웠습니다.</span>
  <br><span style="color:yellowgreen">🔎 따라서 이번 과제 전 [의존성과 추상화의 관계, 의존성 주입을 통한 관리](https://velog.io/@joychae714/%ED%95%99%EC%8A%B5%EC%A0%95%EB%A6%AC-%EC%9D%98%EC%A1%B4%EC%84%B1-%EA%B4%80%EB%A6%AC-%ED%8C%A9%ED%86%A0%EB%A6%AC-%ED%8C%A8%ED%84%B4-AppConfig-%EC%95%8C%EA%B3%A0-%EC%93%B0%EC%9E%90)
에 대해 학습하고 구현을 시작했습니다.</span>
  <br><span style="color:yellowgreen">🔎 이를 반영하여 `RankDelimiter`, `NumberPicker`, `NumberGenerator`, `LottoMachine` 인터페이스를 만들어 의존성을 완화하고, `DependencyConfig`를 만들어 의존성을 관리했습니다.</span>
- [x]  `인터페이스`를 적절한 위치에 도입하고, [도입한 이유를 말로 설명한다](#인터페이스를-도입한-위치).

## 🩺 검증로직 체크리스트

- [x]  검증이 가능한 시점(뷰or도메인)에서 `바로 검증`한다.
- [x]  도메인단에서 검증할 경우 `도메인 내에서` 검증 여부가 확인되도록 한다.

## 🧪 테스트 체크리스트

- [x]  TDD로 테스트를 개발에 이용한다. 매번 기능을 만들고 `테스트를 통과한 뒤에 다음 구현으로 넘어간다`.
- [x]  테스트 구현 과정에서 `제어할 수 없는 요소`가 발생해 진행이 어렵다면, 항상 `책임 분리`를 더 할 수 있는지 체크한다.
- [x]  변수명, 상수 활용 등을 통해서 테스트 케이스로 사용한 문자열, 넘버 역시 `의미를 최대한 표현`한다.
  <br><span style="color:yellowgreen">🔎 특히, 예외 케이스 테스트의 경우 변수가 어떤 이유로 잘못된 변수인지를 변수명을 통해 표현했습니다.</span>
- [x]  DisplayName을 사용하여 `테스트의 문서화`를 강화한다.
  <br><span style="color:yellowgreen">🔎 DisplayName 앞에 `[success]`, `[fail]`을 작성해 테스트 유형을 나누었습니다.</span>
  <br><span style="color:yellowgreen">🔎 `LotteryNumberValidatorTest`의 경우 정해진 예외사항을 DisplayName으로 명시했습니다.</span>
  <br><span style="color:yellowgreen">🔎 `RandomNumberPickerTest`의 경우 외부 모듈의 기능을 설명하는 문서 역할이 중요한 테스트라서 DisplayName을 통해 기능을 명시했습니다.</span>
- [x]  중복되는 로직은 `리팩토링`한다.
  <br><span style="color:yellowgreen">🔎 지난 과제에서 테스트를 1차 작성한 이후로 리팩토링을 많이 하지 않았던 점을 반성했습니다.</span>
  <br><span style="color:yellowgreen">🔎 중복 로직은 따로 메서드로 분리하여 모두 제거했습니다.</span>
- [x]  모든 `퍼블릭 메서드와 클래스`를 테스트대상으로 한다.

---

## ✏️인터페이스를 도입한 위치
