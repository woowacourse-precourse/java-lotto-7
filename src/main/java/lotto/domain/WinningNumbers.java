package lotto.domain;

import java.util.*;

import static lotto.common.constants.LottoNumberType.*;
import static lotto.common.constants.exception.ErrorMessage.*;

public class WinningNumbers {

    private final List<Integer> numbers;

    private WinningNumbers(String numbers) {
        List<Integer> validateWinningNumbers = Validator.validateWinningNumbers(numbers);
        this.numbers = sortWinningNumbers(validateWinningNumbers);
    }

    public static WinningNumbers from(String numbers) {
        return new WinningNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private List<Integer> sortWinningNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    private static class Validator {

        private static final String COMMA = ",";
        private static final String WINNING_NUMBER_NUMERIC_REGEX = "-?\\d+";

        private static List<Integer> validateWinningNumbers(String numbers) {
            validateWinningNumbersIsNotEmpty(numbers);
            List<String> delimitedWinningNumbers = validateWinningNumbersDelimiter(numbers);
            validateWinningNumbersCount(delimitedWinningNumbers);
            List<Integer> positiveWinningNumbers = validateWinningNumbersIsNumeric(delimitedWinningNumbers);
            validateWinningNumbersInRange(positiveWinningNumbers);
            validateUniqueWinningNumbers(positiveWinningNumbers);
            return positiveWinningNumbers;
        }

        private static void validateWinningNumbersIsNotEmpty(String numbers) {
            if (numbers == null || numbers.isBlank()) {
                throw new IllegalArgumentException(EMPTY_WINNING_NUMBERS.getMessage());
            }
        }

        private static List<String> validateWinningNumbersDelimiter(String numbers) {
            if (numbers.contains(COMMA)) {
                return Arrays.stream(numbers.split(COMMA))
                        .toList();
            }
            throw new IllegalArgumentException(INVALID_DELIMITER.getMessage());
        }

        private static void validateWinningNumbersCount(List<String> delimitedWinningNumbers) {
            if (delimitedWinningNumbers.size() != LOTTO_SIZE.getNumber()) {
                throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_COUNT.getMessage());
            }
        }

        private static List<Integer> validateWinningNumbersIsNumeric(List<String> delimitedWinningNumbers) {
            for (String delimitedWinningNumber : delimitedWinningNumbers) {
                if (!delimitedWinningNumber.matches(WINNING_NUMBER_NUMERIC_REGEX)) {
                    throw new IllegalArgumentException(NON_NUMERIC_WINNING_NUMBER.getMessage());
                }
            }
            return delimitedWinningNumbers.stream()
                    .map(Integer::parseInt)
                    .toList();
        }

        private static void validateWinningNumbersInRange(List<Integer> positiveWinningNumbers) {
            boolean hasOutOfRangeNumber = positiveWinningNumbers.stream()
                    .anyMatch(
                            lottoNumber -> lottoNumber < MINIMUM_LOTTO_NUMBER.getNumber()
                                    || lottoNumber > MAXIMUM_LOTTO_NUMBER.getNumber());

            if (hasOutOfRangeNumber) {
                throw new IllegalArgumentException(WINNING_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }

        private static void validateUniqueWinningNumbers(List<Integer> positiveWinningNumbers) {
            int positiveWinningNumbersSize = new HashSet<>(positiveWinningNumbers).size();
            if (positiveWinningNumbersSize != positiveWinningNumbers.size()) {
                throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBERS.getMessage());
            }
        }

    }

}