package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final InputView outputView;

    public LottoController(InputView inputView, InputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();

    }

    private PurchaseAmount readPurchaseAmount() {
        outputView.readPurchaseAmountInput();
        int purchaseAmountInput = inputView.readPurchaseAmountInput();

        return new PurchaseAmount(purchaseAmountInput);
    }
}
