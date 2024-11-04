# java-lotto-precourse
- #### 금액을 입력 받아 해당 금액에 맞는 로또 번호를 생성한다.
- #### 당첨 번호와 보너스 번호를 비교하여 당첨 결과와 수익률을 계산하여 제공한다.
- - -

## 👷기능 요구사항 👷
### Utils
- [x] `Validator`
- 공통 예외 : 입력이 null 또는 공백
- 사이의 공백은 프로그램 내부에서 처리해서 입력을 받아준다.
  - [x] `priceValidator` : 입력 받은 로또 구입 금액을 검증한다.
    - [x] 정수가 아닌 경우
    - [x] 가격의 1000원 단위가 아닌 경우
    - [x] 가격이 음수인 경우 
  - [x] `winningNumValidator` : 입력 받은 당첨 번호를 검증한다.
    - [x] 입력 패턴이 다른 경우
    - [x] 쉼표로 분리한 숫자의 개수가 6이 아닌 경우
  - [x] `lottoNumValidator` : 번호 검증 (1 ~ 45) 
    - [x] 정수가 아닌 경우
    - [x] 1에서 45 사이의 값이 아닌 경우
  - [x] `checkForDuplicates` : 중복된 숫자가 있는지 검증한다.
- [x] `Parser`
  - [x] `inputParser` : 쉼표를 구분자로 하여 당첨 번호를 분리한다.
- [x] `Converter`
  - [x] `priceToLottoCount` : 로또 구입 금액을 구매 개수로 변환한다.
  - [x] `StringToPrice`
  - [x] `StringToLottoNumbers`
  - [x] `StringToBonusNumber`
- [x] `Generator`
  - [x] `LottoNumberGenerator` : 로또 번호를 생성한다.
### Global
- [x] `ErrorMessages`
  - [x] 에러메세지들을 포함한 `Enum` 
- [x] `LottoRank` : `Enum`
  - [x] 당첨 개수와 당첨 금액을 관리하는 `Enum`
  - [x] `findByMatchCount` : 매칭된 숫자의 개수에 따라 적절한 로또 순위를 반환하는 메서드
### Domain
- [x] `Lotto`
  - [x] `checkWinningStatus` : 매칭 숫자 + 보너스 넘버를 비교하여 당첨 형태를 return 한다.
- [x] `Lottos`
  - [x] `getWinningLottos` : `List<Lotto>`를 순회하며 `List<Winning>`을 반환한다.
- [x] `UserLottosInfo` : `List<Winning>`와 사용자가 입력한 가격을 인스턴스 변수로 가진다.
  - [x] `getWinningCountByLottoRank` : `LottoRank`에 따라 당첨된 로또의 개수를 반환한다.
  - [x] `getProfitRate` : 수익률을 계산하여 반환한다.
###### getter 는 생략
### View
- [x] `InputView`
  - [x] `getPrice` : 구매 가격을 입력 받는다.
  - [x] `getLottoNum` : 로또 번호를 입력 받는다.
  - [x] `getBonusNum` : 보너스 번호를 입력 받는다.
- [x] `OutputView`
  - [x] `printLottos` : 구매한 로또 번호를 출력한다.
  - [x] `printResult` : 결과를 양식에 맞게 출력한다.
  - [x] `printErrorMessage` : 에러에 따라 에러메세지를 출력한다.
### Controller
- [x] `LottoController`
  - [x] `run` : 로또 당첨 시작
- - -
- [x] 처리해야할 예외는 `IllegalArgumentException` 이고, 그 외 예외는 종료.
- - - 
### 추가된 코드 컨벤션 지키기
- [x] else 예약어 사용 금지한다.
### 공통 피드백에서 평소 잘 지키지 않는 것
- [x] 변수명에 자료명 사용 금지한다.
- [x] 값을 하드코딩 하지 않는다.
#### 문서 작성 참고 링크
<https://gist.github.com/ihoneymon/652be052a0727ad59601>
