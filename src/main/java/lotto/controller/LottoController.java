package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void draw() {
        int purchaseAmount = makeLottoPurchaseAmountRecursion();
        Lotto winningNumbers = makeWinningNumbersRecursion();
        WinningLotto winningLotto = addBonusNumbersToWinningNumbersRecursion(winningNumbers);
    }

    private int makeLottoPurchaseAmountRecursion() {
        try {
            OutputView.requestInputPurchaseAmount();
            int purchaseAmount = InputView.inputLottoPurchaseAmount();
            return purchaseAmount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return makeLottoPurchaseAmountRecursion();
        }
    }

    private Lotto makeWinningNumbersRecursion() {
        try {
            OutputView.requestInputWinningNumbers();
            Lotto winningNumbers = InputView.inputLottoWinningNumbers();
            return winningNumbers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return makeWinningNumbersRecursion();
        }
    }

    private WinningLotto addBonusNumbersToWinningNumbersRecursion(Lotto winningNumbers) {
        try {
            OutputView.requestInputBounusNumber();
            Integer inputBonusNumber = InputView.inputBonusNumber();
            return new WinningLotto(winningNumbers, inputBonusNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return addBonusNumbersToWinningNumbersRecursion(winningNumbers);
        }
    }
}
