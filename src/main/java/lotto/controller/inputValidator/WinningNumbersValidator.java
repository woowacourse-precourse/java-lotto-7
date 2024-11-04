package lotto.controller.inputValidator;

import static lotto.exception.ErrorBase.BLANK_WINNING_NUMBERS;
import static lotto.exception.ErrorBase.LOTTO_NUMBERS_DUPLICATE;
import static lotto.exception.ErrorBase.LOTTO_NUMBERS_INVALID_SIZE;
import static lotto.exception.ErrorBase.LOTTO_NUMBERS_OUT_OF_RANGE;
import static lotto.exception.ErrorBase.WINNING_NUMBERS_NON_NUMERIC;
import static lotto.util.LottoConstants.LOTTO_NUMBERS_COUNT;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MIN;
import static lotto.util.ValidationUtils.validateNotBlank;

import java.util.Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.util.ValidationUtils;

public class WinningNumbersValidator {
    private static final String DELIMITER = ",";

    public static List<Integer> validate(String winningNumbers) {
        validateNotBlank(winningNumbers, BLANK_WINNING_NUMBERS.getMessage());
        List<Integer> parsedWinNumbers = parseIntegerList(winningNumbers, WINNING_NUMBERS_NON_NUMERIC.getMessage());

        validateNumberRange(parsedWinNumbers);
        validateSize(parsedWinNumbers);
        validateNoDuplicates(parsedWinNumbers);

        return parsedWinNumbers;
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_SIZE.getMessage());
        }
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE.getMessage());
        }
    }

    private static List<Integer> parseIntegerList(String input, String errorMessage) {
        try {
            return Arrays.stream(input.split(DELIMITER, -1))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        boolean outOfRange = numbers.stream()
                .anyMatch(number -> number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX);

        if (outOfRange) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
        }
    }
}
