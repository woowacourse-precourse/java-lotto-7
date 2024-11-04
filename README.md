# java-lotto-precourse

## 문제 요구 사항

간단한 로또 발매기를 구현한다.

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

#### 실행 결과 예시

    구입금액을 입력해 주세요.
    8000

    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43] 
    [3, 5, 11, 16, 32, 38] 
    [7, 11, 16, 35, 36, 44] 
    [1, 8, 11, 31, 41, 42] 
    [13, 14, 16, 38, 42, 45] 
    [7, 11, 30, 40, 42, 43] 
    [2, 13, 22, 32, 38, 45] 
    [1, 3, 5, 14, 22, 45]

    당첨 번호를 입력해 주세요.
    1,2,3,4,5,6

    보너스 번호를 입력해 주세요.
    7

    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.

## 구현 기능 목록

구입 금액 입력 -> 로또 번호 생성 -> 발행한 로또 수량 및 번호 출력 -> 당첨 번호 입력 -> 보너스 번호 입력 -> 일치하는 번호 확인 -> 당첨 통계 출력

### 1. 기능

- #### 입력
    - [x] 로또 구입 금액 입력
        - [x] 구입 금액은 1,000원 단위로 입력
        - [x] 1000원으로 나누어 떨어지지 않는 경우 예외 처리
    - [x] 당첨 번호 입력
        - [x] 번호는 쉼표(,)를 기준으로 구분
        - [x] 당첨 번호는 6개
        - [x] 중복된 숫자는 예외 처리
    - [x] 보너스 번호 입력
        - [x] 보너스 번호는 1개
        - [x] 당첨 번호에 있는 숫자는 예외 처리

- #### 출력
    - [x] 발행한 로또 수량 및 번호 출력
        - [x] 로또 번호는 오름차순으로 정렬
    - [x] 당첨 내역 출력
    - [x] 수익률은 소수점 둘째 자리에서 반올림 (ex. 100.0%, 51.5%, 1,000,000.0%)
    - [x] 예외 상황 시 에러 문구 출력
        - [x] 에러 문구는 "[ERROR]"로 시작해야 함

- #### 로또 번호 생성
    - [x] 로또 수량 구하기 (구입 금액 / 1000)
    - [x] 로또 수량 만큼 로또 번호 6개씩 생성 (1부터 45 사이의 무작위 숫자, 중복 없음)

- #### 일치하는 로또 번호 확인
    - [x] 생성된 로또 번호에서 일치하는 번호 개수 세기
    - [x] 5개 일치할 경우, 남은 번호를 보너스 번호와 비교
    - [x] 당첨 금액 합산
    - [x] 총 수익률 구하기 (문제 예시를 봤을 땐 (당첨금액합 / 구입금액 * 100))

### 2. 세부 조건

- [x] 로또 번호 한 세트에 중복 숫자 없어야 함
- [x] 당첨 번호 입력 형식은 "1,2,3,4,5,6" 이것만 허용
- [x] 당첨 번호와 보너스 번호는 중복되면 안됨

### 3. 프로그래밍 요구 사항 1

- [x] JDK 21 버전에서 실행 가능해야 한다.
- [x] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [x] `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [x] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [x] 기본적으로 Java Style Guide를 원칙으로 한다.

### 4. 프로그래밍 요구 사항 2

- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.  
  예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.  
  힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

### 4. 프로그래밍 요구 사항 2

- [x] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - [x] 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- [x] else 예약어를 쓰지 않는다.
    - [x] else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.  
      힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- [x] Java Enum을 적용하여 프로그램을 구현한다.
- [x] 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - [x] 단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.

#### 라이브러리

- [x] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - [x] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - [x] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### Lotto 클래스

- [x] 제공된 `Lotto` 클래스를 사용하여 구현해야 한다.
- [x] `Lotto`에 `numbers` 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- [x] `numbers`의 접근 제어자인 `private`은 변경할 수 없다.
- [x] `Lotto`의 패키지를 변경할 수 있다.

## 클래스 다이어그램

![classdiagram](https://github.com/user-attachments/assets/fb90e220-b96e-420d-b3fb-86cd6a9d9645)

## 클래스 설명

|     Package      |         Class         | Description            |
|:----------------:|:---------------------:|------------------------|
|  common.config   |       Constants       | 로또 관련 상수 enum          |
|                  |  InstructionMessages  | 안내 메시지 enum            |
|                  |       LottoRank       | 로또 등수별 정보 enum         |
|                  |       AppConfig       | 의존성 주입 class           |
| common.exception |  EmptyInputException  | 빈 입력 exception         |
|                  | InvalidInputException | 잘못된 입력 exception       |
|                  | InvalidStateException | 잘못된 상태 exception       |
|                  |   ExceptionMessages   | 예외 메시지 enum            |
| common.validator |    InputValidator     | 입력값 기준에 따라 판별 class    |
|    controller    |    LottoController    | 로또 동작 처리 class         |
|       view       |         Input         | 입력값 처리 interface       |
|                  |  PurchaseAmountInput  | 구입 금액 입력 class         |
|                  |  WinningNumbersInput  | 당첨 번호 입력 class         |
|                  |   BonusNumberInput    | 보너스 번호 입력 class        |
|                  |        Output         | 출력 처리 class            |
|     service      |    LottoGenerator     | 구입 로또 번호 생성 class      |
|                  |     LottoChecker      | 로또 번호 일치 검사 class      |
|                  |     WinningResult     | 당첨 결과 처리 class         |
|      domain      |         Lotto         | 로또 번호 한 세트 class       |
|                  |      MatchResult      | 로또 번호 한 세트 당첨 결과 class |
|                  |    PurchasedLottos    | 구입 로또 리스트 class        |
|                  |    WinningNumbers     | 당첨 번호 class            |
|                  |   WinningStatistics   | 당첨 통계 계산 class         |
