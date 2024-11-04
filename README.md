# java-lotto-precourse
# 로또 게임 기능 목록

## 1. 입력 기능
### 1.1 구입 금액 입력
- [x] 로또 구입 금액을 입력받는다
- [x] 입력값 유효성 검증
    - 1,000원으로 나누어 떨어지는지 검증
    - 양수인지 검증
    - 숫자가 아닌 값이 입력된 경우 검증

### 1.2 당첨 번호 입력
- [x] 쉼표(,)로 구분된 6개의 당첨 번호를 입력받는다
- [x] 입력값 유효성 검증
    - 6개의 숫자가 입력되었는지 검증
    - 1부터 45 사이의 숫자인지 검증
    - 중복된 숫자가 없는지 검증
    - 숫자가 아닌 값이 입력된 경우 검증

### 1.3 보너스 번호 입력
- [x] 보너스 번호를 입력받는다
- [x] 입력값 유효성 검증
    - 1부터 45 사이의 숫자인지 검증
    - 당첨 번호와 중복되지 않는지 검증
    - 숫자가 아닌 값이 입력된 경우 검증

## 2. 로또 생성 기능
- [x] 구입 금액에 해당하는 만큼의 로또 번호 생성
- [x] 1개의 로또마다 중복되지 않는 6개의 번호 생성(1~45)
- [x] 생성된 번호를 오름차순으로 정렬

## 3. 당첨 확인 기능
- [x] 구매한 각 로또와 당첨 번호를 비교
- [x] 당첨 등수 판정
    - 1등: 6개 번호 일치
    - 2등: 5개 번호 + 보너스 번호 일치
    - 3등: 5개 번호 일치
    - 4등: 4개 번호 일치
    - 5등: 3개 번호 일치

## 4. 출력 기능
### 4.1 구매 내역 출력
- [x] 발행한 로또 수량 출력
- [x] 발행한 로또 번호들을 오름차순으로 출력

### 4.2 당첨 통계 출력
- [x] 당첨 내역 출력 (등수별 당첨 개수)
- [x] 수익률 계산 및 출력 (소수점 둘째 자리에서 반올림)

## 5. 예외 처리
- [x] 모든 예외 상황에서 "[ERROR]"로 시작하는 에러 메시지 출력
- [x] 에러 발생 시 해당 부분부터 다시 입력받기
- [x] IllegalArgumentException으로 예외 처리
- [x] IllegalStateException으로 상태 검증 예외 처리

## 6. 추가 기능 (누락되어 있던 항목들)
### 6.1 객체 상태 검증
- [x] 의존성 주입 시 null 체크
- [x] 객체 초기화 상태 검증
- [x] 컬렉션 불변성 보장

### 6.2 방어적 프로그래밍
- [x] 입력값 방어적 복사
- [x] 반환값 방어적 복사
- [x] 중복 코드 제거를 위한 검증 로직 중앙화

### 6.3 코드 품질 관리
- [x] indent depth 2 이하 유지
- [x] 메서드 길이 15라인 이하 유지
- [x] else 예약어 사용하지 않기

# 커밋 메시지 작성 가이드

## 기본 형식

```
<타입>(<범위>): <제목>

<본문>

<꼬리말>
```

## 타입

- feat: 새로운 기능 추가
- fix: 버그 수정
- docs: 문서 수정
- style: 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
- refactor: 코드 리팩토링
- test: 테스트 코드, 리팩토링 테스트 코드 추가
- chore: 빌드 업무 수정, 패키지 매니저 수정

## 제목 규칙

- 제목은 50자를 넘기지 않습니다.
- 첫 글자는 대문자로 시작합니다.
- 마지막에 마침표(.)를 붙이지 않습니다.
- 명령문으로 작성합니다. ("추가하다", "변경하다" 등)

## 본문 규칙

- 각 줄은 72자를 넘기지 않습니다.
- 어떻게 변경했는지보다 무엇을, 왜 변경했는지 설명합니다.

## 꼬리말 규칙

- Resolve : 기능목록
- BREAKING CHANGE가 있을 경우 명시합니다.

## 예시

```
feat(로그인): 소셜 로그인 기능 추가

카카오와 네이버 소셜 로그인 기능을 추가했습니다.
사용자 편의성을 높이고 회원가입 절차를 간소화하기 위한 목적입니다.

BREAKING CHANGE: 기존 로그인 API의 응답 형식이 변경되었습니다.
```

# MVC 아키텍처

## 🧩 구성 요소 및 예제 코드

### Application
- 프로그램의 시작점

```java
public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        InputValidator inputValidator = new InputValidator();
        ModelFactory modelFactory = new ModelFactory();
        
        Controller controller = new Controller(inputView, outputView, inputValidator, modelFactory);
        controller.run();
    }
}
```

### 컨트롤러 (Controller)
- 주요 게임 루프 관리
- 사용자 입력 처리 및 모델 프로세싱
- 뷰와 모델 컴포넌트 간 조정

