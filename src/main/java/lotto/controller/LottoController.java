package lotto.controller;


import lotto.validation.PurchaseAmountValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        int attemptCount = getAttemptCount();
    }

    private int getAttemptCount() {
        OutputView.printPurchaseAmountInputMessage();
        String purchaseAmount = InputView.UserInput();

    }
}
