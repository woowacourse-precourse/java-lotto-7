# java-lotto-precourse

## 로또 발매기

- MVC 패턴을 적용해 구현한 로또 발매기

## 구현 기능 목록

### Main
* `Application`
    * 로또 발매기를 실행시킵니다.

### model
* `Lotto` 로도 번호를 관리합니다.
  * 당첨 로또 번호를 생성합니다.
  * 구매시에 1장의 랜덤 로또를 생성합니다.
* `Lotteries` 로또 여러 장을 일급 컬렉션으로 관리.
  * 로또 구매시 구매량에 맞는 `Lotto`를 생성합니다
* `YeildRate` 수익률을 계산
  * 총 구매 개수와 수익을 통해서 수익률을 계산합니다.

### controller
* `LottoController` 로또 게임의 전체적인 흐름을 관리합니다.

### view
* `InputView`
  * 로또 발매기의 입력을 담당합니다
* `OutputView`
  * 로또 발매기의 공통 출력 부분을 담당합니다.
* `ViewManager`
  * 로또 발매기의 `InputView`, `OutputView`의 공통 기능을 관리합니다.
* `LottoView`
  * `InputView`, `OutputView`를 통해서 로또 발매기의 입출력 흐름을 관리합니다.

### utils
* `LottoNumberGenerator` : 로또 난수 생성 역할을 담당하는 interface
* `RandomLottoNumberGenerator` : 로또 난수를 생성하는 역할을 구현하는 구현체

### dto
* `LottoDto` : 구매한 로또를 Dto를 통해서 model을 안전하게 관리합니다.
* `StatisticDto` : 당첨 통계를 Dto를 통해서 model을 안전하게 관리합니다.

### config
* `LottoRank`
  * 로또 당첨 순위, 당첨 금액, 보너스 번호의 유무를 관리합니다
* `LottoRule`
  * 로또의 규칙사항을 저장하는 enum

### vo
* 원시값 직접 사용을 방지한 `vo`객체들입니다.
* `vo`를 통해 불변성, 동등성, 자가 유효성을 준수하여 원시 타입을 직접적으로 사용하지 않도록 관리합니다
  * `BonusNumber` : 보너스 번호를 관리합니다
  * `BuyLottoNumber` : 로또 구매시 입력받는 금액을 관리합니다.
  * `TicketCount` : 로또의 수량을 관리합니다.