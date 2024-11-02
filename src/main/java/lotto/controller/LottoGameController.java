package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private InputView inputView;
    private OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        long purchaseAmount = requestPurchaseAmount();
    }

    private long requestPurchaseAmount() {
        outputView.printPurchaseAmountRequestMessage();
        return inputView.readPurchaseAmount();
    }
}
