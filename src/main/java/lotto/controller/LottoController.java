package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Integer purchaseAmount = getPurchaseAmount();
    }

    private Integer getPurchaseAmount() {
        try {
            return inputView.getPurchaseAmountInput();
        } catch (IllegalArgumentException e) {
            outputView.renderErrorMessage(e.getMessage());
            return getPurchaseAmount();
        }
    }
}
