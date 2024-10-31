package lotto.custom.service;

import static lotto.custom.constants.NumberConstants.LOTTO_PRICE;

import lotto.custom.validator.InputValidator;

public class LottoPurchaseService {
    private final InputValidator inputValidator;

    public LottoPurchaseService() {
        this.inputValidator = new InputValidator();
    }

    public void run(String purchaseAmountInput) {
        inputValidator.validatePurchaseAmountInput(purchaseAmountInput);
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        int numberOfLotto = purchaseAmount / LOTTO_PRICE;
    }
}