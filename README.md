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

# MVC 아키텍처 설계 가이드

## 🎯 프로젝트 구조
```
src
├── main
│   └── java
│       └── project
│           ├── Application.java
│           ├── constant
│           │   └── CommonConstants.java
│           ├── controller
│           │   ├── MainController.java
│           │   ├── InputController.java
│           │   └── OutputController.java
│           ├── model
│           │   ├── domain
│           │   │   ├── Entity.java
│           │   │   └── ValueObject.java
│           │   └── factory
│           │       └── ModelFactory.java
│           ├── service
│           │   ├── BusinessService.java
│           │   └── ValidationService.java
│           ├── view
│           │   ├── InputView.java
│           │   ├── OutputView.java
│           │   ├── ConsoleInputView.java
│           │   └── ConsoleOutputView.java
│           └── util
│               ├── InputValidator.java
│               └── Parser.java
└── test
    └── java
        └── project
            ├── model
            ├── service
            └── util
```

## 📦 계층별 설명

### 1. Application
- 프로그램의 진입점
- 의존성 주입 및 초기 설정 담당

```java
public class Application {
    public static void main(String[] args) {
        // 의존성 객체 생성
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        InputValidator validator = new InputValidator();
        BusinessService service = new BusinessService();
        
        // 컨트롤러 생성 및 실행
        MainController controller = new MainController(
            inputView, outputView, validator, service);
        controller.run();
    }
}
```

### 2. Controller Layer
- 사용자 요청 처리 및 흐름 제어
- Model과 View 사이의 중재자 역할

```java
public class MainController {
    private final InputController inputController;
    private final OutputController outputController;
    private final BusinessService businessService;

    public MainController(InputView inputView, OutputView outputView, 
                         InputValidator validator, BusinessService service) {
        this.inputController = new InputController(inputView, validator);
        this.outputController = new OutputController(outputView);
        this.businessService = service;
    }

    public void run() {
        try {
            // 1. 입력 받기
            UserRequest request = inputController.getUserRequest();
            
            // 2. 비즈니스 로직 처리
            BusinessResult result = businessService.process(request);
            
            // 3. 결과 출력
            outputController.displayResult(result);
        } catch (Exception e) {
            outputController.handleError(e);
        }
    }
}
```

### 3. Model Layer
- 비즈니스 도메인 객체들
- 상태와 행위를 가진 객체들의 집합

```java
// Entity 예시
public class Entity {
    private final String id;
    private String name;
    private final Map<String, Object> attributes;

    public Entity(String id, String name) {
        validateId(id);
        this.id = id;
        this.name = name;
        this.attributes = new HashMap<>();
    }

    public void addAttribute(String key, Object value) {
        attributes.put(key, value);
    }
}

// Value Object 예시
public class ValueObject {
    private final String value;

    public ValueObject(String value) {
        validate(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
```

### 4. Service Layer
- 비즈니스 로직 처리
- Model 객체들을 조작하는 처리 담당

```java
public class BusinessService {
    private final ModelFactory modelFactory;
    private final ValidationService validationService;

    public BusinessResult process(UserRequest request) {
        // 1. 유효성 검증
        validationService.validate(request);
        
        // 2. 모델 생성
        Entity entity = modelFactory.createEntity(request);
        
        // 3. 비즈니스 로직 처리
        return processBusinessLogic(entity);
    }
}
```

### 5. View Layer
- 사용자 인터페이스 담당
- 입력과 출력 인터페이스 정의

```java
public interface InputView {
    String readInput();
    int readNumber();
}

public interface OutputView {
    void displayResult(String result);
    void displayError(String message);
}
```

### 6. Util Layer
- 공통 유틸리티 기능 제공
- 입력 검증, 파싱 등의 헬퍼 클래스들

```java
public class InputValidator {
    public void validate(String input, ValidationRule rule) {
        if (!rule.isSatisfied(input)) {
            throw new IllegalArgumentException(rule.getErrorMessage());
        }
    }
}

public class Parser {
    public static <T> T parse(String input, Class<T> type) {
        // 문자열을 특정 타입으로 파싱하는 로직
    }
}
```

## ✨ 설계 원칙

1. **단일 책임 원칙 (SRP)**
    - 각 클래스는 하나의 책임만 가짐
    - 변경 사유가 하나만 존재하도록 설계

2. **의존성 주입 (DI)**
    - 구체 클래스가 아닌 인터페이스에 의존
    - 테스트 용이성 확보

3. **계층 분리**
    - 각 계층은 자신의 역할만 수행
    - 다른 계층과의 결합도를 최소화

4. **캡슐화**
    - 내부 구현을 숨기고 인터페이스만 노출
    - 변경의 영향 범위를 최소화

5. **확장성**
    - 새로운 기능 추가가 용이하도록 설계
    - 기존 코드 수정 없이 확장 가능

## 🔍 테스트 전략

1. **단위 테스트**
    - 각 컴포넌트별 독립적인 테스트
    - Mocking을 통한 의존성 제거

2. **통합 테스트**
    - 여러 컴포넌트의 상호작용 테스트
    - 실제 동작 시나리오 검증

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
