# java-lotto-precourse
## 로또 발매기 프로그램

<br>

## 🚀소개
로또 발매기 프로그램은 사용자의 입력을 통해 로또를 시뮬레이션하는 프로그램입니다. 
간단한 사용자 입력을 통해 구입금액과 당첨 번호, 보너스 번호를 정하고 무작위로 로또 번호를 받아 당첨 통계를 출력합니다.🥇🥉🥈

<br>

## 🔑스스로의 규칙
1. AngularJS Git Commit Message Conventions을 적용해 커밋메시지 작성하기 <br>
2. Java Style Guide을 지키며 프로그래밍 하기<br>
3. 객체지향적 코드 생성하기<br>
4. 클래스와 method를 역할에 기반한 이름 부여하기
5. 테스트 코드 활용하기
6. 상수를 활용하기
7. 다양한 예외상황 생각하기

<br>

## 🔻디렉토리 구조
```
lotto
└── src
   ├── main
   │   └── java
   │      └── lotto
   │          ├── config
   │          │   └── AppConfig.java
   │          ├── controller
   │          │   └── LottoController.java
   │          ├── exception
   │          │   ├── InputErrorMessage.java
   │          │   └── LottoErrorMessage.java
   │          ├── model
   │          │   └── domain
   │          │       ├── BonusNumber.java
   │          │       ├── Lotto.java
   │          │       ├── Lottos.java
   │          │       ├── Money.java
   │          │       ├── Rate.java
   │          │       └── WinningNumbers.java
   │          ├── service
   │          │   ├── LottoCreationService.java
   │          │   └── LottoRateService.java
   │          ├── util
   │          │   ├── generator
   │          │   │   └── RandomNumberGenerator.java
   │          │   ├── parser
   │          │   │   └── InputParser.java
   │          │   └── validator
   │          │       └── InputValidator.java
   │          └── view
   │          │   ├── InputView.java
   │          │   ├── InputViewInterface.java
   │          │   ├── LottoView.java
   │          │   └── LottoViewInterface.java
   │          │   
   │           └── Application.java  
   └── test
       └── java
           └── lotto
               ├── domain
               │   ├── BonusNumberTest.java
               │   ├── MoneyTest.java
               │   └── WinningNumbersTest.java
               ├── service
               │   ├── LottoCreationServiceTest.java
               │   └── LottoRateServiceTest.java
               ├── util
               │   ├── generator
               │   │   └── RandomNumberGeneratorTest.java
               │   ├── parser
               │   │   └── InputParserTest.java
               │   └── validator
               │       └── InputValidatorTest.java
               └── ApplicationTest.java
               └── LottoTest.java
```

## 🔎프로젝트 구조 소개
- config: 애플리케이션의 설정 및 초기화를 담당하는 클래스가 포함되어 있습니다.
- controller: 사용자 입력을 처리하고, 서비스와 뷰 간의 데이터 흐름을 조정합니다.
- exception: 애플리케이션에서 발생할 수 있는 예외 메시지를 모아둔 클래스입니다. InputErrorMessage.java 및 LottoErrorMessage.java는 각각 사용자 입력과 로또 관련 오류 메시지를 정의합니다.
- model: 애플리케이션의 비즈니스 모델을 정의하는 클래스입니다. 여기에는 도메인 클래스와 서비스 클래스가 포함됩니다
  - domain: 로또의 핵심 도메인 객체를 나타내는 클래스입니다. BonusNumber.java, Lotto.java, Lottos.java, Money.java, Rate.java, WinningNumbers.java 등이 포함되어 있습니다.
  - service: 비즈니스 로직을 수행하는 클래스입니다.
    - LottoCreationService.java는 로또 티켓 생성을 담당합니다
    - LottoRateService.java는 로또의 승률 계산 등을 처리합니다.
- util: 애플리케이션의 공통 기능을 제공하는 유틸리티 클래스입니다.
  - generator: 랜덤 숫자를 생성하는 RandomNumberGenerator.java가 포함되어 있습니다.
  - parser: 사용자 입력을 파싱하는 InputParser.java가 포함되어 있습니다.
  - validator: 입력 값의 유효성을 검증하는 InputValidator.java가 포함되어 있습니다.
- view: 사용자와의 상호작용을 위한 입력 및 출력을 처리하는 클래스입니다. InputView.java, LottoView.java와 인터페이스 클래스들이 포함되어 있습니다.
- Application.java: 애플리케이션의 진입점이며, 전체 프로그램을 실행하는 메인 클래스입니다.

