package lotto.controller;

import lotto.view.InputView;

public class LottoGameController {
    public void run() {
        final int purchaseAmount = getPurchaseAmount();
    }

    private static int getPurchaseAmount() {
        return Integer.parseInt(InputView.inputPurchaseAmount());
    }
}
