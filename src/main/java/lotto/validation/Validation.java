package lotto.validation;

import lotto.error.ErrorStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_SIZE = 6;

    public static void validateNotNull(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorStatus.NULL_OR_EMPTY_INPUT.getMessage());
        }
    }

    public static void validatePositiveInteger(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_NEGATIVE_NUMBER.getMessage());
        }
    }

    public static void validatePositiveIntegerList(List<Integer> inputs) {
        for (Integer input : inputs) {
            validatePositiveInteger(input);
        }
    }

    public static void validateMoneyAmount(int input) {
        if (input % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_MONEY_AMOUNT.getMessage());
        }
    }

    public static void validateDuplicateNumbers(List<Integer> input) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        boolean hasDuplicate = input.stream()
                .anyMatch(number -> !uniqueNumbers.add(number));

        if (hasDuplicate) {
            throw new IllegalArgumentException(ErrorStatus.DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void validateNumberSize(Integer size) {
        if (size != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_NUMBER_SIZE.getMessage());
        }
    }

    public static void validateDuplicateNumbersWithBonusNumber(List<Integer> winningNumbers, Integer input) {
        if (winningNumbers.contains(input)) {
            throw new IllegalArgumentException(ErrorStatus.DUPLICATE_NUMBER.getMessage());
        }
    }
}
