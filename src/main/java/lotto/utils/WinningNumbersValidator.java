package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersValidator {

    public static void validateWinningNumbers(List<String> inputNumbers) {
        validateAllNumeric(inputNumbers);
        validateInRange(inputNumbers);
        validateNoDuplicates(inputNumbers);
        validateSize(inputNumbers);
    }

    private static void validateAllNumeric(List<String> inputNumbers) {
        for (String number : inputNumbers) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessages.NON_NUMERIC_INPUT.getMessage());
            }
        }
    }

    private static void validateInRange(List<String> inputNumbers) {
        for (String number : inputNumbers) {
            int num = Integer.parseInt(number);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE.getMessage());
            }
        }
    }

    private static void validateNoDuplicates(List<String> inputNumbers) {
        Set<String> uniqueNumbers = new HashSet<>(inputNumbers);
        if (uniqueNumbers.size() != inputNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBERS.getMessage());
        }
    }

    private static void validateSize(List<String> inputNumbers) {
        if (inputNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.NOT_SIX_NUMBERS.getMessage());
        }
    }
}
