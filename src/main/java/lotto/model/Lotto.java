package lotto.model;

import static lotto.constants.ExceptionMessage.INVALID_WINNING_NUMBERS;
import static lotto.constants.ExceptionMessage.INVALID_RANGE;

import static lotto.constants.LottoConfig.MIN_LOTTO_NUMBER;
import static lotto.constants.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConfig.LOTTO_NUMBER_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateWinningNumberRange(numbers);
        validateNoDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS.format());
        }
    }

    private void validateWinningNumberRange(List<Integer> numbers) {
        boolean isValid = numbers.stream()
                .allMatch(number -> number >= MIN_LOTTO_NUMBER.getValue()
                        && number <= MAX_LOTTO_NUMBER.getValue());
        if (!isValid) {
            throw new IllegalArgumentException(INVALID_RANGE.format());
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS.format());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}