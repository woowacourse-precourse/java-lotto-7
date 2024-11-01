package lotto.domain;

import lotto.exception.winningNumbers.WinningNumbersErrorMessages;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
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
        return Arrays.stream(input.split(","))
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
        if (input.contains(" ") || input.endsWith(",")) {
            throw new IllegalArgumentException(WinningNumbersErrorMessages.INVALID_WHITESPACE.getMessage());
        }
    }

    private void checkInvalidCharacters(String input) {
        if (!input.matches("^(-?\\d+,)*-?\\d+$")) {
            throw new IllegalArgumentException(WinningNumbersErrorMessages.INVALID_DELIMITER.getMessage());
        }
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
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
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException(WinningNumbersErrorMessages.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}