# 프리코스 3주차 Lotto

## 기능 목록
> 간단한 **자동** 로또 발매기 이다.

- [X] 로또 번호의 숫자 범위는 1~45까지이다.
  - 로또 번호가 숫자가 아닌 경우 예외 처리한다.
  - 로또 번호가 1~45사이가 아닌 경우 예외 처리한다.
- [X] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- [X] 로또 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
  - 보너스 번호를 포함한 추첨한 모든 번호는 중복될수 없다.
- [X] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- [X] 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- [X] 로또 1장의 가격은 1,000원이다.
  - 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
  - 가격은 0원 보다 커야 한다.
  - 가격은 숫자여야 한다.
- [X] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 계산한다.
  - 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- [X] 금액을 입력받는다.
- [X] 사용자가 구매한 로또를 출력한다.
- [X] 당첨 번호와 보너스 번호를 입력받는다.
  - 당첨 번호는 6개여야 한다.
  - 당첨 번호는 중복될수 없다.
  - 당첨 번호는 1~45 사이의 숫자여야 한다.
  - 보너스 번호는 1~45 사이의 숫자여야 한다.
- [X] 결과를 출력하고 로또 게임을 종료한다.
- [X] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 클래스 구조

### model
- LottoNumber
  - 로또 번호를 나타내는 일급객체
  - 1~45까지의 숫자만 유지함
- BonusNumber
  - 보너스 번호를 나타내는 일급객체
  - LottoNumber를 일급으로 유지하고 있음
- Lotto
  - 6개의 로또 번호를 유지하는 로또 
  - 일급 컬렉션으로 Set<LottoNumber>를 유지하고 있음
  - 6개의 중복되지 않는 LottoNumber를 유지함
- WinningLotto
  - 당첨된 로또 번호
  - 당첨된 Lotto, BonusNumber를 유지하고 있음
  - Lotto번호에 존재하는 BonusNumber는 존재할 수 없음
- LottoRankEvaluator
  - 사용자가 구매한 로또의 순위를 계산함
  - WinnerLotto를 유지하여 계산함  
- LottoResult
  - 사용자가 구매한 로또의 당첨 결과를 카운터맵(Map<Rank, Integer>)으로 유지하고 있음
  - 로또의 결과로 수익률을 계산함
- Lottos
  - 사용자가 구매한 로또들을 유지함
  - 일급 컬렉션으로 List<Lotto>를 유지하고 있음
  - 사용자가 구매한 로또의 가격을 계산함
- LottoShop
  - 사용자가 금액을 입력하면, 개수에 맞게 로또를 생성한다.
- Rank
  - 로또의 랭킹을 유지하는 enum

### view
- InputView
  - 사용자의 입력을 받음
- OutputView
  - 프로그램의 결과를 출력
- Message
  - 프로그램의 결과를 출력할때 사용하는 문자열을 enum으로 유지
- PrintStringBuilder
  - StringBuilder를 유지하는 일급객체
  - print의 I/O를 줄이기 위해 사용하는 StringBuilder를 편리하게 사용하기 위한 클래스

### controller
- LottoController
  - InputView, OutputView, LottoService의 흐름을 제어
  - 입력 데이터를 가공하여 LottoService에 전달
  - LottoService의 결과물을 OutputView로 전달

### exception
- DuplicateLottoNumberException
  - 로또에 동일한 번호가 있을 경우 발생하는 예외
- ExactChangeNotPossibleException
  - 금액이 1,000원에 나누어 떨어지지 않을때 발생하는 예외
- IllegalArgumentBaseException
  - 프로그램에서 발생하는 IllegalArgumentException의 조상 예외
  - 예외 메시지에 [ERROR]를 기본적으로 추가
- LottoNumberCountException
  - 로또에 로또 번호가 6개가 아닌 경우 발생하는 예외
- LottoNumberFormatException
  - 입력받은 로또 번호가 숫자가 아닌 경우 발생하는 예외
- LottoNumberOutOfRangeException
  - 로또 번호의 범위가 1~45가 아닌 경우 발생하는 예외
- PriceNumberFormatException
  - 입력받은 가격이 숫자가 아닌 경우 발생하는 예외

### dto
- LottosDTO
  - 사용자가 구매한 로또들을 출력하기 위해 Controller → OutputView로 데이터를 전달하는 DTO
- LottoStatisticsDTO
  - 사용자가 구매한 로또 결과의 통계를 출력하기 위해 Controller → OutputView로 데이터를 전달하는 DTO

### constant
- ExceptionMessageConstants
  - 예외에서 사용되는 예외메시지를 유지하는 enum
- LottoConstans
  - 로또 프로그램에서 사용하는 정수를 보관하는 클래스

```bash
lotto
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── lotto
│   │   │   │   ├── constant
│   │   │   │   │   ├── ExceptionMessageConstants
│   │   │   │   │   ├── LottoConstans
│   │   │   │   ├── controller
│   │   │   │   │   ├── LottoController
│   │   │   │   ├── dto
│   │   │   │   │   ├── LottosDTO
│   │   │   │   │   ├── LottoStatisticsDTO
│   │   │   │   ├── exception
│   │   │   │   │   ├── DuplicateLottoNumberException.java
│   │   │   │   │   ├── ExactChangeNotPossibleException.java
│   │   │   │   │   ├── IllegalArgumentBaseException.java
│   │   │   │   │   ├── LottoNumberCountException.java
│   │   │   │   │   ├── LottoNumberFormatException.java
│   │   │   │   │   ├── LottoNumberOutOfRangeException.java
│   │   │   │   │   ├── PriceNumberFormatException.java
│   │   │   │   ├── model
│   │   │   │   │   ├── BonusNumber.java
│   │   │   │   │   ├── Lotto.java
│   │   │   │   │   ├── LottoNumber.java
│   │   │   │   │   ├── LottoRankEvaluator.java
│   │   │   │   │   ├── LottoResult.java
│   │   │   │   │   ├── Lottos.java
│   │   │   │   │   ├── LottoShop.java
│   │   │   │   │   ├── Rank.java
│   │   │   │   │   ├── WinningLotto.java
│   │   │   │   ├── service
│   │   │   │   │   ├── LottoService.java
│   │   │   │   ├── util
│   │   │   │   │   ├── Parser.java
│   │   │   │   ├── view
│   │   │   │   │   ├── InputView.java
│   │   │   │   │   ├── Message.java
│   │   │   │   │   ├── OutputView.java
│   │   │   │   │   ├── PrintStringBuilder.java
│   └── test/
│   │   ├── model
│   │   │   ├── BonusNumberTest.java
│   │   │   ├── LottoNumberTest.java
│   │   │   ├── LottoRankEvaluatorTest.java
│   │   │   ├── LottoResultTest.java
│   │   │   ├── LottoShopTest.java
│   │   │   ├── LottosTest.java
│   │   │   ├── LottoTest.java
│   │   │   ├── WinningLottoTest.java
│   │   ├── service
│   │   │   ├── LottoServiceTest.java
│   │   ├── ApplicationTest.java
└── README.md
```
