# java-lotto-precourse


##  학습 목표

- 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
- 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.

## 구현

### 사용 라이브러리
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.

### 입력
- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받는다.
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
	- 로또 번호의 숫자 범위는 1 ~ 45 까지이다.
- 보너스 번호를 입력 받는다.
	- 보너스 번호는 당첨 번호와 달라야 한다.

### 기능

- 구매 수량만큼 로또를 발행한다. 단, 번호는 중복되어서는 안된다.
- 당첨은 1등부터 5등까지 있다.
	- 1등: 6개 번호 일치 / 2,000,000,000원
	- 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
	- 3등: 5개 번호 일치 / 1,500,000원
	- 4등: 4개 번호 일치 / 50,000원
	- 5등: 3개 번호 일치 / 5,000원

### 출력

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
- 당첨 내역을 출력한다.
- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

### 예외 처리

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
	- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
- 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

### 기타 사항

- 프로그램 종료 시 System.exit()를 호출하지 않는다.

## 테스트

- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

## 코딩 컨벤션

- 블록 들여쓰기는 4 space
- 열 제한 120자 이내
- 들여쓰기를 지속하려면 다음 줄에 8 space
- 가독성 향상을 위해서는 어디서든 enter
- indent(인덴트, 들여쓰기)는 2까지만 허용한다.(메소드를 적극적으로 분리하여 구현할 것)
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- else 예약어를 쓰지 않는다.(switch/case도 허용하지 않는다.)
- Java Enum을 적용하여 프로그램을 구현한다.


## 패키지 구조

이번 주차에서는 '객체'에 보다 집중해서 구현해보았다. 확실히 OOPL의 핵심인 객체 위주로 개발을 하니 전반적으로 정리정돈이 잘 된 느낌이 들었다. 그러나 주어진 요구사항 볼륨에 비해 너무 과하게 계층을 분리한 것 같아서, 다음에는 일부 계층을 축소시킬 계획이다.

```
+---main
|   \---java
|       \---lotto
|           |   Application.java
|           |
|           +---config
|           |       LottoConfig.java
|           |
|           +---controller
|           |       LottoController.java
|           |
|           +---domain
|           |   |   AmountOfLottos.java
|           |   |   BonusNumber.java
|           |   |   Lotto.java
|           |   |   ResultCount.java
|           |   |   WinningNumbers.java
|           |   |
|           |   \---enums
|           |           WinningStatistics.java
|           |
|           +---error
|           |   \---enums
|           |           LottoErrorMessage.java
|           |
|           +---io
|           |   |   Input.java
|           |   |   Output.java
|           |   |
|           |   +---enums
|           |   |       LottoInquiryMessage.java
|           |   |
|           |   \---impl
|           |           ConsoleInput.java
|           |           ConsoleOutput.java
|           |
|           \---service
|                   LottoService.java
|
\---test
    \---java
        \---lotto
            |   ApplicationTest.java
            |
            \---domain
                    AmountOfLottosTest.java
                    BonusNumberTest.java
                    LottoTest.java
                    WinningNumbersTest.java
```


## 비즈니스

- 마감일시: 24-11-04 23:59
- 제출 시작일시: 24-11-03 15:00
- 지원 플랫폼에 로그인한 뒤 '제출하기'를 눌러 과제 제출하여 예제 테스트 실행해볼 것
- 제출 이후에도 push를 통해 수정 가능
- 단, 마감 이후에는 추가 push를 허용하지 않음