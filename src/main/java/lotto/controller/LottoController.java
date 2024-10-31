package lotto.controller;

import lotto.model.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;


    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Purchase purchase = requestPurchase();
        int purchaseQuantity = purchase.getQuantity();
        outputView.printPurchaseQuantity(purchaseQuantity);
    }

    private Purchase requestPurchase() {
        outputView.printPurchasePriceRequest();
        int purchasePrice = inputView.getInteger();
        return new Purchase(purchasePrice);
    }
}
