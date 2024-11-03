package lotto.validator;

import message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final int MAX_PURCHASE_AMOUNT = 100000;

    public static void validatePurchaseAmount(String input) {
        validateNotEmpty(input);
        validateIsNumeric(input);
        validatePositiveAmount(input);
        validateThousandUnit(input);
        validateMaxPurchaseAmount(input);
    }

    public static void validateWinningNumber(String input) {
        validateWinningNumberFormat(input);
        validateWinningNumberRange(input);
        validateNoDuplicateWinningNumbers(input);
    }

    public static void validateBonusNumber(String input, List<Integer> winningNumbers) {
        validateIsNumeric(input);
        validateBonusNumberRange(input);
        validateBonusNumberNotInWinningNumbers(input, winningNumbers);
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.message());
        }
    }

    private static void validateIsNumeric(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.message());
        }
    }

    private static void validatePositiveAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.POSITIVE_AMOUNT.message());
        }
    }

    private static void validateThousandUnit(String input) {
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.THOUSAND_UNIT.message());
        }
    }

    private static void validateMaxPurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.MAX_PURCHASE_AMOUNT.message());
        }
    }

    private static void validateWinningNumberFormat(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT.message());
        }
    }

    private static void validateWinningNumberRange(String input) {
        String[] numbers = input.split(",");

        for (String number : numbers) {
            validateIsNumeric(number);
            int num = Integer.parseInt(number);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE.message());
            }
        }
    }

    private static void validateNoDuplicateWinningNumbers(String input) {
        Set<Integer> numberSet = new HashSet<>();
        String[] numbers = input.split(",");

        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (!numberSet.add(num)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS.message());
            }
        }
    }

    private static void validateBonusNumberRange(String input) {
        int bonusNum = Integer.parseInt(input);
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE.message());
        }
    }

    private static void validateBonusNumberNotInWinningNumbers(String input, List<Integer> winningNumbers) {
        int bonusNum = Integer.parseInt(input);
        if (winningNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.message());
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
