package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessages;
import lotto.constant.LottoConstants;
import lotto.exception.InputException;

public class WinningNumberValidator {

    public static List<Integer> validateWinningNumbers(List<String> winningNumbersInput) {
        List<Integer> winningNumbers = parseWinningNumbers(winningNumbersInput);
        checkWinningNumbersSize(winningNumbers);
        checkWinningNumbersRange(winningNumbers);
        checkDuplicateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private static List<Integer> parseWinningNumbers(List<String> winningNumbersInput) {
        try {
            return winningNumbersInput.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InputException(ErrorMessages.ERROR_NON_INTEGER_LOTTO_NUMBER);
        }
    }

    private static void checkWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new InputException(ErrorMessages.ERROR_INVALID_WINNING_NUMBER_COUNT);
        }
    }

    private static void checkWinningNumbersRange(List<Integer> winningNumbers) {
        if (winningNumbers.stream()
                .anyMatch(num -> num < LottoConstants.LOTTO_NUMBER_MIN || num > LottoConstants.LOTTO_NUMBER_MAX)) {
            throw new InputException(ErrorMessages.ERROR_WINNING_NUMBER_OUT_OF_RANGE);
        }
    }

    private static void checkDuplicateWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new InputException(ErrorMessages.ERROR_DUPLICATE_WINNING_NUMBER);
        }
    }
}
