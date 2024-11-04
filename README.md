# java-lotto-precourse

<br>

# 🚀 미션 간단 설명

1~45까지 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑아 당첨 여부를 확인하고 수익률을 출력하는 로또 발매기 프로그램을 구현하는 미션입니다.

<br>

## 🔒 제약사항 (1)

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)를 원칙으로 한다.

## 🔒 제약사항 (2)

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

## 🔒 제약사항(3)

- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- Java Enum을 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.

## 💡 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.


## **🍀 Lotto 클래스**

- 제공된 Lotto 클래스를 사용하여 구현해야 한다.
- Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- numbers의 접근 제어자인 private은 변경할 수 없다.
- Lotto의 패키지를 변경할 수 있다.

---

<br>

# 🛠️ 구현할 기능 목록
- 로또 구입 금액 입력 (한장당 1000원)
    - 로또 번호 오름차순으로 정렬
- 당첨 번호 입력
    - 1-45까지의 임의의 수 6개 생성하는 함수
- 보너스 번호 입력
- 입력한 값이 잘못된 값인지 체크하는 함수 (잘못된 값을 입력시 `IllegalArgumentException` 발생)
    - 1000으로 나눈 나머지가 0이 아니면 예외처리
    - 당첨번호/보너스번호 1 ~ 45 사이가 아니면 예외처리
    - 당첨번호 6개 아니면 예외처리
    - 당첨번호/보너스번호 숫자 아니면 예외처리
    - 보너스 번호가 당첨번호 중에 있으면 예외처리
    - 로또 구입 금액 입력이 빈 문자열이면 예외처리
    - 당첨번호 입력이 빈 문자열이면 예외처리
    - 보너스번호 입력이 빈 문자열이면 예외처리
    - 당첨번호 공백이 존재하면 예외처리
    - 당첨번호 앞뒤에 쉼표가 존재하면 예외처리
    - 당첨번호와 보너스 번호가 중복이면 예외처리
- 당첨번호, 당첨금액, 메시지 정의 enum 클래스
- 일치하는 로또 번호 개수 확인하는 함수
- 일치하는 번호 개수만큼 수익률 계산하는 함수
    - 3개 번호 일치하면 5,000원 (5등)
    - 4개 번호 일치하면 50,000원 (4등)
    - 5개 번호 일치하면 1,500,000원 (3등)
    - 5개 번호, 보너스번호 일치하면 30,000,000원 (2등)
    - 6개 번호 일치하면 2,000,000,000원 (1등)
- 구입 금액 입력 안내 출력하는 함수
- 당첨 번호 입력 안내 출력하는 함수
- 보너스 번호 입력 안내 출력하는 함수
- 구매한 로또 수량에 따라 번호 출력하는 함수
- 당첨 통계(일치하는 개수) 출력하는 함수
- 수익률(소수점 둘째 자리에서 반올림) 출력하는 함수

<br> 

## 📋 구현 체크
- [x] 로또 구입 금액 입력 (한장당 1000원)
  - [ ] 로또 번호 오름차순으로 정렬
- [x] 당첨 번호 입력
  - [ ] 1-45까지의 임의의 수 6개 생성하는 함수
- [x] 보너스 번호 입력
- [x] 입력한 값이 잘못된 값인지 체크하는 함수 (잘못된 값을 입력시 `IllegalArgumentException` 발생)
  - [x] 1000으로 나눈 나머지가 0이 아니면 예외처리
  - [x] 당첨번호/보너스번호 1 ~ 45 사이가 아니면 예외처리
  - [x] 당첨번호 6개 아니면 예외처리
  - [x] 당첨번호/보너스번호 숫자 아니면 예외처리
  - [x] 당첨번호 중에 중복이 있으면 예외처리
  - [x] 입력이 빈 문자열이면 예외처리
  - [x] 입력에 공백이 존재하면 예외처리
  - [x] 당첨번호 입력이 숫자로 끝나지 않으면 예외처리
  - [x] 당첨번호가 올바른 형식(숫자, 쉼표)으로 작성되지 않으면 예외처리
  - [x] 당첨번호와 보너스번호가 중복이면 예외처리
- [ ] 당첨번호, 당첨금액, 메시지 정의 enum 클래스
- [ ] 일치하는 로또 번호 개수 확인하는 함수
- [ ] 일치하는 번호 개수만큼 수익률 계산하는 함수
  - 3개 번호 일치하면 5,000원 (5등)
  - 4개 번호 일치하면 50,000원 (4등)
  - 5개 번호 일치하면 1,500,000원 (3등)
  - 5개 번호, 보너스번호 일치하면 30,000,000원 (2등)
  - 6개 번호 일치하면 2,000,000,000원 (1등)
- [ ] 구입 금액 입력 안내 출력하는 함수
- [ ] 당첨 번호 입력 안내 출력하는 함수
- [ ] 보너스 번호 입력 안내 출력하는 함수
- [ ] 구매한 로또 수량에 따라 번호 출력하는 함수
- [ ] 당첨 통계(일치하는 개수) 출력하는 함수
- [ ] 수익률(소수점 둘째 자리에서 반올림) 출력하는 함수
---