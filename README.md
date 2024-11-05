# 💰💵 로또 게임 💵💰

***

## ⭐️ 핵심 기능

### ✅ 입력 기능

- [x] 로또 구입 금액 입력 기능
- [x] 당첨 번호 입력 기능
- [x] 보너스 번호 입력 기능

### ✅ 로또 발행 기능

- [x] 구입 금액에 해당하는 만큼 로또를 발행
- [x] 발행된 하나의 로또 당 1에서 45 사이의 중복되지 않은 6개의 숫자 뽑기
    - [x] 로또 번호 오름차순 정렬 기능

### ✅ 로또 번호와 당첨 번호 비교 기능

- [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교

### ✅ 계산 기능

- [x] 등수 계산 기능
    - [x] 5개 일치하는 경우 보너스 번호 비교
- [x] 당첨금 계산 기능
- [x] 수익률 계산 기능

### ✅ 출력 기능

- [x] 발행한 로또 수량 출력
- [x] 발행한 로또 번호 출력
- [x] 당첨 내역 출력
- [x] 수익률 출력

### ✅ 예외 처리 기능

- 로또 구입 금액 입력 시
    - [x] 입력값이 존재하지 않는 경우
    - [x] 입력값이 숫자가 아닌 경우
    - [x] 한 장 가격 미만인 경우
    - [x] 한 장 가격으로 나누어 떨어지지 않는 경우
    - [x] 최대로 구매 가능한 로또 금액을 초과하는 경우

- 당첨 번호 입력 시
    - [x] 입력값이 존재하지 않는 경우
    - 구분자가 잘못 입력된 경우
        - [x] 잘못된 구분자가 입력된 경우
        - [x] 추가적으로 구분자가 더 입력된 경우
    - [x] 각 입력값이 숫자가 아닌 경우
    - [x] 숫자가 여섯 개가 아닌 경우
    - [x] 각 숫자가 범위에서 벗어난 경우
    - [x] 중복되는 숫자가 존재하는 경우

- 보너스 번호 입력 시
    - [x] 입력값이 존재하지 않는 경우
    - [x] 입력값이 숫자가 아닌 경우
    - [x] 숫자가 범위에서 벗어나는 경우
    - [x] 당첨 번호와 중복되는 경우

***

## 📦 역할별 패키지 분리

```
src/
├── main
│   └── java
│       └── lotto
│           ├── Application.java
│           ├── config
│           │   ├── Config.java                   // Reader와 Writer 구현체를 구성해 반환
│           │   └── LottoConfig.java              // Config를 주입받아 입출력에 필요한 컴포넌트 반환
│           ├── constants
│           │   ├── ExceptionMessages.java 
│           │   ├── InputMessages.java
│           │   ├── NumberConstants.java
│           │   ├── OutputMessages.java
│           │   └── StringConstants.java
│           ├── controller
│           │   └── LottoController.java
│           ├── domain
│           │   ├── Lotto.java                    // 로또 객체
│           │   ├── Rank.java                     // 일치 개수별 등수를 관리
│           │   ├── WinningLotto.java             // 당첨 로또를 관리
│           │   └── WinningProcessor.java         // 당첨 결과(통계, 당첨금, 수익률)를 관리
│           ├── dto
│           │   ├── UserLotto.java                // 사용자가 구매한 로또를 저장
│           │   └── WinningResult.java            // 당첨 결과를 저장
│           │
│           ├── exception                          // 커스텀 예외 메서드
│           ├── io
│           │   ├── InputHandler.java              // 입력값을 받아 반환
│           │   ├── InputValidator.java            // 입력값을 검증
│           │   ├── OutputHandler.java             // 결과를 출력 
│           │   ├── UserLottoParser.java           // 사용자가 구매한 로또를 파싱해 문자열 값으로 반환
│           │   ├── WinningResultParser.java       // 당첨 결과를 파싱해 문자열 값으로 반환
│           │   ├── reader
│           │   │   ├── MissionUtilsReader.java    // Reader의 구현체로, 콘솔에서 값을 입력받음
│           │   │   └── Reader.java                // 입력을 추상화
│           │   └── writer
│           │       ├── SystemWriter.java          // Writer의 구현체로, 콘솔에 값을 출력
│           │       └── Writer.java                // 출력을 추상화
│           ├── service
│           │   └── LottoService.java             
│           └── validator
│               └── Validator.java                 
└── test
    └── java
        └── lotto
            ├── ApplicationTest.java
            ├── LottoTest.java
            ├── domain
            │   ├── RankTest.java
            │   ├── WinningLottoTest.java
            │   └── WinningProcessorTest.java
            ├── io
            │   ├── InputHandlerTest.java
            │   ├── InputValidatorTest.java
            │   ├── OutputHandlerTest.java
            │   ├── UserLottoParserTest.java
            │   └── WinningResultParserTest.java
            ├── service
            │   └── LottoServiceTest.java
            └── testutil
                ├── ReaderFake.java                 // 테스트 입력값을 모킹
                └── WriterFake.java                 // 테스트 출력값을 검증
```

***

## ✅ 프로그래밍 요구 사항

### 제출 전 확인 리스트

- [x] JDK-21 사용
- [x] 프로그램 실행의 시작점은 `Application`의 `main()`
- [x] `build.gradle` 변경 불가, 제공된 라이브러리만 사용
- [x] [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 준수하며 프로그래밍
- [x] 프로그램 종료 시`System.exit()`를 호출 X
- [x] 프로그램 구현 완료 시 `ApplicationTest`의 모든 테스트가 성공
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동 X
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현(2까지만 허용)
- [x] 3항 연산자 사용 X
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들기
- [x] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인
- [x] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현
- [x] else 예약어 사용 X
- [x] Java Enum을 적용하여 프로그램을 구현
- [x] 구현한 기능에 대한 단위 테스트를 작성(단, UI(System.out, System.in, Scanner) 로직은 제외)

### 라이브러리 요구 사항

- [x] camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현
- [x] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
