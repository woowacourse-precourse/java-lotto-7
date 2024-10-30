# java-lotto-precourse
# 로또

---

## 📝 구현 기능 목록 (Features)

### 1. Model

- **Lotto 클래스**
    - 로또 한장의 번호 6개를 저장합니다.
    - 주요 필드:
        - `numbers`: 추첨된 로또 번호들을 저장할 List입니다.
        - `validate`: 번호 6개를 제대로 추첨하였는지 검사하는 메서드 입니다.
        - `sortNumbers`: 로또번호 6개를 오름차순으로 정렬합니다.
- **LottoWinningNumbers 클래스**
  - 로또 당첨번호 6개와 보너스번호 1개를 저장합니다.
  - 주요 필드:
    - `winningNumbers`: 로또 당첨번호 6개를 저장하는 List입니다.
    - `bonusNumber` :보너스 번호 1개를 저장하는 변수입니다.
### 2. View

- **InputView 클래스**
    - 사용자에게 **금액**과,**당첨번호**를 입력받아, 입력값을 반환합니다.
    - 주요 필드:
      - `inputMoney`: 금액 입력받고, 유효성 검사를 수행합니다.
      - `inputWinningNumbers`: 로또 당첨번호 6개를 입력받고, 유효성 검사를 수행후 반환합니다.
      - `inputBonusNumber`: 보너스 번호 1개를 입력받고, 유효성 검사를 수행후 반환합니다.
- **OutputView 클래스**
    - **발행한 로또수량 및 번호**,**당첨 내역**,**수익률**을 출력합니다.
    - 주요 메서드:
        - `printLottoResults()`: 로또 구매 갯수와 번호들을 출력합니다.
        - `printLottoWinningStatistics()`: 당첨 통계를 출력합니다.
        - `ProfitRate()`: 수익률을 출력합니다.

### 3. Controller

- **lottoController 클래스**
    - 로또 당첨갯수 계산과 수익률을 계산합니다.
    - `inputView`에서 받은 입력을 바탕으로 `Lotto` 객체 리스트를 생성하고, 당첨번호가 몇개인지 계산합니다.
    - `outputView`를 통해 결과를 출력합니다.

### 4. Util

- **Validator 클래스**
    - 유효성 검사 로직을 담당하는 유틸리티 클래스입니다.
- **Config 클래스**
  - 상수값들을 저장하는 유틸리티 클래스입니다. 