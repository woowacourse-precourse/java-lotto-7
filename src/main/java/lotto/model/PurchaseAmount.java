package lotto.model;

import static lotto.constants.ErrorMessage.INPUT_VALUE_MUST_BE_NUMERIC;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_BLANK_AT_EDGES;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_ZERO_VALUE;
import static lotto.constants.ErrorMessage.PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000;

public class PurchaseAmount {
    private static final int UNIT = 1000;

    private final String rawPurchaseAmount;

    public PurchaseAmount(String rawPurchaseAmount) {
        validate(rawPurchaseAmount);
        this.rawPurchaseAmount = rawPurchaseAmount;
    }

    public int calculateLottoCount() {
        return toInteger(rawPurchaseAmount) / UNIT;
    }

    private void validate(String rawPurchaseAmount) {
        validateStrip(rawPurchaseAmount);
        validateNumeric(rawPurchaseAmount);
        validateZero(rawPurchaseAmount);
        validateThousandUnit(rawPurchaseAmount);
    }

    private void validateStrip(String rawPurchaseAmount) {
        String stripped = rawPurchaseAmount.strip();
        if (rawPurchaseAmount.equals(stripped)) {
            return;
        }
        throw new IllegalArgumentException(NOT_ALLOWED_BLANK_AT_EDGES);
    }

    private void validateNumeric(String rawPurchaseAmount) {
        try {
            toInteger(rawPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_VALUE_MUST_BE_NUMERIC);
        }
    }

    private void validateZero(String rawPurchaseAmount) {
        int purchaseAmount = toInteger(rawPurchaseAmount);
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException(NOT_ALLOWED_ZERO_VALUE);
        }
    }

    private void validateThousandUnit(String rawPurchaseAmount) {
        int purchaseAmount = toInteger(rawPurchaseAmount);
        if (purchaseAmount % UNIT == 0) {
            return;
        }
        throw new IllegalArgumentException(PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000);
    }

    private int toInteger(String rawPurchaseAmount) {
        return Integer.parseInt(rawPurchaseAmount);
    }
}
