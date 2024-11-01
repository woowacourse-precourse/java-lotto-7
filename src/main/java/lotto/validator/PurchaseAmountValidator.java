package lotto.validator;

import static lotto.constants.LottoConstants.*;

public class PurchaseAmountValidator {
    private PurchaseAmountValidator() {
        // 인스턴스 생성 방지
    }

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
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NUMBER.getMessage(PURCHASE_AMOUNT));
        }
    }

    private static void validateNoSpace(String input) {
        if (!input.equals(input.strip())) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NO_SPACE.getMessage(PURCHASE_AMOUNT));
        }
    }

    private static void validateOverThreshold(int amount) {
        if (amount < PURCHASE_AMOUNT_THRESHOLD) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_OVER_THRESHOLD.getMessage());
        }
    }

    private static void validateUnit(int amount) {
        if (amount % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_UNIT.getMessage());
        }
    }
}