## 📘프로그래밍 요구 사항 1
1. 21 버전에서 실행 가능해야 한다.
2. 프로그램 실행의 시작점은 `Application`의` main()`이다.
3. `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
4. 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
5. 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
6. `자바 코드 컨벤션`을 지키면서 프로그래밍한다.
7. 기본적으로 `Java Style Guide`를 원칙으로 한다.

## 📘프로그래밍 요구 사항 2
1. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
2. 3항 연산자를 쓰지 않는다.
3. 함수가 한가지 일만 하도록 최대한 작게 분리해라
4. JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

## 📘프로그래밍 요구 사항 3
1. 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
2. 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
3. else 예약어를 쓰지 않는다.
4. Java Enum을 적용하여 프로그램을 구현한다.
5. 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.

<br>


## 📄라이브러리
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다

<br>


## ⭕Lotto 클래스
- 제공된 Lotto 클래스를 사용하여 구현해야 한다.
- Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- numbers의 접근 제어자인 private은 변경할 수 없다.
- Lotto의 패키지를 변경할 수 있다.
```
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
}
```

<br>

## 🔻기능 목록

### 1️⃣사용자 안내 및 입력 기능
#### 1-1. 로또 구입 금액 입력 안내 메시지 출력
- 프로그램이 시작되면 구입 금액을 입력받기 위한 메시지를 출력합니다.
  - 출력되는 메시지:`구입금액을 입력해 주세요.`
    
#### 1-2. 구입 금액 입력 받기
- 사용자는 로또 구입 금액을 입력합니다
  - 올바른 입력값이 아니라면 `예외`를 발생한다.
     
#### 1-3. 당첨 번호 입력 안내 메시지 출력
- 사용자가 로또를 구매하면, 당첨 번호 입력을 위한 안내 메시지를 출력합니다.
  - 출력되는 메시지: `당첨 번호를 입력해 주세요.`
    
#### 1-4. 당첨 번호 입력 받기
- 당첨 번호는 중복되지 않는 6개의 숫자로 구성됩니다.
  - 올바른 입력값이 아니라면 `예외`를 발생한다.
    
#### 1-5. 보너스 번호 입력 안내 메시지 출력
- 당첨 번호 입력 후 보너스 번호 입력을 유도합니다.
  - 출력되는 메시지: "보너스 번호를 입력해 주세요."
    
#### 1-6. 보너스 번호 입력 받기
- 보너스 번호는 당첨 번호에 없는 `1~45 범위 내`의 숫자로 입력받습니다.
 - 올바른 입력값이 아니라면 `예외`를 발생한다.
   
<br>

### 2️⃣입력 값 검증 기능
⭕발생하는 예외는 IllegalArgumentException으로 지정한다.
⭕올바른 입력값이 아니라면 [ERROR]로 시작하는 메시지와 함께 예외를 발생시킵니다.

#### 2-1. 구입 금액 유효성 검증
- 입력된 구입 금액이 유효한지 확인한다.
    - 입력 금액이  `1,000원 단위`로 나누어 떨어지지 않으면가  예외를 발생시킵니다.  
    - 입력 금액이  `1,000원 미만`일 경우 예외를 발생시킵니다.
    - 입력 금액이 `1,000,000`을 넘어가면 예외를 발생시킵니다.
  
#### 2-2. 당첨 번호 유효성 검증
- 입력된 당첨 번호가 유효한지 확인합니다.
    - 입력값이 `1~45 범위내의 정수`가 아니라면 예외를 발생시킵니다.
    - 입력 값이 `중복이라면` 예외를 발생시킵니다.
  
#### 2-2. 보너스 번호 유효성 검증
- 입력된 보너스 번호가 유효한지 확인합니다.
    - 입력값이 `1~45 범위내의 정수`가 아니라면 예외를 발생시킵니다.
    - 입력 값이 당첨 번호와 `중복이라면` 예외를 발생시킵니다.    

 <br>
  
### 3️⃣로또 발행 기능

#### 3-1. 로또 발행
- 입력받은 구입 금액에 따라 필요한 만큼의 로또를 발행합니다
  - 로또 1장의 가격은 1,000원입니다.
  - 예: 구입 금액이 8,000원인 경우 8개의 로또가 발행됩니다.
    
#### 3-2. 로또 번호 생성
- 각 로또 번호는 `중복`되지 않는 `1~45 사이`의 숫자 6개로 구성됩니다.
- 로또 번호는 `Randoms.pickUniqueNumbersInRange(1, 45, 6)`을 이용해 생성됩니다.
  
#### 3-3. 발행한 로또 목록 출력
발행된 로또의 수량과 각 로또 번호를 오름차순으로 정렬하여 출력합니다.

<br>

 
### 4️⃣당첨 결과 확인 및 수익률 계산 기능
#### 4-1. 당첨 여부 및 등수 계산
- 등수 기준은 다음과 같습니다:
  -1등: 6개 번호 일치 (2,000,000,000원)
  -2등: 5개 번호 + 보너스 번호 일치 (30,000,000원)
  -3등: 5개 번호 일치 (1,500,000원)
  -4등: 4개 번호 일치 (50,000원)
  -5등: 3개 번호 일치 (5,000원)
  
#### 4-2. 당첨 통계 출력
- 각 등수별로 당첨된 횟수를 출력합니다.
    - 예: 3개 일치 (5,000원) - 1개
      
#### 4-3. 수익률 계산 및 출력
- 당첨 금액을 합산하고, 구입 금액 대비 수익률을 계산하여 `소수점 둘째 자리`에서 반올림하여 출력합니다.
  - 예: 총 수익률은 62.5%입니다.

<br>

## 🛠테스트 목록
### 1️⃣구입 금액 입력 검증 테스트
1. 입력된 금액이 1,000원 단위일 경우 정상적으로 통과되는지 테스트. [ ✔ ]
2. 1,000원 단위가 아닌 경우 예외가 발생하는지 테스트.[  ✔ ]
3. 공백("") 또는 빈 문자열이 입력된 경우 예외가 발생하는지 테스트.[ ✔ ]
4. 1000원 미안을 입력한 경우 예외가 발생하는지 테스트.[ ✔ ]
5. 입력값이 1,000,000원을 초과한 경우 예외가 발생하는지 테스트 [ ✔ ]

<br>

### 2️⃣당첨 번호 입력 검증 테스트
1. 공백("") 또는 빈 문자열이 입력된 경우 예외가 발생하는지 테스트.[ ✔ ]
2. 1~45 범위의 양의 정수 값이 입력된 경우 정상적으로 통과되는지 테스트.[ ✔ ]
3. 입력 값이 숫자가 아닌 경우(문자나 특수문자) 예외가 발생하는지 테스트.[ ✔ ]
4. 음수나 0이 입력된 경우 예외가 발생하는지 테스트.[ ✔ ]
5. 입력값이 중복되는지 테스트[ ✔ ]
6. 입력한 숫자의 개수가 6개인지 확인하는 테스트[ ✔ ]
   
<br>

### 3️⃣보너스 번호 입력 검증 테스트
1. 공백("") 또는 빈 문자열이 입력된 경우 예외가 발생하는지 테스트.[ ✔ ]
2. 1~45 범위의 양의 정수 값이 입력된 경우 정상적으로 통과되는지 테스트.[ ✔ ]
3. 입력 값이 숫자가 아닌 경우(문자나 특수문자) 예외가 발생하는지 테스트.[ ✔ ]
4. 음수나 0이 입력된 경우 예외가 발생하는지 테스트.[ ✔ ]
5. 입력값이 중복되는지 테스트[ ✔ ]

<br>

### 4️⃣ 로또 발행 기능 테스트
1. 구입 금액에 따라 로또 발행 개수가 정확한지 테스트. [  ]
2. 한개의 로또당 1~45 범위의 숫자 6개가 중복되지 않고 발행되는지 테스트[  ]

<br>

### 5️⃣당첨 결과 확인 및 수익률 계산 기능 테스트
1. 각 로또 번호와 당첨 번호 비교 시 1~5등이 정확히 계산되는지 테스트. [  ]
2. 당첨 통계 출력이 요구사항에 맞게 정상적으로 출력되는지 테스트. [  ]
3. 수익률이 올바르게 계산되어 소수점 둘째 자리에서 반올림되는지 테스트. [  ]
<br>

### 6️⃣ 전체 시나리오 테스트
1. 정상적인 금액 입력, 로또 발행, 당첨 번호 입력 후 당첨 여부 확인 및 수익률 계산까지 전 과정을 테스트. [  ]
