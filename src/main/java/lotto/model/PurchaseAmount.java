package lotto.model;

import static lotto.constants.ErrorMessage.INPUT_VALUE_MUST_BE_NUMERIC;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_BLANK_AT_EDGES;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_MINUS;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_ZERO_VALUE;
import static lotto.constants.ErrorMessage.PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000;

public class PurchaseAmount {
    private static final int UNIT = 1000;

    private final int purchaseAmount;

    public PurchaseAmount(String rawPurchaseAmount) {
        validate(rawPurchaseAmount);
        this.purchaseAmount = parseNumeric(rawPurchaseAmount);
    }

    public int calculateLottoCount() {
        return purchaseAmount / UNIT;
    }

    private void validate(String rawPurchaseAmount) {
        validateStrip(rawPurchaseAmount);
    }

    private void validateStrip(String rawPurchaseAmount) {
        String stripped = rawPurchaseAmount.strip();
        if (rawPurchaseAmount.equals(stripped)) {
            return;
        }
        throw new IllegalArgumentException(NOT_ALLOWED_BLANK_AT_EDGES);
    }

    private int parseNumeric(String rawPurchaseAmount) {
        try {
            int purchaseAmount = Integer.parseInt(rawPurchaseAmount);
            validateAfterParsing(purchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_VALUE_MUST_BE_NUMERIC);
        }
    }

    private void validateAfterParsing(int purchaseAmount) {
        validateZero(purchaseAmount);
        validateMinus(purchaseAmount);
        validateThousandUnit(purchaseAmount);
    }

    private void validateZero(int purchaseAmount) {
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException(NOT_ALLOWED_ZERO_VALUE);
        }
    }

    private void validateMinus(int purchaseAmount) {
        if (isMinus(purchaseAmount)) {
            throw new IllegalArgumentException(NOT_ALLOWED_MINUS);
        }
    }

    private void validateThousandUnit(int purchaseAmount) {
        if (purchaseAmount % UNIT == 0) {
            return;
        }
        throw new IllegalArgumentException(PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000);
    }

    private boolean isMinus(int purchaseAmount) {
        return purchaseAmount < 0;
    }
}