package lotto.controller;

import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MachineController {
    public void start() {
        OutputView.printInputPurchaseAmountMessage();
        int purchaseAmount = InputView.readPurchaseAmount();

        User user = new User(purchaseAmount);
    }
}
