package lotto.util;

import static lotto.exception.ErrorBase.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonValidator {

    public static void validateNotBlank(String input, String errorMessage) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static Long parseLong(String input, String errorMessage) {
        try {
            return Long.parseLong(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static Integer parseInteger(String input, String errorMessage) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateSize(List<Integer> numbers, int expectedSize) {
        if (numbers.size() != expectedSize) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_SIZE.getMessage());
        }
    }

    public static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE.getMessage());
        }
    }

    public static void validateNumberRange(List<Integer> numbers, int min, int max) {
        boolean outOfRange = numbers.stream().anyMatch(number -> number < min || number > max);
        if (outOfRange) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
        }
    }

    public static void validatePositiveAmount(Long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_INVALID.getMessage());
        }
    }

    public static void validateMultipleOf(Long amount, int multiple) {
        if (amount % multiple != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_MULTIPLE.getMessage());
        }
    }
}
