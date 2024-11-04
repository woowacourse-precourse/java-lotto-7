package lotto.application.validation;

import lotto.util.ErrorMessages;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumberValidator implements LottoNumberValidation {

    private static final int REQUIRED_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @Override
    public List<Integer> validate(String input) {
        List<Integer> numbers = parseNumbers(input);
        validateNumbers(numbers);
        return numbers;
    }

    @Override
    public List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_INPUT.getMessage());
        }
    }
    @Override
    public void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
        if (numbers.stream().anyMatch(num -> num < MIN_NUMBER || num > MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }
}
