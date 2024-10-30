package lotto.controller;

import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;

public class LottoGameController {
    public void run() {
        final int purchaseAmount = getPurchaseAmount();
    }

    private static int getPurchaseAmount() {
        String input = InputView.inputPurchaseAmount();
        return PurchaseAmountValidator.validate(input);
    }
}
