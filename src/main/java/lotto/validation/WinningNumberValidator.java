package lotto.validation;

import lotto.constants.ErrorMessageConstants;
import lotto.constants.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberValidator {
    private static final String WINNING_NUMBER_DELIMITER = ",";

    private WinningNumberValidator() {
        throw new IllegalStateException(ErrorMessageConstants.INSTANCE_CREATION_ERROR);
    }

    public static void validateWinningNumbersInput(String winningNumbersInput) {
        ValidationUtils.validateNotBlank(winningNumbersInput, ErrorMessageConstants.EMPTY_WINNING_NUMBERS);

        List<String> numbers = List.of(winningNumbersInput.split(WINNING_NUMBER_DELIMITER));
        numbers.stream()
                .map(String::trim)
                .forEach(number -> {
                    ValidationUtils.validateNotBlank(number, ErrorMessageConstants.EMPTY_WINNING_NUMBERS);
                    ValidationUtils.validateIsNumber(number, ErrorMessageConstants.INVALID_WINNING_NUMBER_FORMAT);
                });
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumberCount(winningNumbers);
        validateWinningNumberRange(winningNumbers);
        validateWinningNumberDuplicate(winningNumbers);
    }

    private static void validateWinningNumberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_WINNING_NUMBER_COUNT);
        }
    }

    private static void validateWinningNumberRange(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch(number -> number < LottoConstants.LOTTO_MIN_NUMBER || number > LottoConstants.LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_WINNING_NUMBER_RANGE);
        }
    }

    private static void validateWinningNumberDuplicate(List<Integer> winningNumbers) {
        Set<Integer> uniqueWinningNumbers = new HashSet<>(winningNumbers);
        if (uniqueWinningNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_WINNING_NUMBER_DUPLICATE);
        }
    }
}
