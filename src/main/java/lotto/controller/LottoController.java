package lotto.controller;

import static lotto.model.LottoPrizeCalculator.*;
import static lotto.validation.PurchaseAmountValidation.*;
import static lotto.validation.WinningNumberValidation.parseValidatedBonusNumber;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import java.util.List;
import java.util.Map;
import lotto.model.LottoTickets;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import lotto.validation.WinningNumberValidation;


public class LottoController {

    public void run() {
        int attemptCount = getAttemptCount();
        printPurchaseLottoCount(attemptCount);

        LottoTickets lottoTickets = new LottoTickets(attemptCount);
        WinningLotto winningLotto = createWinningLotto();

        Map<Prize, Integer> lottoResult = calculate(lottoTickets, winningLotto);
        double profitRatio = calculateProfitRatio(attemptCount, getTotalAmount());

        printResultStatistics(lottoResult, profitRatio);
    }

    private int getAttemptCount() {
        printPurchaseAmountInputMessage();
        try {
            String purchaseAmount = UserInput();
            return parseValidatedLottoCount(purchaseAmount);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getAttemptCount();
        }
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber(winningNumber);
        return new WinningLotto(winningNumber, bonusNumber);
    }

    private List<Integer> getWinningNumber() {
        printWinningNumberInputMessage();
        try {
            String winningNumber = UserInput();
            return WinningNumberValidation.parseValidatedWinningNumber(winningNumber);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getWinningNumber();
        }
    }

    private int getBonusNumber(List<Integer> winningNumber) {
        printBonusNumberInputMessage();
        try {
            String bonusNumber = UserInput();
            return parseValidatedBonusNumber(bonusNumber, winningNumber);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getBonusNumber(winningNumber);
        }
    }


    private void printResultStatistics(Map<Prize, Integer> lottoResult, double profitRatio) {
        printWinningStatisticsMessage();
        printResult(lottoResult);
        printProfitRatio(profitRatio);
    }

}
