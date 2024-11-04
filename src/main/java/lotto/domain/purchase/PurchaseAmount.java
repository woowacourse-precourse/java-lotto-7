package lotto.domain.purchase;

import lotto.constants.LottoConstants;
import lotto.validator.PurchaseAmountValidator;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = validate(purchaseAmount);
    }

    private int validate(String purchaseAmount) {
        PurchaseAmountValidator.validateNullOrEmpty(purchaseAmount);
        PurchaseAmountValidator.validateNumeric(purchaseAmount);
        int amount = Integer.parseInt(purchaseAmount);
        PurchaseAmountValidator.validateMultipleOfThousand(amount);
        return amount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int calculateIssuedTicketCount() {
        return purchaseAmount / LottoConstants.LOTTO_PRICE;
    }
}
