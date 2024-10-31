package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {

    public void start(){
        String purchaseAmount = inputPurchaseAmount();
    }

    private String inputPurchaseAmount() {
        OutputView.inputPurchaseAmount();
        return InputView.readUserInput();
    }
}
