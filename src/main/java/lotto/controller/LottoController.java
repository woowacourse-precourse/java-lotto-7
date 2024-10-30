package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int tryPurchaseAmount = tryPurchaseAmount();
    }

    private int tryPurchaseAmount() {
        while (true) {
            try {
                outputView.printPurchaseAmountMessage();
                return inputView.inputPurchaseAmount();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
