package lotto.controller;

import lotto.model.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        requestPurchaseAmount();
        String rawPurchaseAmount = receivePurchaseAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(rawPurchaseAmount);
    }

    private String receivePurchaseAmount() {
        return inputView.receivePurchaseAmount();
    }

    private void requestPurchaseAmount() {
        outputView.requestPurchaseAmount();
    }
}
