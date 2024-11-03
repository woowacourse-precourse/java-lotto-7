package lotto.Validator;

import static lotto.error.ErrorCode.NEGATIVE_OR_ZERO_AMOUNT;
import static lotto.error.ErrorCode.NOT_MULTIPLE_OF_THOUSAND;

public class AmountValidator {
    public static void validateAmount(int input) {
        validateDivisibleByThousand(input);
        validatePositive(input);
    }

    private static void validateDivisibleByThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }

    private static void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(NEGATIVE_OR_ZERO_AMOUNT.getMessage());
        }
    }

}
