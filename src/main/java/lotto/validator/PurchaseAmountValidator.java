package lotto.validator;

import static lotto.constants.LottoConstants.*;

public class PurchaseAmountValidator {
    private int purchaseAmount;

    public PurchaseAmountValidator(String input) {
        this.purchaseAmount = parsePurchaseAmount(input);
        validateZeroOrMore();
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

    private void validateZeroOrMore() {
        if (purchaseAmount < PURCHASE_AMOUNT_THRESHOLD) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_ZERO_OR_MORE.getMessage());
        }
    }
}
