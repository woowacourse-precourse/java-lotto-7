
# 개인 체크리스트
> 1주차~2주차의 개선점을 바탕으로 세운 개인적인 목표를 반영한 체크리스트입니다.

## 🏁 과제 전반 체크리스트

- [x]  `과제의 기본 요구사항 충족`을 최우선으로 1차 구현한다.
    > <span style="color:yellowgreen">🔎 `Application.java`, `Lotto.java`, `Rank.java` 세개의 클래스로 1차 구현을 완료했습니다.</span>
- [x]  `학습목표 충족`을 최우선으로 리팩토링한다.
- [x]  1주차, 2주차 공통피드백을 모두 충족시킨다.
- [x]  “~이 좋다더라”, “~하면 안된다더라” 와 같은 **단정짓는 생각을 지양하고 상황에 따른 판단을 한다.**
    > <span style="color:yellowgreen">🔎 코드 리뷰 과정에서 단순히 `보통 이렇게 하니까 이렇게 해보세요`, `이렇게 하는 건 MVC패턴에 위반돼요` 와 같은 단정적인 리뷰를 그대로 수용하거나, 제가 쓴 적이 많았습니다.</span>
  <br><span style="color:yellowgreen">🔎 단정적인 생각을 지양하도록, 논의의 여지가 있는 코드에 대한 판단 이유를 노션에 메모하며 구현했습니다.</span>
- [x]  책임을 최대한 섬세하게 나누되, 각각의 클래스와 메서드의 역할이 분명하도록 한다.
    > <span style="color:yellowgreen">🔎 2주차 과제 리뷰를 통해 가장 반성한 점입니다.</span>
  <br><span style="color:yellowgreen">🔎 클래스나 메서드의 양을 최소화하는 것에 부담을 느끼지 않고, 오히려 아주 섬세하게 나눠서 객체 간의 협력 구조가 섬세하게 드러나는 것을 목표로 진행했습니다.</span>
- [x]  `스태틱 메서드`와 `싱글톤 패턴`을 구분해서 사용한다.
- [x]  읽는 사람이 `두 번 생각하게 하는 로직은 지양`한다.
- [x]  작은 것이라도 `축약하지 않는다`.
- [x]  조건문에 `부정연산자 사용을 지양`한다.
- [x]  `주석을 사용하지 않는다`. 사용할 상황이어도 최대한 코드를 활용해 문서화한다.
    > <span style="color:yellowgreen">🔎 코드의 가독성을 높이기 위해선 `코드를 문서처럼 작성하는 것`이 중요함을 깨달았습니다.</span>
  <br><span style="color:yellowgreen">🔎 주석 지양 외에도 변수명, 메서드명을 잘 짓거나, ENUM에서 카테고리를 설명하는 필드를 추가하면서 문서화를 진행했습니다.</span>

## 📑 문서 체크리스트

- [x]  리드미에 기능구현목록 뿐만 아니라 `프로젝트 소개`도 작성하여 프로젝트를 잘 드러낸다.
- [x]  `리드미`와 `체크리스트`를 분리해서 작성한다.
    > <span style="color:yellowgreen">🔎 2주차 과제에서 체크리스트를 리드미에 작성했는데, 리드미의 가독성이 떨어진다고 판단이 들어 파일을 분리했습니다.</span>
- [x]  리드미를 수정할 일이 있다면 `변경 이력`을 함께 작성한다.
    > <span style="color:yellowgreen">🔎 리드미를 더욱 살아있는 문서로 만들기 위해 `docs/REAME_CHANGELOG.md`에 변경 이력을 작성했습니다.</span>

## 🛠️ 리팩토링 체크리스트

- [x]  1차 구현 이후, `일급 개념`이 어떤 것이 될 수 있는지 체크한다.
    > <span style="color:yellowgreen">🔎 2주차 과제 리뷰에서 배운 점으로, 일급 개념을 명확히 해야 각 개념 별 책임 분리도 쉬워지고 코드 이해도 쉬워짐을 느꼈습니다.</span>
  <br><span style="color:yellowgreen">🔎 이번 과제의 일급 개념은 `로또 번호`와 `당첨 번호`로 나누었습니다.</span>
  <br><span style="color:yellowgreen">✏️ 그러나 리팩토링의 거의 마무리 단계에서 일급 개념이 확정된 것이 아쉽습니다. 클래스의 관계를 파악하는 눈을 더 기를 것입니다.</span>
- [x]  1차 구현 이후, 클래스다이어그램을 사용해 `상속, 구현, 의존, 연관, 합성관계`를 표시한다.
- [x]  리팩토링 시 `관련 함수를 묶어` 클래스를 만들고, `객체들이 협력하여` 하나의 큰 기능을 수행하도록 한다.
    > <span style="color:yellowgreen">🔎 1차 구현에서는 표면적 요구사항의 충족을 최우선으로 하고, 리팩토링부터는 객체 지향 프로그래밍을 최우선 목표로 두었습니다.</span>
