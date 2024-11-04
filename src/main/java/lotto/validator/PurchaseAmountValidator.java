package lotto.validator;

import static lotto.constants.LottoConstants.PURCHASE_AMOUNT;
import static lotto.constants.LottoConstants.PURCHASE_AMOUNT_THRESHOLD;
import static lotto.constants.LottoConstants.PURCHASE_AMOUNT_UNIT;

public class PurchaseAmountValidator {

    public static int validateAndParse(String input) {
        validateNoSpace(input);
        validateIsNumber(input);
        int amount = Integer.parseInt(input);

        validateOverThreshold(amount);
        validateUnit(amount);

        return amount;
    }

    private static void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoErrorMessages.MUST_BE_NUMBER.getMessage(PURCHASE_AMOUNT));
        }
    }

    private static void validateNoSpace(String input) {
        if (!input.equals(input.strip())) {
            throw new IllegalArgumentException(LottoErrorMessages.MUST_BE_NO_SPACE.getMessage(PURCHASE_AMOUNT));
        }
    }

    private static void validateOverThreshold(int amount) {
        if (amount < PURCHASE_AMOUNT_THRESHOLD) {
            throw new IllegalArgumentException(LottoErrorMessages.MUST_BE_OVER_THRESHOLD.getMessage());
        }
    }

    private static void validateUnit(int amount) {
        if (amount % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(LottoErrorMessages.MUST_BE_UNIT.getMessage());
        }
    }
}