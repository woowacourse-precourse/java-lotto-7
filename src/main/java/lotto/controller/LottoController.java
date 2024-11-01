package lotto.controller;

import lotto.constant.Constant;
import lotto.domain.Amount;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Amount amount = getPurchaseAmount();
    }

    private Amount getPurchaseAmount() {
        while (true) {
            inputView.printPurchaseAmountInputMessage();
            try {
                return Amount.of(inputView.getInput());
            } catch (IllegalArgumentException e) {
                System.out.println(Constant.ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
    }
}
