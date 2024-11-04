# java-lotto-precourse

## 프로젝트 개요
- 사용자에게 로또 구입 금액을 입력받고, 구입 금액에 해당하는 무작위 번호의 로또를 생성하여 출력한다. 사용자에게 당첨 번호와 보너스 번호를 입력받아서, 당첨 결과와 수익률을 출력한다.

## 구현 기능

### CONFIG
- [X] bean 등록을 위한 project scan 기능
- [X] bean 등록 대상으로 지정하기 위한 annotation
- [X] IoC를 위한 DI 기능
  - 예외 상황: 순환 참조, bean이 존재하지 않는 경우, bean이 여러 개 존재하는 경우
- [X] project scan, bean container 관리 기능
- [X] FrontController과 백 애플리케이션 기반 기능
- [X] front와 back의 통신 기능
- [X] 프론트 애플리케이션 로직 및 재시도 기능 

### INPUT
- [X] 로또 구입 금액 입력
- [X] 당첨 번호 입력
- [X] 보너스 번호 입력

### PARSING
- [X] 로또 구입 금액 파싱
  - 예외 상황: 숫자가 아닌 경우
- [X] 당첨 번호 파싱
  - 예외 상황: 숫자가 아닌 경우, `,`로 split했을 때 정상적으로 파싱되지 않는 경우
- [X] 보너스 볼 파싱
  - 예외 상황: 숫자가 아닌 경우

### VALIDATION
- [X] 로또 번호 범위 검증
- [X] 로또 번호 개수 검증
- [X] 로또 번호 중복 검증
- [X] 로또 구입 금액 검증
  - 예외 상황: 로또 가격으로 구입 금액이 나누어 떨어지지 않는 경우
- [X] 당첨 번호 검증
  - 예외 상황: 당첨 번호가 6개가 아닌 경우, 1~45 사이의 숫자가 아닌 경우, 중복되는 번호가 있는 경우
- [X] 보너스 번호 검증
  - 예외 상황: 1~45 사이의 숫자가 아닌 경우, 당첨 번호와 중복되는 경우

### SERVICE
- [X] 로또 구입
- [X] 당첨 번호 지정
- [X] 보너스 번호 지정 및 결과와 수익률 계산

### OUTPUT
- [X] 로또 구입 결과 출력
- [X] 당첨 결과 출력
- [X] 수익률 출력
- [X] 에러 시 에러 메시지 출력

---

## 추가 설명

### 추가 구현 기능 설명
1. **bean 등록을 위한 project scan 기능**
    - `@Controller`, `@Service`, `@Repository` 어노테이션이 적용된 클래스를 찾아서 반환한다.
2. **bean container**
    - 지정한 클래스를 bean으로 등록하고, 의존성 주입을 통해 객체를 생성한다.
    - 의존성 주입 시 순환 참조를 감지하여 예외를 발생시킨다.
    - bean container에서 bean을 가져올 때, 싱글톤 패턴을 적용하여 동일한 객체를 반환한다.
    - bean container에서 bean을 가져올 때, 해당 class와 interface를 통해 가져올 수 있다.
3. **DI 기능**
    - reflection으로 instance를 생성하면서 bean container에서 bean을 가져와서 의존성 주입을 진행한다.
4. **front와 back의 통신 기능**
    - front와 back의 통신을 위한 기능을 구현하기 위해 front의 스레드와 back의 스레드를 분리하였다.
    - front에서 입력을 받아 back으로 전달하고, back에서 결과를 front로 응답한다.
    - front와 back이 요청, 응답하는 과정에서 back에서 에러가 발생하면 front로 에러 발생 여부와 에러 메시지를 전달한다.

### 고려했던 점
1. **view의 역할**
    - view의 역할을 일반적인 frontEnd의 역할로 정의하고, 그에 따른 역할을 하도록 구현했습니다.
    - 다만, view에서 json을 전송하고 dto에 mapping하는 과정은 현재 자바로 통일된 코드에서는 불필요한 연산만 진행하는 것이라 판단하여, 생략하고 dto로 대체했습니다.
2. **파싱과 검증**
    - 파싱과 검증을 어느 단계에서 진행할지, 같이 진행해야 하는지에 대한 고민이 있었습니다.
        - 파싱은 frontEnd가 입력을 받아 json으로 가공하여 backEnd에게 전송하듯이 view에서 진행했습니다.
        - 검증은 객체의 정합성을 보장하고, 응집성을 높이기 위하여 객체 내부에 검증 로직을 작성하고, 객체 생성 시 검증을 진행하도록 구현했습니다.
3. **실행 진입점과 front와 back의 관리 주체**
    - front와 back이 분리된 application을 구현하기 위해 frontApplication, backApplication을 작성하여 각각의 관리 주체로 삼았습니다. 그리고 main에서 frontApplication과 backApplication을 실행시켜, 일반적인 웹 애플리케이션과 유사하게 동작하도록 구현할 수 있었습니다.
4. **front와 back의 통신**
    - front에서 입력을 받아 back으로 전달하고, back에서 결과를 front로 응답한다.
    - front와 back이 요청, 응답하는 과정에서 back에서 에러가 발생하면 front로 에러 발생 여부와 에러 메시지를 전달한다.
5. **스레드 분리에 따른 제약사항**
    - 스레드를 분리함에 따라, 테스트 코드의 random 값의 임의 지정이 적용되지 않아, back의 스레드는 현재 스레드에서 진행하는 것으로 하고, front의 스레드만 분리하였습니다.
6. **enum의 활용**
    - enum을 활용하라는 지시사항에 따라, Lotto에 사용되는 config와 lottoResult의 당첨 정보를 enum으로 관리할 수 있도록 하였습니다. enum으로 관리함에 따라 여러 클래스와 지점들에서 일관성 있게 관리할 수 있고, 수정이 용이하며, 값이 어떤 의미를 가지는 지 알 수 있다는 장점이 있습니다.
7. **front에서의 에러 처리 및 재시도 로직**
    - 일반적인 웹 애플리케이션과 유사하게 back에서 에러가 발생했다는 응답이 오면, front에서 에러 메시지를 출력하고, front에서 재시도하는 로직을 실행하였습니다.
8. **재시도 로직에서의 에러 처리**
    - 현재 테스트 코드에서 console.readline()에서 발생하는 NoSuchElementException을 통해 프로그램을 종료하는 것을 이용하고 있습니다. 스레드가 분리된 상태에서는 frontApplication이 NoSuchElementException을 통해 종료되면 backApplication도 종료되도록 구현해야 했기 때문에, finally문을 통해 정상 종료일 때도, 비정상 종료일 때도 backApplication이 종료되도록 구현하였습니다.