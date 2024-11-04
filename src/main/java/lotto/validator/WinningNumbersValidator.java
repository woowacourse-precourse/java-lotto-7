package lotto.validator;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersValidator {
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private WinningNumbersValidator() {
    }

    public static void validate(String winningNumbers) {
        validateNotNull(winningNumbers);
        validateNotEmpty(winningNumbers);
        List<Integer> numbers = parseWinningNumbers(winningNumbers);
        validateWinningNumbersCount(numbers);
        validateWinningNumbersRange(numbers);
        validateWinningNumbersDuplication(numbers);
    }

    private static void validateNotNull(String input) {
        if (input == null) {
            throw LottoException.from(ErrorMessage.NULL_INPUT_ERROR);
        }
    }

    private static void validateNotEmpty(String input) {
        if (input.isBlank()) {
            throw LottoException.from(ErrorMessage.EMPTY_INPUT_ERROR);
        }
    }

    private static void validateWinningNumbersCount(List<Integer> numbers) {
        if (isWinningNumbersCountInvalid(numbers)) {
            throw LottoException.from(ErrorMessage.INVALID_WINNING_NUMBERS_ERROR);
        }
    }

    private static void validateWinningNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (isWinningNumberOutOfRange(number)) {
                throw LottoException.from(ErrorMessage.INVALID_NUMBER_RANGE_ERROR);
            }
        }
    }

    private static void validateWinningNumbersDuplication(List<Integer> numbers) {
        if (isWinningNumbersDuplicated(numbers)) {
            throw LottoException.from(ErrorMessage.DUPLICATE_WINNING_NUMBER_ERROR);
        }
    }

    private static boolean isWinningNumbersCountInvalid(List<Integer> numbers) {
        return numbers.size() != WINNING_NUMBER_COUNT;
    }

    private static boolean isWinningNumberOutOfRange(Integer number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    private static boolean isWinningNumbersDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() < WINNING_NUMBER_COUNT;
    }

    private static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(numberString -> {
                    try {
                        return Integer.parseInt(numberString);
                    } catch (NumberFormatException e) {
                        throw LottoException.from(ErrorMessage.INVALID_NUMBER_RANGE_ERROR);
                    }
                })
                .toList();
    }
}
