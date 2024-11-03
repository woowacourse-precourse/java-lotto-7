package lotto.model.purchase;

import lotto.utils.ErrorMessages;

public class PurchaseAmountValidator {
    private final int lottoPrice;

    public PurchaseAmountValidator(int lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public void validate(int amount) {
        validateMinimumPurchaseAmount(amount);
        validateMultipleOfPrice(amount);
    }

    private void validateMultipleOfPrice(int amount) {
        if (amount % lottoPrice != 0) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_INVALID_AMOUNT);
        }
    }

    private void validateMinimumPurchaseAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NON_POSITIVE_TICKET_COUNT);
        }
    }

}
