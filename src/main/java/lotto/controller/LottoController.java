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
        int purchasePrice = inputView.getInteger();
        validatePurchasePrice(purchasePrice);
        return purchasePrice;
    }

    private void validatePurchasePrice(int value) {
        validatePositive(value);
        validatePurchaseUnit(value);
    }

    private void validatePositive(final int value) {
        if (isNotPositive(value)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotPositive(final int value) {
        return value <= 0;
    }

    private void validatePurchaseUnit(final int value) {
        if (isNotMultipleOf1000(value)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotMultipleOf1000(final int value) {
        return value % 1000 != 0;
    }
}
