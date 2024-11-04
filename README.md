# java-lotto-precourse

## TODO

- [x] Money 클래스 구현
  - [x] 1000원 단위로 나누어 떨어지지 않거나 음수이면 예외 처리
  - [x] 매직 넘버 상수화: 1000, 0

- [x] LottoNumber 클래스 구현
  - [x] 매직넘버 상수화: 1, 45
  - [x] 1~45 사이 값 아닐 시 예외 처리

- [x] Lotto 클래스 추가 구현
  - [x] 매직넘버 상수화: 6
  - [x] 중복이 있는 경우 예외 처리
  - [x] 오름차순 정렬하여 저장

- [x] WinningNumbers 클래스 구현
  - [x] 멤버변수: Lotto lotto, LottoNumber bonusNumber
  - [x] 중복이 있는 경우 예외 처리

- [x] Prize enum 클래스 구현
  - [x] First ~ Fifth, MISS
  - [x] amount, matchCount, needBonusMatch를 가지고 있도록
  - [x] 상 관련 비즈니스 로직을 담당하도록

- [x] WinnigResult 클래스 구현
  - [x] 당첨 prize들을 저장하고 수익률 계산을 담당하도록

- [x] LottoMachine 클래스 구현
  - [x] 멤버변수: List<Lotto> lottos, List<Prize> prizes
  - [x] run 메서드. 사용자 입력 받고 결과 출력
  - [x] 로또를 구매하는 메서드

- [x] InputView 클래스 구현
  - [x] readPurchaseAmount
  - [x] readWinningNumbers
  - [x] parseNumbers, parseNumber: 숫자 형식 입력 아닐 시 예외 처리
  - [x] retry() 구현

- [x] OutputView 클래스 구현
  - [x] printPurchaseQuantity: 구매 개수 출력
  - [x] printLottos: 구매한 로또 번호를 출력
  - [x] printWinningResult: 당첨 내역, 수익률 출력
