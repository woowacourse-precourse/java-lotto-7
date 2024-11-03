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

- [x] WinningNumbers 클래스 구현
  - [x] 멤버변수: Lotto lotto, LottoNumber bonusNumber
  - [x] 중복이 있는 경우 예외 처리

- [x] Prize enum 클래스 구현
  - [x] First ~ Fifth, MISS

- [ ] LottoMachine 클래스 구현
  - [x] 멤버변수: List<Prize> prizes
  - [ ] run 메서드. 사용자 입력 받고 결과 출력
  - [x] 랜덤한 로또 번호를 뽑는 메서드
  - [ ] 뽑은 번호를 가지고 prizes를 업데이트 하는 메서드

- [ ] InputView 클래스 구현
  - [ ] readPurchaseAmount() 구현
  - [ ] readWinningNumbers() 구현

- [ ] OutputView 클래스 구현
  - [ ] printPurchaseQuantity(Money money)
  - [ ] printLottoNumbers(Lotto lotto): LottoMachine에서 랜덤 번호를 뽑을 때마다 실행
  - [ ] printWinningResult(WinningResult winningResult): 당첨 내역, 수익률 출력
