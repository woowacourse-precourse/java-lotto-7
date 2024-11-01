package lotto.validator;

import static lotto.constants.LottoConstants.*;

public class PurchaseAmountValidator {
    private final int purchaseAmount;

    public PurchaseAmountValidator(String input) {
        this.purchaseAmount = parsePurchaseAmount(input);
        validateOverThreshold();
        validateUnit();
    }

    private int parsePurchaseAmount(String input) {
        validateNoSpace(input);
        validateIsNumber(input);
        return Integer.parseInt(input);
    }

    private void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NUMBER.getMessage(PURCHASE_AMOUNT));
        }
    }

    private void validateNoSpace(String input) {
        if (!input.equals(input.strip())) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NO_SPACE.getMessage(PURCHASE_AMOUNT));
        }
    }

    private void validateOverThreshold() {
        if (purchaseAmount < PURCHASE_AMOUNT_THRESHOLD) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_OVER_THRESHOLD.getMessage());
        }
    }

    private void validateUnit() {
        if (purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_UNIT.getMessage());
        }
    }
}
