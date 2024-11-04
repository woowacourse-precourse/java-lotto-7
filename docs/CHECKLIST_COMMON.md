# 과제 기본 요구사항 체크리스트
> 과제 페이지에 명시된 기본 요구사항을 반영한 체크리스트입니다.
## ✅ 학습 목표
- [x]  관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
    >  <span style="color:yellowgreen">🔎 클래스를 최대한 세분화하고 패키지로 묶어, 객체들 간의 협력구조가 잘 보이도록 하는 것에 집중했습니다.
- [x]  클래스/함수에 대한 단위테스트를 통해 의도한대로 정확하게 작동하는 영역을 확보한다.
    > <span style="color:yellowgreen">🔎 UI가 포함된 메서드를 제외한 모든 클래스의 public 메서드에 대해 단위테스트를 작성하고, 코드 가독성을 높이는 것에 집중했습니다.
- [x]  2주차 공통 피드백을 최대한 반영한다.

## ✅ 과제 진행 요구 사항
- [x]  기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- [x]  README.md의 기능목록 단위로 커밋한다.
    > <span style="color:yellowgreen">🔎 1차 구현부터 기능 목록 단위로 커밋했으며, 리팩토링 이후로는 리팩토링이 수정한 기능 단위로 커밋했습니다.</span>

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
    > <span style="color:yellowgreen">🔎 특히 `assertj.Assertions`의 모듈을 다양하게 학습하고 적용해보았습니다.</span>
  <br><span style="color:yellowgreen">🔎 `ParameterizedTest의 @MethodSource, @CsvSource`, `@BeforeAll` 등을 배워 적용하자 테스트 난이도가 훨씬 낮아졌습니다.</span>
- [x]  메서드의 길이가 15라인을 넘어가지 않도록 구현한다.
- [x]  else 예약어, switch/case를 사용하지 않는다.
- [x]  Java Enum을 적용한다.
    > <span style="color:yellowgreen">🔎 1~5등 상태 그리고 당첨되지 않은 상태를 정적으로 관리하기 위해 `Rank`라는 ENUM 클래스를 만들었습니다.</span>
  <br><span style="color:yellowgreen">🔎 상태 관리가 매우 쉽고, 상태 자체를 관리하는 클래스와 상태를 활용하여 비즈니스 로직을 실행하는 것이 용이해졌습니다.</span>
  <br><span style="color:yellowgreen">✏️ 다만, ENUM 클래스이다보니 객체를 참조하는 것이 매우 열려있었는데, 이를 어디까지 열어도 될지 고민을 했습니다.</span>
- [x]  구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(`System.out`,`System.in`, `Scanner`) 로직은 제외한다.
  - [x]  제공된 Lotto 클래스를 사용하여 구현한다.
      - [x]  `Lotto`에 `numbers`이외의 필드(인스턴스 변수)를 추가하지 않는다.
      - [x]  `numbers`의 접근 제어자인`private`은 변경하지 않는다.
     > [참고] `Lotto.java`의 위치를 이동했더니 해당 파일이 삭제된 것으로 기록이 남았습니다.
        <br>`model/lotto/lottoNumber`에 위치해 있으니 참고 부탁드립니다.


## ✅ 2주차 공통피드백

- [x]  README를 작성할 때 프로젝트의 소개를 목적으로 상세히 작성한다.
    > <span style="color:yellowgreen">🔎 프로젝트 소개를 위해 로또 발매를 하는 사용자(`For Lottery Buyers`), 로또 당첨 번호를 입력하는 사용자(`For Lottery Drawers`), 소스 코드를 보는 개발자(`For Developers`)를 대상으로 프로젝트 소개글을 작성했습니다!
- [x]  기능 목록에 기술적인 내용은 배제한다.
- [x]  기능 목록에 정상적인 경우와 예외상황을 모두 명시한다.
    > <span style="color:yellowgreen">🔎 기능 목록 표에서 정상 흐름을 설명하는 `세부기능`과, 예외상황을 처리하는 `예외흐름`을 나누어 작성했습니다.</span>
