# java-lotto-precourse

## Controller

- [ ] View와 Model(service, domain)을 이어주는 LottoController 객체 
  - 실질적으로 컨트롤러를 실행시키는 start 메서드 
  - 구입 금액을 입력받고 BuyingPrice에 저장하는 lottoPayment 메서드 
  - 구입 금액에 따른 발행하는 로또의 수를 출력하고 로또를 발행한 후 출력하는 publishLottos 메서드 
  - 당첨 번호와 보너스 번호를 입력받은 후 WinningLotto에 저장하는 getWinningLotto 메서드
  - 발행한 로또들인 purchasedLottos와 당첨번호인 WinningLotto를 비교하고 그에 따른 통계 결과를 출력하는 displayResults 메서드


## Domain

- [ ] 입력 받은 돈을 저장하는 BuyingPrice 객체
  - BuyingPriceValidator로 검증


- [ ] 랜덤으로 발행한 로또를 list로 저장하는 Lotto 객체
  - LottoValidator로 검증


- [ ] 발행한 로또 1개의 결과를 저장하는 LottoResult 객체
  - toString을 이용하여 각 Winning에 따른 결과를 출력하게 해줌 


- [ ] 전체 결과를 통계로 저장하는 LottoStatistics 객체
  - 지금까지의 상금 스탯과 수익률을 저장하는 객체임


- [ ] 로또의 결과를 가독성있게 해주는 Winning Enum
  - 1등부터 5등, 그리고 아무 상금도 못받는 경우까지 기록


- [ ] 사용자가 입력한 당첨 번호를 저장하는 WinningLotto 객체
  - 역시 LottoValidator로 검증하지만 여기는 Lotto객체랑 다르게 보너스 번호도 검증



## Service

- [ ] 입력한 돈에 로직을 처리하는 BuyingPriceService 객체

  - 입력한 돈에 따른 로또의 발행수를 리턴해주는 returnNumberOfLotto 메서드


- [ ] 랜덤하게 로또 번호를 발행하는 CreateLottoService 객체
  - 로또 1개당 랜덤하게 숫자를 뽑아서 발행하는 createSingleLotto 메서드

  - 발행한 로또들을 list에 저장하는 createRandomLottos 메서드


- [ ] 결과를 받아서 통계로 만들어 반환해 주는 LottoStatisticsService 객체
  - 수익률과 WinningStat을 반환하는 calculateStatistics 메서드 
  - LottoResult 리스트를 돌면서 해당 Winning 값이면 merge를 통해서 WinningStat을 1을 올려주는 calculateWinningStatistics 메서드
  - 총 상금을 계산하는 calculateTotalWinningPrize 메서드
  - 총 상금과 구입한 금액으로 수익률을 계산하는 calculateProfitRate 메서드


- [ ] 발행한 로또와 당첨 번호를 비교한 후 결과를 반환해주는 WinningCalculateService 객체 
  - 발행한 전체 로또와 당첨 번호를 비교하고 결과를 반환하는 calculateLottoResults 메서드
  - 발행한 1개의 로또와 당첨 번호를 비교하는 calculateSingleLottoResult 메서드
  - 비교 후 맞는 숫자에 따라 결과를 반환하는 determineWinningResult 메서드


## Util

### Parser

- [ ] 보너스 번호(String)를 int형으로 파싱해주는 BonusNumberParser 객체


- [ ] 입력받은 돈(String)을 int형으로 파싱해주는 BuyingPriceParser 객체


- [ ] 당첨 번호(String)을 쉼표와 int형의 리스트로 파싱해주는 WinningLottoParser 객체


### Validator

- [ ] 다른 Validator들의 상속을 위한 추상 클래스 Validator


- [ ] 로또를 검증해주는 LottoValidator
  - 이 LottoValidator는 발행한 로또와 당첨 번호를 검증하는 데에 쓰임


- [ ] 입력받는 돈을 검증해주는 BuyingPriceValidator
  - BuyingPrice를 검증할 때 쓰임


## View

- [ ] 사용자의 입력을 받아서 Controller에 전달하는 InputView 객체
  - 사용자에게 금액을 입력받는 inputBuyingPriceView 메서드
  - 사용자에게 당첨 번호를 입력받는 inputLottoNumbersView 메서드 
  - 사용자에세 보너스 번호를 입력받는 inputBonusNumberView 메서드


- [ ] Contorller가 주는 결과를 받아서 사용자에게 출력하는 OutputView 객체
  - 구입 금액을 사용자에게 물어볼때 사용하는 askBuyingPriceView 메서드
  - 발행할 로또의 수를 출력해주는 responseNumberOfLotto 메서드
  - 당첨 번호를 사용자에게 물어볼때 사용하는 askWinningLotto 메서드
  - 보너스 번호를 사용자에게 물어볼때 사용하는 askBonusNumber 메서드
  - 발행한 로또들을 출력해주는 printLottos 메서드 
  - 발행할 로또를 출력할때 형식에 맞게 대괄호를 출력해주는 formatLottoNumbers 메서드
  - WinningStat과 더불어 수익률까지 전체 결과를 출력해주는 printStatistics 메서드 
  - WinningStat을 출력해주는 printWinningResults 메서드 

