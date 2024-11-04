package lotto.validation;

import java.util.HashSet;
import java.util.Set;
import lotto.enums.ErrorMessage;

public class Validator {
    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final String DELIMITER_REGEX = "^[0-9]+(,[0-9]+)*$";

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

    public static boolean isValidNumberAndDelimiter(String winningNumber) {
        if (winningNumber.matches(DELIMITER_REGEX)) {
            return true;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER_AND_NUMBER.getMessage());
    }

    public static boolean isBetweenOneAndFortyFive(int parsedWinNumber) {
        if (parsedWinNumber >= 1 && parsedWinNumber <= 45) {
            return true;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_BETWEEN_ONE_AND_FORTYFIVE.getMessage());
    }

    public static void isNumberSixSize(String[] splitWinningNumber) {
        if (splitWinningNumber.length != 6) {
            throw new IllegalStateException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    public static void isDuplicateNumber(int parsedWinNumber) {
        Set<Integer> existNumbers = new HashSet<>();

        if (existNumbers.contains(parsedWinNumber)) {
            throw new IllegalStateException(ErrorMessage.INPUT_NUMBER_DUPLICATE_ERROR.getMessage());
        }
        existNumbers.add(parsedWinNumber);
    }
}

