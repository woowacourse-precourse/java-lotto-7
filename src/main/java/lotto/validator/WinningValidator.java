package lotto.validator;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningValidator {
    private static final String NUMERIC_REGEX = "\\d+";
    private static final int REQUIRED_WINNING_NUMBER_COUNT = 6;

    public static void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY_INPUT.getMessage());
        }
    }

    public static void validateIsNumericWithCommas(String winningNumbers) {
        String withoutCommas = winningNumbers.replace(",", "");
        if (!withoutCommas.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_MUST_BE_NUMBER.getMessage());
        }
    }

    public static void validateWinningNumberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != REQUIRED_WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_COUNT_MESSAGE.getMessage());
        }
    }

    public static void validateBonusNumberIsNumeric(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_MUST_BE_NUMBER.getMessage());
        }
    }

    public static void validateNumberInRange(int number) {
        if (number < LottoConstants.LOTTO_MIN_NUMBER || number > LottoConstants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_MUST_BE_IN_RANGE.getMessage());
        }
    }

    public static void validateAllNumbersInRange(List<Integer> winningNumbers) {
        winningNumbers.forEach(WinningValidator::validateNumberInRange);
    }

    public static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            }
        }
    }

    public static void validateBonusNumberIsDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }
}
