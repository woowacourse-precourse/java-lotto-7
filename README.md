# 로또

## :computer: 프로그램 소개

로또 구입 금액과 당첨 번호를 입력하면 구입 금액에 해당하는 만큼 로또를 발행하고 당첨 번호와 비교하여 당첨 내역과 수익률을 출력하는 프로그램

## :pushpin: 기능 목록

:star: 핵심 기능 : 발행한 로또 번호와 당첨 번호를 비교하여 당첨 내역과 수익률 출력하기

* 로또 구입 금액 입력 안내 문구 출력하기 - `OutputView#printLottoAmountPrompt`
* 로또 구입 금액 입력받기 - `InputView#readLottoPurchasePrice`
    * 숫자가 아닌 경우 예외 발생 후 다시 입력받기 - `InputView#validateIsNumeric`
    * 구입 금액이 1,000원으로 나누어떨어지지 않는 경우 예외 발생 후 다시 입력받기 - `InputView#validatePurchasePriceByThousand`
* 발행한 로또 수량 출력하기 - `OutputView#printLottoAmount`
* 구입 금액에 따라 무작위로 로또 번호 발행하고 오름차순으로 정렬하기 - `Application#generateLottoNumbers`
* 정렬한 로또 번호 출력하기 - `OutputView#printUserLottoNumber`
* 당첨 번호 입력 안내 문구 출력하기 - `OutputView#printLottoWinningNumberPrompt`
* 당첨 번호 입력받기 - `InputView#readLottoWinningNumber`
    * 쉼표가 아닌 다른 구분자를 사용한 경우 예외 발생 후 다시 입력받기 - `InputView#validateNonCommaDelimiter`
    * 마지막에 쉼표를 입력한 경우 예외 발생 후 다시 입력받기 - `InputView#validateLastCharComma`
    * 6개의 숫자를 입력하지 않은 경우 예외 발생 후 다시 입력받기 - `Lotto#validate`
    * 1~45 사이의 숫자가 아닌 경우 예외 발생 후 다시 입력받기 - `Lotto#validateLottoRange`
    * 중복된 번호를 입력한 경우 예외 발생 후 다시 입력받기 - `Lotto#validateLottoDuplicate`
* 보너스 번호 입력 안내 문구 출력하기 - `OutputView#printLottoBonusNumberPrompt`
* 보너스 번호 입력받기 - `InputView#readLottoBonusNumber`
    * 숫자가 아닌 경우 예외 발생 후 다시 입력받기 - `InputView#validateIsNumeric`
    * 1~45 사이의 숫자가 아닌 경우 예외 발생 후 다시 입력받기 - `InputView#validateLottoRange`
    * 당첨 번호와 중복된 번호를 입력한 경우 예외 발생 후 다시 입력받기 - `InputView#validateBonusNumberDuplicate`
* 발행한 로또 번호와 당첨 번호를 비교하기 - `Application#checkLottoMatch`
  * 발행한 로또 번호와 당첨 번호를 비교하여 일치한 번호 개수 구하기 - `Application#compareLottoNumbers`
  * 일치한 번호 개수가 5개인 경우 발행한 로또 번호에 보너스 번호가 포함되어 있는지 검사하기 - `Application#compareBonusNumber`
* 당첨 내역 출력하기 - `OutputView#printLottoResult`
* 구입 금액과 당첨 내역을 바탕으로 수익률 계산하기 - `Application#calculateLottoProfit`
* 수익률을 소수점 둘째 자리에서 반올림하여 출력하기 - `OutputView#printLottoProfit`
