# 💰💵 로또 게임 💵💰

***

## 학습 목표

- 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
- 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.
- 2주 차 공통 피드백을 최대한 반영한다.

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

### 📁 [controller]

#### - LottoController

### 📁 [domain]

#### - Lotto

#### - Rank

#### - WinningLotto

#### - WinningProcessor

### 📁 [dto]

#### - LottoRequest

#### - UserLotto

#### - WinningResult

### 📁 [service]

#### - LottoService

### 📁 [io]

#### - reader

#### - writer

#### - InputHandler

#### - InputValidator

#### - OutputHandler

#### - UserLottoParser

#### - WinningResultParser

### 📁 [config]

#### - Config

#### - LottoConfig

### 📁 [constants]

#### - ExceptionMessages

#### - InputMessages

#### - NumberConstants

#### - OutputMessages

#### - StringConstants

### 📁 [exception]

#### - BonusNumberDuplicatedLottoNumberException

#### - BonusNumberOutOfRangeException

#### - BuyAmountHasChangeException

#### - DuplicatedLottoNumberException

#### - EmptyWinningNumberInputException

#### - IllegalInputReadException

#### - IllegalNumberFormatException

#### - LottoCountOutOfRangeException

#### - LottoNumberCountOutOfRangeException

#### - LottoNumberOutOfRangeException

***

## ✅ 프로그래밍 요구 사항

### 제출 전 확인 리스트

- [ ] JDK-21 사용
- [ ] 프로그램 실행의 시작점은 `Application`의 `main()`
- [ ] `build.gradle` 변경 불가, 제공된 라이브러리만 사용
- [ ] [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 준수하며 프로그래밍
- [ ] 프로그램 종료 시`System.exit()`를 호출 X
- [ ] 프로그램 구현 완료 시 `ApplicationTest`의 모든 테스트가 성공
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동 X
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현(2까지만 허용)
- [ ] 3항 연산자 사용 X
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들기
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인
- [ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현
- [ ] else 예약어 사용 X
- [ ] Java Enum을 적용하여 프로그램을 구현
- [ ] 구현한 기능에 대한 단위 테스트를 작성(단, UI(System.out, System.in, Scanner) 로직은 제외)

### 라이브러리 요구 사항

- [ ] camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현
- [ ] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
