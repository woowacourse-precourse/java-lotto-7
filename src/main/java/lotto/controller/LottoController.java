package lotto.controller;

import lotto.domain.PurchaseAmount;
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
        PurchaseAmount purchaseAmount = readPurchaseAmount();

    }

    private PurchaseAmount readPurchaseAmount() {
        outputView.promptPurchaseAmount();
        int purchaseAmountInput = inputView.readPurchaseAmountInput();

        return new PurchaseAmount(purchaseAmountInput);
    }
}
