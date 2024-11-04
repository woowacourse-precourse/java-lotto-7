package lotto.controller;

import lotto.domain.AutoLottos;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        int purchaseAmount = getPurchaseAmountWithRetry();

        AutoLottos autoLottos = new AutoLottos(purchaseAmount);

        OutputView.outputAutoLottos(autoLottos.getAutoLottos());

        Lotto winningNumbers = getWinningNumbersWithRetry();
        WinningLotto winningLotto = addBonusNumberToWinningNumbersWithRetry(winningNumbers);

        WinningResult winningResult = new WinningResult();
        winningResult.matchLottosAndWinningLotto(autoLottos.getAutoLottos(), winningLotto);

        OutputView.outputWinningResult(winningResult, purchaseAmount);
    }

    private int getPurchaseAmountWithRetry() {
        try {
            OutputView.requestInputPurchaseAmount();
            int purchaseAmount = InputView.inputLottoPurchaseAmount();
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmountWithRetry();
        }
    }

    private Lotto getWinningNumbersWithRetry() {
        try {
            OutputView.requestInputWinningNumbers();
            Lotto winningNumbers = InputView.inputLottoWinningNumbers();
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbersWithRetry();
        }
    }

    private WinningLotto addBonusNumberToWinningNumbersWithRetry(Lotto winningNumbers) {
        try {
            OutputView.requestInputBounusNumber();
            Integer inputBonusNumber = InputView.inputBonusNumber();
            return new WinningLotto(winningNumbers, inputBonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return addBonusNumberToWinningNumbersWithRetry(winningNumbers);
        }
    }
}
