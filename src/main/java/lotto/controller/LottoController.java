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
        validatePurchasePrice(purchasePrice);
        return Integer.parseInt(purchasePrice);
    }

    private void validatePurchasePrice(final String purchasePrice) {
        validateNumberFormat(purchasePrice);
        validatePositiveIntegerRange(purchasePrice);
        validatePurchaseUnit(Integer.parseInt(purchasePrice));
    }

    private void validateNumberFormat(final String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotNumber(final String input) {
        return !input.matches("\\d+");
    }

    private void validatePositiveIntegerRange(final String input) {
        try {
            final int value = Integer.parseInt(input);
            if (isZero(value)) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isZero(final int value) {
        return value == 0;
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