- [x]  **리팩토링 구현 과정에서 진행이 어렵다면, 항상 책임 분리를 더 할 수 있는지 체크한다.**
    > <span style="color:yellowgreen">🔎 2주차 과제 리뷰에서 깨달은 가장 중요한 점입니다. </span>
  <br><span style="color:yellowgreen">🔎 코드를 짜다가 `불편한 점이 생기면, 이는 책임을 더 분리해야 한다는 신호`임을 깨달아, 의식적으로 이 생각을 하며 구현습니다.</span>
  <br><span style="color:yellowgreen">🔎 코드 짜기 불편하다는 생각이 들 때마다 클래스를 분리했고, 목표했던 `섬세한 책임 분리`에 큰 도움이 되었다고 생각합니다.</span>
- [x]  `의존성`이 발생할 때마다 `추상화`를 고려한다. 이후 추상화를 하면 `의존성 주입`을 고려한다.
    > <span style="color:yellowgreen">🔎 이 역시 지난 과제에서 많이 반성한 점 중 하나입니다. </span>
  <br><span style="color:yellowgreen">🔎 의존성 관리가 필요한 이유를 제대로 학습하지 못하고 의존성 관리를 도입한 점이 아쉬웠습니다.</span>
  <br><span style="color:yellowgreen">🔎 따라서 이번 과제 전 [의존성과 추상화의 관계, 의존성 주입을 통한 관리](https://velog.io/@joychae714/%ED%95%99%EC%8A%B5%EC%A0%95%EB%A6%AC-%EC%9D%98%EC%A1%B4%EC%84%B1-%EA%B4%80%EB%A6%AC-%ED%8C%A9%ED%86%A0%EB%A6%AC-%ED%8C%A8%ED%84%B4-AppConfig-%EC%95%8C%EA%B3%A0-%EC%93%B0%EC%9E%90)
  에 대해 학습하고 구현을 시작했습니다.</span>
  <br><span style="color:yellowgreen">🔎 이를 반영하여 `RankDelimiter`, `NumberPicker`, `NumberGenerator`, `LottoMachine` 인터페이스를 만들어 의존성을 완화하고, `DependencyConfig`를 만들어 의존성을 관리했습니다.</span>
  <br><span style="color:yellowgreen">✏️ 많은 고민을 하며 인터페이스를 도입했지만, 프로젝트의 확장성이 없어 인터페이스의 효용을 잘 실감하지 못했다는 점이 많이 아쉽습니다.</span>
  <br><span style="color:yellowgreen">✏️ 추상화가 어떻게 객체 지향에 기여할지 계속해서 학습하고 도입해볼 계획입니다.</span>
- [x]  `인터페이스`를 적절한 위치에 도입하고, 도입한 이유를 글로 작성한다.

## 🩺 검증로직 체크리스트

- [x]  검증이 가능한 시점(뷰or도메인)에서 `바로 검증`한다.
    > <span style="color:yellowgreen">🔎 한 시점에 모두 검증을 하지 않고, 비슷한 로직끼리 묶어 검증 시점을 여러 개로 나누었습니다.</span>
  <br><span style="color:yellowgreen">🔎 뷰 : 입력받은 시점에서 가장 기본적인 형태 검사 - 빈값인지, 정수인지 등</span>
  <br><span style="color:yellowgreen">🔎 도메인 : 비즈니스 로직 관련된 검사 (하나의 도메인만 사용한다면 해당 모델 안에서, 복합적으로 사용하면 서비스 단에서 검증 실시)</span>
- [x]  도메인단에서 검증할 경우 `도메인 내에서` 검증 여부가 확인되도록 한다.
    > <span style="color:yellowgreen">🔎 모델의 생성자 내부에 `validate()` 메서드를 두어, 생성 전 검증을 마침을 보장했습니다.</span>

## 🧪 테스트 체크리스트

- [x]  TDD로 테스트를 개발에 이용한다. 매번 기능을 만들고 `테스트를 통과한 뒤에 다음 구현으로 넘어간다`.
- [x]  테스트 구현 과정에서 `제어할 수 없는 요소`가 발생해 진행이 어렵다면, 항상 `책임 분리`를 더 할 수 있는지 체크한다.
- [x]  변수명, 상수 활용 등을 통해서 테스트 케이스로 사용한 문자열, 넘버 역시 `의미를 최대한 표현`한다.
    > <span style="color:yellowgreen">🔎 특히, 예외 케이스 테스트의 경우 변수가 어떤 이유로 잘못된 변수인지를 `변수명`을 통해 표현했습니다.</span>
- [x]  DisplayName을 사용하여 `테스트의 문서화`를 강화한다.
    > <span style="color:yellowgreen">🔎 DisplayName 앞에 `[success]`, `[fail]`을 작성해 테스트 유형을 나누었습니다.</span>
  <br><span style="color:yellowgreen">🔎 `LotteryNumberValidatorTest`의 경우 정해진 예외 유형을 DisplayName으로 명시했습니다.</span>
  <br><span style="color:yellowgreen">🔎 `RandomNumberPickerTest`의 경우 외부 모듈의 기능을 설명하는 문서 역할이 중요한 테스트라서 DisplayName을 통해 기능을 명시했습니다.</span>
- [x]  중복되는 로직은 `리팩토링`한다.
    > <span style="color:yellowgreen">🔎 지난 과제에서 테스트를 1차 작성한 이후로 리팩토링을 많이 하지 않았던 점을 반성했습니다.</span>
  <br><span style="color:yellowgreen">🔎 중복 로직은 따로 메서드로 분리하여 모두 제거했습니다.</span>
- [x]  모든 `퍼블릭 메서드와 클래스`를 테스트대상으로 한다.
