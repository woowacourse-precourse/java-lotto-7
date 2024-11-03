package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.domain.LottoResult;
import lotto.service.LottoPrizeService;
import lotto.service.LottoService;
import lotto.util.constant.LottoConstants;
import lotto.util.validator.BonusNumbersValidator;
import lotto.util.validator.PurchaseMoneyValidator;
import lotto.util.validator.WinnerNumbersValidator;
import lotto.view.InputView;
import lotto.view.OutputPrompt;
import lotto.view.OutputResult;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.constant.LottoConstants.*;

public class LottoController {

    // 로또 내부 메인 실행 흐름
    public static void startLotto() throws IllegalArgumentException{
        LottoCollection lotto = initializeLottoCollection();
        generateAndDisplayLottoNumbers(lotto);
        setWinningNumbers(lotto);
        calculateAndDisplayWinningStatistics(lotto);
    }

    // 1. LottoCollection 생성
    private static LottoCollection initializeLottoCollection() throws IllegalArgumentException {
        long purchaseAmount = getValidatedPurchaseAmountFromUser();
        return new LottoCollection(purchaseAmount);
    }

    // 1-1. 로또 구입 금액 입력 및 유효성 검증
    private static long getValidatedPurchaseAmountFromUser() throws IllegalArgumentException {
        boolean validInput = true;
        String purchaseMoneyInput = "";
        while(validInput){
            try {
                OutputPrompt.printPurchaseAmountPrompt();
                purchaseMoneyInput = InputView.getUserInput();
                PurchaseMoneyValidator.validatePurchaseMoney(purchaseMoneyInput);
                validInput = false;
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception);
            }
        }
        return Long.parseLong(purchaseMoneyInput);
    }

    // 2. 로또 번호 생성 및 출력
    private static void generateAndDisplayLottoNumbers(LottoCollection lotto) {
        ArrayList<Lotto> newLotto = LottoService.generateNewLottoNumbers(lotto.getNumOfLotto());
        lotto.setLotto(newLotto);
        OutputResult.printNewLotto(lotto.getLotto());
    }

    // 3. 당첨 번호 및 보너스 번호 설정
    private static void setWinningNumbers(LottoCollection lotto) {
        Lotto winnerLotto = getValidatedWinningNumbersFromUser();
        int bonusNumber = getValidatedBonusNumberFromUser(winnerLotto.getNumbers());
        lotto.setWinnerLottoAndBonusNumber(winnerLotto, bonusNumber);
    }

    // 3-1. 당첨 번호의 입력 및 유효성 검증
    private static Lotto getValidatedWinningNumbersFromUser() {
        boolean validInput = true;
        Lotto winnerLotto = null;
        while (validInput) {
            try {
                OutputPrompt.printWinnerNumbersPrompt();
                String winnerLottoInput = InputView.getUserInput();
                WinnerNumbersValidator.validateWinnerNumber(winnerLottoInput);
                winnerLotto = new Lotto(LottoService.generateWinnerLotto(winnerLottoInput));
                validInput = false;
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception);
            }
        }
        return winnerLotto;
    }

    // 3-2. 보너스 번호의 입력 및 유효성 검증
    private static int getValidatedBonusNumberFromUser(List<Integer> winnerNumbers) {
        boolean validInput = true;
        int bonusNumber = 0;
        while (validInput) {
            try {
                OutputPrompt.printBonusNumbersPrompt();
                String bonusNumberInput = InputView.getUserInput();
                BonusNumbersValidator.validateBonusNumber(bonusNumberInput, winnerNumbers);
                bonusNumber = Integer.parseInt(bonusNumberInput);
                validInput = false;
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception);
            }
        }
        return bonusNumber;
    }

    // 4. 당첨 확인 및 통계 출력
    private static void calculateAndDisplayWinningStatistics(LottoCollection lotto) {
        LottoResult lottoResult = new LottoResult();

        LottoPrizeService.checkPrizeOfLotto(lotto, lottoResult);
        OutputResult.printWinningStatus(lottoResult);

        LottoPrizeService.calculateProfit(lotto.getPurchaseMoney(), lottoResult);
        OutputResult.printTotalProfit(LottoResult.getProfit());
    }

}
