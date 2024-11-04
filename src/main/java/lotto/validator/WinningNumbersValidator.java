package lotto.validator;

import static lotto.constants.CommonConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.CommonConstants.MIN_LOTTO_NUMBER;
import static lotto.exception.ExceptionMessage.BLANK_WINNING_LOTTO_NUMBERS;
import static lotto.exception.ExceptionMessage.DUPLICATE_WINNING_NUMBERS;
import static lotto.exception.ExceptionMessage.INVALID_WINNING_LOTTO_NUMBERS_PATTERN;
import static lotto.exception.ExceptionMessage.OUT_OF_LOTTO_NUMBER_RANGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.util.WinningNumbersParser;
import org.junit.platform.commons.util.StringUtils;

public class WinningNumbersValidator {
    private static final String VALID_WINNING_NUMBERS_REGEX = "^(\\s*[1-9][0-9]*\\s*,\\s*){5}(\\s*[1-9][0-9]*\\s*)$";

    public static void validate(String winningNumbers) {
        validateBlank(winningNumbers);
        validatePattern(winningNumbers);
        validateRange(winningNumbers);
        validateDuplication(winningNumbers);
    }

    private static void validateBlank(String winningNumbers) {
        if (StringUtils.isBlank(winningNumbers)) {
            throw new IllegalArgumentException(BLANK_WINNING_LOTTO_NUMBERS.getMessage());
        }
    }

    private static void validatePattern(String winningNumbers) {
        if (isInValidPattern(winningNumbers)) {
            throw new IllegalArgumentException(INVALID_WINNING_LOTTO_NUMBERS_PATTERN.getMessage());
        }
    }

    private static boolean isInValidPattern(String winningNumbers) {
        return !Pattern.matches(VALID_WINNING_NUMBERS_REGEX, winningNumbers);
    }

    private static void validateRange(String winningNumbers) {
        List<Integer> parsedWinningNumbers = WinningNumbersParser.parse(winningNumbers);
        for (Integer parsedNumber : parsedWinningNumbers) {
            if (outOfRange(parsedNumber)) {
                throw new IllegalArgumentException(OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    private static boolean outOfRange(int num) {
        return !(MIN_LOTTO_NUMBER <= num && num <= MAX_LOTTO_NUMBER);
    }

    private static void validateDuplication(String winningNumbers) {
        List<Integer> parsedWinningNumbers = WinningNumbersParser.parse(winningNumbers);
        Set<Integer> uniqueWinningNumbers = new HashSet<>(parsedWinningNumbers);
        if (uniqueWinningNumbers.size() != parsedWinningNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }
}
