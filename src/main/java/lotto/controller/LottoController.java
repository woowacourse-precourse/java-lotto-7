package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        OutputView.printInputPurchaseAmountMessage();
        String purchaseAmountInput = InputView.getUserInput();
        OutputView.printInputWinningNumbers();
        String winningNumbersInput = InputView.getUserInput();


    }
}
