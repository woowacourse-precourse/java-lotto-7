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
* checkValidateNumbers //로또가 생성 가능한 지 확인

## 2) LottoCreator
* chooseNumberOfLotto //로또 개수 정하기
* whetherPossiblePurchasePrice //가능한 로또 가격인지 확인하는 기능

## 3) (ENUM) LottoPrice 

## 4) Lottos
* createLottos //로또들 생성하기

## 5) ProfitCalculator
* initializeRankCount //순위별 로또 수 초기화하기
* chooseLottoRank //로또 순위고르기
* calculateRankCount //순위별 로또 수 세기
* calculateProfit //이익 계산하기

## 6) WinningLotto
---
# < view >
## 1)  InputView
* inputPurchasePrice //구매 금액 입력받기
* inputWinningNumbers //당첨번호 입력받기
* inputBonusNumber //보너스번호 입력받기

## 2) OutputView
* outputNumberOfLotto //로또 개수 출력하기
* outputLottos //로또 출력하기
* outputMatchCounts //로또들의 일치 숫자수 세기
* outputMatchCount //로또의 일치 숫자수 세기
* outputStatistics //당첨통계 출력하기
* outputProfitRate //수익률 출력하기
---
# < 예외 >
* 로또 번호가 6개가 아닐 시 예외처리
* 로또 번호가 1부터 45사이의 숫자가 아닐 시 예외처리
* 로또에 중복된 숫자가 있을 시 예외 처리
* 구입금액이 입력값이 숫자가 아닐 시 예외처리
* 구입금액이 1000원 미만일 시 예외 처리
* 구입금액이 1000원으로 나누어 떨어지지 않을 시 예외처리

