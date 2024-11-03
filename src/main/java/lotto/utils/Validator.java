package lotto.utils;

import static lotto.exception.ExceptionMessage.IS_DUPLICATED;
import static lotto.exception.ExceptionMessage.NOT_IN_RANGE;
import static lotto.exception.ExceptionMessage.NOT_MATCHED_NUMBERS;
import static lotto.exception.ExceptionMessage.NOT_NUMBER;
import static lotto.exception.ExceptionMessage.NOT_POSITIVE_NUMBER;
import static lotto.exception.ExceptionMessage.NOT_VALID_PURCHASE_AMOUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validatePurchaseInput(String input) {
        long number = parseNumber(input);
        isPositiveNumber(number);
        isValidPurchaseAmount(number);
    }

    public static void validateWinningNumbersInput(String input) {
        List<String> numbers = parseWinningNumber(input);
        isValidWinningNumber(numbers);
    }

    public static void validateBonusNumberInput(String input, List<Integer> winningNumbers) {
        int number = (int) parseNumber(input);
        isInRange(number);
        isValidBonusNumber(number, winningNumbers);
    }

    private static long parseNumber(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private static List<String> parseWinningNumber(String input) {
        List<String> numbers = List.of(input.split(","));

        if(numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_MATCHED_NUMBERS.getMessage());
        }

        return numbers;
    }

    private static void isPositiveNumber(long input) {
        if(input <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER.getMessage());
        }
    }

    private static void isInRange(int input) {
        if(input < 1 || input > 45) {
            throw new IllegalArgumentException(NOT_IN_RANGE.getMessage());
        }
    }

    private static void isValidPurchaseAmount(long input) {
        if(input % 1000 != 0) {
            throw new IllegalArgumentException(NOT_VALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void isValidWinningNumber(List<String> inputs) {
        Set<Integer> numbers = new HashSet<>();

        for(String input : inputs) {
            int number = (int) parseNumber(input);
            isInRange(number);

            if(numbers.contains(number)) {
                throw new IllegalArgumentException(IS_DUPLICATED.getMessage());
            }
            numbers.add(number);
        }
    }

    private static void isValidBonusNumber(int input, List<Integer> winningNumbers) {
        if(winningNumbers.contains(input)) {
            throw new IllegalArgumentException(IS_DUPLICATED.getMessage());
        }
    }

}
