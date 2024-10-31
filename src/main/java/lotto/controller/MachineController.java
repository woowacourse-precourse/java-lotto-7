package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class MachineController {
    public void start() {
        OutputView.printInputPurchaseAmountMessage();
        int purchaseAmount = InputView.readPurchaseAmount();
    }
}
