package lotto.domain;

import lotto.util.ParseUtil;
import lotto.validator.PurchaseAmountValidator;

public class PurchaseAmount {

    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        PurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount createPurchaseAmount(String input) {
        PurchaseAmountValidator.validateInputPurchaseAmount(input);
        return new PurchaseAmount(ParseUtil.parseInt(input));
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

}
