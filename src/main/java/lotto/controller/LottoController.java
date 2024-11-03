package lotto.controller;

import lotto.view.InputView;

import static lotto.service.Validator.validatePurchaseAmount;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run () {
        Integer purchaseAmount = lottoPurchase();
    }

    private Integer lottoPurchase () {
        String rawPurchaseAmount = inputView.getPurchaseAmount();

        validatePurchaseAmount(rawPurchaseAmount);

        return Integer.parseInt(rawPurchaseAmount);
    }
}
