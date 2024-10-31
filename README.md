# java-lotto-precourse

## 로또 발매기

- MVC 패턴을 적용해 구현한 로또 발매기

## 구현 기능 목록

### Main

* Application
    * 로또 발매기를 실행시킵니다.

### model
* `Lotto` 로또 하나를 관리
  * 
* `Lotteries` 로또 여러 장을 일급 컬렉션으로 관리.
  * 
* `YeildRate` 수익률을 관리
  * 

### controller
* `LottoController` 로또 게임의 전체적인 흐름을 관리
  * 

### view
* `InputView`
  *
* `OutputView`
  * 

### utils
* `LottoNumberGenerator` 로또 난수 생성 역할을 담당하는 interface
  * 
* `RandomLottoNumberGenerator` 로또 난수를 생성하는 역할을 구현하는 구현체
  * 

### dto

### config
* `LottoRank`
  * 로또 당첨 순위, 당첨 금액, 보너스 번호의 유무를 관리합니다
* `LottoRule`
  * 로또의 규칙사항을 저장하는 enum