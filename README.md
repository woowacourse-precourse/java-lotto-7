# java-lotto-precourse

# < controller >
## 1) Controller
* chooseNumberOfLotto //로또 개수 정하기
* purchaseLottos //로또 구매하기
* convertToInteger //String을 숫자List로 변경하기
* createWinningLotto //당첨 티켓 생성하기
* printStatistics //로또 통계 출력하기
* runLotto //로또 과제 실행하기
---
# < model >
## 1) Lotto
* validate //로또가 생성 가능한 지 확인

## 2) WinningLotto

## 3) Lottos

## 4) LottoPrice (enum)

## 5) ProfitCalculator

## 6) LottoCreator
* chooseNumberOfLotto //로또 개수 정하기
* whetherPossiblePurchasePrice //가능한 로또 가격인지 확인하는 기능
---
# < view >
## 1)  InputView
* inputPurchasePrice //구매 금액 입력받기
* inputWinningNumbers //당첨번호 입력받기
* inputBonusNumber //보너스번호 입력받기

## 2) OutputView
* outputNumberOfLotto //로또 개수 출력하기
* outputLottos //로또 출력하기
* outputStatistics //당첨통계 출력하기
* outputProfitRate //수익률 출력하기
---
# < 예외 >
* 로또 번호가 6개가 아닐 시 예외처리
* 로또 번호가 1부터 45사이의 숫자가 아닐 시 예외처리
