# java-lotto-precourse

# 로또

## 기능 소개

- 구매 금액과 당첨 금액을 입력 받고 당첨내역과 수익률을 알려주는 로또발매 서비스
    - 로또 번호의 숫자 범위는 1~45
    - 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자 뽑기
    - 로또 1장의 가격은 1,000원
    - 당첨 번호의 구분자는 쉼표(,)

## 패키지 구조

- domain
    - ErrorMessage
    - Lotto
    - Lottos
    - LottoConfig
    - LottoGenerator
    - LottoMachine
    - LottoRank
    - PurchaseAmount
    - WinningNumbers
    - WinningResult
- view
    - InputHandler
    - InputView
    - OutputView

## 기능 목록

- [x] 로또 생성 - Lotto#Lotto()
    - [x] 번호의 개수가 6개가 아니면 예외처리 - Lotto#validate()
    - [x] 중복된 번호가 있으면 예외처리 - Lotto#checkDuplicateNumbers()
- [x] 로또 번호중에 숫자가 포함되어 있는지 확인 - Lotto#contains()
- [x] 포함되어 있는 숫자의 개수 구하기 - Lotto#getMatchCount()
- [x] 로또 등수 구하기 -LottoRank#get()
- [x] 수악률을 계산 - WinningResult#calculateProfitRate()

### 입력

- [x] 구매 금액 입력 - InputView#readPurchaseAmount()
    - [x] 입력 받은 값이 숫자가 아니면 예외처리 - InputHandler#validateNumber()
    - [x] 구매 금액이 부족하면 예외처리 - PurchaseAmount#checkEnough()
    - [x] 구매 금액이 로또 가격과 나누어 떨어지지 않으면 예외처리 - PurchaseAmount#checkDivisible()
- [x] 당첨 번호 입력 - InputView#readWinningNumbers()
    - [x] null이 들어오면 예외처리 - InputHandler#checkNull()
    - [x] 입력 받은 값이 숫자가 아니면 예외처리 - InputHandler#validateNumber()
    - [x] 숫자의 범위가 1~45가 아니면 예외처리 - InputHandler#checkNumberRange()
    - [x] 중복 되는 숫자가 있으면 예외처리 - Lotto#checkDuplicateNumbers()
- [x] 보너스 번호 입력 -InputView#readBonusNumber()
    - [x] 입력 받은 값이 숫자가 아니면 예외처리 - InputHandler#validateNumber()
    - [x] 숫자의 범위가 1~45가 아니면 예외처리 - InputHandler#checkNumberRange()
    - [x] 당첨 번호와 중복 되는 숫자가 있으면 예외처리 - WinningNumbers#setBonusNumber()

### 출력

- [x] 구매한 로또 번호 출력 - OutputView#printLottos()
- [x] 당첨 결과 출력 - OutputView#printWinningResult()
- [x] 수익률 출력 - OutputView#printProfitRate()