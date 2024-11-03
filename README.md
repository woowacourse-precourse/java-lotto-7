# java-lotto-precourse

## 🚀 미션 간단 설명

1~45까지 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑아 당첨 여부를 확인하고 수익률을 출력하는 로또 발매기 프로그램을 구현하는 미션입니다.

---

### 🔒 제약사항 (1)

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)를 원칙으로 한다.

### 🔒 제약사항 (2)

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
        - [AssertJ User Guide](https://assertj.github.io/doc)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### 🔒 제약사항(3)

- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- Java Enum을 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.

---

### 💡 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

---

### **🍀 Lotto 클래스**

- 제공된 Lotto 클래스를 사용하여 구현해야 한다.
- Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- numbers의 접근 제어자인 private은 변경할 수 없다.
- Lotto의 패키지를 변경할 수 있다.

---

# 🛠 구현할 기능 목록
- 입력 기능
    - 구매 금액을 입력받는 기능
    - 당첨 번호를 입력받는 기능
    - 보너스 번호를 입력받는 기능
- 출력 기능
    - 발행한 로또 수량 및 번호를 출력하는 기능
    - 당첨 내역을 출력하는 기능
    - 수익률을 출력하는 기능
- 입력값 검증
    - 금액
      - 정수형인지 확인하는 기능
      - 1000으로 나누어 떨어지는지 확인하는 기능
    - 당첨 번호
      - 쉼표로 구분하였을 때 원소가 정수형인지 확인하는 기능
      - 1 ~ 45 사이의 숫자인지 확인하는 기능
      - 6개의 숫자인지 확인하는 기능
    - 보너스 번호
      - 정수형인지 확인하는 기능
      - 1 ~ 45 사이의 숫자인지 확인하는 기능
      - 당첨번호에 존재하지 않는 숫자인지 확인하는 기능
- 로도 진행 기능
  - 구매 수량만큼 로또 번호를 생성하는 기능
  - 당첨 결과를 구하는 기능
<br>
---
## 📋 구현 체크
- [ ] 입력 기능
    - [ ] 구매 금액을 입력받는 기능
    - [ ]당첨 번호를 입력받는 기능
    - [ ]보너스 번호를 입력받는 기능
- [ ] 출력 기능
    - [ ] 발행한 로또 수량 및 번호를 출력하는 기능
    - [ ] 당첨 내역을 출력하는 기능
    - [ ] 수익률을 출력하는 기능
- [ ] 입력값 검증
    - [x] 금액
        - [x] 정수형인지 확인하는 기능
        - [x] 1000으로 나누어 떨어지는지 확인하는 기능
    - [x] 당첨 번호
        - [x] 쉼표로 구분하였을 때 원소가 정수형인지 확인하는 기능
        - [x] 1 ~ 45 사이의 숫자인지 확인하는 기능
        - [x] 6개의 숫자인지 확인하는 기능
    - [x] 보너스 번호
        -  [x] 정수형인지 확인하는 기능
        - [x] 1 ~ 45 사이의 숫자인지 확인하는 기능
        - [x] 당첨번호에 존재하지 않는 숫자인지 확인하는 기능
- [ ] 로또 진행 기능
    - [ ] 구매 수량만큼 로또 번호를 생성하는 기능
    - [ ] 당첨 결과를 구하는 기능
- [ ] 모든 테스트 케이스가 성공하는지?
- [ ] 자바 코드 컨벤션(Java Style Guide)을 지켰는지?
