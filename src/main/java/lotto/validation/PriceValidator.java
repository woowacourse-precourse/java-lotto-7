package lotto.validation;

import enums.Delimiter;
import enums.ErrorMessage;

public class PriceValidator {

    public static void validatePrice(String input) {
        validateNull(input);
        long convertInput = convertToLong(input);
        validateZero(convertInput);
        validateUnderThousand(convertInput);
        validateDivideThousand(convertInput);
    }

    private static void validateNull(String price) {
        if (isNullOrEmpty(price)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    private static void validateZero(long price) {
        if (price == 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ZERO.getErrorMessage());
        }
    }

    private static void validateUnderThousand(long price) {
        if (price < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_UNDER_THOUSAND.getErrorMessage());
        }
    }

    private static void validateDivideThousand(long price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_NOT_DIVIDE_THOUSAND.getErrorMessage());
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static long convertToLong(String input) {
        return Long.parseLong(input.trim());
    }
}
