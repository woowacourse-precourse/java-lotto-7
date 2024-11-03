package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        OutputView.printPurchaseAmountMessage();
        String purchaseAmount = InputView.getPurchaseAmount();
    }

}
