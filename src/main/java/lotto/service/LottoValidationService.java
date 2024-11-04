package lotto.service;

import lotto.util.validator.PurchaseAmountValidator;
import lotto.util.validator.Validator;

public class LottoValidationService {
    private final PurchaseAmountValidator purchaseAmountValidator;

    public LottoValidationService() {
        this.purchaseAmountValidator = new PurchaseAmountValidator();
    }

    public int validatePurchaseAmount(String input) {
        purchaseAmountValidator.validate(input);
        return Integer.parseInt(input);
    }

}
