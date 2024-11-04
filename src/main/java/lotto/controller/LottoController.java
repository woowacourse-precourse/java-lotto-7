package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        OutputView.printPurchaseAmountMsg();
        int purchaseAmount = InputView.getPurchaseAmount();
    }
}