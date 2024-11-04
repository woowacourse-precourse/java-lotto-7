# java-lotto-precourse
___
## 설계
___
### class LottoController
로또 프로그램 전반의 흐름을 제어하며 사용자에게 입력을 받아 서비스 단에 필요한 값을 요청합니다.

### class Lotto
로또 티켓 한장을 구체화한 클래스로 Set을 통해 LottoNumber들 값이 중복되지 않도록 하며 값의 유효성을 검증합니다.

### class LottoBuyer
로또 티켓 구매자를 구체화한 클래스로 예산으로 구매한 로또 티켓과 비용을 가집니다.

### class LottoNumber
로또 티켓의 추첨 숫자 하나에 대한 구체화입니다. VO의 조건을 만족하고자 구현했습니다.

### class LottoReward
로또 당첨금에 대한 정보를 담은 enum 클래스입니다.

### class LottoWinCalculator
로또 결과 계산에 필요한 로직을 담은 클래스입니다.

### class LottoWinNumber
당첨 번호와 보너스 번호를 처리하는 클래스입니다.

### class Budget - interface Money
구매 금액을 입력 받아 저장하는 클래스입니다. 이번 프로그램에서는 "천원" 단위라는 특수한 조건이 있다고 생각해 interface를 통해 추후 확장성을 고려했습니다.

### class WoowaLottoGenerator - interface RandomNumberGenerator
무작위 숫자 생성과 리스트 생성을 담당하는 클래스입니다.

### class StatisticsReport
추첨 결과에 대한 클래스 입니다.

### class LottoManager - interface LottoValueProvider
로또에 관련된 서비스의 진행을 담당합니다. interface를 통해 controller에게 요청 받아 필요한 기능을 수행하도록 했습니다.

### class InpuHandler
입력에 필요한 로직을 담는 클래스입니다.
InputReader를 통해 값을 받습니다.

### class OutputHandler
출력에 관한 로직을 담는 클래스입니다. statisticsreport를 받아 값을 처리해 필요한 정보를 출력합니다.
printer를 통해 값을 출력합니다.

## 진행 흐름
___

### Controller.run()

1. 컨트롤러가 InputHandler를 통해 필요한 값(로또 구입 금액)을 요청해 입력 받습니다.
2. 입력 받은 값을 Service에 보내 처리를 요청합니다.
   1. LottoManager는 로또 구매를 처리하고 결과를 반환합니다.
3. 컨트롤러가 OutputHandler를 통해 결과를 출력합니다.
4. InputHandler를 통해 당첨번호, 보너스 번호를 입력 받습니다.
5. 값을 Service에 보내 처리를 요청합니다.
   1. LottoManager는 당첨 결과를 처리해 결과를 반환 합니다.
6. 컨트롤러가 OutputHandler를 통해 결과를 출력합니다.


## 패키지
___
- 📦lotto
  - 📂controller
    - LottoController.class
  - 📂service
    - 📂domain
      - 📂lotto
        - Lotto.class
        - LottoBuyer.class
        - LottoNumber.class
        - LottoReward.class
      - 📂lottoresult
        - LottoWinCalculator.class
      - 📂money
        - Budget.class
        - Money.interface
      - 📂numbergenerator
        - RandomNumberGenerator.interface
        - WoowaLottoGenerator.class
      - 📂statistics
        - StatisticsReport.class
    - LottoManager.class
    - LottoValueProvider.interface
  - 📂view
    - InputHandler.clss
    - InputReader.class
    - OutputHandler.class
    - Printer.class