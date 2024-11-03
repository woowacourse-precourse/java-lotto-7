# java-lotto-precourse

![image](https://github.com/user-attachments/assets/7e5f21c4-fd8f-421f-bf5a-a0e75116beb7)

> # 🎫 로또
> 간단한 로또 발매기를 구현한다.

<br>

> ## 🗞️ 프로젝트 개요
> 입력된 로또 구입 금액에 따른 각 로또 번호, 당첨 결과와 수익률을 출력한다.

<br>

- 로또 번호의 숫자 범위는 1~45이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등~5등까지 있고, 당첨 기준과 금액은 아래와 같다.
  - 1등 : `6`개 번호 일치 / `2,000,000,000`원
  - 2등 : `5`개 번호 + 보너스 번호 일치 / `30,000,000`원
  - 3등 : `5`개 번호 일치 / `1,500,000`원
  - 4등 : `4`개 번호 일치 / `50,000`원
  - 5등 : `3`개 번호 일치 / `5,000`원
- 로또 1장의 가격 `1,000`원에 따라 로또를 발행한다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력한다.
- 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고
  "[ERROR]"로 시작하는 에러 메시지를 출력 후<br>그 부분부터 입력을 다시 받는다.
  - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.
 
<br>

> ## 📃 프로그래밍 요구 사항
> 기존의 프로그래밍 요구 사항에 추가로 고려한다.

<br>

- 함수(또는 메서드)의 길이가 15라인을 넘지 않도록 한다.
  - 함수(또는 메서드)가 한 가지 일만 하도록 구현한다.
- `else` 예약어를 쓰지 않는다.
  - `switch/case`도 허용하지 않는다.
- Java Enum을 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI로직은 제외한다.

<br>

> ## 🕸️ 클래스 및 기능 설명

<br>

### Model
  - **Lotto**: 입력받은 로또 번호(당첨 번호)를 저장하며, 생성 시 `LottoValidator`를 통해 유효성을 검사
  - **LottoBonus**: 입력받은 보너스 번호를 저장하며, 생성 시 `LottoBonusValidator`를 통해 유효성을 검사
  - **LottoRank**: 당첨 결과를 정의하는 Enum으로, 매칭된 숫자의 개수에 따른 등수와 상금 정보를 관리
  - **LottoTicket**: 랜덤으로 생성된 로또 티켓 번호를 저장

<br>

### View
  - **InputView**: 사용자로부터 구매 금액, 당첨 번호, 보너스 번호를 입력받는 역할
    - `inputPurchasePrice`: 구입 금액을 입력받음
    - `inputWinningNumbers`: 당첨 번호를 입력받음
    - `inputBonusNumber`: 보너스 번호를 입력받음
      
  - **OutputView**: 사용자에게 구매 금액에 따른 로또 발행 갯수, 정렬된 로또 번호, 당첨 통계, 총 수익률을 출력
    - `displayPurchaseCount`: 구매한 로또 티켓 수를 출력
    - `displayLottoTickets`: 정렬된 로또 티켓 번호들을 출력하며, `Controller`에서 정렬된 리스트를 받아와 표시
    - `displayResult`: 당첨 통계를 출력하며, 등수별로 당첨 개수를 표시
    - `displayProfitRate`: 총 수익률을 출력
    
<br>

### Controller
  - **LottoNumberController**: 당첨 번호와 보너스 번호를 입력받고 `Lotto`와 `LottoBonus` 객체를 생성
     - `generateWinningLotto`: `InputView`로부터 입력을 받고, `InputValidator`를 사용해 기초 검증을 수행한 후 `Lotto` 객체를 반환
     - `generateBonusNumber`: 입력된 보너스 번호가 유효한지 검증한 후 `LottoBonus` 객체를 반환
   
   - **LottoPurchaseController**: 사용자가 입력한 구매 금액을 통해 로또 티켓을 생성하고, 그 결과를 출력
     - `purchaseLottoTickets`: 구매 금액을 `InputView`로부터 입력받아 검증한 후, 해당 금액으로 구매 가능한 티켓을 생성하여<br>정렬된 형태로 `OutputView`에 전달
  
   - **LottoResultChecker**: 로또 당첨 결과를 계산하고, 총 수익률을 산출하여 출력
     - `displayResults`: 티켓과 당첨 번호, 보너스 번호를 받아 당첨 결과와 수익률을 계산하고 이를 `OutputView`에 전달하여 출력
     - `checkResults`: 티켓별 당첨 결과를 `LottoRank`를 기준으로 집계하고, `calculateProfitRate` 메서드는 결과를 바탕으로<br>총 수익률을 계산
  
   - **LottoTicketGenerator**: 구매 금액에 따라 생성해야 할 티켓 수를 계산하여 로또 티켓을 생성하고 반환
     - `generateTickets`: 입력받은 구매 금액에 따라 `LottoTicket` 객체를 생성하고 리스트로 반환

<br>

### Validator

- **InputValidator**: 입력받은 문자열을 유효한 정수로 변환하고, 쉼표로 구분된 로또 번호 목록 생성
  - `validateInteger`: 입력이 정수인지 확인하며, 정수가 아닌 경우 예외 발생
  - `validateWinningNumbers`: 입력 문자열을 쉼표로 분리하고, 각 요소가 정수인지 검사하여 로또 번호 리스트로 변환.<br>정수가 아닌 값이 포함된 경우 예외 발생

- **LottoBonusValidator**: 보너스 번호의 유효성을 검사.
  - `validateBonusNumber`: 보너스 번호가 로또 번호와 중복되지 않도록 검증하며, 범위가 1에서 45 사이인지 확인.<br>조건을 만족하지 않으면 예외 발생

- **LottoTicketValidator**: 로또 티켓 구입 금액의 유효성을 검사
  - `validatePurchasePrice`: 구입 금액이 양수인지, 1000원 단위인지 검사
  - `validatePositive`: 금액이 양수인지 확인
  - `validateUnit`: 금액이 1000원 단위인지 확인

- **LottoValidator**: 로또 번호 리스트의 유효성을 검사
  - `validateLottoNumbers`: 로또 번호의 개수, 각 번호의 범위, 중복 여부를 확인하여 유효성을 검증
  - `validateSize`: 로또 번호가 정확히 6개인지 확인
  - `validateRange`: 각 번호가 1에서 45 사이의 범위인지 확인
  - `validateDuplicates`: 로또 번호에 중복된 값이 없는지 확인

<br>
  
> ## 🔨 기능 목록

<br>
 
### 입력 기능
- 로또 구입 금액 입력받는 기능 ☑️
- `1~45`까지의 당첨 번호 `6`개의 숫자를 입력받는 기능 ☑️ 
- **당첨 번호 제외** 보너스 번호를 입력받는 기능 ☑️
### 연산 기능
- 로또를 발행 시 중복되지 않는 `6`개의 숫자를 뽑는 기능 ☑️
- 당첨 번호 추첨 시 중복되지 않는 `6`개의 숫자와 보너스 번호 `1`개를 뽑는 기능 ☑️
- 로또 구입 금액에 따른 로또를 발행하는 기능 ☑️
- 발행한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 구하는 기능 ☑️
- 당첨 내역에 따른 수익률을 구하는 기능
### 출력 기능
- 발행한 로또 수량 및 번호를 오름차순 출력하는 기능 ☑️
- 당첨 내역을 출력하는 기능 ☑️
- 수익률을 출력하는 기능 ☑️

<br>

> ## 🔧 예외 처리 목록
> 예외 상황 시 에러 문구를 [ERROR]로 시작하여 출력

<br>

### 로또 금액 입력 예외
  - 로또 금액이 완전한 정수가 아닌 경우 ☑️
  - 로또 금액이 양수가 아닌 경우 ☑️
  - 로또 금액이 `1,000`원 단위로 나누어 떨어지지 않는 경우 ☑️
### 당첨 번호 입력 예외
  - 당첨 번호에 정수가 아닌 값이 있을 경우 ☑️
  - 당첨 번호가 `6`개가 주어지지 않은 경우 ☑️
  - 당첨 번호 중 `1~45`의 범위를 벗어나는 수가 존재하는 경우 ☑️
  - 당첨 번호 중 중복되는 수가 존재하는 경우 ☑️
### 보너스 번호 입력 예외
   - 보너스 번호가 정수가 아닌 경우 ☑️
   - 보너스 번호가 `1~45`의 수가 아닌 경우 ☑️
   - 보너스 번호가 당첨 번호와 중복되는 경우 ☑️

<br>

> ## 📺 개발 환경
- <img src="https://img.shields.io/badge/Build-%23121011?style=for-the-badge"><img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Gradle&logoColor=white"><img src="https://img.shields.io/badge/8.7-515151?style=for-the-badge">
- <img src="https://img.shields.io/badge/Language-%23121011?style=for-the-badge"><img src="https://img.shields.io/badge/java-%23ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"><img src="https://img.shields.io/badge/21-515151?style=for-the-badge">
- <img src="https://img.shields.io/badge/Project Encoding-%23121011?style=for-the-badge"><img src="https://img.shields.io/badge/UTF 8-EA2328?style=for-the-badge">
