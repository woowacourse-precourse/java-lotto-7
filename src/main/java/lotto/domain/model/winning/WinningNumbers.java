package lotto.domain.model.winning;

import lotto.domain.constant.GlobalConstants;
import lotto.exception.winning.WinningNumbersErrorMessages;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int EXPECTED_SIZE = 6;
    private static final String NUMBER_DELIMITER = ",";
    private static final String WHITESPACE_OR_TRAILING_COMMA_REGEX = ".*\\s.*|.*,$";
    private static final String COMMA_SEPARATED_NUMBERS_REGEX = "^(-?\\d+,)*-?\\d+$";

    private final List<Integer> numbers;

    public WinningNumbers(String input) {
        this.numbers = parseAndValidate(input);
    }

    private List<Integer> parseAndValidate(String input) {
        checkEmptyOrNull(input);
        checkWhitespaceOrTrailingComma(input);
        checkInvalidCharacters(input);

        List<Integer> parsedNumbers = parseNumbers(input);
        validateNumbers(parsedNumbers);
        return parsedNumbers;
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateNumbers(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicates(numbers);
        checkRange(numbers);
    }

    private void checkEmptyOrNull(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(WinningNumbersErrorMessages.INVALID_EMPTY.getMessage());
        }
    }

    private void checkWhitespaceOrTrailingComma(String input) {
        if (input.matches(WHITESPACE_OR_TRAILING_COMMA_REGEX)) {
            throw new IllegalArgumentException(WinningNumbersErrorMessages.INVALID_WHITESPACE.getMessage());
        }
    }

    private void checkInvalidCharacters(String input) {
        if (!input.matches(COMMA_SEPARATED_NUMBERS_REGEX)) {
            throw new IllegalArgumentException(WinningNumbersErrorMessages.INVALID_CHARACTER.getMessage());
        }
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != EXPECTED_SIZE) {
            throw new IllegalArgumentException(WinningNumbersErrorMessages.INVALID_SIZE.getMessage());
        }
    }

    private void checkDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(WinningNumbersErrorMessages.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < GlobalConstants.MIN_LOTTO_NUMBER || num > GlobalConstants.MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(WinningNumbersErrorMessages.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}