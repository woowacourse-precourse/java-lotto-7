package lotto.util.validator;

import lotto.exception.InputErrorMessage;
import lotto.util.parser.InputParser;

import java.util.List;

public class BonusNumberValidator {
    private final static String NUMBER_PATTERN = "\\d+";
    private final static int MAX_BONUS = 45;
    private final static int MIN_BONUS = 1;
    private BonusNumberValidator() {}

    public static void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        validateNotEmpty(bonusNumber);
        validateNumericFormat(bonusNumber);
        int bonus = InputParser.parseNumber(bonusNumber);
        validateRange(bonus);
        validateDuplicates(bonus, winningNumbers);
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(InputErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateNumericFormat(String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_BONUS_RANGE.getMessage());
        }
    }

    private static void validateRange(int bonus) {
        if (bonus < MIN_BONUS || bonus > MAX_BONUS) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_BONUS_RANGE.getMessage());
        }
    }

    private static void validateDuplicates(int bonus, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(InputErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }
}
