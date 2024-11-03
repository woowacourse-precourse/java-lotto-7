# [Precourse Week3] Lotto 🍀

## 📑 구현 기능 목록

---
## 🍀controller
- LottoController
  - 로또를 구매하고 로또 당첨 번호를 생성 및 당첨 결과 반환 등 전체 로직을 컨트롤한다.

---
## 🍀model
### ✅ lotto
- Lotto
  - 로또 번호의 개수를 검증하고 로또 번호를 담은 리스트로 생성한다.

- LottoConstant
  - 로또와 관련한 상수를 정의한다.

- LottoRankAward
  - 로또 당첨 순위, 순위에 따른 금액 등을 enum 클래스로 다룬다
  - 또한 findRank 메서드에서는 파라미터를 통해 로또 당첨 순위를 찾고 반환해주는 기능을 한다.

- LottoWinningNumbers
  - 로또 당첨 번호와 보너스 번호 정보를 담은 클래스이다.

<br>

### ✅ lottoBuyer
- LottoBuyer
  - 구매자가 구매한 로또에 대한 정보들을 담고 있다.
  - 로또 당첨 결과 또한 구매자의 정보이므로 당첨 결과도 담고 있다.

- LottoRepository
  - 구매자가 구매한 로또들을 모은 레포지토리다.
  - 레포지토리는 리스트의 형태로 Lotto를 담는다.

---
## 🍀util
- NumberConverter
  - 입력받은 문자열을 숫자로 변환하는 기능을 한다.

- NumberFormatter
  - 입력받은 숫자를 천 단위로 잘라 ','를 붙인 문자열을 반환한다.

- NumberParser
  - 문자열로 입력받은 숫자를 ',' 단위로 나누고 숫자로 변환 가능한지 검증하고 set으로 반환한다.

- RandomNumberGenerator
  - 입력받은 범위와 개수에 따라 난수들을 생성하여 list로 반환한다.

---
## 🍀validator
- LottoNumberValidator
  - 로또 번호가 주어진 범위 안에서 생성되었는지 검증하는 기능을 한다.

---
## 🍀view
### ✅ lottoPurchaseView
- LottoPurchaseInputView
  - 로또를 구매할 때의 입력 로직을 수행한다.

- LottoPurchaseOutputView
    - 로또를 구매할 때의 출력 로직을 수행한다.
    - 또한 생성된 로또 번호를 오름차순으로 정렬하여 출력하는 기능을 한다.

### ✅ lottoWinningView
- WinningLottoInputView
  - 로또 당첨 번호를 입력할 때의 입력 로직을 수행한다.

- WinningLottoOutputView
    - 로또 당첨 정보와 수익률을 출력할 때의 출력 로직을 수행한다.


### ✅ ConsoleInputProvider
- 기본적인 입력 로직을 수행한다.

### ✅ InputProvider
- ConsoleInputProvider의 인터페이스로 테스트를 위해 존재한다.



