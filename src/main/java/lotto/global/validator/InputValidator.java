package lotto.global.validator;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.global.exception.ErrorMessage;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class InputValidator {

    public static int validatePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            validatePurchaseAmountRange(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_NOT_NUMBER.getMessage());
        }
    }

    private static void validatePurchaseAmountRange(int amount) {
        if (amount > 100000000) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_MAXIMUM.getMessage());
        }
        if (amount < 1000) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_MINIMUM.getMessage());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
        }
    }

    public static List<Integer> validateWinningNumbers(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.getMessage());
        }

        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(InputValidator::parseNumber)
                    .collect(Collectors.toList());

            validateWinningNumbersSize(numbers);
            validateWinningNumbersDuplicate(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NOT_NUMBER.getMessage());
        }
    }

    private static void validateWinningNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_SIZE.getMessage());
        }
    }

    private static void validateWinningNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_DUPLICATE.getMessage());
        }
    }

    public static int validateBonusNumber(String input, List<Integer> winningNumbers) {
        try {
            int bonusNumber = Integer.parseInt(input.trim());
            validateBonusNumberDuplicate(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NOT_NUMBER.getMessage());
        }
    }

    private static void validateBonusNumberDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NOT_NUMBER.getMessage());
        }
    }
}