- [x]  기능 목록을 지속적으로 업데이트한다.
    > <span style="color:yellowgreen">🔎 `docs/README_CHANGELOG.md`를 만들어 리드미 변경 시 변경 이력과 변경 이유를 설명해서, 더욱 살아있는 문서로 만들었습니다.</span>
- [x]  문자열이나 숫자 값을 하드 코딩하지 않는다.
    > <span style="color:yellowgreen">🔎 숫자나 문자열 자체로 의미가 읽기 어렵고 변경 가능성이 있는 매직 넘버, 매직 리터럴을 상수처리했습니다.</span>
  <br><span style="color:yellowgreen">✏️ 그러나, `콘솔 출력 문자열`의 경우 상수로 바꾸면 가독성이 안 좋아져서 상수화하지 않았습니다.</span>
  <br><span style="color:yellowgreen">✏️ 대신 `String.format()`을 사용해 정적 문자열을 통합하고, 수정이 쉽도록 만들었습니다.</span>
- [x]  상수-멤버변수-생성자-메서드 순의 코딩 컨벤션을 지키고, 메서드는 논리적인 이유로 정렬한다.
    > <span style="color:yellowgreen">🔎 코딩 컨벤션을 지키고, 메서드의 경우 `public 메서드 > private 메서드 호출 순 > getter` 순으로 정렬했습니다.</span>
- [x]  변수 이름에 자료형을 사용하지 않는다.
    > <span style="color:yellowgreen">🔎 모든 메인 코드 변수 이름에 자료형을 사용하지 않았습니다.</span>
  <br><span style="color:yellowgreen">✏️ 그러나 자료형 자체가 중요한 `common/Converter`와 몇가지 테스트 메서드는 `자료형을 사용해` 의미를 강조했습니다.</span>
- [x]  한 메서드가 한 가지 기능만 담당하게 한다.
- [x]  메서드가 한 가지 기능을 하는지 확인하는 나만의 기준을 만든다.
    > <span style="color:yellowgreen">🔎 `단위 테스트를 만들 때 불편함이 없는가?`, 즉 `단위 테스트의 대상만 테스트 데이터로 생성해도 테스트가 가능한가?` 를 기준으로 메서드를 계속해서 분리했습니다.</span>
  <br><span style="color:yellowgreen">✏️ 아직은 하나의 테스트를 위해 너무 많은 객체를 생성하는 테스트도 있어서, 역할 분리가 더 필요하다고 느끼는 지점도 있습니다.</span>
- [x]  학습테스트를 통해 JUnit을 학습한다.
    > <span style="color:yellowgreen">🔎 구현을 시작하기 이전에, 공통 피드백에서 제공됐던 학습 테스트 자료를 통해 학습을 진행했습니다.</span>
  <br><span style="color:yellowgreen">🔎 학습한 코드는 `test/java/study`에 있습니다.</span>
- [x]  [테스트를 작성하는 이유](https://velog.io/@joychae714/why-i-use-test)에 대해 정리하고 글로 작성해본다.
- [x]  테스트를 메서드 등의 작은 단위부터 만든다.
    > <span style="color:yellowgreen">🔎 1차 구현때는 `기능목록의 세부 기능 기준`으로 테스트를 만들었습니다.</span>
  <br><span style="color:yellowgreen">🔎 이후 리팩토링하면서 메서드가 늘어나고, 리팩토링이 어느정도 완료된 이후 `모든 public 메서드`에 대해 테스트를 작성했습니다.</span>
  <br><span style="color:yellowgreen">✏️ 그러나 리팩토링 과정에서는 항상 메서드의 성능을 어느정도 확인 한 이후, `뒤늦게` 테스트를 작성한 적이 많았습니다.
<br>아직 테스트를 바로 작성하는 습관이 들지 않아서 다소 아쉬웠습니다.</span>

