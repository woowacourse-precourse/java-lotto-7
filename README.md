# java-lotto-precourse

### 개요
- 여러 개의 로또가 발행 된다.
- 당첨번호 6개와 보너스 번호 1개를 이용해 당첨 여부 판별
- 수익률 출력

## 주요 기능

### ✅ 로또 티켓 생성
  - [X] 사용자가 입력한 금액에 따라 구매 가능한 로또 티켓 생성
  - [X] 구입 금액이 숫자인지 검증
  - [X] 구입 금액이 1000원단위 인지 검증

### ✅ 6개의 당첨번호 입력
  - [X] 당첨번호가 숫자인지 검증
  - [X] 당첨번호가 1~45사이 인지 검증
  - [X] 당첨번호 중복 검증

### ✅ 보너스 번호 1개를 입력
  - [X] 보너스번호가 숫자인지 검증
  - [X] 보너스번호가 1~45인지 검증
  - [X] 당첨번호와 중복되는지 검증

### ✅ 당첨 여부 확인
  - [X] 생성된 로또 티켓과 입력된 당첨 번호를 비교하여 당첨 여부 확인
  - [X] 각 티켓의 당첨 등급을 계산

### ✅ 수익률 계산
  - [X] 구매 금액 대비 수익률 계산하여, 사용자가 얻은 수익 계산

### ✅ 결과 출력
  - [X] 구매한 로또 티켓, 당첨 결과, 수익률을 출력

### ✅ 예외 처리
  - [X] 예외 발생이 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그부분부터 입력을 다시 받는다.

## 📦 패키지 구조
1. constants
   - ErrorMessage: 애플리케이션 전반에서 사용되는 에러 메시지 상수를 정의한 클래스
   - LottoConstants: 로또 시스템에서 사용되는 상수 값을 정의한 클래스

2. controller
   - LottoController: 애플리케이션의 주요 흐름을 관리하는 컨트롤러로, 사용자 입력과 출력, 서비스 호출을 통해 로또 게임의 전체적인 흐름을 제어

3. domain
   - domain.lotto
     - Lotto: 로또 티켓을 나타내는 도메인 객체로, 로또 번호와 관련된 기본 로직을 포함
     - IssuedLotto: 발행된 로또 티켓의 목록을 관리하는 객체
     - Rank: 당첨 등급을 나타내는 열거형으로, 등급별 일치 번호 수와 상금을 정의
   - domain.purchase
     - PurchaseAmount: 사용자가 입력한 구매 금액을 나타내는 객체로, 금액 유효성 검사와 관련된 로직을 포함
   - domain.winning
     - WinningNumbers: 당첨 번호를 나타내는 객체로, 로또 번호와 보너스 번호를 포함하고 당첨 여부를 확인하는 기능을 제공

4. service
   - LottoService: 다른 서비스(LottoGeneratorService, WinningCheckerService, ProfitCalculatorService)를 조합하여 로또 게임의 주요 비즈니스 로직을 관리
   - LottoGeneratorService: 로또 티켓을 생성하는 로직을 담당하는 서비스
   - ProfitCalculatorService: 당첨 결과를 기반으로 수익률을 계산하는 서비스
   - WinningCheckerService: 로또 티켓과 당첨 번호를 비교하여 당첨 등급을 확인하는 로직을 포함하는 서비스

5. validator
   - PurchaseAmountValidator: 구매 금액의 유효성을 검증하는 클래스
   - WinningNumberValidator: 당첨 번호와 보너스 번호의 유효성을 검증하는 클래스

6. view
   - InputView: 사용자로부터 입력을 받는 클래스
   - OutputView: 사용자에게 결과를 출력하는 클래스