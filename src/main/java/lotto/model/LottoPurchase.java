package lotto.model;

import lotto.validator.LottoPurchaseValidator;

public class LottoPurchase {

    public LottoPurchase(int purchaseAmount) {
        LottoPurchaseValidator.validate(purchaseAmount);
    }
}