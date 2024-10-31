package lotto.validation;

import lotto.enums.ErrorMessage;

public class Validator {
    private static final String NUMBER_REGEX = "^[0-9]+$";

    public static boolean isBlank(String inputCost) {
        if (inputCost.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK_ERROR.getMessage());
        }
        return false;
    }

    public static boolean isPositiveNumber(String inputCost) {
        if (inputCost.matches(NUMBER_REGEX)) {
            return true;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER_ERROR.getMessage());
    }

    public static boolean isDivisibleByThousand(int parsedPurchaseAmount) {
        if (parsedPurchaseAmount % 1000 == 0) {
            return true;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_NOT_DIVISIBLE_BY_1000.getMessage());
    }


}

