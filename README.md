# java-lotto-precourse
## 1️⃣ 기능 목록
- [x] 입력 받는 기능을 구현한다.
    - [x] 로또 구입 금액을 입력 받는다.
        - [x] [예외처리] 입력값이 숫자가 아닌 값이 들어오는 경우
    - [x] 당첨 번호를 입력 받는다.
        - [x] [예외처리] 입력값이 숫자, 쉼표로 이루어지지 않은 경우
    - [x] 보너스 번호를 입력 받는다.
        - [x] [예외처리] 입력값이 숫자가 아닌 값이 들어오는 경우
- [x] 로또를 생성하는 기능을 구현한다.
    - [x] 금액만큼 로또를 생성하다.
        - [x] [예외처리] 1,000원으로 나누어 떨어지지 않은 경우
        - [x] [예외처리] 0원을 입력 받는 경우
    - [x] 일반 로또를 생성하다.
        - [x] [예외처리] 로또 번호의 개수가 6개가 아닌 경우
        - [x] [예외처리] 중복된 로또 번호가 존재하는 경우
        - [x] [예외처리] 1 ~ 45 사이의 숫자가 들어오지 않은 경우
    - [x] 당첨 번호와 보너스 번호를 생성하다.
        - [x] [예외처리] 당첨 번호는 일반 로또와 같은 예외 처리를 가진다.
        - [x] [예외처리] 보너스 번호가 당첨 번호에 이미 존재하는 경우
        - [x] [예외처리] 보너스 번호가 1 ~ 45 사이의 숫자가 아닌 경우
- [x] 로또를 발행한다.
    - [x] 발행한 로또 수량을 출력한다.
    - [x] 발행한 로또 번호를 출력한다.
- [x] 로또 당첨을 계산한다.
    - [x] 당첨 번호와 발행 번호가 몇 개 일치하는지 확인한다.
    - [x] 보너스 번호와 일치하는지 확인한다.
    - [x] 로또 당첨 개수를 계산한다.
- [x] 로또 당첨 개수를 보여준다.
    - [x] 로또 당첨 내역을 출력한다.
    - [x] 로또 수익률을 출력한다.

## 2️⃣ 진행 순서
- [x] 로또 구입 금액을 입력 받는다.
- [x] 당첨 번호와 보너스 번호를 입력 받는다.
- [x] 로또 구입 금액만큼 로또를 발행한다.
- [x] 발행한 로또 수량을 출력한다.
- [x] 발행한 로또 번호를 출력한다.
- [x] 발행한 로또와 당첨 번호 및 보너스 번호를 비교하여 각 등수마다 당첨된 개수를 계산한다.
- [x] 당첨 내역을 출력한다.
- [x] 수익률을 계산한다.
- [x] 수익률을 출력한다.

## 3️⃣ 주의사항
- [x] 로또 구입 금액은 1,000원 단위로 입력해야 한다.
- [x] 당첨 번호는 쉼표(,)를 기준으로 입력해야 한다.
- [x] 로또 번호는 오름차순으로 정렬해서 보여주어야 한다.
- [x] 수익률은 소수점 둘째 자리에서 반올림한다.
- [x] 예외 상황시 에러 문구를 출력해야 한다.


### 디렉토리 구조
```bash
src
└── main
└── java
└── lotto
├── Application.java
├── controller
│   └── LottoController.java
├── domain
│   ├── Lotto.java
│   ├── Lottos.java
│   ├── Money.java
│   ├── Prize.java
│   ├── PrizeResult.java
│   ├── Rate.java
│   └── WinningLotto.java
├── generator
│   ├── LottoGenerator.java
│   └── LottoNumbersGenerator.java
├── exception
│   ├── BuyLottoMoneyFormat.java
│   ├── DivideMoneyException.java
│   ├── DuplicateLottoNumberException.java
│   ├── InvalidLottoInputFormatException.java
│   ├── InvalidRangeLottoNumberException.java
│   ├── InvalidSizeLottoNumberException.java
│   ├── SingleNumberFormatException.java
│   └── ZeroMoneyException.java
└── view
├── InputBonusNumberView.java
├── InputBuyLottoView.java
├── InputView.java
├── InputWinningLottoView.java
├── OutputBuyLottoCount.java
├── OutputLottoList.java
└── OutputStatistics.java
└── test
└── java
└── lotto
├── ApplicationTest.java
├── domain
│   ├── LottoTest.java
│   └── WinningLottoTest.java
```
## 질의응답

### Q. 로또 번호는 어떤 방식으로 생성되나요?
A. 로또 번호는 LottoGenerator 클래스를 사용하여 무작위로 생성되며, 중복된 번호가 생기지 않도록 HashSet을 이용해 관리합니다. 생성된 번호는 오름차순으로 정렬하여 출력됩니다.

### Q. 로또 구입 금액에 대한 예외 처리는 어떻게 구현되었나요?  
A.  로또 구입 금액은 반드시 1,000원 단위로 입력받아야 하며, 이를 확인하기 위해 ZeroMoneyException과 DivideMoneyException 클래스를 사용하여 입력값이 유효한지 검증합니다. 유효하지 않은 경우 적절한 예외 메시지를 던집니다.

### Q. 당첨 번호와 보너스 번호의 유효성 검사는 어떻게 이루어지나요?
A. WinningLotto 클래스에서 당첨 번호와 보너스 번호의 유효성을 검증합니다. 보너스 번호가 당첨 번호와 중복되는지 확인하고, 범위(1~45)를 벗어나지 않도록 검사하여 유효하지 않으면 예외를 발생시킵니다.

### Q. 로또의 수익률 계산은 어떻게 이루어지나요?  
A. Rate 클래스에서 로또의 수익률을 계산합니다. 총 수익과 지출한 금액을 기반으로 수익률을 계산하며, 소수점 둘째 자리에서 반올림하여 반환합니다.

### Q. 예외 처리와 관련하여 어떤 점에 중점을 두었나요?
A. 사용자 입력이 잘못되었을 때 적절한 예외를 던져 사용자에게 이해할 수 있는 오류 메시지를 제공합니다. 또한, 각 클래스마다 명확한 예외 처리 클래스를 만들어서 코드의 가독성과 유지보수성을 높였습니다.

### Q. 테스트 코드는 어떤 방식으로 작성되었나요?
A. JUnit을 사용하여 각 도메인 클래스에 대한 단위 테스트를 작성했습니다. 입력 값이 유효한 경우와 유효하지 않은 경우에 대해 다양한 테스트 케이스를 구성하여 예외 발생 여부를 검증합니다.

### Q. MVC 패턴을 어떻게 적용했나요?
A.  MVC 패턴을 적용하여 사용자 입력과 출력을 분리하였습니다. controller 패키지에는 비즈니스 로직을 처리하는 LottoController가 있고, view 패키지에는 사용자와의 상호작용을 위한 입력 및 출력 클래스를 구현하여 사용자 경험을 개선하였습니다. domain 패키지는 도메인 모델을 포함하고 있습니다.