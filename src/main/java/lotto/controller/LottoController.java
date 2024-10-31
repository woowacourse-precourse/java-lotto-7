package lotto.controller;

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
        int purchasePrice = getPurchasePrice();
    }

    private int getPurchasePrice() {
        outputView.printPurchasePriceRequest();
        String purchasePrice = inputView.read();
        return Integer.parseInt(purchasePrice);
    }
}
