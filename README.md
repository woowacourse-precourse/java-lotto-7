# java-lotto-precourse

## Controller

- [ ] View와 Model(service, domain)을 이어주는 LottoController 객체 


## Domain

- [ ] 돈을 입력받는 BuyingPrice 객체


- [ ] 랜덤으로 발행한 로또를 list로 저장하는 Lotto 객체


- [ ] 발행한 로또 1개의 결과를 저장하는 LottoResult 객체


- [ ] 전체 결과를 통계로 저장하는 LottoStatistics 객체


- [ ] 로또의 결과를 가독성있게 해주는 Winning Enum


- [ ] 사용자가 입력한 당첨 번호를 저장하는 WinningLotto 객체


## Service

- [ ] 입력한 돈에 로직을 처리하는 BuyingPriceService 객체

  - 입력한 돈에 따른 로또의 발행수를 리턴해주는 메서드


- [ ] 랜덤하게 로또 번호를 발행하는 CreateLottoService 객체


- [ ] 결과를 받아서 통계로 만들어 반환해 주는 LottoStatisticsService 객체


- [ ] 발행한 로또와 당첨 번호를 비교한 후 결과를 반환해주는 WinningCalculateService 객체 


## Util

- [ ] 보너스 번호(String)를 int형으로 파싱해주는 BonusNumberParser 객체


- [ ] 입력받은 돈(String)을 int형으로 파싱해주는 BuyingPriceParser 객체


- [ ] 당첨 번호(String)을 쉼표와 int형의 리스트로 파싱해주는 WinningLottoParser 객체


## View

- [ ] 사용자의 입력을 받아서 Controller에 전달하는 InputView 객체


- [ ] Contorller가 주는 결과를 받아서 사용자에게 출력하는 OutputView 객체

