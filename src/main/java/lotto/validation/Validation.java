package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    public static void validatedPurchaseAmount(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ValidationType.EMPTY_AMOUNT.validationMsg());
        }
    }
    public static void validatedThousandUnitAmount(String input) {
        try {
            int inputResult = Integer.parseInt(input);
            if (inputResult < 1000) {
                throw new IllegalArgumentException(ValidationType.NEGATIVE_AMOUNT.validationMsg());
            }
            if (!(inputResult % 1000 == 0)) {
                throw new IllegalArgumentException(ValidationType.INVALID_UNIT.validationMsg());
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidationType.NOT_NUMERIC.validationMsg());
        }
    }

    public static void validatedWinnigNumbers(List<Integer> winningNumbers) {
        Set<Integer> numberSet = new HashSet<>();
        validatedWinningNumbers(winningNumbers);
        for (Integer number : winningNumbers) {
            outOfRangeWinningNumber(number);
            duplicateWinningNumber(number, numberSet);
        }
    }
    public static void validateWinningNumberFormat(String winningNumber) {
        String regex ="^(\\d{1,2})(,\\d{1,2}){5}$";
        if (!winningNumber.matches(regex)) {
            throw new IllegalArgumentException(ValidationType.INVALID_FORMAT.validationMsg());
        }
    }

    private static void validatedWinningNumbers(List<Integer> winningNumbers) {
        if (!(winningNumbers.size() == 6)) {
            throw new IllegalArgumentException(ValidationType.INVALID_COUNT.validationMsg());
        }
    }

    private static void outOfRangeWinningNumber(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ValidationType.OUT_OF_RANGE.validationMsg());
        }
    }

    private static void duplicateWinningNumber(Integer number, Set<Integer> numberSet) {
        if (!numberSet.add(number)) {
            throw new IllegalArgumentException(ValidationType.DUPLICATE_NUMBERS.validationMsg());
        }
    }
}
