package lotto.validator;

import static lotto.message.CommonConstants.LOTTO_MAX_NUMBER;
import static lotto.message.CommonConstants.LOTTO_MIN_NUMBER;
import static lotto.message.CommonConstants.LOTTO_SIZE;
import static lotto.message.CommonConstants.SEPARATOR;
import static lotto.message.ErrorMessage.ERROR_DUPLICATE_WINNING_NUMBERS;
import static lotto.message.ErrorMessage.ERROR_EMPTY_WINNING_NUMBERS;
import static lotto.message.ErrorMessage.ERROR_NOT_SEPARATED;
import static lotto.message.ErrorMessage.ERROR_WINNING_NUMBERS_RANGE;
import static lotto.message.ErrorMessage.ERROR_WINNING_NUMBERS_SIZE_LESS;
import static lotto.message.ErrorMessage.ERROR_WINNING_NUMBERS_SIZE_MORE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.platform.commons.util.StringUtils;

public class WinningNumbersValidator {

    public static void validateInputWinningNumbers(String inputWinningNumbers) {
        validateSeparator(inputWinningNumbers);
        validateNotEmpty(inputWinningNumbers);
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersCount(winningNumbers);
        validateNumbersRange(winningNumbers);
        validateDuplicateNumbers(winningNumbers);
    }

    private static void validateSeparator(String inputWinningNumbers) {
        if (!inputWinningNumbers.contains(SEPARATOR)) {
            throw new IllegalArgumentException(ERROR_NOT_SEPARATED);
        }
    }

    private static void validateNotEmpty(String winningNumbers) {
        if (StringUtils.isBlank(winningNumbers)) {
            throw new IllegalArgumentException(ERROR_EMPTY_WINNING_NUMBERS);
        }
    }

    private static void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() < LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_SIZE_LESS);
        }
        if (winningNumbers.size() > LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_SIZE_MORE);
        }
    }

    private static void validateNumbersRange(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_RANGE);
            }
        }
    }

    private static void validateDuplicateNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() < winningNumbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_WINNING_NUMBERS);
        }
    }

}
