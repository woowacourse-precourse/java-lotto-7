![image](https://github.com/user-attachments/assets/6c57b634-be63-4d6d-ab09-54dc46ebdec5)

## 프로젝트 소개
본 프로젝트는 간단한 로또 프로그램입니다.

사용자에게서 구입 금액을 입력 받아 금액만큼 로또를 발행하며
당첨 번호, 보너스 번호를 각각 입력 받은 뒤
발행된 로또와 비교하여 당첨 순위와 수익률을 보여줍니다.

## 📌 프로젝트 구조

프로젝트의 구조는 다음과 같이 설계되었습니다.

```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── lotto
│   │   │       └── constant
│   │   │       │    ├── ErrorMessage.java
│   │   │       │    ├── OutputMessage.java
│   │   │       └── controller
│   │   │       │    ├── LottoController.java
│   │   │       └── domain
│   │   │       │    ├── Lotto.java
│   │   │       │    ├── LottoBuyer.java
│   │   │       │    ├── LottoPublisher.java
│   │   │       │    ├── LottoRankSummary.java
│   │   │       │    └── LottoWinningRanks.java
│   │   │       └── service
│   │   │       │    └── LottoService.java
│   │   │       └── validator
│   │   │       │    └── InputValidator.java
│   │   │       └── view
│   │   │       │    ├── Input.java
│   │   │       │    └── Output.java
│   │   │       └── vo
│   │   │       │    ├── BonusNumber.java
│   │   │       │    ├── LottoNumber.java
│   │   │       │    ├── PurchaseAmount.java
│   │   │       │    └── WinningNumber.java
│   │   │       └── Application.java
│   └── test
│   │   ├── java
│   │   │   └── lotto
│   │   │       └── domain
│   │   │       │    ├── Lotto.java
│   │   │       │    ├── LottoBuyer.java
│   │   │       │    ├── LottoPublisher.java
│   │   │       │    └── LottoWinningRanks.java
│   │   │       └── validator
│   │   │       │    └── InputValidatorTest.java
│   │   │       └── vo
│   │   │       │    ├── BonusNumberTest.java
│   │   │       │    ├── LottoNumberTest.java
│   │   │       │    ├── PurchaseAmountTest.java
│   │   │       │    └── WinningNumberTest.java
│   │   │       └── ApplicationTest.java
├── build.gradle
└── README.md
```

- `src/main/java/lotto/domain`: 로또에서 사용되는 도메인을 제공하는 클래스
- `src/main/java/lotto/service`: 도메인을 이용하여 로또 서비스을 제공하는 클래스
- `src/main/java/lotto/controller`: 프로그램의 흐름을 제어하는 클래스
- `src/main/java/lotto/vo`: 값들을 래핑하는 객체 클래스
- `src/main/java/lotto/validator`: 입력을 검증하는 클래스
- `src/main/java/lotto/constant`: 출력 메세지와 에러 메세지를 모아둔 클래스
- `src/main/java/lotto/view`: 입력, 출력을 맡는 클래스
- `src/test/java/lotto/domain`: 로또에서 사용되는 도메인 테스트
- `src/test/java/lotto/validator`: 입력 검증 테스트
- `src/test/java/lotto/vo`: 객체별로 유효한 값인지 검증, 에러메세지 테스트
- `build.gradle`: 프로젝트의 빌드 설정을 정의한 파일
- `README.md`: 프로젝트에 대한 소개와 사용법, 구현 기능 목록을 소개하는 문서

## 💡 프로젝트 기능
- 로또 구입 금액을 입력받아, 그 금액에 해당하는 만큼 로또를 발행한다.
- 사용자가 당첨 번호와 보너스 번호를 입력한다.
- 입력된 당첨 번호와 사용자의 로또 번호를 비교하여 당첨 내역과 수익률을 출력한다.
- 사용자가 잘못된 값을 입력한 경우, 에러 메시지를 표시하고 다시 입력받는다.

# 구현 기능 목록

## 🟡 **입력**
    - 로또 구입 금액을 입력 받기
        - 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않으면 예외 처리

    - 당첨 번호를 입력 받기
        - 번호는 쉼표(,)를 기준으로 구분하며 다른 구분자를 사용하면 예외 처리
        - 숫자가 6개가 아니면 예외 처리
        - 중복되는 숫자가 있다면 예외 처리

    - 보너스 번호를 입력 받기
        - 당첨 번호와 중복되는 숫자가 있다면 예외 처리

    - 공통 예외 상황
        - 빈 문자열, null, 공백을 입력하면 예외 처리
        - 문자가 입력되면 예외 처리
        - 0 또는 음수가 입력되면 예외 처리
        - 숫자와 띄어쓰기가 함께 입력되면 예외 처리

## 🟢 **처리 과정**
    1. 입력 받은 금액 만큼 로또를 발행
        - 로또 1장의 가격은 1000원
        - 로또 번호의 숫자 범위는 1~45까지
        - 로또 번호는 중복되지 않는 6개의 숫자
        - 발행된 로또는 오름차순으로 정렬

    2. 입력 받은 당첨 번호 및 보너스 번호와 발행한 로또 비교
        - 6개 번호 일치 / 2,000,000,000원
        - 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 5개 번호 일치 / 1,500,000원
        - 4개 번호 일치 / 50,000원
        - 3개 번호 일치 / 5,000원

    3. 비교하여 나온 당첨 내역과 수익률 계산
        - 수익률은 소수점 둘째 자리에서 반올림

## 🔴 **출력**
    - 구입 금액 입력 요청 메세지 출력
    - 발행한 로또 수량 및 번호를 출력
    - 당첨 번호 입력 요청 메세지 출력
    - 보너스 번호 입력 요청 메세지 출력
    - 당첨 내역을 출력
    - 수익률을 출력
    - 예외 상황 시 에러 문구를 출력
        - 에러 문구는 "[ERROR]"로 시작
