# 로또 💰

_간단한 로또 발매기를 구현한다._

## **목표** 🎯

구입 금액, 당첨 번호, 보너스 번호를 입력받아 당첨 내역을 출력하는 프로그램

## 기능 목록 📋

```markdown
src
├── main
│   └── java
│       └── lotto
│           ├── Application.java                // 프로그램의 진입점
│           ├── controller
│           │   └── Controller.java             // 컨트롤러 클래스
│           ├── model
│           │   ├── ErrorMessage.java           // 에러 메시지 관리하는 열거형
│           │   ├── Lotto.java                  // 로또 클래스
│           │   ├── LottoReward.java            // 로또 당첨 금액을 관리하는 열거형
│           │   ├── Statistics.java             // 당첨 통계 클래스
│           │   └── WinningLotto.java           // 당첨 번호와 보너스 번호를 저장하는 클래스
│           ├── service
│           │   ├── LottoService.java           // 로또 생성, 통계 계산 클래스
│           │   └── Validator.java              // 유효성 검사 클래스
│           ├── util
│           │   └── Parser.java                 // 파싱 클래스
│           └── view
│               ├── Input.java                  // 사용자 입력 클래스
│               ├── Output.java                 // 출력 클래스
│               └── Prompt.java                 // 입력 안내 메시지 열거형
└── test
    └── java
        └── lotto
            ├── ApplicationTest.java            // 애플리케이션의 통합 테스트를 수행하는 클래스
            └── LottoTest.java                  // Lotto 클래스의 단위 테스트를 수행하는 클래스

```

## 예외 처리 목록 ✅
* 구입 금액
    + 천원 단위
    + 천원 미만
    + 십만원 초과
* 당첨 번호
    + 1 ~ 45
    + 6 미만, 6 초과
    + 중복
* 보너스 번호
    + 1 ~ 45
    + 1 이상인지
    + 당첨 번호와 중복
* 문자 입력
* 빈 입력
* 중복 로또 번호

### 라이브러리 🦾
* 입력은 `camp.nextstep.edu.missionutils.Randoms`의 pickUniqueNumbersInRange()를 활용한다. 
* 난수는 `camp.nextstep.edu.missionutils.Console`의 readLine()을 활용한다.

### Lotto 클래스
+ 제공된 Lotto 클래스를 사용하여 구현해야 한다.
+ Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
+ numbers의 접근 제어자인 private은 변경할 수 없다.
+ Lotto의 패키지를 변경할 수 있다.

### 개인 목표(공통 피드백 및 요구 사항)
- 하드코딩 줄이기
- 명명에 자료형쓰지 않기
    * 메서드명도 포함인가..?
- API 와 컬렉션 활용하기
    * 구현하기 전에 찾아봐라..
- 한 메서드가 한 가지 기능만 담당하게 하기
    * 메서드당 15줄 이하로 작성해보자
- 테스트를 작성하고, 경험을 정리하기
- 작은 단위 테스트부터 진행하기
- Java Enum을 적용하여 구현하기
    * 에러 메시지나 당첨 금액에 적용하면 될 듯


#### 마치면서
- 하드코딩 줄이기, 개인적인 습관이기도 하고 크게 고려하면서 작성하지 않았어서 어려웠었다.
- 마지막에 계속 테스트가 통과하지 않아서 열받았었는데 알고보니 2등 & 보너스 상금을 잘못 적었음
- MVC 패턴을 처음으로 적용하기 기존과 다르게 많이 시도했는데 아직은 갈 길이 많이 남은 것 같다.