# [Precourse Week 3] Lotto

# 🎱🍀GOOD LUCK🍀🎱

---

## 📋 로또 발급 규칙 📋
- 로또 번호는 1~45 사이에서 6개가 생성됩니다.
- #### ⛔️ 하나의 로또는 1,000원이며 '사행성 조장을 방지하기 위해' 한 사람 당 **10만원**으로 구매를 제한합니다!
- 로또를 발급할 때 지불할 로또 금액을 입력합니다.
- 지불할 로또 금액은 1,000원 단위만 유효합니다.
- 로또 금액을 입력할 때는 다른 특수기호를 포함하지 않은 숫자만🔢 입력해주세요.
- 모든 입력값은 올바른 입력형식이 아닐 시 다시 입력을 받습니다.

---

## 📋 로또 추첨 규칙 📋
- 로또 당첨 번호는 마찬가지로 1~45 사이에서 6개, 그리고 보너스 번호〇를 1개 추첨합니다.
- 보너스 번호는 앞에 생성된 로또 당첨 번호와 중복되지 않으며 가능한 범위는 동일합니다.
- 로또 당첨 번호를 입력할 때는 콤마(,)로 구분하여 입력해주세요.
- 또한 다른 특수기호를 포함하지 않은 숫자만🔢 입력해주세요.
- 마찬가지로 모든 입력값은 올바른 입력형식이 아닐 시 다시 입력을 받습니다.

---

### ⛔️ [주의] 잘못된 입력값이 들어올 경우에는 입력받던 곳으로 다시 돌아가 유효한 값이 들어올 때까지 입력을 받는다 ⛔️


---

## ‼️ 예외가 발생하는 경우 ‼️

- 총 로또 구매 금액이 1000원 이하일 때
- 총 로또 구매 금액이 10만원을 초과할 때
- 총 로또 구매 금액이 1000으로 나누어떨어지지 않을 때

- 총 로또 구매 금액으로 유효하지 않은 값이 들어올 때
  - 숫자가 아닌 문자가 포함된 경우(_와 ,도 숫자 구분자로 사용하지 않는다)
  - 아무런 입력값이 들어오지 않은 경우

- 로또 당첨 번호를 입력할 때 잘못된 숫자가 입력되는 경우
  - 구분자가 ,가 아닌 경우
  - 양끝 공백은 자동으로 제거된다
  - 숫자가 아닌 문자가 포함된 경우(_와 ,도 숫자 구분자로 사용하지 않는다)
  - 각 로또 번호가 1과 45 사이에 있는 수가 아닐 때
  - 하나의 로또가 가지고 있는 번호의 개수가 6개가 아닐 때

- 보너스 번호 입력값으로 유효하지 않은 값이 들어올 때
  - 숫자가 아닌 문자가 들어올 경우
  - 1~45사이의 정수가 아닐 경우
  - 로또 당첨 번호 6개 중 중복되는 숫자가 있을 경우

---

##  구현 기능 목록

---
## 🎱controller
- LottoController
  - 로또 컨트롤러이다.

---
## 🎱service
- LottoService
  - 로또 생성에 대한 전반적인 비즈니스 로직을 수행한다.

---
## 🎱model
### ✅ lotto
- Lotto
  - 6자리의 중복 없는 로또 번호 리스트를 담고 있다.
  - 개수 검사와 중복 검사 로직을 포함한다.

- LottoConstant
  - 로또와 관련한 상수를 정의한다.

- LottoRankAward
  - 당첨 번호 개수에 따른 순위, 당첨금, 보너스 번호 일치 여부를 담고 있는 enum 클래스이다.
  - findLottoRank 메서드에서 당첨 번호 개수에 따른 로또 등수를 찾아 반환한다.

- LottoWinningNumbers
  - 로또 당첨 번호와 보너스 번호 정보를 담은 클래스이다.

<br>

### ✅ lottoPurchaser
- LottoBuyer
  - 로또 구매자가 구매한 로또에 대한 정보들을 담고 있다.
  - 구매한 로또들은 로또 레포지토리에 저장되는 형태이다.
  - 로또 당첨 결과 또한 구매자의 정보이므로 당첨 결과도 담고 있다.

- LottoRepository
  - InMemoryLottoRepository의 인터페이스이다.

- InMemoryLottoRepository
  - 구매한 로또들을 저장하는 저장소이다.

---
## 🎱 util
- NumberConverter
  - 입력받은 문자열을 숫자로 변환하는 기능을 한다.
  - 문자열에는 숫자 형태만 들어있어야 한다.
  - 문자열 양 끝에 공백이 있다면 제거하고 정수로 변환한다.

- NumberFormatter
  - 숫자를 원하는 형식으로 변환하는 구현 클래스의 인터페이스이다.
  - NumberFormatterWithComma
    - 숫자를 천 단위로 잘라 ','를 붙여 문자열로 반환한다.
  - NumberFormatterWithPercentage
    - 숫자를 소수점 둘째자리에서 반올림하여 문자열로 반환한다.

- NumberParserWithComma
  - 문자열로 입력받은 숫자를 ',' 단위로 나누고 NumberConverter의 기능을 통해 각 정수를 반환한다.
  - parseNumbers 메서드를 통해 각 정수들 사이에 중복이 없는지 확인하고 최종적으로는 set으로 결과를 반환한다.

- NumberParserFactory
  - NumberConverter를 생성자 주입한 NumberParserWithComma를 생성하는 팩토리 패턴을 구현하는 클래스이다.

- LottoNumberGenerator
  - 주어진 범위와 개수에 따른 로또 번호 생성만을 위한 난수 생성기로 인터페이스는 따로 구현하지 않았으며 정적 메서드를 담고 있다.

---
## 🎱 validator
- validateLottoPurchasePrice
  - 로또 구매 가격을 검증한다.

- WinningLottoNumberValidator
  - 입력받은 로또 당첨 번호를 검증한다.

---
## 🎱 view
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

- LottoProfitOutputView
  - 구매한 로또의 총 수익률을 파라미터로 받아 출력한다.

### ✅ LottoInputViewFactory
  - 로또 입력 view 객체들을 생성하는 역할을 수행하는 팩토리 클래스이다.

### ✅ LottoOutputViewFactory
  - 로또 출력 view 객체들을 생성하는 역할을 수행하는 팩토리 클래스이다.


### ✅ ConsoleInputProvider
  - 기본적인 입력 로직을 수행한다.

### ✅ InputProvider
  - ConsoleInputProvider의 인터페이스로 테스트를 위해 존재한다.



