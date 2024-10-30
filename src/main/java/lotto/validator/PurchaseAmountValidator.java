package lotto.validator;

import static java.lang.String.format;
import static lotto.constant.LottoGameRule.LOTTO_COST;
import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_NOT_DIVISIBLE;
import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_NOT_NUMBER;
import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_OUT_OF_RANGE;

import lotto.exception.LottoException;

public class PurchaseAmountValidator {
    public static int validate(final String input) {
        int purchaseAmount = validateIsNumber(input);

        validateDivisibility(purchaseAmount);
        validateRange(purchaseAmount);

        return purchaseAmount;
    }

    private static int validateIsNumber(final String input) {
        int purchaseAmount;

        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(PURCHASE_AMOUNT_NOT_NUMBER);
        }

        return purchaseAmount;
    }

    private static void validateDivisibility(final int purchaseAmount) {
        if (isNotDivisible(purchaseAmount)) {
            throw new LottoException(format(PURCHASE_AMOUNT_NOT_DIVISIBLE.getMessage(), LOTTO_COST.getValue()));
        }
    }

    private static void validateRange(final int purchaseAmount) {
        if (isInValidRange(purchaseAmount)) {
            throw new LottoException(format(PURCHASE_AMOUNT_OUT_OF_RANGE.getMessage(), LOTTO_COST.getValue()));
        }
    }

    private static boolean isNotDivisible(final int purchaseAmount) {
        return purchaseAmount % LOTTO_COST.getValue() != 0;
    }

    private static boolean isInValidRange(final int purchaseAmount) {
        return purchaseAmount < LOTTO_COST.getValue();
    }
}
