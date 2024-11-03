package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    private static void getValidLottoPurchaseAmount() {
        try {
            PurchaseAmountDTO purchaseAmountDTO = InputView.inputLottoPurchaseAmount();

        } catch (IllegalArgumentException e) {
            getValidLottoPurchaseAmount();
        }
    }
}
