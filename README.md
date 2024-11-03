# java-lotto-precourse

___

## 조건 및 형식

### 라이브러리

- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange() 활용
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine() 활용

### 에러 메세지

    [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.

### Lotto 클래스

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

- 제공된 Lotto 클래스를 사용하여 구현해야 한다.
- Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- numbers의 접근 제어자인 private은 변경할 수 없다.
- Lotto의 패키지를 변경할 수 있다.

### 프로그래밍 요구사항

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 Java Style Guide를 원칙으로 한다.

######

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

######

- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- Java Enum을 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.

#

--- 

## 구현 기능 목록

### 1. 로또 번호 발행 기능

#### 1-1. 로또 번호 발행 기능 : 1~45 범위의 6개의 중복되지 않는 랜덤 숫자를 발행함

### 2. 입력 기능

#### 2-1. 처음 입력받는 값은 로또 구입 금액

- 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 혹은 올바른 값이 아닌 경우 IllegalArgumentException 출력

#### 2-2. 두 번째로 입력받을 값은 당첨 번호

- 받은 번호는 쉼표(,)를 통해 구분
- 입력 값들이 1~45 범위의 6개의 중복되지 않는 랜덤 숫자가 아닌 경우 IllegalArgumentException 예외처리

#### 2-3. 세 번째로 입력받을 값은 보너스 번호

- 당첨 번호들 중에 있거나 1~45 범위의 정수가 아닌 경우 IllegalArgumentException 예외처리

#### \*\*\*추가됨\*\*\* 2-4. 2-1에서 입력받은 금액만큼의 로또 발행

### 3. 출력 기능

#### 3-1. 입력 받은 구입 금액을 기준으로 로또 발행

    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45]

#### 3-2. 당첨 내역 출력

    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개

#### 3-3. 수익률 출력

- 수익률은 소수점 둘째 자리에서 반올림

      총 수익률은 62.5%입니다.