```java
public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final ModelFactory modelFactory;

    public Controller(InputView inputView, OutputView outputView,
                      InputValidator inputValidator, ModelFactory modelFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.modelFactory = modelFactory;
    }

    public void run() {
        try {
            String input = getValidInput();
            Model model = modelFactory.createModel(input);
            String result = model.process();
            outputView.printResult(result);
        } catch (Exception e) {
            outputView.printError(e.getMessage());
        }
    }

    private String getValidInput() {
        while (true) {
            try {
                String input = inputView.readInput();
                inputValidator.validate(input);
                return input;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
```

### 뷰 (View)
- **입력뷰 (InputView)**: 사용자 입력 읽기 인터페이스
- **출력뷰 (OutputView)**: 출력 표시 인터페이스

```java
public interface InputView {
    String readInput();
}

public class ConsoleInputView implements InputView {
    @Override
    public String readInput() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}

public interface OutputView {
    void printResult(String result);
    void printError(String error);
}

public class ConsoleOutputView implements OutputView {
    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printError(String error) {
        System.out.println("[ERROR] " + error);
    }
}
```

### 모델 (Model)
- **모델 (Model)**: 게임 로직 인터페이스
- **모델팩토리 (ModelFactory)**: 적절한 모델 인스턴스 생성

```java
public interface Model {
    String process();
}

public class DefaultModel implements Model {
    private final String input;

    public DefaultModel(String input) {
        this.input = input;
    }

    @Override
    public String process() {
        return "처리된 결과: " + input;
    }
}

public class ModelFactory {
    public Model createModel(String input) {
        return new DefaultModel(input);
    }
}
```

### 유틸리티
- **입력검증기 (InputValidator)**: 사용자 입력 유효성 검사

```java
public class InputValidator {
    public void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
        // 추가적인 검증 규칙을 여기에 구현
    }
}
```
## 프로젝트 구조

```
src
├── main
│   └── java
│       └── com
│           └── example
│               ├── Application.java
│               ├── controller
│               │   └── Controller.java
│               ├── model
│               │   ├── Model.java
│               │   ├── DefaultModel.java
│               │   └── ModelFactory.java
│               ├── view
│               │   ├── input
│               │   │   ├── InputView.java
│               │   │   └── ConsoleInputView.java
│               │   └── output
│               │       ├── OutputView.java
│               │       └── ConsoleOutputView.java
│               └── util
│                   └── InputValidator.java
└── test
    └── java
        └── com
            └── example
                ├── controller
                ├── model
                ├── view
                └── util
```

## 패키지 설명

1. `com.example`: 프로젝트의 루트 패키지
  - `Application.java`: 프로그램의 진입점

2. `com.example.controller`: 컨트롤러 관련 클래스
  - `Controller.java`: 주요 게임 로직을 관리하고 Model과 View를 조정

3. `com.example.model`: 모델 관련 클래스
  - `Model.java`: 모델 인터페이스
  - `DefaultModel.java`: 기본 모델 구현
  - `ModelFactory.java`: 모델 객체 생성을 담당하는 팩토리 클래스

4. `com.example.view`: 뷰 관련 클래스
  - `input`: 입력 관련 클래스
    - `InputView.java`: 입력 뷰 인터페이스
    - `ConsoleInputView.java`: 콘솔 기반 입력 뷰 구현
  - `output`: 출력 관련 클래스
    - `OutputView.java`: 출력 뷰 인터페이스
    - `ConsoleOutputView.java`: 콘솔 기반 출력 뷰 구현

5. `com.example.util`: 유틸리티 클래스
  - `InputValidator.java`: 사용자 입력 유효성 검사 클래스

## ✨ 주요 특징

1. **모듈성**: 관심사의 명확한 분리로 유지보수 용이
2. **확장성**: 새로운 기능이나 모델 추가가 쉬움
3. **테스트 용이성**: 의존성 주입을 통한 단위 테스트 용이
4. **유연성**: 인터페이스를 통한 다양한 입출력 구현 가능
5. **오류 처리**: 중앙집중식 오류 관리
6. **재사용성**: 모델팩토리를 통한 다양한 게임 모델 관리

## 📅 개발 계획

| 단계 | 초점 |
|----|------|
| 1  | 기본 구조 구현 및 입출력 테스트 |
| 2  | 입력검증기 구현 및 유효성 검사 규칙 |
| 3  | 모델팩토리 및 기본 모델 구현 |
| 4  | 다양한 모델 구현 및 게임 로직 |
| 5  | 예외 처리 및 엣지 케이스 관리 |
| 6  | 시스템 통합 및 최적화 |

## 🚀 시작하기

1. 저장소 클론
2. 프로젝트 디렉토리로 이동
3. `Application.java` 실행하여 애플리케이션 시작


## 🛠️ 확장 및 커스터마이징

- 새로운 모델 추가: `Model` 인터페이스를 구현하고 `ModelFactory`에 추가
- 다른 입출력 방식: `InputView`와 `OutputView` 인터페이스의 새로운 구현 제공
- 추가 유효성 검사: `InputValidator`에 새로운 검증 규칙 추가

## 🤝 기여하기

깃 팔로우를 걸어주세요!
