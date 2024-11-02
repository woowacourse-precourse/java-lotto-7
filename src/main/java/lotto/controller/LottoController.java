package lotto.controller;

import lotto.model.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputView.requestPurchaseAmount());
        outputView.printPurchaseAmount(purchaseAmount.getLottoQuantity());
    }
}
